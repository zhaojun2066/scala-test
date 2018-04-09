package com.scala.test.clazz

import scala.collection.mutable.ArrayBuffer

/**
  * Created by jufeng on 2018/4/8.
  * 嵌套类
  */
class NetWork {

  class Member(val  name:String){
    println("name is " +name)
  }
  private val members = new ArrayBuffer[Member]()

  def join(name:String) = {
    val m = new  Member(name)
    members += m
    m
  }
}
