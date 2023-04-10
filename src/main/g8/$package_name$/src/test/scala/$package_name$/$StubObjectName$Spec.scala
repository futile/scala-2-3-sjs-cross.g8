package $package_name$

import utest._

object $StubObjectName$Spec extends TestSuite {
  val tests = Tests {
    test("helloWorld works") {
      assert($StubObjectName$.helloWorld == "Hello, World!")
    }

    test("answerToEverything works") {
      assert($StubObjectName$Macros.answerToEverything == 42)
    }
  }
}
