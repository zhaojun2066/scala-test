package com.scala.test.caseclazz

/**
  * Created by jufeng on 2018/4/19.
  * Scala具有一种特殊类型的类叫做case类。默认情况下，case类是不可变的，并且通过值做比较。你可以使用关键字case class定义case类。
  *  你可以不使用new来实例化case类：
val point = Point(1, 2)
val anotherPoint = Point(1, 2)
val yetAnotherPoint = Point(2, 2)
  */
case class Ponit(x:Int,Y:Int)
