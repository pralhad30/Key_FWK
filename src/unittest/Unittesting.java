package unittest;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class Unittesting {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void test() {
		calculator obj1 = new calculator();
		int output_f = obj1.addition(4,5);
		assertEquals(9,output_f);
		System.out.print(output_f);
	}

}
