package com.scala.test.highlevelfunction

/**
  * Created by jufeng on 2018/4/19.
  * 在这个例子中，方法decorator.layout通过作为方法调用中的参数，被自动转换为类型为Int => String的值。
  * 请注意方法decorator.layout是一个多态方法（也就是说它的签名类型中有一些是抽象而没有明确定义的），
  * 并且Scala编译器需要首先实例化它的方法类型。
  */
class Decorator(left:String,right: String) {

  //泛型方法，scala 会根据实际参数推断出类型
  def layout[A](x:A) = left+x.toString+ right


}

object Decorator{

  def test(f: Int => String ,v:Int) = f(v)

  def main(args: Array[String]): Unit = {
    val decorator = new  Decorator("[","]")
    println(test(decorator.layout,7)) //被自动转换为类型为Int => String的值。
    println(test(decorator.layout _,7)) //手动转换
  }
}
