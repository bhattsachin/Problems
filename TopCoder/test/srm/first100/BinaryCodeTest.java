package srm.first100;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryCodeTest {
	
	BinaryCode code = new BinaryCode();

	
	
	@Test
	public void testOne(){
		String[] output = new String[]{"01",  "10"};
		String[] result = code.decode("11");
		assertArrayEquals(output,result);
	}
	
	@Test
	public void testTwo(){
		String[] output = new String[]{"NONE",  "11001"};
		String[] result = code.decode("22111");
		System.out.println(result[0] + " " + result[1]);
		assertArrayEquals(output,result);
	}
	
	@Test
	public void testThree(){
		String[] output = new String[]{"NONE",  "NONE"};
		String[] result = code.decode("123210120");
		System.out.println(result[0] + " " + result[1]);
		assertArrayEquals(output,result);
	}

	@Test
	public void testFour(){
		String[] output = new String[]{"01101001101101001101001001001101001",  "10110010110110010110010010010110010"};
		String[] result = code.decode("12221112222221112221111111112221111");
		System.out.println(result[0] + " " + result[1]);
		assertArrayEquals(output,result);
	}
	
	@Test
	public void testFive(){
		String[] output = new String[]{"011100011",  "NONE"};
		String[] result = code.decode("123210122");
		System.out.println(result[0] + " " + result[1]);
		assertArrayEquals(output,result);
	}
}
