package com.scala.test.extendss

/**
  * Created by jufeng on 2018/4/9.
  */
class Employee(override val id:Int,name:String,age:Int,val salary :Double) extends Person(name,age){

  // var  salary = 0.0

  override val toString: String = super.toString + " , salary=" + salary

  override val address: String = "bejing shoudu "

  //override 可以不写,前提必须是抽象类的抽象方法和抽象字段
  def description(say:String): String = {
     toString
  }
}
