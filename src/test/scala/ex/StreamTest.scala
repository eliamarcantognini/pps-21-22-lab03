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

  @Test
  def testConstant(): Unit =
    val s1 = Cons("x", Cons("x", Cons("x", Cons("x", Cons("x", Nil())))))
    assertEquals(s1, Stream.toList(Stream.take(constant("x"))(5)))

  @Test
  def testFib(): Unit =
    val s1 = Cons(0, Cons(1, Cons(1, Cons(2, Cons(3, Cons(5, Cons(8, Cons(13 , Nil()))))))))
    assertEquals(s1, Stream.toList(Stream.take(fib())(8)))