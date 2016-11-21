package collections.list

import scala.util.Random

/**
  * Created by Sergei on 20.11.2016.
  */
object NameGenerator {

  def parseNameSurname: Unit = {
    NameParser.parse(maleFirstNameFile, femaleFirstNameFile, lastNameFile)
  }

  val maleFirstNameFile = "C:/Users/Sergei/Documents/GitHub/scala/scala-hello-worlds/res/MaleFirstNames.txt"
  val femaleFirstNameFile = "C:/Users/Sergei/Documents/GitHub/scala/scala-hello-worlds/res/FemaleFirstNames.txt"
  val lastNameFile = "C:/Users/Sergei/Documents/GitHub/scala/scala-hello-worlds/res/LastNames.txt"
  val maleFirstNamesList:List[String] = generateMaleFirstName
  val femaleFirstNamesList:List[String] = generateFemaleFirstName
  val secondNamesList:List[String] = generateSecondNames

  def generateRandomMaleName: Unit = {
    val name:String = maleFirstNamesList(Random.nextInt(maleFirstNamesList.size)) + " " + secondNamesList(Random.nextInt(secondNamesList.size))
    println(name)
  }

  def generateRandomFemaleName: Unit = {
    val name:String = femaleFirstNamesList(Random.nextInt(femaleFirstNamesList.size)) + " " + secondNamesList(Random.nextInt(secondNamesList.size))
    println(name)
  }


  def generateMaleFirstName: List[String] = {
    val source = scala.io.Source.fromFile(maleFirstNameFile)
    val firstPart = source.getLines().toList
    source.close()
    firstPart
  }

  def generateFemaleFirstName: List[String] = {
    val source = scala.io.Source.fromFile(femaleFirstNameFile)
    val firstPart = source.getLines().toList
    source.close()
    firstPart
  }

  def generateSecondNames: List[String] = {
    val source = scala.io.Source.fromFile(lastNameFile)
    val secondPart = source.getLines().toList
    source.close()
    secondPart
  }

}
