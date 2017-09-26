package com.xten.op.akka.local

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/8/18 
  * Time: 上午10:30 
  */
object AkkaApp extends App{

  var config = ConfigFactory.load("akka_local.conf")
  val system = ActorSystem.create("local",config)

  val classLoader = this.getClass.getDeclaredClasses
  val monitor =  system.actorOf(Props.apply(classOf[AkkaMonitor]))

  Thread.sleep(2000)
  for(i <- 1 to 1) {
    monitor ! "success"

  }


}
