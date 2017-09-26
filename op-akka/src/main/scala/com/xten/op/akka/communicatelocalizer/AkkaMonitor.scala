package com.xten.op.akka.communicatelocalizer

import akka.actor.{Actor, Props}
import org.slf4j.LoggerFactory


class AkkaMonitor extends Actor {

  private val LOGGER = LoggerFactory.getLogger(classOf[AkkaMonitor])



  override def preStart() = {
    println(this.getClass.getClassLoader)
  }

  override def receive = {

    case "success" => {

      println(this.getClass.getClassLoader)
    }
    case _ => {
      LOGGER.info("unhandled message")
    }
  }


}

