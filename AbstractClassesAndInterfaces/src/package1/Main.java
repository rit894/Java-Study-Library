package package1;

interface Animal {
	  public void animalSound(); // interface method (does not have a body)
	  public void sleep(); // interface method (does not have a body)
	}

	// Pig "implements" the Animal interface

	class Pig implements Animal {
		@Override
	  public void animalSound() {
	    // The body of animalSound() is provided here
	    System.out.println("The pig says: wee wee");
	  }
	  public void sleep() {
	    // The body of sleep() is provided here
	    System.out.println("Zzz");
	  }
	}

	
	interface FirstInterface{ public void Mymethod();}
	interface SecondInterface{ public void myotherMethod();}
	
	class Demo implements FirstInterface , SecondInterface{
		public void Mymethod() {
			System.out.println("THis is the first method ");
			
		}
		public void myotherMethod() {
			System.out.println("THis is the second methode");
		}
		
		public void Mythirdmethod() {
			System.out.println("THis is possible");
		}
	}
	class Main {
	  public static void main(String[] args) {
	    Pig myPig = new Pig();  
	    myPig.animalSound();
	    myPig.sleep();
	    
	    Demo d1 = new Demo();
	    d1.Mymethod();
	    d1.myotherMethod();
	    d1.Mythirdmethod();
	  }
	}
