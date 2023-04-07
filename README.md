A [Giter8][g8] template for a scala sbt-project with scala2 and -3 cross-compilation, as well as Scala.js and ScalaJvm cross-compilation.

## Features

The created project provides the following features:

* Scala-2 and -3 cross compilation based on https://docs.scala-lang.org/scala3/guides/migration/tutorial-macro-cross-building.html
* Scala.js and ScalaJvm cross-compilation using https://github.com/portable-scala/sbt-crossproject
* Unit-testing with [utest](https://github.com/com-lihaoyi/utest)
* Improved defaults for sbt through [sbt-tpolecat](https://github.com/typelevel/sbt-tpolecat)
* An example project to demonstrate the file structure and capabilities

### Quick Tests

Running `g8Test` inside can be slow, but there is a simple way to speed up the process.
Instead, inside `sbt` run:

```
~; g8; eval {import scala.sys.process._; "cd target/g8/ && sbt +test" !}
```

This should be almost ~2x faster than `g8Test`.

Note: This will only execute the sbt-command `+test`, and not run all the commands from `src/test/g8/test`.

Template license
----------------
Written in 2023 by 'Felix Rath', felixm.rath@gmail.com

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See file `LICENSE` and <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
