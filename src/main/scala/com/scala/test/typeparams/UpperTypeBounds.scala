package com.scala.test.typeparams

/**
  * Created by jufeng on 2018/4/20.
  * 在Scala中，类型参数和抽象类型可以通过类型范围进行限制
  * 类PetContainer的类型参数P必须是Pet的子类型。Dog和Cat都是Pet的子类型，所以我们可以创建PetContainer[Dog]和PetContainer[Cat]。
  * 然而，如果我们尝试创建PetContainer[Lion]，则就会得到如下错误：
  *   type arguments [Lion] do not conform to class PetContainer’s type parameter bounds [P <: Pet]
  *   这是因为Lion不是Pet的子类型。
  */
class UpperTypeBounds

abstract class Animals{
  def name: String
}
abstract class Pets extends Animals

class Cats extends Pets{
  override def name: String = "cat"
}

class Dogs extends Pets{
  override def name: String = "dog"
}
class Lions extends Animals{
  override def name: String = "lion"
}

class PetContainer[P <: Pets](p:P){
  def pet:P = p
}

object UpperTypeBounds{
  def main(args: Array[String]): Unit = {
    val dogContainer = new PetContainer[Dogs](new Dogs)
    val catContainer = new PetContainer[Cats](new Cats)
    //  val lionContainer = new PetContainer[Lion](new Lion)
    //                         ^this would not compile
  }
}