package $package_name$

import utest._

object StubSpec extends TestSuite {
  val tests = Tests {
    test("helloWorld works") {
      assert(Stub.helloWorld == "Hello, World!")
    }

    test("answerToEverything works") {
      assert(StubMacros.answerToEverything == 42)
    }
  }
}
