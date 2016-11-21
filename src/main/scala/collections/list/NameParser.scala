package collections.list

import java.io.{BufferedWriter, File, FileWriter, PrintWriter}

import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

/**
  * Created by Sergei on 20.11.2016.
  */
object NameParser {
  val maleNameURL = "http://random-name-generator.info/male-names/"
  val femaleNameURL = "http://random-name-generator.info/female-names/"
  val lastNameURL = "http://random-name-generator.info/last-names/"

  def parse(maleFirstNameFile:String, femaleFirstNameFile:String, lastNameFile:String) = {
    parseFirstName(maleFirstNameFile, femaleFirstNameFile)
    parseSecondName(lastNameFile)
  }

  def parseFirstName(maleFirstNameFile:String, femaleFirstNameFile:String) = {
    writeNames(maleFirstNameFile, maleNameURL)
    writeNames(femaleFirstNameFile, femaleNameURL)
  }

  def parseSecondName(lastNameFile:String) = writeNames(lastNameFile, lastNameURL)

  def writeNames(fileName:String, url:String) = {
    val bw = new BufferedWriter(new PrintWriter(new File(fileName)))
    for (char <- 'A' to 'Z') {
      val elements = Jsoup.connect(url + char).get().getElementsByClass("nameList")
      val tempTable = elements.iterator()
      while (tempTable.hasNext()) {
        val names = tempTable.next().getAllElements.iterator()
        names.next()
        while (names.hasNext()) {
          bw.write(names.next().text())
          bw.newLine()
        }
      }
    }
    bw.close
  }

}
