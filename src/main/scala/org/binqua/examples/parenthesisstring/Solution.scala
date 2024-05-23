package org.binqua.examples.parenthesisstring

import scala.annotation.tailrec

object Solution {
  def checkValidString(s: String): Boolean =
    validate(charsToBeAnalysed = s.toList, openedCounter = List(0))

  @tailrec private def validate(charsToBeAnalysed: List[Char], openedCounter: List[Int]): Boolean = {
    val potentialClosedAhead = charsToBeAnalysed.count(c => c == ')' || c == '*')
    val newCounters = openedCounter.filter(opened => opened >= 0 && opened <= potentialClosedAhead)
    newCounters match {
      case Nil => false
      case counters =>
        charsToBeAnalysed match {
          case Nil                => counters.contains(0)
          case ::('(', charsLeft) => validate(charsLeft, counters.map(_ + 1))
          case ::(')', charsLeft) => validate(charsLeft, counters.map(_ - 1))
          case ::('*', charsLeft) =>
            val newCounters = List(1, 0, -1).flatMap(x => counters.map(_ + x)).distinct
            validate(charsLeft, openedCounter = newCounters)
          case ::(_, _) => false
        }
    }

  }

}
