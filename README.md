A [Giter8][g8] template for a Scala sbt-project with Scala-2 and -3 cross-compilation, as well as Scala.js and ScalaJvm cross-compilation.
This is a useful starting point for libraries, especially for macro-libraries, as these should usually work, and be useful, cross-platform and -version.

## Usage

To create a project based on this template, run:

``` shellsession
$ sbt new futile/scala-2-3-sjs-cross.g8
```

Afterwards, check out the generated directory layout (also see below), and the generated `build.sbt`, which contains some additional meta-information to configure.

## Features

The created project provides the following features:

* Scala-2 and -3 cross compilation based on https://docs.scala-lang.org/scala3/guides/migration/tutorial-macro-cross-building.html
* Scala.js and ScalaJvm cross-compilation using https://github.com/portable-scala/sbt-crossproject
* Unit-testing with [utest](https://github.com/com-lihaoyi/utest)
* Improved defaults for sbt through [sbt-tpolecat](https://github.com/typelevel/sbt-tpolecat)
* A replicable and shared development environment through [`nix`][nix]
* An example project that implements a macro in Scala-2 and Scala-3


## Template Properties and Layout

These are (at the time of writing) the [properties configurable when instantiating the template](src/main/g8/default.properties):

```
name=new-folder-name
organization=com.github.your_username
package_name=exampackage
scala2_version=2.13.10
scala3_version=3.2.2
StubObjectName=Stub
```

### Created Layout

The layout created by the template looks like this:

```
$new-folder-name$
├── $package_name$
│  └── src
│     ├── main
│     │  ├── scala
│     │  │  └── $package_name$
│     │  │     └── $StubObjectName$.scala
│     │  ├── scala-2
│     │  │  └── $package_name$
│     │  │     └── $StubObjectName$Macros-Scala2.scala
│     │  └── scala-3
│     │     └── $package_name$
│     │        └── $StubObjectName$Macros-Scala3.scala
│     └── test
│        └── scala
│           └── $package_name$
│              └── $StubObjectName$Spec.scala
├── .gitignore
├── build.sbt
├── flake.nix
├── project
│  ├── build.properties
│  └── plugins.sbt
└── README.md
```

## Development

Some notes for developing this project:

### Dev-Environment

It is recommended to use [`nix`][nix] for development, as it provides all the required dependencies, and in the same version as used by CI.
See https://zero-to-nix.com for a gentle and guided introduction to using `nix`.

To enter the development environment with `nix`:

``` shellsession
$ nix flake develop
```

### Quick Tests

Running `g8Test` inside `sbt` can be slow, but there is a simple way to speed up the process.
Instead, inside `sbt` run (requires [just](https://just.systems), including in the nix-environment):

```
~; g8; eval {import scala.sys.process._; "just test-quick" !}
```

This should be almost ~2x faster than `g8Test`.

Note: This will only execute the sbt-command `+test`, and not run all the commands from `src/test/g8/test`.

Template license
----------------
Written in 2023 by Felix Rath, felixm.rath@gmail.com

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See file `LICENSE` and <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
[nix]: https://nixos.org
