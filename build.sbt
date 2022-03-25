name := "Phil's Cube"

version := "0.1"

scalaVersion := "3.1.1"

//libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.11"
//libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.11" % "test"

libraryDependencies ++= Seq(
  "org.scalatestplus" %% "scalacheck-1-15" % "3.2.11.0" % Test,
  "org.scalatest" %% "scalatest" % "3.2.11" % Test,
  "org.scalacheck" %% "scalacheck" % "1.15.4" % Test
)

/*
assembly / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x                             => MergeStrategy.first
}
assembly / mainClass := Some("cube.Cube")
assembly / test := {}
 */
