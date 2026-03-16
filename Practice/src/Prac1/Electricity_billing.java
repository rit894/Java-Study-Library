package Prac1;
//Abstract class
abstract class Car {
 abstract void start();
 abstract void stop();
}

//Concrete class 1
class ElectricCar extends Car {
 @Override
 void start() {
     System.out.println("Electric car started silently.");
 }

 @Override
 void stop() {
     System.out.println("Electric car stopped.");
 }
}

//Concrete class 2
class PetrolCar extends Car {
 @Override
 void start() {
     System.out.println("Petrol car engine roars to life.");
 }

 @Override
 void stop() {
     System.out.println("Petrol car engine shuts down.");
 }
}

//Main class to test abstraction
public class Electricity_billing {
 public static void main(String[] args) {
     Car tesla = new ElectricCar();
     Car honda = new PetrolCar();

     tesla.start();
     tesla.stop();

     honda.start();
     honda.stop();
 }
}
