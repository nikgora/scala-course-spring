package karazin.scala.users.group.week1.topic


object adt:
  
  /** Represents optional values. Instances of `Option`
   * are either an instance of `Some` or the object `None`.
  */
  enum Option[+V]:

    /** Case `Some[A]` represents existing values of type
     * `A`.
     */
    case Some(x: V) extends Option[V]

    /** This case object represents non-existent values.
     */
    case None extends Option[Nothing]

    /** Returns the result of applying `f`` to this `Option`'s value if
     * this `Option` is nonempty.
     * Returns `None` if this `Option` is empty.
     * Slightly different from `map` in that $f is expected to
     * return an `Option` (which could be `None`).
     *
     *  @param f the function to apply
     */
    def flatMap[Q](f: V => Option[Q]): Option[Q] =
      this match
        case Option.None     => Option.None
        case Option.Some(v)  => f(v)

    /** Returns a `Some` containing the result of applying `f`` to this `Option`'s
     * value if this `Option` is nonempty.
     * Otherwise return `None`.
     *
     *  @note This is similar to `flatMap` except here,
     *  $f does not need to wrap its result in an `Option`.
     *
     *  @param f the function to apply
     */
    def map[Q](f: V => Q): Option[Q] =
      this match
        case Option.None     => Option.None
        case Option.Some(v)  => Option.Some(f(v))

  object Option:
    /** An Option factory which creates Some(x) if the argument is not null,
     * and None if it is null.
     *
     * @param x the value
     * @return Some(value) if value != null, None if value == null
     */
    def apply[V](v: V): Option[V] =
      if v == null then Option.None else Option.Some(v)
