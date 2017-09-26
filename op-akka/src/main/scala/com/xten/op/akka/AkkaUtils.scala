package com.xten.op.akka

import java.util

import akka.actor.{ActorContext, ActorPath, ActorRef, ActorSelection, ActorSystem, ExtendedActorSystem, Extension, ExtensionKey, Props}
import com.typesafe.config.{Config, ConfigFactory}
import org.jboss.netty.logging.{InternalLoggerFactory, Slf4JLoggerFactory}
import org.slf4j.LoggerFactory

/**
  * Created with IntelliJ IDEA. 
  * User: kongqingyu
  * Date: 2017/5/5 
  */
object AkkaUtils {

  val LOG = LoggerFactory.getLogger(AkkaUtils.getClass)


  def createActorSystem(name:String, akkaConfig: Config): ActorSystem = {
    // Initialize slf4j as logger of Akka's Netty instead of java.util.logging (FLINK-1650)
    InternalLoggerFactory.setDefaultFactory(new Slf4JLoggerFactory)
    ActorSystem.create(name, akkaConfig)
  }

  def createActorSystem(akkaConfig: Config): ActorSystem = {
    createActorSystem("defaultTide",akkaConfig)
  }

  def remotePath(system: ActorSystem, ref: ActorRef): String = {
    val remoteAddr = RemoteAddressExtension(system).address
    val remotePath = ref.path.toStringWithAddress(remoteAddr)
    remotePath
  }

  def remotePath()(implicit actorContext: ActorContext) :String = {
    remotePath(actorContext.system,actorContext.self)
  }


  def remotePath(system: ActorSystem, actorPath: ActorPath): String = {
    val remoteAddr = RemoteAddressExtension(system).address
    val remotePath = actorPath.toStringWithAddress(remoteAddr)
    remotePath
  }

  /**
    * path 转为对应的Selection
    * @param path
    * @param context
    * @return
    */
  def pathToSelection(path:String)(implicit context: ActorContext) : ActorSelection = {
    context.actorSelection(path)
  }

  def pathToSelection(paths:List[String])(implicit context: ActorContext) : List[ActorSelection] = {
    paths.map(p => {context.actorSelection(p)})
  }


  def parseConfig(args: (String,Any)*) : Config={
    val map = new util.HashMap[String,Any]()

    for (arg <- args){
      map.put(arg._1,arg._2)
    }
    ConfigFactory.parseMap(map)
  }






  def getLogLevel: String = {
    if (LOG.isTraceEnabled) {
      "TRACE"
    } else {
      if (LOG.isDebugEnabled) {
        "DEBUG"
      } else {
        if (LOG.isInfoEnabled) {
          "INFO"
        } else {
          if (LOG.isWarnEnabled) {
            "WARNING"
          } else {
            if (LOG.isErrorEnabled) {
              "ERROR"
            } else {
              "OFF"
            }
          }
        }
      }
    }
  }

}

class RemoteAddressExtensionImpl(system: ExtendedActorSystem) extends Extension {
  def address = system.provider.getDefaultAddress
}

object RemoteAddressExtension extends ExtensionKey[RemoteAddressExtensionImpl] {

}
