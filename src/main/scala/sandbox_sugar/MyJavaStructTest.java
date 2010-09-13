package sandbox_sugar;

import static org.junit.Assert.*;
import org.junit.Test;

class MyJavaStructA {
	private final String _name;
	private int _age;
	
	// code below generated by IDE (several clicks)
	// need to edit code below if we'll add/remove field

	public MyJavaStructA(String name, int age) {
		this._name = name;
		this._age = age;
	}

	public int getAge() {
		return _age;
	}

	public void setAge(int age) {
		this._age = age;
	}

	public String getName() {
		return _name;
	}

	@Override
	public String toString() {
		return "MyJavaStructA [_name=" + _name + ", _age=" + _age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _age;
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyJavaStructA other = (MyJavaStructA) obj;
		if (_age != other._age)
			return false;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
		return true;
	}
	
}

public class MyJavaStructTest {
	@Test
	public void testMyJavaStructA() {
		MyJavaStructA a = new MyJavaStructA(("A" + 'b').toUpperCase(), 30);
		
		assertEquals("AB", a.getName());
		assertFalse("AB" == a.getName());
		//a.setName("foo") // read-only => doesn't compile
		
		assertEquals(30, a.getAge());
		a.setAge(a.getAge() + 1);
		assertEquals(31, a.getAge());

		// readable default toString generated
		assertEquals("MyJavaStructA [_name=AB, _age=31]", a.toString());

		// equals on field generated
		assertEquals(new MyJavaStructA("AB",31), a);
		assertFalse(new MyJavaStructA("AB",31) == a);
		assertEquals(new MyJavaStructA("AB",31).hashCode(), a.hashCode());
	}
}
