package collections.list

import collections.CollectionsManager

/**
  * Created by Sergei on 20.11.2016.
  */
object ListManager extends CollectionsManager{
  override def test: Unit = {

//    NameGenerator.parseNameSurname
    NameGenerator.generateRandomMaleName
    NameGenerator.generateRandomFemaleName
  }
}