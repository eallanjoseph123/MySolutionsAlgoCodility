package test;

import org.junit.Assert;
import org.junit.Test;

import main.java.PracticeSolutions;

public class PracticeTest {
	
	@Test
	public void oddOccurrencesInArrayTest(){
		/*Assert.assertEquals(42, 
				PracticeSolutions.oddOccurrencesInArray(new 
						int[]{3,3,1,1,5,5,42,42}));*/
		Assert.assertEquals(46, 
				PracticeSolutions.oddOccurrencesInArray(new 
						int[]{46}));
		Assert.assertEquals(46,  
				PracticeSolutions.oddOccurrencesInArray(new 
						int[]{42,46,42}));
		Assert.assertEquals(42, 
				PracticeSolutions.oddOccurrencesInArray(new 
						int[]{42}));
		Assert.assertEquals(3, 
				PracticeSolutions.oddOccurrencesInArray(new 
						int[]{1,1,2,2,2,3,4,4}));
		Assert.assertEquals(1, 
				PracticeSolutions.oddOccurrencesInArray(new 
						int[]{3,3,5,5,1,2,2,2,2,55,66,22,22,66,55}));
		Assert.assertEquals(3, 
				PracticeSolutions.oddOccurrencesInArray(new 
						int[]{3,1,5,5,1}));
		Assert.assertEquals(1, 
				PracticeSolutions.oddOccurrencesInArray(new 
						int[]{3,3,5,5,1}));
		Assert.assertEquals(7, 
				PracticeSolutions.oddOccurrencesInArray(new 
						int[]{9,3,9,9,9,7,3}));
	}
	
	@Test
	public void cyclicRotationTest(){
		Assert.assertArrayEquals(new int[]{9,7,6,3,8}, 
				PracticeSolutions.cyclicRotation(new 
						int[]{3,8,9,7,6},3));
	}
	
	@Test
	public void binaryGap(){
		Assert.assertEquals(0, PracticeSolutions.binaryGap(15));
		Assert.assertEquals(2, PracticeSolutions.binaryGap(9));
		Assert.assertEquals(1, PracticeSolutions.binaryGap(20));		
		Assert.assertEquals(5, PracticeSolutions.binaryGap(1041));
		Assert.assertEquals(1, PracticeSolutions.binaryGap(10));
		Assert.assertEquals(3, PracticeSolutions.binaryGap(589631));
	}
}
