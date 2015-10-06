import java.util.*;
public class Solution07 {
	
	/*the gender ratio should be equal to 1, actually it makes no difference as long as
	 * the odds of having a boy or a girl is equal. although every family has one girl,
	 * but some families must to more boys to get a girl.  
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution07 s = new Solution07();
		System.out.println(s.simulation(100));
	}
	
	/*for every family, calculate the number of boys before getting a girl.
	 * and then sum them up to see the gender ratio.
	 */
	public double simulation(int n) {
		
		Random r = new Random();
		int numberOfBoys = 0;
		for(int i = 0; i < n; i++) {
			int girl = 0;
			int boy = 0;
			while(girl == 0) {
				if(r.nextBoolean()) { //use a boolean value to determine next child is a girl or a boy
					girl++;
				} else {
					boy++;
				}
			}
			
			numberOfBoys += boy;
		}
		
		return n / (double) (n + numberOfBoys); //n is the number of girls
		
	}
}
