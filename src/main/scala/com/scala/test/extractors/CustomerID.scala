package com.scala.test.extractors

import scala.util.Random

/**
  * Created by jufeng on 2018/4/20.
  *
  * 如果只是一个测试，则返回Boolean类型。例如case even()
    如果返回类型T的单个sub-value，则返回Option[T]
    如果想要返回几个sub-value T1,…,Tn，则将它们放在一个可选的tuple组内Option[(T1,…,Tn)]
   有时，sub-values的个数是固定的，并且我们想要返回一个序列。出于这个原因，你也可以通过unapplySeq来定义模式，
   它返回Option[Seq[T]]。这个机制用于在模式case List(x1, …, xn)中作为实例。
  */
object CustomerID {
  def apply(name: String) = s"$name--${Random.nextLong}"

  def unapply(customerID: String): Option[String] ={
    val name = customerID.split("--").head
    if (name.nonEmpty) Some(name) else None
  }

  def main(args: Array[String]): Unit = {
    val id = CustomerID("yong")
    id match {
      case CustomerID(name) => println(name)
      case _ => println("not a id")
    }
  }

}
