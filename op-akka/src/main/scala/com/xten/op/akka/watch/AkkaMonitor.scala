package com.xten.op.akka.watch

import akka.actor.SupervisorStrategy.{Resume, Stop}
import akka.actor.{Actor, OneForOneStrategy, Props, SupervisorStrategy, Terminated}
import org.slf4j.LoggerFactory

import scala.concurrent.duration.Duration


class AkkaMonitor extends Actor {

  private val LOGGER = LoggerFactory.getLogger(classOf[AkkaMonitor])

  val fivesec: Duration = Duration.create(5, "seconds")

  override def preStart() = {
    println(this.getClass.getClassLoader)
  }

  // 监管机制
  override def supervisorStrategy(): SupervisorStrategy = OneForOneStrategy(maxNrOfRetries = 5, withinTimeRange = fivesec) {
    case e: Exception =>
      LOGGER.error(s"supervision received Exception,component is ${e.getClass.getSimpleName},error is: ${e.getMessage}",e)
      Stop
  }

  override def receive = {

    case "success" => {

      val akkaActor = context.actorOf(Props.apply(classOf[ExceptionActor]))

      context watch akkaActor

      println(this.getClass.getClassLoader)
    }
    case Terminated(actorRef) => {
      LOGGER.info(s"terminated ${actorRef.path.toString}")
    }
    case _ => {
      LOGGER.info("unhandled message")
    }
  }


}

