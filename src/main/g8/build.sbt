Global / onChangedBuildSource := ReloadOnSourceChanges

// meta- & publish-information
inThisBuild(
  List(
    organization := "$organization$",
    homepage := Some(url("https://github.com/<your-gh-username>/$name$")),
    licenses := Seq(
      // Add your licenses here, e.g.:
      // "MIT License" -> url("https://opensource.org/licenses/MIT")
    ),
    developers := List(
      Developer(
        "your-gh-username",
        "Your Name",
        "your@email.address",
        url("https://github.com/<your-gh-username>")
      )
    ),
    version := "0.1.0-SNAPSHOT"
  )
)

// build-information
val scala2Version = "$scala2_version$"
val scala3Version = "$scala3_version$"

// For information on scala-2 and -3 cross-building see: https://docs.scala-lang.org/scala3/guides/migration/tutorial-macro-cross-building.html

inThisBuild(
  Seq(
    crossScalaVersions := Seq(scala2Version, scala3Version),
    scalaVersion := scala2Version, // switch to `scala3Version` if you want scala3 by default
    testFrameworks += new TestFramework("utest.runner.Framework")
  )
)

// manual aggregation project to prevent publishing
lazy val root = (project in file("."))
  .aggregate($package_name$.js, $package_name$.jvm)
  .settings(
    publish := {},
    publishLocal := {}
  )

// For information on JVM&JS cross-building see: https://github.com/portable-scala/sbt-crossproject

lazy val $package_name$ =
  crossProject(
    JSPlatform,
    JVMPlatform
    /*, NativePlatform */ // `NativePlatform` might work, haven't tested too much
  )
    .crossType(CrossType.Pure)
    .settings(
      name := "$package_name$",
      libraryDependencies ++= Seq(
        "com.lihaoyi" %%% "utest" % "0.8.1" % "test"
      )
    )
    .jsSettings() // ScalaJs-specific settings
    .jvmSettings() // ScalaJvm-specific settings
