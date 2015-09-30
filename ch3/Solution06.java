
import java.util.*;

public class Solution06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution06 s = new Solution06();
		Shelter shelter = new Shelter();
		shelter.enQueue(s.new Dog("d1"));
		shelter.enQueue(s.new Dog("d2"));
		shelter.enQueue(s.new Cat("c3"));
		shelter.enQueue(s.new Dog("d4"));
		shelter.enQueue(s.new Cat("c5"));
		System.out.println(shelter.deQueneAny().getName());
		System.out.println(shelter.deQueneCat().getName());
		System.out.println(shelter.deQueneDog().getName());
	}
	
	/*in this problem, we have two kinds of animals, and we will give every animal
	 * an order number when they enter the shelter.
	 */
	
	abstract class Animal {
		private int order;
		protected String name;
		public Animal(String n) {
			this.name = n;
		}
		
		public void setOrder(int num) {
			this.order = num;
		}
		
		public int getOrder() {
			return this.order;
		}
		
		public boolean isOlder(Animal a) {
			return this.order < a.order;
		}
		
		public String getName() {
			return this.name;
		}
	}
	
	private static class Shelter{
		//two lists to store dogs and cats
		private LinkedList<Dog> dogQ = new LinkedList<Dog>();
		private LinkedList<Cat> catQ = new LinkedList<Cat>();
		private int order = 0;
		
		public void enQueue(Animal a) {
			a.setOrder(order);// give every animal an order
			order++;
			
			if(a instanceof Dog) {
				dogQ.addLast((Dog) a);
			} else if(a instanceof Cat) {
				catQ.addLast((Cat) a);
			}
		}
		
		public Animal deQueneAny() {
			if(dogQ.isEmpty() && catQ.isEmpty()) {
				System.out.println("There is no animal in the shelter");
				return null;
			}
			if(dogQ.isEmpty()) {
				return deQueneCat();
			} else if(catQ.isEmpty()) {
				return deQueneDog();
			}
			
			//get the oldest dog and cat
			Dog dog = dogQ.peek();
			Cat cat = catQ.peek();
			
			//return the older one.
			if(dog.isOlder(cat)) {
				return deQueneDog();
			} else {
				return deQueneCat();
			}
		}
		
		public Animal deQueneDog() {
			return dogQ.poll();
		}
		
		public Animal deQueneCat() {
			return catQ.poll(); 
		}
	}
	
	class Dog extends Animal {
		public Dog(String n) {
			super(n);
		}
	}
	
	class Cat extends Animal {
		public Cat(String n) {
			super(n);
		}
	}
}
