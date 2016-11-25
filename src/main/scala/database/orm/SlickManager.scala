package database.orm

import scala.slick.driver.PostgresDriver.simple._

/**
  * Created by Sergei on 24.11.2016.
  */
object SlickManager {

  class Nationalities(tag: Tag) extends Table[(String, Int)](tag, "nationalities") {
    def nationality = column[String]("nationality")
    def nationality_id = column[Int]("nationality_id")
    def * = (nationality, nationality_id)
  }

  def main(args: Array[String]): Unit = {

    // my database server is located on the localhost
    // database name is "my-db"
    // username is "postgres"
    // and password is "postgres"
    val connectionUrl = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=admin"

    Database.forURL(connectionUrl, driver = "org.postgresql.Driver") withSession {
      implicit session =>
        val nationalities = TableQuery[Nationalities]

        // SELECT * FROM users
        nationalities.list foreach { row =>
          println("nationality: " + row._1 + " id: " + row._2)
        }

        // SELECT * FROM users WHERE username='john'
        nationalities.filter(_.nationality_id === 3).list foreach { row =>
          println("nationality whose id = 3 is "+row._1 )
        }
    }
  }


}
