package com.scala.test.clazz

/**
  * Created by jufeng on 2018/4/8.
  */
class Conuter {

  private var value = 0 //你必须初始化值
  def  inc() = {
    value += 1
  }

 // def cur() = value
  def current = value


  //合法 ，other 也是Counter对象，如果是private[this] var value = 0,就不可以了
  // [this]修饰的成员 为对象所有，也就是Counter类的方法只能访问当前对象的value，
  //而不能访问Counter类型的其他对象的value属性，因为不会生成getter 和setter方法
  def isLess(other : Conuter) = value < other.value

}

object Conuter{
  def main(args: Array[String]): Unit = {
    val myCount = new Conuter // or new Counter()
    myCount.inc()
    println(myCount.current) //调用无参方法可以有括号，也可以没有
  }
}
