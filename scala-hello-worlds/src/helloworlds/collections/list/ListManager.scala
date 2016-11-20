package helloworlds.collections.list

import helloworlds.collections.CollectionsManager

/**
  * Created by Sergei on 20.11.2016.
  */
object ListManager extends CollectionsManager{
  override def test: Unit = {

    //call this method to get list of names
    //NameGenerator.parseNameSurname


    NameGenerator.generateRandomMaleName
    NameGenerator.generateRandomFemaleName
  }
}