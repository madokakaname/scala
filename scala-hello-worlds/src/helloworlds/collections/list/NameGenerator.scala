package helloworlds.collections.list

import scala.util.Random

/**
  * Created by Sergei on 20.11.2016.
  */
object NameGenerator {
  val firstPartList:List[String] = generateFirstPart
  val secondPartList:List[String] = generateSecondPart

  def generateRandomName: Unit = {
    val name:String = getRandomFirstPart + " " + getRandomSecondPart
//    val name = List(firstPartList, secondPartList).map()
    println(name)
  }
  def getRandomFirstPart: String = {
    firstPartList(Random.nextInt(firstPartList.size))
  }
  def getRandomSecondPart: String = {
    secondPartList(Random.nextInt(secondPartList.size))
  }
  def generateFirstPart: List[String] = {
    val firstPart = List("John", "Ivan", "Bill")
    firstPart
  }
  def generateSecondPart: List[String] = {
    val secondPart = List("Cena", "Petrov", "Gates")
    secondPart
  }


}
