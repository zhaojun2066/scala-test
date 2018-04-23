package com.scala.test.absracttypes

/**
  * Created by jufeng on 2018/4/20.
  */
class AbstractType

trait Buffer{
  type T
  val element: T
}
abstract class SeqBuffer extends Buffer{
  type U
  type T <: Seq[U]
  def length = element.length
}

abstract class IntBuffer extends SeqBuffer{
  type U = Int
}

object AbstractType{
  def newIntSeqBuf(elem1: Int,elem2:Int):IntBuffer = new IntBuffer {
    override type T = List[U]
    override val element: List[Int] = List(elem1,elem2)
  }

  def main(args: Array[String]): Unit = {
    val buf = newIntSeqBuf(7, 8)
    println("length = " + buf.length)
    println("content = " + buf.element)
  }
}
