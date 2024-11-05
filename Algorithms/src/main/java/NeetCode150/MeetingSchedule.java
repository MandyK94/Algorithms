package NeetCode150;

import java.util.ArrayList;
import java.util.List;

public class MeetingSchedule {
	
	
	public class Interval {
		public int start; 
		public int end;
		public Interval(int start, int end) {
			this.start=start;
			this.end=end;
		}
	}
	
	public boolean canAttendMeetings(List<Interval> intervals) {
		intervals.sort((o1, o2) -> o1.start-o2.start);
		
		for(int i=0;i<intervals.size()-1;i++) {
			Interval i1 = intervals.get(i);
			Interval i2 = intervals.get(i+1);
			if(i1.start==i2.start) {
				return false;
			} else if(i1.end>i2.start) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public void test() {
		Interval int1 = new Interval(5, 8);
		Interval int2 =  new Interval(9, 15);
		Interval int3 = new Interval(15, 20);
		List<Interval> list =  new ArrayList<Interval>();

		list.add(int1);
		list.add(int2);
		//list.add(int3);
		
		System.out.println(canAttendMeetings(list));
	}
	
	
	public static void main(String[] args) {
		
		MeetingSchedule ms = new MeetingSchedule();
		ms.test();
		
	}
	
}
