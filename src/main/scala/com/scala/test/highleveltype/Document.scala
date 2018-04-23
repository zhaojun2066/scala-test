package com.scala.test.highleveltype

import com.sun.prism.impl.Disposer.Target
import sun.awt.resources.awt

import scala.collection.mutable
import scala.io.Source

/**
  * Created by jufeng on 2018/4/19.
  */
class Document {

  def setTitle(title: String):this.type ={
    this
  }

  def setAuthor(title:String):this.type = {
    this
  }


  //结构类型 ，意思一组关于抽象方法、字段，类型的说明 ，如下面target
  // 你可以对任何含有append方法的实例调用appendLines方法
  def appendLines(target: {def append(str: String): Any},
                  lines: mutable.Iterable[String]): Unit ={
    for (l <- lines) {
      target.append(l)
      target.append("\n")
    }

  }


  //target限制为混合类型
  def appendLines2(target: AutoCloseable with Serializable {def append(str: String): Any},
                   lines: mutable.Iterable[String]): Unit ={
    for (l <- lines) {
      target.append(l)
      target.append("\n")
    }

  }


}


class Book extends Document{
  def  addChapter(chapter: String) ={
    this
  }

  //为这个hashmap创建一个别名
  type Index  = mutable.HashMap[String,(Int,Int)]
}

//单例类型
object Title
class Doc{
  private var usrNextArgsAs: Any = null
  var title:String = _
  def set(obj:Title.type ):this.type  = {usrNextArgsAs = obj;this}
  def to(arg: String) = if (usrNextArgsAs== Title) title = arg else title = "no"
}




//抽象类型
trait Reader{
  type Contents
  def read(file:String):Contents
}
class StringReader extends Reader{
  override type Contents = String
  override def read(file: String): Contents = {
    Source.fromFile(file,"utf-8").mkString
  }
}
//类型参数实现
trait Read[C]{
  def read(file:String):C
}
class StringRead extends Read[String]{
  override def read(file: String): String = {
    Source.fromFile(file,"utf-8").mkString
  }
}


object Test{
  def main(args: Array[String]): Unit = {
    val doc = new  Document
    doc.setTitle("").setAuthor("")

    val book = new Book
    //book.setTitle("").setAuthor("").addChapter("") addChapter 会错误，因为他返回的是Document 不是 Book,Document 没有addChapter。
    //解决办法是返回this.type ,book
    book.setTitle("").setAuthor("").addChapter("")

    val d = new  Doc
    d.set(Title).to("hello ")

  }
}