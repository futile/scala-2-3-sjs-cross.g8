// ScalaJs & Scala-Native cross-building, see https://github.com/portable-scala/sbt-crossproject
// ScalaJs
addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject" % "1.3.0")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "1.13.0")
// Scala-Native
// addSbtPlugin("org.portable-scala" % "sbt-scala-native-crossproject" % "1.3.0")
// addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.12")

// Improved defaults for `scalacOptions`: https://github.com/typelevel/sbt-tpolecat
addSbtPlugin("io.github.davidgregory084" % "sbt-tpolecat" % "0.4.2")
