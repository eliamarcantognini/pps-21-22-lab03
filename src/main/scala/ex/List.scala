package ex

import scala.annotation.tailrec

object List extends App:

  // A generic linkedlist
  enum List[E]:
    case Cons(head: E, tail: List[E])
    case Nil()
  // a companion object (i.e., module) for List
  object List:

    def sum(l: List[Int]): Int = l match
      case Cons(h, t) => h + sum(t)
      case _ => 0

    @tailrec
    def drop[A](l: List[A], n: Int): List[A] = l match
      case Cons(h, t) if n > 0 => drop(t, n-1)
      case Cons(h, t) => Cons(h, t)
      case _ => Nil()

    def append[A](left: List[A], right: List[A]): List[A] = (left, right) match
      case (Cons(h, t), right) => Cons(h, append(t, right))
      case _ => right

    def flatMap[A, B](l: List[A])(f: A => List[B]): List[B] = l match
      case Cons(h, t) => append(f(h), flatMap(t)(f))
      case _ => Nil()

    def map[A, B](l: List[A])(mapper: A => B): List[B] = flatMap(l)(a => Cons(mapper(a), Nil()))

    def filter[A](l: List[A])(pred: A => Boolean): List[A] =
      flatMap(l)(a => if (pred(a)) Cons(a, Nil()) else Nil())

    def max(l: List[Int]): Option[Int] = l match
      case Cons(h: Int, Nil()) => Some(h)
      case Cons(h, t) => max(t) match
        case Some(a)  if a > h => Some(a)
        case _ => Some(h)
      case Nil() => None
