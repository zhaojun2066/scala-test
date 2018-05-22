package com.scala.test.fpinscala.c07

/**
  * Created by jufeng on 2018/5/15.
  */
trait Par[+A] {
  //def unit[A](a: => A): Par[A]
  def get[A](a: Par[A]):A
  def map2[A,B,C](l:A =>Par[A],r:A =>Par[A])(f:(A,B)=> Par[A]):Par[A]
}

object Par{
  type Par[A] = ExecutorService => Future[A]
  def run[A](s: ExecutorService)(a: Par[A]): Future[A] = a(s)
 // def unit[A](a: A): Par[A] = (es: ExecutorService) => UnitFuture(a)
}


trait ExecutorService{
  def submit[A](a: Callable[A]): Future[A]
}

trait Callable[A]{
  def call: A
}

trait Future[A]{

}

private case class UnitFuture[A](get: A) extends Future[A]{

}
