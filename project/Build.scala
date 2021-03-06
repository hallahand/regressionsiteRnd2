import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "regressionsite"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
	"mysql" % "mysql-connector-java" % "5.1.18",
	"org.apache.poi" % "poi" % "3.9",
	"com.typesafe" %% "play-plugins-mailer" % "2.1-RC2",
    javaCore,
    javaJdbc,
    javaEbean
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here 
  )

}
