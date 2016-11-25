name := "sbt-test-project"

version := "1.0"

scalaVersion := "2.11.0"

// https://mvnrepository.com/artifact/org.jsoup/jsoup
libraryDependencies += "org.jsoup" % "jsoup" % "1.8.3"

// https://mvnrepository.com/artifact/org.postgresql/postgresql
libraryDependencies += "org.postgresql" % "postgresql" % "9.4-1200-jdbc41"

// https://mvnrepository.com/artifact/org.sorm-framework/sorm
libraryDependencies += "org.sorm-framework" % "sorm" % "0.3.21"

// https://mvnrepository.com/artifact/com.typesafe.slick/slick_2.11
libraryDependencies += "com.typesafe.slick" % "slick_2.11" % "2.1.0"
//libraryDependencies += "com.typesafe.slick" %% "slick" % "3.2.0-M1"