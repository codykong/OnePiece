package com.xten.op.akka.remote

import akka.actor.Actor
import com.xten.op.akka.AkkaUtils
import org.slf4j.LoggerFactory


class RemoteActor extends Actor {

  private val LOGGER = LoggerFactory.getLogger(classOf[RemoteActor])


  override def preStart() = {
    println("AkkaActor:"+this.getClass.getClassLoader)
    LOGGER.info(s"path is ${AkkaUtils.remotePath()}")
  }

  override def receive = {

    case "success" => {

      println(this.getClass.getClassLoader)
    }
    case fact : BaseFact =>{
      LOGGER.error(s"fact is ${fact}")
    }
    case any: Any => {
      LOGGER.info(s"unhandled message,${any}")
      throw new Exception("throw exception")
    }
  }


}

case class BaseFact(name : String)


