package com.scala.test.traits

/**
  * Created by jufeng on 2018/4/10.
  * 特质里未被实现的方法均是抽象的，所以不用加上abstract
  */
trait Logger {
  def log(msg:String) //这是一个抽象方法
  def info(msg: String) {log("INFO: " + msg)}
  def warn(msg: String) {log("WARN: " + msg)}
  def debug(msg: String) {log("DEBUG: " + msg)}
}


