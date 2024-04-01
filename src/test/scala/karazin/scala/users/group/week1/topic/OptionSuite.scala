package karazin.scala.users.group.week1.topic

import munit.ScalaCheckSuite
import org.scalacheck.Prop._
import adt.Option
import adt.Option.None
import adt.Option.Some
import karazin.scala.users.group.model.DummyError

class OptionSuite extends ScalaCheckSuite {

  property("applying pure value returns Some") {
    forAll { (v: String) =>
      Option(v) == Some(v)
    }
  }

  property("applying null value returns None") {
    propBoolean {
      Option(null) == None
    }
  }

  property("flatmap returns Some if applied to Some and the function returns Some") {
    forAll { (v: Int, f: Int => String) =>
      Option(v).flatMap(v => Option(f(v))) == Option(f(v))
    }
  }

  property("flatmap returns None if applied to Some but the function returns None") {
    forAll { (v: Int) =>
      Option(v).flatMap(v => None) == None
    }
  }

  property("flatmap returns None immediately") {
    propBoolean {
      None.flatMap(v => throw DummyError) == None
    }
  }

  property("flatmap returns Some if applied to Some") {
    forAll { (v: Int, f: Int => String) =>
      Option(v).map(v => f(v)) == Option(f(v))
    }
  }

  property("map returns None immediately") {
    propBoolean {
      None.map(v => throw DummyError) == None
    }
  }

}
