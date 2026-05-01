package Question1;

 abstract class Ride {
    protected String rideId;
    protected String pName;
    protected double distance;
    protected double baseFare;
    

    public Ride(String rideId, String pName, double distance, double baseFare) {
        this.rideId = rideId;
        this.pName = pName;
        this.distance = distance;
        this.baseFare = baseFare;
    }

    public double calculateTotalFare() {
        return distance * baseFare;
    }

    public void displayRideDetails() {
        System.out.println("\n--- Ride Details ---");
        System.out.println("Ride ID: " + rideId);
        System.out.println("Passenger: " + pName);
        System.out.println("Distance: " + distance + " km");
        System.out.println("Base Fare: $" + baseFare);
        System.out.println("Standard Fare: $" + calculateTotalFare());
    }
    
    abstract public double ComputefinalFare(double sm);
}

class PremiumRide extends Ride implements RideService,PaymentProcessor {
	
	final double  MIN_FARE  = 30.0;
	
    private double driverRating;
    private double surgeMultiplier;
    private String passangerId;
    private boolean isRideConfirmed = false ;
    private boolean isPaid = false;
    
    

    public PremiumRide(String rideId, String pName, double distance, double baseFare) {
        super(rideId, pName, distance, baseFare);
    }

    
    public void displayPremiumRideDetails(double rating, double sm) {
        this.driverRating = rating;
        this.surgeMultiplier = sm;
        
        super.displayRideDetails();
        
        double finalFare = calculateTotalFare() * surgeMultiplier;
        System.out.println("Surge Multiplier: " + surgeMultiplier + "x");
        System.out.println("Driver Rating: " + driverRating + " stars");
        System.out.println("FINAL PREMIUM FARE: $" + finalFare);
    }

	@Override
	public double ComputefinalFare(double sm) {
		
		return (calculateTotalFare()*sm);
		
		
	}

	@Override
	public void bookRIde(String passengerid, double km) {
		
		this.passangerId = passengerid;
		if(km<0 || isRideConfirmed) {
			System.out.println("No driver is avialable in this perimeter of distance");
		}
		System.out.println("Ride is confirmed for passernger "+passangerId
				);
		this.isRideConfirmed = true;
		
		
	}

	@Override
	public void cancelRide(String rideId) {
		
		distance = 0.0;
		System.out.println("ride is cancelled Sucessfully");
		this.isRideConfirmed = false;
		
	}

	@Override
	public void processPayment(String rideId, double amount) {
		
		if(isRideConfirmed && amount > MIN_FARE) {
			
			this.isPaid = true;
			System.out.println("Pyment sucssfull>>>");
			
			
		}
		this.isPaid = false;
		
		System.out.println("Payment Unsucssfull");
		
	}

	@Override
	public void issueRefund(String rideId, double amount) {
		
		if(isPaid) {
			System.out.println("Refund issued succesfully ");
		}
		
		System.out.println("Refund Failed >>>>");
	}
	
}

public class BaseCode {
    public static void main(String[] args) {
      

        // Premium Ride
        PremiumRide pr = new PremiumRide("PR1234", "Pandhi", 452.5, 6.23);
        pr.displayPremiumRideDetails(5.0, 2.0);
    }
}