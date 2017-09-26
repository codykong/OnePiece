package com.xten.op.akka.remote

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/8/18 
  * Time: 上午10:30 
  */
object RemoteApp extends App{

  var config = ConfigFactory.load("akka_remote.conf")
  val system = ActorSystem.create("remote",config)

  val monitor =  system.actorOf(Props.apply(classOf[RemoteMonitor]),"remoteMonitor")
//
//  for(i <- 1 to 3) {
//    monitor ! "success"
//
//  }


}
