package database.orm

import sorm._

/**
  * Created by Sergei on 24.11.2016.
  */
object SORMManager {

  case class Artist(name: String, genres: Set[Genre])
  case class Genre(name: String)

  object Db extends Instance(
    entities = Set(Entity[Artist](), Entity[Genre]()),
    url = "jdbc:postgresql://postgres:admin@localhost:5432/postgres"
  )

  def main (args: Array[String]) {
    // Declare a model:

    // Initialize SORM, automatically generating schema:

    // Store values in the db:
    val metal = Db.save(Genre("Metal"))
    val rock = Db.save(Genre("Rock"))
    Db.save(Artist("Metallica", Set(metal, rock)))
    Db.save(Artist("Dire Straits", Set(rock)))

    // Retrieve values from the db:
    // Option[Artist with Persisted]:
    val metallica = Db.query[Artist].whereEqual("name", "Metallica").fetchOne()
    // Stream[Artist with Persisted]:
    val rockArtists = Db.query[Artist].whereEqual("genres.item.name", "Rock").fetch()
  }

}
