package karazin.scala.users.group.week1.homework

import munit.ScalaCheckSuite
import org.scalacheck.Prop.*
import org.scalacheck.Gen

class ErrorOrSuite extends ScalaCheckSuite {

  import karazin.scala.users.group.week1.homework.adt.ErrorOr
  // Fix ??? according to your naming
  property("applying pure value returns Value") {
    forAll { (value: Int) =>
      ErrorOr(value) == ErrorOr.Value(value)
    }
  }

  // Fix ??? according to your naming
  property("applying value which throws an exception returns Exception") {
    val exceptionGen: Gen[Throwable] = Gen.const(new RuntimeException("Test Exception"))
    forAll(exceptionGen) { exception =>
      ErrorOr(throw exception) == ErrorOr.Error(exception)
    }
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some non-error case and function returns non-error case
  property("flatmap returns ??? if `f` returns ???") {
    false
  }

  // Fix ???? according to your naming
  // Check the property when ErrorOr represents some non-error case but function returns error case
  property("flatmap returns ???? if `f` returns ????") {
    false
  }

  // Fix ??? according to your naming
  // Check property when ErrorOr represents some non-error case
  // and function returns non-error case but execution of function fails with some exception
  property("flatmap returns ??? if `f` fails") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some error case
  property("flatmap returns ??? immediately") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some non-error case and function returns non-error case
  property("map returns ??? if `f` returns ???") {
    false
  }

  // Fix ??? according to your naming
  // Check property when ErrorOr represents some non-error case
  // and function returns non-error case but execution of function fails with some exception
  property("map returns ??? if `f` fails") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some error case
  property("map returns ??? immediately") {
    false
  }

}
