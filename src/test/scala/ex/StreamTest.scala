package ex

import org.junit.Assert.assertEquals
import org.junit.Test
import Stream.*
import List.*

class StreamTest:

  import Stream.*
  import List.*

  val s: Stream[Int] = Stream.take(Stream.iterate(0)(_ + 1))(10)

  @Test
  def testDrop(): Unit =
    assertEquals(Cons(6, Cons(7, Cons(8, Cons(9, Nil())))), Stream.toList(Stream.drop(s)(6)))