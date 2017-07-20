package test;

import org.junit.Assert;
import org.junit.Test;

import main.java.PracticeSolutions;

public class PracticeTest {
	
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
