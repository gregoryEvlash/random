import sbt._

object Dependencies {

  val `cats-helper` = "com.evolutiongaming" %% "cats-helper" % "2.7.2"
  val scalatest     = "org.scalatest"       %% "scalatest"   % "3.1.1"

  object Cats {
    private val version = "2.6.1"
    val core   = "org.typelevel" %% "cats-core" % version
  }

  object CatsEffect {
    private val version = "2.5.1"
    val effect = "org.typelevel" %% "cats-effect" % version
  }
}