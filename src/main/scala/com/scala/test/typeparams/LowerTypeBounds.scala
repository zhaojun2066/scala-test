package com.scala.test.typeparams

/**
  * Created by jufeng on 2018/4/20.
  * 在Scala中，类型参数和抽象类型可以通过类型范围进行限制
  * B >: A 表示类型参数B或者抽象类型B是类型A的超类型。大部分情况下，A将会作为类的类型参数，B将会作为方法的类型参数。
  */

/**
  * trait Node[+B] {
      def prepend(elem: B): Unit
    }

    case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
      def prepend(elem: B) = ListNode[B](elem, this)
      def head: B = h
      def tail = t
    }

    case class Nil[+B]() extends Node[B] {
      def prepend(elem: B) = ListNode[B](elem, this)
    }
  */
class LowerTypeBounds
trait Node[+B] {
  def prepend[U >: B](elem: U)
}

case class ListNode[+B](h: B, t: Node[B]) extends Node[B] {
  def prepend[U >: B](elem: U) = ListNode[U](elem, this)
  def head: B = h
  def tail = t
}

case class Nil[+B]() extends Node[B] {
  def prepend[U >: B](elem: U) = ListNode[U](elem, this)
}

trait Mammal
case class AfricanSwallow() extends Mammal
case class EuropeanSwallow() extends Mammal

object LowerTypeBounds{
  def main(args: Array[String]): Unit = {
    val africanSwallowList= ListNode[AfricanSwallow](AfricanSwallow(), Nil())
    val mammalList: Node[Mammal] = africanSwallowList
    mammalList.prepend(new EuropeanSwallow)
  }
}