package com.study.myjava;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.study.myjava.App.GeneratedCombination;
import com.study.myjava.App.TravelConvert;

public class AppTest {
	
	
	@Test
	public void testNow1() {
		List<TravelConvert> list = Arrays.asList(
				//new TravelConvert(int workOrder, String jobOrder, int activityLog, String siteBase, String siteId)
				new TravelConvert(1,"j001",1001,String.valueOf(-15),String.valueOf(14532)),
				new TravelConvert(1,"j002",1002,String.valueOf(-15),String.valueOf(14533)),
				new TravelConvert(1,"j003",1003,String.valueOf(-15),String.valueOf(14534))
				
				,
				new TravelConvert(2,"j004",1004,String.valueOf(-14),String.valueOf(14535)),
				new TravelConvert(2,"j005",1005,String.valueOf(-14),String.valueOf(14536)),
				new TravelConvert(2,"j006",1006,String.valueOf(-14),String.valueOf(14537)),
				
				new TravelConvert(3,"j007",1007,String.valueOf(-13),String.valueOf(14538)),
				new TravelConvert(3,"j008",1008,String.valueOf(-13),String.valueOf(14539)),
				new TravelConvert(3,"j009",1009,String.valueOf(-13),String.valueOf(14540)),
				new TravelConvert(3,"j010",1010,String.valueOf(-13),String.valueOf(14541)),
				
				new TravelConvert(4,"j011",1011,String.valueOf(-12),String.valueOf(14542)),
				new TravelConvert(4,"j012",1012,String.valueOf(-12),String.valueOf(14543)),
				
				new TravelConvert(4,"j013",1013,String.valueOf(-11),String.valueOf(14544))
				
				);
		
	
		
		
		Map<Integer, List<GeneratedCombination>>  actual = App.convert(list);
		
		
		for(Map.Entry<Integer, List<GeneratedCombination>> e :actual.entrySet()) {
			List<GeneratedCombination> l = e.getValue();
			l.forEach(x->System.out.println(x));
		}
	}
}
