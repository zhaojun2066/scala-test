package com.scala.test.typeparams

/**
  * Created by jufeng on 2018/4/18.
  * 泛型类
  */
class Pair[T,S] (val fitst: T ,val second: S)

class  Test{

  //泛型方法，scala 会根据实际参数推断出类型
  def getMiddle[T] (a :Array[T]) = a(a.length /2)

  //如果有必要，也可以保存到f ,就是具体的函数了
  val f = getMiddle[String] _
}

//类型变量界定 必须是Comparable[T] 的子类型 ，才可以
class Pat[T <:Comparable[T]] (val  f:T ,val s:T){
  def smaller = if (f.compareTo(s)<0) f else  s
}

class PP[T](val f:T ,val s : T){
  def replaceFirst[R >: T](newf: R) = new PP[R](newf,s)
}

//视图界定,Int 没有实现Comparable ，但是RichInt实现了，<% 可以隐士的转换为RichInt
class Pairs[T <% Comparable[T]]
class Pairss[T <% Ordered[T]] (val f:T ,val s:T){
  def smaller = if (f>s) f else s
}

//型变,+T 意味着 Student 是Person的子类 所以PPP[Student]也是 PPP[Person]的子类型了
// mkFriends(p: PPP[Person]) 也就可以接受PPP[Student] 参数了，否则二者是没有关系的
class  Person
class Student extends Person
class PPP[+T](val f: T ,s:T){
  def  mkFriends(p: PPP[Person])={
    println(p.f)
  }
}






