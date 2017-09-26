package com.xten.op.akka.util;

import akka.actor.*;
import akka.util.Timeout;
import com.typesafe.config.Config;
import scala.concurrent.duration.Duration;

/**
 * Description:
 * User: kongqingyu
 * Date: 2017/9/19
 */
public class AkkaUtils {

    public static final Timeout DEFAULT_TIMEOUT = new Timeout(Duration.create(5, "seconds"));


    public static ActorSystem createActorSystem(String name, Config akkaConfig) {
        return  ActorSystem.create(name,akkaConfig);
    }


    public static ActorRef createActor(String name, ActorSystem actorSystem , Class<?> proxyClass, Object... args ){
        Props props = Props.create(proxyClass,args);
        return actorSystem.actorOf(props,name);

    }

    public static ActorRef createActor(String name, ActorContext actorContext , Class<?> proxyClass, Object... args ){
        Props props = Props.create(proxyClass,args);
        return actorContext.actorOf(props,name);

    }


    public static String remotePath(ActorSystem actorSystem , ActorRef actorRef){
        Address address = actorSystem.provider().getDefaultAddress();
        return actorRef.path().toStringWithAddress(address);
    }

    public static String remotePath(ActorContext actorContext) {
        Address address = actorContext.system().provider().getDefaultAddress();
        return actorContext.self().path().toStringWithAddress(address);
    }

    public static ActorSelection getFromRemotePath(ActorContext actorContext, String remotePath){
        return actorContext.actorSelection(remotePath);
    }

    public static ActorRef getActorRefFromRemotePath(ActorSystem actorSystem, String remotePath){

        return actorSystem.actorFor(remotePath);
    }


}
