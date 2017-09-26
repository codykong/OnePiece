package com.xten.op.akka.remote

import java.util.concurrent.TimeUnit

import akka.actor.SupervisorStrategy.{Restart, Stop}
import akka.actor.{Actor, OneForOneStrategy, Props, SupervisorStrategy}
import com.xten.op.akka.remote.RemoteApp.system
import com.xten.op.akka.util.AkkaUtils
import org.slf4j.LoggerFactory

import scala.concurrent.duration.{Duration, FiniteDuration}
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Description: 
  * User: kongqingyu
  * Date: 2017/9/7 
  */
class RemoteMonitor extends Actor{

  private val LOG = LoggerFactory.getLogger(classOf[RemoteMonitor])

  var restartNum = 0

  override def preStart(): Unit = {
    super.preStart()
    val remoteActor =  context.actorOf(Props.apply(classOf[RemoteActor]),"remoteActor")

//    context watch remoteActor

    LOG.info(s"remoteActor path is ${AkkaUtils.remotePath(context.system,remoteActor)}")

  }


  override def supervisorStrategy: SupervisorStrategy = OneForOneStrategy(maxNrOfRetries = 5, withinTimeRange = Duration.create(5, "seconds")) {

    case ex : Exception => {
      restartNum +=1
      LOG.error(s"receive exception:restartNum is ${restartNum}")
      if (restartNum < 3) {
        Restart
      }else {
        startToDispatch
        Stop
      }
    }
  }


  override def receive = {
    case any: Any => {
      LOG.info(s"unhandled message,${any}")
    }
  }

  def startToDispatch(): Unit ={
    context.system.scheduler.scheduleOnce(FiniteDuration.apply(3, TimeUnit.SECONDS)) {
      val remoteActor =  context.actorOf(Props.apply(classOf[RemoteActor]),"remoteActor")

      LOG.info(s"restart remoteActor path is ${AkkaUtils.remotePath(context.system,remoteActor)}")
    }
  }



}
