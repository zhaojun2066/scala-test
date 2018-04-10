package com.scala.test.io

import java.io.File

import scala.io.Source

/**
  * Created by jufeng on 2018/4/10.
  */
object SourceTest {

  def main(args: Array[String]): Unit = {
    val source = Source.fromFile("D:\\me\\scala-test\\src\\main\\scala\\com\\scala\\test\\a","UTF-8")
   /* val lineIterator = source.getLines()
    for (l <- lineIterator) println(l)*/

    val contents = source.getLines().toArray.mkString(" ")
    //val contents = source.mkString(" ")
    println("--> " +contents)


    //读取字符，Source的类扩展自Iterator[Char]
    val source2 =  Source.fromFile("D:\\me\\scala-test\\src\\main\\scala\\com\\scala\\test\\a","UTF-8")
    for (c <- source2) println(c)

    //读取所有空格隔开的词法单元
    val source3 =  Source.fromFile("D:\\me\\scala-test\\src\\main\\scala\\com\\scala\\test\\a","UTF-8")
    val tokens = source3.mkString.split("\\s+")
    println(tokens.mkString(","))

    //转换数字
    val s4 = Source.fromFile("D:\\me\\scala-test\\src\\main\\scala\\com\\scala\\test\\number","UTF-8")
    val t4 = s4.mkString.split("\\s+")
    val numbers =t4.map(_.toInt)
    println(numbers.mkString(","))

    val s5 = Source.fromURL("https://github.com/zhaojun2066/scala-test/blob/master/src/main/scala/com/scala/test/extendss/Employee.scala","UTF-8")
    val lineIterator = s5.getLines()
    for (l <- lineIterator) println(l)


    //读取二进制文件,scala 没有提供，你需要使用java类库
    //scala没有提供写入文件的支持，可使用java.io.PrintWriter
    //scala 没有提供访问某个目录中的所有文件，或者递归所有目录的类

  }

/*
  def sundir(dir: File):Iterator[File] = {
    val children = dir.listFiles().filter(_.isDirectory)
    children.toIterator ++ children.toIterator.flatMap(subdis _)
  }
*/

}
