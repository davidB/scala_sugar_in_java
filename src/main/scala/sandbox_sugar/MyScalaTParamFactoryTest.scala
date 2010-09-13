package sandbox_sugar

import junit.framework.Assert._
import org.junit.Test

class MyScalaTParamFactoryTest() {

  def newOne[T]()(implicit m: Manifest[T]): T = {
    // assume T as a no-args constructor
    m.erasure.newInstance().asInstanceOf[T]
  }

  // sample call

  @Test
  def testMyScalaStructA() {
    val v = newOne[String]()
    assertEquals("", v)
  }
}