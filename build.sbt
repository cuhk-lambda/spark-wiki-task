name := "myFirstSparkTask"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.3"
libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "3.2.0"
libraryDependencies += "io.spray" %%  "spray-json" % "1.3.5"

javaOptions in ThisBuild ++= Seq("-Xmx10g", "-Xms5g")
fork := true

enablePlugins(AssemblyPlugin)



assemblyMergeStrategy in assembly := {
  case PathList("org","aopalliance", xs @ _*) => MergeStrategy.last
  case PathList("javax", "inject", xs @ _*) => MergeStrategy.last
  case PathList("org", "apache", xs @ _*) => MergeStrategy.last
  case "git.properties" => MergeStrategy.last
  case "mime.types" => MergeStrategy.last
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}