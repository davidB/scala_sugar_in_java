package sandbox_sugar

import junit.framework.Assert._
import org.junit.Test
import scala.reflect.{BeanProperty, BeanInfo}

//@BeanInfo // to generate BeanInfo
// use @BeanProperty only if you need to integrate with a java framework that require getter/setter (getXxxx/setXxxx)
case class MyScalaStructA(@BeanProperty name : String, @BeanProperty var age : Int)

//@BeanInfo
class MyScalaStructB(val name : String, var age : Int)


class MyScalaStructTest() {

	@Test
	def testMyScalaStructA() {
		val a = MyScalaStructA(("A" + 'b').toUpperCase, 30)
		
		assertEquals("AB", a.name)
		assertTrue("AB" == a.name) //in scala == call equals method
		assertFalse(a.name eq "AB")
		assertEquals("AB", a.getName())
		// a.name = "foo" // read-only => doesn't compile
		//a.setName("foo") // read-only => doesn't compile
		
		assertEquals(30, a.age)
		a.age = a.age + 1
		assertEquals(31, a.age)
		a.setAge(a.getAge + 1)
		assertEquals(32, a.age)

		// readable default toString generated
		assertEquals("MyScalaStructA(AB,32)", a.toString)

		// equals on field generated
		assertEquals(MyScalaStructA("AB",32), a)
		assertTrue(MyScalaStructA("AB",32) == a)
		assertEquals(MyScalaStructA("AB",32).hashCode, a.hashCode)
	}
	
	@Test
	def testMyScalaStructB() {
		// same feature as case class, except... 
		
		// ... need to use 'new' operator
		val b = new MyScalaStructB("B", 30)
		assertEquals("B", b.name)
		assertEquals(30, b.age)

		// ... readable toString not generated (same a default java toString())
		assertFalse("MyScalaStructB(B,30)" == b.toString)
		
		// ... equals method about fields not generated (and hashCode) (same as default java equals() and hashCode() )
		assertFalse(new MyScalaStructB("B", 30) == b)
		
		// ... more (no extractor for pattern matching....
	}
}