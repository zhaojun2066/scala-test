package com.scala.test.actors

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by jufeng on 2018/5/11.
  */
class HelloActor(name: String)extends Actor{
  override def receive: Receive = {
    case "hello" => println("hello from %s".format(name))
    case _ => println("%s, huh?".format(name))
  }
}

object HelloMain {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("helloSystem")
    // 如果HelloActor不带构造参数，这可以这么使用
    // val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")

    val helloActor = system.actorOf(Props(new HelloActor("jufeng")), "helloactor")
    helloActor ! "hello"
    helloActor ! "buenos dias"
  }
}
