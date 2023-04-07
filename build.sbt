Global / onChangedBuildSource := ReloadOnSourceChanges

// at the time of writing, `sbt-scripted`, used for running tests with `g8Test`, only supports up to 2.12
ThisBuild / scalaVersion := "2.12.17"

// This build is for this Giter8 template.
// To test the template run `g8` or `g8Test` from the sbt session.
// `g8`: Outputs template applied with defaults to `target/g8/`
// `g8Test`: Outputs template applied with defaults to `target/sbt-build/, and runs commands defined in `src/test/g8/test`
// `test`: As configured below, redirects to `g8Test`
// See http://www.foundweekends.org/giter8/testing.html#Using+the+Giter8Plugin for more details.
lazy val root = (project in file("."))
  .enablePlugins(ScriptedPlugin)
  .settings(
    name := "scala-2-3-sjs-cross.g8",
    Test / test := {
      val _ = (Test / g8Test).toTask("").value
    },
    scriptedLaunchOpts ++= List(
      "-Xms1024m",
      "-Xmx1024m",
      "-XX:ReservedCodeCacheSize=128m",
      "-Xss2m",
      "-Dfile.encoding=UTF-8"
    ),
    resolvers += Resolver.url(
      "typesafe",
      url("https://repo.typesafe.com/typesafe/ivy-releases/")
    )(Resolver.ivyStylePatterns)
  )
