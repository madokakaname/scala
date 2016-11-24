package database.jdbc

import java.sql.DriverManager
import java.sql.Connection

/**
  * Created by Sergei on 24.11.2016.
  */
object JDBCManager {

  def main(args: Array[String]) {
    // connect to the database named "mysql" on the localhost
    val driver = "org.postgresql.Driver"
    val url = "jdbc:postgresql://localhost:5432/postgres"
    val username = "postgres"
    val password = "admin"

    // there's probably a better way to do this
    var connection:Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT sn.name, n.nationality FROM second_name sn, nationalities n" + "\n"
        + "where sn.nationality_id = n.nationality_id")
      while ( resultSet.next() ) {
        val nameToNationality = (resultSet.getString("name"), resultSet.getString("nationality"))
        println(nameToNationality)
      }
    } catch {
      case e => e.printStackTrace
    }
    connection.close()
  }


}
