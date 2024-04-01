package karazin.scala.users.group.week2.homework

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

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some value case
  property("withFilter returns ??? if applied to ??? and predicate is true") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some value case
  property("withFilter returns ??? if applied to ??? and predicate is false") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some error case
  property("withFilter returns ??? if applied to ??? and predicate is true") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some error case
  property("withFilter returns ??? if applied to ??? and predicate is false") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when a nested ErrorOr represents some value case
  property("flatten returns ??? if applied to a nested ???") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when a nested ErrorOr represents some error case
  property("flatten returns ??? if applied to a nested ???") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some error case
  property("flatten returns ??? if applied to ???") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when a nested value is not an ErrorOr
  property("flatten compilation fails if applied to a none-??? nested") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some value case
  property("foreach applies side effect if applied to ???") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some error case
  property("foreach ignores side effect if applied to ???") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some value case
  property("fold returns the result of the function application if applied to ???") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some error case
  property("fold returns default if applied to ???") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some value case
  property("foldLeft returns the result of the function application if applied to ???") {
    false
  }

  // Fix ??? according to your naming
  // Check the property when ErrorOr represents some error case
  property("foldLeft returns acc if applied to ???") {
    false
  }

}
