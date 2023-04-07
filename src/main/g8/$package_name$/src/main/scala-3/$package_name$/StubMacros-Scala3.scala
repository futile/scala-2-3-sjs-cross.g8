package $package_name$

import scala.quoted.{Quotes, Expr}

object StubMacros:
  inline def answerToEverything: Int = \${answerToEverythingImpl}

  private def answerToEverythingImpl(using quotes: Quotes): Expr[Int] =
    '{42}
