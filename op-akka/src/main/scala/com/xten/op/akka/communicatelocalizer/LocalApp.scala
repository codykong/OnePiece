package com.xten.op.akka.communicatelocalizer

import akka.actor.{ActorSystem, Props}

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/8/18 
  * Time: 上午10:30 
  */
object AkkaApp extends App{

  val system = ActorSystem.create("akka1")
  println(s"system1 ${system.getClass.getClassLoader}")
  //    system1.getClass.getClassLoader

  val classLoader = this.getClass.getDeclaredClasses
  system.actorOf(Props.apply(classOf[AkkaMonitor]))



}
