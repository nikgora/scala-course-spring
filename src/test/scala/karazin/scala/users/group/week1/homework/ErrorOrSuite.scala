package karazin.scala.users.group.week1.homework

import munit.ScalaCheckSuite
import org.scalacheck.Prop.*
import adt.ErrorOr
import adt.ErrorOr.Value
import adt.ErrorOr.Error
import org.scalacheck.Gen
import karazin.scala.users.group.model.DummyError
import java.lang

class ErrorOrSuite extends ScalaCheckSuite {

  import karazin.scala.users.group.week1.homework.adt.ErrorOr
  // Fix ??? according to your naming
  property("applying pure value returns Value") {
    forAll { (value: Int) =>
      ErrorOr(value) == ErrorOr.Value(value)
    }
  }

  // Fix ??? according to your naming
  property("applying value which throws an exception returns Error") {
    forAll { (throwable: Throwable) =>
      val result = try {
        ErrorOr.apply(throw throwable)
      } catch {
        case e: Throwable => ErrorOr.Error(e)
      }
      result == ErrorOr.Error(throwable)
    }
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some non-error case and function returns non-error case
  property("flatmap returns Value if `f` returns Value") {
    forAll { (v: Int, f: Int => String) =>
      ErrorOr(v).flatMap(v => ErrorOr(f(v))) == ErrorOr(f(v))
    }
  }

  // Fix ???? according to your naming
  // Check the property when ErrorOr represents some non-error case but function returns error case
  property("flatmap returns Error if `f` returns Error") {
    forAll { (value: Int, throwable: Throwable) =>
      ErrorOr(value).flatMap(_ => throw throwable)  == Error(throwable)
    }
  }

  // Fix ??? according to your naming
  // Check property when ErrorOr represents some non-error case
  // and function returns non-error case but execution of function fails with some exception
  property("flatmap returns Error if `f` fails") {
    forAll { (v: Int) =>
      Value(v).flatMap(v => throw DummyError) == Error(DummyError)
    }
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some error case
  property("flatmap returns Error immediately") {
    propBoolean {
      Error(DummyError).flatMap(_ => throw IllegalArgumentException()) == Error(DummyError)
    }
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some non-error case and function returns non-error case
  property("map returns Value if `f` returns Value") {
    forAll { (v: Int, f: Int => String) =>
      Value(v).map(v => f(v)) == Value(f(v))
    }
  }

  // Fix ??? according to your naming
  // Check property when ErrorOr represents some non-error case
  // and function returns non-error case but execution of function fails with some exception
  property("map returns Error if `f` fails") {
    forAll { (v: Int) =>
      Value(v).map(v => throw DummyError) == Error(DummyError)
    }
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some error case
  property("map returns Error immediately") {
    propBoolean {
      Error(DummyError).map(_ => throw IllegalArgumentException()) == Error(DummyError)
    }
  }

}
