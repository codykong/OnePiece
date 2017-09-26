package com.xten.op.akka.watch

import akka.actor.{ActorSystem, Props}

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/8/18 
  * Time: 上午10:30 
  */
object WatchApp extends App{

  val system = ActorSystem.create("akka1")
//  println(s"system1 ${system.getClass.getClassLoader}")
  //    system1.getClass.getClassLoader

//  val classLoader = this.getClass.getDeclaredClasses
  val ref = system.actorOf(Props.apply(classOf[AkkaMonitor]))

  ref ! "success"

}
