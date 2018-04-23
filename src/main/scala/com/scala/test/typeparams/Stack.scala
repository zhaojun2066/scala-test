package com.scala.test.typeparams

/**
  * Created by jufeng on 2018/4/20.
  * 泛型类
  */
class Stack[A] {
  private var elements: List[A] = Nil
  def push(x: A) =elements = x :: elements
  def peek: A = elements.head
  def pop: A = {
    val currentTop = peek
    elements = elements.tail
    currentTop
  }

}
class Fruit
class Apple extends Fruit
class Banana extends Fruit

object Stack{
  def main(args: Array[String]): Unit = {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.pop)
    println(stack.pop)


    //类Apple和Banana都扩展自Fruit，所以我们可以将实例apple和banana压入Fruit类型的stack。
    val stack1 = new Stack[Fruit]
    val apple = new Apple
    val banana = new Banana
    stack1.push(apple)
    stack1.push(banana)
  }
}
