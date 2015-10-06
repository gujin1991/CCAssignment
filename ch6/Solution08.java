
public class Solution08 {
	/*in order to find the minimum number of drops, we need to make drop number of egg1 
	 * and egg2 stay the same. therofore, we can make the number of floor we drop egg1  
	 * increase the number which is smaller than last increment by 1.
	 */
	static int BREAK_FLOOR = 101;
	static int FLOOR_NUMBER = 100;
	int current_floor = 0; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution08 s = new Solution08();
		System.out.println(s.eggDrop());
	}
	/*
	 * 
	 */
	
	public int eggDrop(){
		int start_floor = 14;
		int egg1 = start_floor;
		int egg2 = 1;
		
		while(egg1 <= FLOOR_NUMBER && !isBreak(egg1)) {
			egg2 = egg1 + 1;	//get the last floor
			start_floor--;	//minus the increment 
			egg1 += start_floor; 
		}
		
		while(egg2 < egg1 && egg2 <= FLOOR_NUMBER && !isBreak(egg2)) {
			egg2++;
		}
		
		return egg2 > FLOOR_NUMBER ? -1 : egg2;
	}
	
	public boolean isBreak(int floor) {
		current_floor = floor;
		return current_floor >= BREAK_FLOOR;
	}

}
