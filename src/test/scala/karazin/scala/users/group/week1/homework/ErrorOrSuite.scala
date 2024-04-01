package karazin.scala.users.group.week1.homework

import munit.ScalaCheckSuite
import org.scalacheck.Prop.*

class ErrorOrSuite extends ScalaCheckSuite {

  // Fix ??? according to your naming
  property("applying pure value returns ???") {
    false
  }

  // Fix ??? according to your naming
  property("applying value which throws an exception returns ???") {
    false
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
