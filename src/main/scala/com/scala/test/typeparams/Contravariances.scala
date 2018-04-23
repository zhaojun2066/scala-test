package com.scala.test.typeparams

/**
  * Created by jufeng on 2018/4/20.
  * 逆变
  * 泛型类的类型参数A可以通过使用注解-A变为逆变的。这在类和它的类型参数之间创建了一个跟协变类似但是完全相反的子类型关系。
  * 对于类Writer[-A]，使A变为逆变的，意味着对于两个类型A和B，且A是B的子类型，则Writer[B]是Writer[A]的子类型。
  */
class Contravariances {

}

abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit =
    println("The animal's name is: " + animal.name)
}

class CatPrinter extends Printer[Cat] {
  def print(cat: Cat): Unit =
    println("The cat's name is: " + cat.name)
}

object ContravarianceTest extends App {
  val myCat: Cat = Cat("Boots")
  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(myCat)
  }

  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter
  printMyCat(catPrinter)
  printMyCat(animalPrinter)
}
