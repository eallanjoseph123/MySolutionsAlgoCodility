package test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import main.java.PracticeSolutions;

public class PracticeTest {
	@Test
	public void sumTTest(){
		int []  a = {3,5,4,1, 2, 2, 3, 4};
		Assert.assertEquals(6,PracticeSolutions.sumT(a));
	}
	@Test
	public void fishTest(){
		int []  a = {4,3,2,1,5};
		int []  b = {0,1,0,0,0};
		Assert.assertEquals(2,PracticeSolutions.fish(a,b));
	}
	@Test
	public void fishTest1(){
		int []  a = {4,5,6,7,2,1};
		int []  b = {0,1,0,0,0,1};
		Assert.assertEquals(5,PracticeSolutions.fish(a,b));
	}
	
	@Test
	public void familyTest(){
		Assert.assertEquals(433110,
				PracticeSolutions.family(101334));
		Assert.assertEquals(0,
				PracticeSolutions.family(0));
		Assert.assertEquals(321,
				PracticeSolutions.family(213));
		Assert.assertEquals(553,
				PracticeSolutions.family(535));
		Assert.assertEquals(553,
				PracticeSolutions.family(535));
		Assert.assertEquals(321,
				PracticeSolutions.family(321));
		Assert.assertEquals(-1,
				PracticeSolutions.family(111_332_255));
		Assert.assertEquals(96_653_221,
				PracticeSolutions.family(23_521_966));
		
	}
	@Test
	public void swapTest(){
		Assert.assertEquals(
				Boolean.TRUE,
				PracticeSolutions.swap1(new 
				int[]{1,5,3,3,7}));
		Assert.assertEquals(Boolean.FALSE,
				PracticeSolutions.swap1(new 
				int[]{1,3,5,3,4}));
		Assert.assertEquals(Boolean.TRUE,
				PracticeSolutions.swap1(new 
				int[]{1,3,5}));
	}
	
	//@Test
	public void bracketsTest(){
		Assert.assertEquals(0,
				PracticeSolutions.brackets("{{{{"));
		Assert.assertEquals(1,
				PracticeSolutions.brackets("{[()()]}"));
		Assert.assertEquals(1,
		PracticeSolutions.brackets("({{({}[]{})}}[]{})"));	
		Assert.assertEquals(0,
		PracticeSolutions.brackets("([)()]"));
		Assert.assertEquals(0,
		PracticeSolutions.brackets("([)()]"));
		Assert.assertEquals(0,
				PracticeSolutions.brackets(")("));
		Assert.assertEquals(0,
				PracticeSolutions.brackets(")"));
		Assert.assertEquals(1,
				PracticeSolutions.brackets("([{}])"));
		Assert.assertEquals(0,
				PracticeSolutions.brackets("([{)(}])"));
		Assert.assertEquals(0,
				PracticeSolutions.brackets("())(()"));
	}
	
	@Test
	public void triangleTest(){
		Assert.assertEquals(0,
				PracticeSolutions.triangle(new 
						int[]{10,50}));
		Assert.assertEquals(0,
				PracticeSolutions.triangle(new 
						int[]{10,50,5}));
		Assert.assertEquals(0,
				PracticeSolutions.triangle(new 
						int[]{10,50,5,1}));
		Assert.assertEquals(1,
				PracticeSolutions.triangle(new 
						int[]{10,2,5,1,8,20}));
		}
	
	@Test
	public void maxProductOfThreeTest(){
		Assert.assertEquals(120,
				PracticeSolutions.maxProductOfThree(new 
						int[]{-4, -6, 3, 4, 5}));
		Assert.assertEquals(125,
				PracticeSolutions.maxProductOfThree(new 
						int[]{-5,5,-5,4}));
		Assert.assertEquals(60,
				PracticeSolutions.maxProductOfThree(new int[]{-3,1,2,-2,5,6}));
		Assert.assertEquals(-80,
				PracticeSolutions.maxProductOfThree(new int[]{-10,-2,-4}));
	}
	
	@Test
	public void maxCounterTest(){
		Assert.assertArrayEquals(new int[]
				{3},PracticeSolutions.
				maxCounter(1, new int[]{2,1,1,2,1}));
		Assert.assertArrayEquals(new int[]
				{3,2,0},PracticeSolutions.
				maxCounter(3, new int[]{2,1,1, 2,1}));
		Assert.assertArrayEquals(new int[]
	{1},PracticeSolutions.maxCounter(1, new int[]{1}));
		Assert.assertArrayEquals(new int[]{3,2,2,4,2},
				PracticeSolutions.
				maxCounter(5, new int[]{3,4,4,6,1,4,4})); 
	}
	
	
	@Test
	public void missingIntegerTest() {
		Assert.assertEquals(1,
				PracticeSolutions.missingInteger(new int[]{4}));
		Assert.assertEquals(1,
				PracticeSolutions.missingInteger(new int[]{0}));
		Assert.assertEquals(2,
				PracticeSolutions.missingInteger(new int[]{1}));
		Assert.assertEquals(1,
				PracticeSolutions.missingInteger(new int[]{-1,-1,2,3,2,4,4}));
		Assert.assertEquals(1,
				PracticeSolutions.missingInteger(new int[]{7,3,6,4,7,2}));
			Assert.assertEquals(1,
				PracticeSolutions.missingInteger(new int[]{-1,-1,2,3,2,4,4}));
		Assert.assertEquals(5,
				PracticeSolutions.missingInteger(new int[]{1,3,6,4,1,2}));
		Assert.assertEquals(1,
				PracticeSolutions.missingInteger(new int[]{
						-1,-3,-6,-4,-1,-2}));
		Assert.assertEquals(6,
				PracticeSolutions.missingInteger(new int[]{
			1,2,2,4,4,1,2,2,1,4,3,3,3,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,5,5,5,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,7,7,7,7,7,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,
			1,2,2,4,4,1,2,2,1,4,}));
	}
	@Test
	public void tapeEquilibriumTest() {
		Assert.assertEquals(1,
				PracticeSolutions.tapeEquilibrium(new int[]{3,1,2,4,3}));
		Assert.assertEquals(2,
				PracticeSolutions.tapeEquilibrium(new int[]{3,1}));
	}

	
	@Test
	public void getValueTest(){
		Assert.assertEquals(709, 
				PracticeSolutions.getValue("TRADINGFEW","LGXWEV"));	
	}
	
	//@Test
	public void countDivTest(){
		
		Assert.assertEquals(1, 
				PracticeSolutions.countDiv(10, 10, 5));
		Assert.assertEquals(5, 
		PracticeSolutions.countDiv(11, 35, 5));
		Assert.assertEquals(4, 
				PracticeSolutions.countDiv(1, 10, 3));
		Assert.assertEquals(3, 
				PracticeSolutions.countDiv(6, 11, 2));
		Assert.assertEquals(1, 
				PracticeSolutions.countDiv(0, 0, 11));
		Assert.assertEquals(0, 
				PracticeSolutions.countDiv(1, 1, 11));
		Assert.assertEquals(0, 
				PracticeSolutions.countDiv(10, 10, 7));
		Assert.assertEquals(0, 
				PracticeSolutions.countDiv(10, 10, 20));
		Assert.assertEquals(1, 
				PracticeSolutions.countDiv(11, 13, 2));
	}

	@Test
	public void distinctTest() {
		Assert.assertEquals(0, PracticeSolutions.distinct(new int[] {}));
		Assert.assertEquals(1, PracticeSolutions.distinct(new int[] { 0 }));
		Assert.assertEquals(3, PracticeSolutions.distinct(new int[] { 2, 1, 1, 2, 3, 1 }));
	}

	@Test
	public void countPassengersTest() {
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(new int[] { 10, 0 });
		list.add(new int[] { 3, 5 });
		list.add(new int[] { 2, 5 });
		Assert.assertEquals(5, PracticeSolutions.countPassengers(list));
	}

	private static void testing(long actual, long expected) {
		Assert.assertEquals(expected, actual);
	}

	// @Test
	public void test1() {
		System.out.println("Fixed Tests: thirt");
		testing(PracticeSolutions.thirt(8529), 79);
		testing(PracticeSolutions.thirt(85299258), 31);
		testing(PracticeSolutions.thirt(5634), 57);
		testing(PracticeSolutions.thirt(1111111111), 71);
		testing(PracticeSolutions.thirt(987654321), 30);
	}

	@Test
	public void frogRiver() {
		Assert.assertEquals(-1, PracticeSolutions.
				frogRiver(2, new int[] { 1,1,1,1}));
		Assert.assertEquals(6, PracticeSolutions.
				frogRiver(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
		Assert.assertEquals(4, PracticeSolutions.
				frogRiver(3, new int[] { 1, 3, 1, 3, 2,1,3 }));
		}

	// @Test
	public void frogJumpTest() {
		// Assert.assertEquals(0,PracticeSolutions.frogjump(10, 10, 25));
		Assert.assertEquals(3, PracticeSolutions.frogjump(10, 85, 30));
		Assert.assertEquals(9, PracticeSolutions.frogjump(2, 135, 15));
	}

	@Test
	public void permMissingElemTest() {
		Assert.assertEquals(4, PracticeSolutions.permMissingElem(new int[] { 2, 3, 1, 5 }));
		Assert.assertEquals(1, PracticeSolutions.permMissingElem(new int[] { 2, 3, 4, 5 }));
		Assert.assertEquals(6, PracticeSolutions.permMissingElem(new int[] { 1, 2, 3, 4, 5 }));
		Assert.assertEquals(2, PracticeSolutions.permMissingElem(new int[] { 1 }));
		Assert.assertEquals(1, PracticeSolutions.permMissingElem(new int[] { 0 }));
		Assert.assertEquals(1, PracticeSolutions.permMissingElem(new int[] {}));
	}

	 @Test
	public void oddOccurrencesInArrayTest() {
		Assert.assertEquals(0, PracticeSolutions.oddOccurrencesInArray(new int[] { 3, 3, 1, 1, 5, 5, 42, 42 }));
		Assert.assertEquals(46, PracticeSolutions.oddOccurrencesInArray(new int[] { 46 }));
		Assert.assertEquals(46, PracticeSolutions.oddOccurrencesInArray(new int[] { 42, 46, 42 }));
		Assert.assertEquals(42, PracticeSolutions.oddOccurrencesInArray(new int[] { 42 }));
		Assert.assertEquals(3, PracticeSolutions.oddOccurrencesInArray(new int[] { 1, 1, 2, 2, 2, 3, 4, 4 }));
		Assert.assertEquals(1, PracticeSolutions
				.oddOccurrencesInArray(new int[] { 3, 3, 5, 5, 1, 2, 2, 2, 2, 55, 66, 22, 22, 66, 55 }));
		Assert.assertEquals(3, PracticeSolutions.oddOccurrencesInArray(new int[] { 3, 1, 5, 5, 1 }));
		Assert.assertEquals(1, PracticeSolutions.oddOccurrencesInArray(new int[] { 3, 3, 5, 5, 1 }));
		Assert.assertEquals(7, PracticeSolutions.oddOccurrencesInArray(new int[] { 9, 3, 9, 9, 9, 7, 3 }));
	}

	@Test
	public void cyclicRotationTest() {
		Assert.assertArrayEquals(new int[] { 9, 7, 6, 3, 8 },
				PracticeSolutions.cyclicRotation(new int[] { 3, 8, 9, 7, 6 }, 3));
	}

	@Test
	public void binaryGap() {
		Assert.assertEquals(0, PracticeSolutions.binaryGap(15));
		Assert.assertEquals(2, PracticeSolutions.binaryGap(9));
		Assert.assertEquals(1, PracticeSolutions.binaryGap(20));
		Assert.assertEquals(5, PracticeSolutions.binaryGap(1041));
		Assert.assertEquals(1, PracticeSolutions.binaryGap(10));
		Assert.assertEquals(3, PracticeSolutions.binaryGap(589631));
	}
}
