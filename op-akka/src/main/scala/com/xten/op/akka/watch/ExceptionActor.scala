package com.xten.op.akka.watch

import akka.actor.Actor
import com.xten.op.common.util.StringUtil
import org.slf4j.LoggerFactory


class ExceptionActor extends Actor {

  private val LOGGER = LoggerFactory.getLogger(classOf[ExceptionActor])

  throw new RuntimeException("start actor error")


  override def preStart() = {
    println("AkkaActor:"+this.getClass.getClassLoader)
    StringUtil.test()
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

