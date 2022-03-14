package ex

import org.junit.Assert.assertEquals
import org.junit.Test
import List.*

class ListTest:
  import List.*

  val l: List[Int] = Cons(10, Cons(20, Cons(30, Nil())))

  @Test
  def testDrop(): Unit =
    assertEquals(Cons(20, Cons(30, Nil())), drop(l, 1))
    assertEquals(Cons(30, Nil()), drop(l, 2))
    assertEquals(Nil(), drop(l, 3))
    assertEquals(Nil(), drop(l, 5))

  @Test
  def testAppend(): Unit =
    assertEquals(l, append(Nil(), l))
    assertEquals(l, append(l, Nil()))
    assertEquals(Cons(10, Cons(20, Cons(30, Cons(40, Nil())))), append(l, Cons(40, Nil())))

  @Test
  def testFlatMap(): Unit =
    val l1: List[Int] = Cons(11, Cons(12, Cons(21, Cons(22, Cons(31, Cons(32, Nil()))))))
    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), flatMap(l)(v => Cons(v + 1, Nil())))
    assertEquals(l1, flatMap(l)(v => Cons(v + 1, Cons(v + 2, Nil()))))

  @Test
  def testMap(): Unit =
    assertEquals(Cons(11, Cons(21, Cons(31, Nil()))), map(l)(_ + 1))
    assertEquals(Cons("10", Cons("20", Cons("30", Nil()))), map(l)(_ + ""))