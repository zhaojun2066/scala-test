package com.scala.test.typeparams

/**
  * Created by jufeng on 2018/4/20.
  *  型变 sealed abstract class List[+A]  就是型变
  */


abstract class Animal {
  def name: String
}
case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal


object CovarianceTest extends App {
  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  printAnimalNames(cats)
  // Whiskers
  // Tom
  printAnimalNames(dogs)
  // Fido
  // Rex
}
