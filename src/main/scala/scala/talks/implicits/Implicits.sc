/* implicit params */

implicit val minOrdering: Ordering[Int] = Ordering.fromLessThan[Int](_ < _)

List(3, 1, 2).sorted

/* implicit conversions */

//val x: Int = 2.3  //won't compile because you cannot assign Double to Int

import scala.language.implicitConversions

implicit def double2Int(x: Double): Int = x.toInt

val x: Int = 2.3

/* ambiguity problem */

//implicit val maxOrdering: Ordering[Int] = Ordering.fromLessThan[Int](_ > _)

List(3, 1, 2).sorted

