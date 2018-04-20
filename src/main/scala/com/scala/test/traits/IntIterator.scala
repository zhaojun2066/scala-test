package com.scala.test.traits

import scala.collection.mutable.ArrayBuffer

/**
  * Created by jufeng on 2018/4/19.
  * trait相当于接口或者抽象类
  */
trait Iterator[A]{
  def hasNext: Boolean
  def  next:A
}

//说明to是private val
class IntIterator(to:Int) extends Iterator[Int]{

  private var current = 0

  override def hasNext: Boolean = current < to

  override def next: Int = {
    if (hasNext){
      val t = current
      current +=1
      t
    }else{
      0
    }
  }
}


//子类型化,子类实现
//特征Pet有一个抽象域name，name通过Cat和Dog在它们的构造函数中得以实现。
// 在最后一行代码中，我们调用pet.name，pet.name必须在特征Pet的所有子类型中得到实现。
trait Pet{
  val name:String
}
class Cat(val name:String) extends Pet

class Dog(val name: String) extends Pet


//抽象类型
abstract class AbstractIterator{
  type T
  def hasNext: Boolean
  def next: T
}
class StringIter(s: String) extends AbstractIterator{
  type T = Char
  private var i = 0

  def hasNext: Boolean = i < s.length

  def next: Char = {
    val ch  = s.charAt(i)
    i +=1
    ch
  }
}
//
trait RichIterator extends AbstractIterator{
  def foreach(f: T => Unit):Unit = while (hasNext) f (next)
}

//将StringIterator和RichIterator的功能组合成一个单实例类。
//有点模板模式的意思
class Iter(val s:String) extends StringIter(s) with RichIterator

object Test{
  def main(args: Array[String]): Unit = {
    val dog = new  Dog("Dog")
    val cat = new Cat("Tomcat")
    val amns = ArrayBuffer[Pet](dog,cat)
    amns.foreach(p => println(p.name))


    //新类Iter有一个超类StringIterator和一个mixin RichIterator。
    val iter = new Iter("hello")
    iter foreach(println)
  }
}
