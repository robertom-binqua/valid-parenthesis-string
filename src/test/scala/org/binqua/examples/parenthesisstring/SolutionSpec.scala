package org.binqua.examples.parenthesisstring

import munit.FunSuite
import org.binqua.examples.parenthesisstring.Solution._

class SolutionSpec extends FunSuite {

  test("adsf invalid") {
    assertEquals(checkValidString("adsf"), false)
  }

  test("() valid") {
    assertEquals(checkValidString("()"), true)
  }

  test("(()) valid") {
    assertEquals(checkValidString("(())"), true)
  }

  test("(()()) valid") {
    assertEquals(checkValidString("(()())"), true)
  }

  test("(()())()() valid") {
    assertEquals(checkValidString("(()())()()"), true)
  }

  test("(( invalid") {
    assertEquals(checkValidString("(("), false)
  }

  test(")) invalid") {
    assertEquals(checkValidString("))"), false)
  }

  test(") invalid") {
    assertEquals(checkValidString(")"), false)
  }

  test("(* valid") {
    assertEquals(checkValidString("(*"), true)
  }

  test("** valid") {
    assertEquals(checkValidString("**"), true)
  }

  test("*( invalid") {
    assertEquals(checkValidString("*("), false)
  }

  test("**** valid") {
    assertEquals(checkValidString("****"), true)
  }

  test("*** valid") {
    assertEquals(checkValidString("***"), true)
  }

  test("(()))) invalid") {
    assertEquals(checkValidString("(())))"), false)
  }

  test("(())* valid") {
    assertEquals(checkValidString("(())*"), true)
  }

  test("((((((((())))))))) valid") {
    assertEquals(checkValidString("((((((((()))))))))"), true)
  }

  test("(((((((((*)))))))))))((*) valid") {
    assertEquals(checkValidString("(((((((((*)))))))))))((*)"), false)
  }

  test("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(()) invalid") {
    assertEquals(
      checkValidString(
        "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"
      ),
      false
    )
  }

}
