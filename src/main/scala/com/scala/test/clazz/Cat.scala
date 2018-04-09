package com.scala.test.clazz

/**
  * Created by jufeng on 2018/4/8.
  */

//主构造器放在类名字后面
class Cat(var name:String="Li", //私有字段 ，共有的get set
          val age :Int=10,//私有 只有共有get 方法 age()
          private[this] val address:String=" no here..." //私有 只有私有get
         ) {

  if (name ==null) name = "tomecat" //主构造器的执行初始化语句

  def description = name + " is " + age +" years old and address " + address

  def isLess(other: Cat) = age < other.age


}

object Cat{
  def main(args: Array[String]): Unit = {
    var ct = new Cat("tom",10,"beijing")
    println(ct.description)

     ct = new  Cat()
    println(ct.description)
  }
}
