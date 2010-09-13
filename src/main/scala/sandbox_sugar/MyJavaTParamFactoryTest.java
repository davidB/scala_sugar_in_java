package sandbox_sugar;

import static org.junit.Assert.*;
import org.junit.Test;

public class MyJavaTParamFactoryTest {

	public <T> T newOne(Class<T> clazz) throws Exception {
		return clazz.newInstance();
	}

	@Test
	public void testMyJavaStructA() throws Exception {
		String v = newOne(String.class);
		assertEquals("", v);
	}
}
