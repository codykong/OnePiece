package com.xten.op.akka.local

import akka.actor.Actor
import com.xten.op.common.util.StringUtil
import org.slf4j.LoggerFactory


class AkkaActor extends Actor {

  private val LOGGER = LoggerFactory.getLogger(classOf[AkkaActor])


  override def preStart() = {
    println("AkkaActor:"+this.getClass.getClassLoader)
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

