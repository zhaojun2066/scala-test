package com.scala.test.extendss

/**
  * Created by jufeng on 2018/4/9.
  */
 class PersonA(name:String, age:Int){
  private val address:String="" // 2 val只能重写另一个val 或者不带参数的def
  override def toString: String = name + " is " + age +" years old. "
}
