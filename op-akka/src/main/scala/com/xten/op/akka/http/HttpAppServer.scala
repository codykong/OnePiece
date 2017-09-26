//package com.xten.op.akka.http
//
//import akka.{Done, pattern}
//import akka.actor.ActorSystem
//import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
//import akka.http.scaladsl.server.Directives.complete
//import akka.http.scaladsl.server.RouteResult.Complete
//import akka.http.scaladsl.server.{HttpApp, Route}
//import akka.http.scaladsl.settings.ServerSettings
//import akka.http.scaladsl.unmarshalling.{FromEntityUnmarshaller, FromRequestUnmarshaller, Unmarshaller}
//import akka.stream.ActorMaterializer
//import com.google.gson.Gson
//
//import scala.concurrent.duration._
//import scala.concurrent.{ExecutionContext, Future}
//
///**
//  * Created with IntelliJ IDEA.
//  * User: kongqingyu
//  * Date: 2017/8/25
//  * Time: 上午11:36
//  */
//object HttpAppServer extends HttpApp{
//
//  val gson = new Gson()
//
//
//  case class Order(email: String, amount: Double)
//
//
////  implicit val mater = ActorFlowMaterializer()
////  implicit val orderUM: FromEntityUnmarshaller[Order] = {
////    Unmarshaller.stringUnmarshaller.map(p => gson.fromJson(p,classOf[Order]))
////  }
//
////  implicit val PortofolioFormats = jsonFormat2(Person)
//
//  implicit val materializer = ActorMaterializer()
//
//  override protected def routes: Route = {
//
//    pathPrefix("events" / Segment / "tickets") { event =>
//      post {
//        pathEndOrSingleSlash {
//          // POST /events/:event/tickets
//          entity(as[Order]) { request =>
//            complete{
//              new Gson().toJson(request)
//            }
//          }
//        }
//      }
//    }
//
//  }
//
////  override def waitForShutdownSignal(actorSystem: ActorSystem)(implicit executionContext: ExecutionContext): Future[Done] = {
////    pattern.after(5 seconds, actorSystem.scheduler)(Future.successful(Done))
////  }
//
//  def main(args: Array[String]): Unit = {
//    val system = ActorSystem("ownActorSystem")
//    HttpAppServer.startServer("localhost", 8080, ServerSettings(system), system)
//  }
//
//
//
//
//}
//
//
//case class A(name : String = "abc")
