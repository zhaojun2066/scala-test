package com.scala.test.extendss

/**
  * Created by jufeng on 2018/4/9.
  * 抽象父类
  * 抽象方法只需要不定义方法体就行了
  */
abstract class Person (name:String,age:Int){
  def id :Int    //抽象字段 ,带有抽象的getter和setter方法     // 2 val只能重写另一个val 或者不带参数的def ,
  def description(say:String):String //抽象方法 带有抽象的getter和setter方法
  val address:String // 2 val只能重写另一个val 或者不带参数的def
  override def toString: String = name + " is " + age +" years old. "
}
