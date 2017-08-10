package test;

import org.junit.Assert;
import org.junit.Test;

import main.java.algo.MyAlgo;

public class MyAlgoTest {
	
	@Test
	public void compareTripTest(){
		Assert.assertArrayEquals(new int[]{0},
		MyAlgo.compareTripTest(1,2,3,1,2,3));
		
	}
	
	@Test
	public void count8Test(){
		Assert.assertEquals(4,
				MyAlgo.count8(8818));
		Assert.assertEquals(2,
				MyAlgo.count8(818));
		Assert.assertEquals(4,
				MyAlgo.count8(8188));
	}
	
	@Test
	public void sumDigitsTest(){
	Assert.assertEquals(13,
			MyAlgo.sumDigits(49));
	Assert.assertEquals(9,
			MyAlgo.sumDigits(27));
	Assert.assertEquals(9,
			MyAlgo.sumDigits(126));
	}
	@Test
	public void fibTest(){
	Assert.assertEquals(8,
			MyAlgo.fib(6));
	}
	//@Test
	public void triangleTest() {
		Assert.assertEquals(9,
				MyAlgo.bS(new int[] {0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,
						0,1,3,4,6,10,16,36,44,46,222,555,952,123},952));
	}
}
