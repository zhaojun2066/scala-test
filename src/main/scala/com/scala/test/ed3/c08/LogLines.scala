package com.scala.test.ed3.c08

import scala.io.Source

/**
  * Created by jufeng on 2018/5/21.
  */
class LogLines {

/*  def processLine(fileName: String, line: String, width: Int) = {
    if (line.length> width){
      println(fileName + " : "  + line.trim)
    }
  }*/

  def processFile(fileName: String, width: Int) = {
    val source = Source.fromFile(fileName)
    for (line <- source.getLines() /*;if line.length> width*/)
      proLine(line)


    //内部的局部函数
    def proLine(line: String) = {
      if  (line.length> width)
        println(fileName + " : "  + line.trim)
    }
  }

}

object LogLines{
  def main(args: Array[String]): Unit = {
    val width = args(0).toInt
    val l = new LogLines
    for (a<- args.drop(1))  //drop 截取从index 到length长度
      l.processFile(a,width)

  }
}
