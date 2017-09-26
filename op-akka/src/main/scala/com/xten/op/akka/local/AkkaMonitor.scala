package com.xten.op.akka.local

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorRef, ActorSelection, Props}
import akka.util.Timeout
import com.xten.op.akka.RemoteAddressExtension
import com.xten.op.akka.remote.BaseFact
import org.slf4j.LoggerFactory

import scala.concurrent.duration.FiniteDuration
import scala.util.{Failure, Success}

import scala.concurrent.ExecutionContext.Implicits.global


class AkkaMonitor extends Actor {

  private val LOG = LoggerFactory.getLogger(classOf[AkkaMonitor])


  val path = "akka.tcp://remote@127.0.0.1:2553/user/remoteMonitor/remoteActor"

  var selection : ActorSelection = null

  var actor : ActorRef = null

  override def preStart(): Unit = {
    super.preStart()

    selection = context.actorSelection(path)

    selection.resolveOne(FiniteDuration.apply(3, TimeUnit.SECONDS)).onComplete {
      case Success(resolved) => {
        actor = resolved
      }
      case Failure(e) => {
      }

    }
  }


  override def receive = {

    case "success" => {

      for (i <- 1 to 20) {
        actor ! "abc"
        Thread.sleep(1000)
      }
    }
    case _ => {
      LOG.info("unhandled message")
    }
  }


}

