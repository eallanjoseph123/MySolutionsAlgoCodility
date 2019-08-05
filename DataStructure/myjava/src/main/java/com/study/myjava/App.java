package com.study.myjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
	public static void main(String[] args) {
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
		
		//====================== sample output start ================================
		Map<Integer, List<GeneratedCombination>> actual = App.convert(list);

		for (Map.Entry<Integer, List<GeneratedCombination>> e : actual.entrySet()) {
			List<GeneratedCombination> l = e.getValue();
			for(GeneratedCombination gc : l) {
				System.out.println(gc);
			}System.out.println();
		}
		
		//====================== sample output end================================
	}

	//the list must be sorted
	public static Map<Integer, List<GeneratedCombination>> convert(List<TravelConvert> list) {
		Map<Integer, List<GeneratedCombination>> map = new HashMap<>();
		for (int counter = 1; counter < list.size(); counter++) {
			TravelConvert previousTC = list.get(counter - 1);
			TravelConvert currentTC = list.get(counter);
			if (isSameWorkerId(previousTC, currentTC)) {
				if (map.containsKey(previousTC.getWorkOrder())) {
					//Succeeding GC after the first creation of GC
					List<GeneratedCombination> listOfGc = map.get(previousTC.getWorkOrder());
					GeneratedCombination succeedingGc = createGeneratedCombination(currentTC, previousTC.getSiteId(), currentTC.getSiteId());
					listOfGc.add(succeedingGc);
				} else {
					addTheFirstGc(map, previousTC);
					//reset the counter for every first GeneratedCombination
					counter -= 1;
				}
			} else {
				addTheLastGc(map, previousTC);

			}
		}
		addTheLastTraveller(list, map);

		return map;
	}

	private static void addTheLastGc(Map<Integer, List<GeneratedCombination>> map, TravelConvert tc1) {
		if (map.containsKey(tc1.getWorkOrder())) {
			List<GeneratedCombination> gcList = map.get(tc1.getWorkOrder());
			GeneratedCombination primaryGc = gcList.get(0);
			GeneratedCombination gc2 = createGeneratedCombination(tc1, tc1.getSiteId(), primaryGc.getSiteNumberFrom());
			gcList.add(gc2);
		}
	}

	private static void addTheFirstGc(Map<Integer, List<GeneratedCombination>> map, TravelConvert tc1) {
		List<GeneratedCombination> listOfGc = new ArrayList<>();
		GeneratedCombination result = createGeneratedCombination(tc1, tc1.getSiteBase(), tc1.getSiteId());
		listOfGc.add(result);
		map.put(tc1.getWorkOrder(), listOfGc);
	}

	private static boolean isSameWorkerId(TravelConvert tc1, TravelConvert tc2) {
		return tc2.getWorkOrder() == tc1.getWorkOrder();
	}
	
	// if the size of the list is odd, The last value must be added.
	private static void addTheLastTraveller(List<TravelConvert> list, Map<Integer, List<GeneratedCombination>> map) {
		int totalValue = list.size();
		if ((totalValue % 2) != 0) {
			List<GeneratedCombination> listOfGc = new ArrayList<>();
			TravelConvert lastTraveler = list.get(totalValue - 1);
			GeneratedCombination gc = createGeneratedCombination(lastTraveler, lastTraveler.getSiteBase(),
					lastTraveler.getSiteId());
			listOfGc.add(gc);
			map.put(lastTraveler.getWorkOrder(), listOfGc);
		}
	}

	private static GeneratedCombination createGeneratedCombination(TravelConvert initialTc, String siteNumberFrom,
			String siteNumberTo) {
		GeneratedCombination initialGC = new GeneratedCombination();
		initialGC.setWorkOrder(initialTc.getWorkOrder());
		initialGC.setActivityLog(initialTc.getActivityLog());
		initialGC.setSiteNumberFrom(siteNumberFrom);
		initialGC.setSiteNumberTo(siteNumberTo);
		return initialGC;
	}

	static class GeneratedCombination {
		int workOrder;
		int activityLog;
		String siteNumberFrom;
		String siteNumberTo;

		public GeneratedCombination() {

		}

		public GeneratedCombination(int workOrder, int activityLog, String siteNumberFrom, String siteNumberTo) {
			super();
			this.workOrder = workOrder;
			this.activityLog = activityLog;
			this.siteNumberFrom = siteNumberFrom;
			this.siteNumberTo = siteNumberTo;
		}

		public int getWorkOrder() {
			return workOrder;
		}

		public void setWorkOrder(int workOrder) {
			this.workOrder = workOrder;
		}

		public int getActivityLog() {
			return activityLog;
		}

		public void setActivityLog(int activityLog) {
			this.activityLog = activityLog;
		}

		public String getSiteNumberFrom() {
			return siteNumberFrom;
		}

		public void setSiteNumberFrom(String siteNumberFrom) {
			this.siteNumberFrom = siteNumberFrom;
		}

		public String getSiteNumberTo() {
			return siteNumberTo;
		}

		public void setSiteNumberTo(String siteNumberTo) {
			this.siteNumberTo = siteNumberTo;
		}

		@Override
		public String toString() {
			return "GeneratedCombination [workOrder=" + workOrder + ", activityLog=" + activityLog + ", siteNumberFrom="
					+ siteNumberFrom + ", siteNumberTo=" + siteNumberTo + "]";
		}

	}

	static class TravelConvert {
		int workOrder;
		String jobOrder;
		int activityLog;
		String siteBase;
		String siteId;

		@Override
		public String toString() {
			return "TravelConvert [workOrder=" + workOrder + ", jobOrder=" + jobOrder + ", activityLog=" + activityLog
					+ ", siteBase=" + siteBase + ", siteId=" + siteId + "]";
		}

		public TravelConvert(int workOrder, String jobOrder, int activityLog, String siteBase, String siteId) {
			super();
			this.workOrder = workOrder;
			this.jobOrder = jobOrder;
			this.activityLog = activityLog;
			this.siteBase = siteBase;
			this.siteId = siteId;
		}

		public int getWorkOrder() {
			return workOrder;
		}

		public void setWorkOrder(int workOrder) {
			this.workOrder = workOrder;
		}

		public String getJobOrder() {
			return jobOrder;
		}

		public void setJobOrder(String jobOrder) {
			this.jobOrder = jobOrder;
		}

		public int getActivityLog() {
			return activityLog;
		}

		public void setActivityLog(int activityLog) {
			this.activityLog = activityLog;
		}

		public String getSiteBase() {
			return siteBase;
		}

		public void setSiteBase(String siteBase) {
			this.siteBase = siteBase;
		}

		public String getSiteId() {
			return siteId;
		}

		public void setSiteId(String siteId) {
			this.siteId = siteId;
		}

	}

}
