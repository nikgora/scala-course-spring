package karazin.scala.users.group.week2.homework

import karazin.scala.users.group.week2.topic.adt.Option

/*
  Resources:
  * https://en.wikipedia.org/wiki/Algebraic_data_type
  * https://docs.scala-lang.org/scala3/book/types-adts-gadts.html
*/

object adt:
  
  enum ErrorOr[+V]:
    /* 
      Two case must be defined: 
      * a case for a regular value
      * a case for an error (it should contain an actual throwable)
     */
    case Value(v: V)

    case Error(e: Throwable)
    /* 
      The method is used for defining execution pipelines
      Provide a type parameter, an argument and a result type
      
      Make sure that if an internal function is failed with an exception
      the exception is not thrown but the case for an error is returned
    */
    def flatMap[Q](f: V => ErrorOr[Q]): ErrorOr[Q] =
      this match
        case ErrorOr.Value(v) =>
          try
            f(v)
          catch
            case e: Throwable => ErrorOr.Error(e)

        case ErrorOr.Error(e) => ErrorOr.Error(e)

    /* 
      The method is used for changing the internal object
      Provide a type parameter, an argument and a result type
      
      Make sure that if an internal function is failed with an exception
      the exception is not thrown but the case for an error is returned
     */
    def map[Q](f: V => Q): ErrorOr[Q] =
      this match
        case ErrorOr.Value(v) =>
          try
            ErrorOr.Value(f(v))
          catch
            case e: Throwable => ErrorOr.Error(e)

        case ErrorOr.Error(e) => ErrorOr.Error(e)

    def withFilter(p: V => Boolean): ErrorOr[V] =
      this match
        case ErrorOr.Value(v) =>
          try if p(v) then ErrorOr.Value(v) else ErrorOr.Error(new NoSuchElementException(s"Predicate does not hold for $v"))
          catch case e: Throwable => ErrorOr.Error(e)
        case ErrorOr.Error(e) => ErrorOr.Error(e)

    def flatten[U](using ev: V <:< ErrorOr[U]): ErrorOr[U] =
      this match
        case ErrorOr.Value(v) =>
          try ev(v)
          catch case e: Throwable => ErrorOr.Error(e)
        case ErrorOr.Error(e) => ErrorOr.Error(e)

    def foreach[U](f: V => U): Unit =
      this match
        case ErrorOr.Value(v) =>
          try f(v)
          catch case e: Throwable => ()
        case ErrorOr.Error(e) => ()

    def fold[Q](ifEmpty: => Q)(f: V => Q): Q =
      this match
        case ErrorOr.Value(v) =>
          try f(v)
          catch case e: Throwable => ifEmpty
        case ErrorOr.Error(e) => ifEmpty

    def foldLeft[Q](z: Q)(op: (Q, V) => Q): Q =
      this match
        case ErrorOr.Value(v) =>
          try op(z, v)
          catch case e: Throwable => z
        case ErrorOr.Error(e) => z

    def foldRight[Q](z: Q)(op: (V, Q) => Q): Q =
      this match
        case ErrorOr.Value(v) =>
          try op(v, z)
          catch case e: Throwable => z
        case ErrorOr.Error(e) => z


  // Companion object to define constructor
  object ErrorOr:
    /* 
      Provide a type parameter, an argument and a result type
      
      Make sure that if an internal function is failed with an exception
      the exception is not thrown but the case for an error is returned
    */
    def apply[V](v: V): ErrorOr[V] =
      try
        ErrorOr.Value(v)
      catch
        case e: Throwable => ErrorOr.Error(e)
      
  