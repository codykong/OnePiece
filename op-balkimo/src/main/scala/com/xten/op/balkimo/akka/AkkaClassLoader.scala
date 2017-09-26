package com.xten.op.balkimo.akka

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import com.xten.op.balkimo.classloader.PackagedProgram

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/8/17 
  * Time: 下午2:24 
  */
object AkkaClassLoader{

  def main(args: Array[String]): Unit = {


    val parentClassLoader = getClass.getClassLoader
    println(s"parentClassLoader is  ${parentClassLoader}")
    val config = ConfigFactory.load("akka_remote.conf")


    val path = "/Users/xten/MySpace/github/xten.one-piece/op-akka/target/op-akka-0.0.1-SNAPSHOT-allinone.jar"
    val mainClassStr = "com.xten.op.akka.local.AkkaApp"
    val packagedProgram = new PackagedProgram(path, mainClassStr)
    val userClassLoader1 = packagedProgram.getUserCodeClassLoader

    println(s"userClassLoader1 is  ${userClassLoader1}")

    Thread.currentThread().setContextClassLoader(userClassLoader1)
    val system1 = ActorSystem.create("akka1",config)
    println(s"system1 ${system1.getClass.getClassLoader}")
    val proxyClass = Class.forName("com.xten.op.akka.local.AkkaMonitor",true,userClassLoader1)

    val actor1 = system1.actorOf(Props.create(proxyClass), "actor1")







  }


}
