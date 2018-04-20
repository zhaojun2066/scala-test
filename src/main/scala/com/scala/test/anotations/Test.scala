package com.scala.test.anotations

import java.io.IOException

import com.scala.test.clazz.Conuter
import com.scala.test.objects.Account
import com.sun.istack.internal.NotNull

import scala.annotation.{switch, varargs}
import scala.beans.{BeanProperty, BooleanBeanProperty}

/**
  * Created by jufeng on 2018/4/18.
  */

@SerialVersionUID(444440L)
class Test extends  Serializable{

  def some(@NotNull a :String): Unit ={

  }

  @volatile var dome =  false // jvm 中将是volatile 字段


  //受检异常，和scala 不同，java编译器会跟踪受检异常，如果你从java代码中调用scala代码，其签名应
  //包含那些可能抛出的受检异常，下面例子
  @throws (classOf[IOException]) def read(filename:String){}

  //java
  //void read(String filename) throws IOException
 //如果没有@throws Java代码讲不能捕获该异常

  //变长参数
  //@varargs注解让你可以从Java调用scala的带有变长参数的方法
  def process(args: String*){}
  //scala编译器会变成序列
  def process2(args: Seq[String]){}

  @varargs def process1(args: String*){}
  //加上这个注解会生成如下Java方法：
  //void procees1(String ... args)


  //生成JavaBean风格的getter 和setter
  @BeanProperty var name:String = _
  @BooleanBeanProperty val flag:Boolean = false //生成带有is前缀的getter方法



  //跳变生成，java的switch 会生成跳表，会更加高效
  //scala 可以用@switch注解检查你的match，看是不是真的被编译成了跳转表

  def ma(@switch x:Int):String = x match {
    case 0 => "0"
    case 1 => "1"
    case _ => "?"
  }


  //T 只能是 Long,Double，这样编译会自动生成各自的方法，而不是每次都会自动包装了
  def allDifferent[@specialized(Long,Double) T] (x:T,y: T) = x!=y








}
