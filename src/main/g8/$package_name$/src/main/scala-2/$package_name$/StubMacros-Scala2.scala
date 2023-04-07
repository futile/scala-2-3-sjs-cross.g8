package $package_name$

import scala.reflect.macros._

object StubMacros {
  def answerToEverything: Int = macro answerToEverythingImpl

  def answerToEverythingImpl(c: blackbox.Context): c.Tree = {
    import c.universe._
    q"42"
  }
}
