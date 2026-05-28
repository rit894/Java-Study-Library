package Package2;
import java.time.LocalDateTime;
import java.util.*;

 abstract class TrafficDevice implements TraficControl{
	
	protected String Did;
	protected String Location ;
	 protected String Status ;
	protected LocalDateTime Lastupdated ;
	protected boolean IsActivated = false;
	
	
	public TrafficDevice(String did, String location) {
		
		Did = did;
		Location = location;
		Status = "Turned off";
		
	}


	@Override
	public void acitivate() {
		
		if(!IsActivated) {
			System.out.println("System is being activated ");
			
			Status = " Turned On ";
			
			Lastupdated = LocalDateTime.now();
			
		}
		else {
			System.out.println("System is already active ");
		}
		
		
	}


	@Override
	public void deactivate() {
		
		if(IsActivated) {
			
			System.out.println("System is being Deactivated ");
			
			Status = " Turned OFF";
			
			Lastupdated = LocalDateTime.now();
			
			
		}
		System.out.println("It is already off ");
	}


	@Override
	public void getStatus() {
	
		System.out.println("Status : "+ Status);
		System.out.println(" Last update at : "+Lastupdated );
		
	}


	@Override
	 abstract public void adaptiveControl();
	
	
	
}
 
 class TrafficSignal extends TrafficDevice {

	public TrafficSignal(String did, String location) {
		super(did, location);
		
	}

	@Override
	public void adaptiveControl() {
		
		System.out.println("Heavy Congnestion Deteced ");
		System.out.println(" AI Advise : Exteding Greeen Signal DUration ");
		
		
	}
	 
 }
 
 class SurveillanceCamera extends TrafficDevice {

	public SurveillanceCamera(String did, String location) {
		super(did, location);
		
	}

	@Override
	public void adaptiveControl() {
		
		System.out.println("Accident Detected  ");
		System.out.println(" AI Advise : Sending EMergency alerts  ");
		
		
	}
	 
 }
 
 class EmergencyAlert extends TrafficDevice {

		public EmergencyAlert(String did, String location) {
			super(did, location);
			
		}

		@Override
		public void adaptiveControl() {
			
			System.out.println("Accident Detected  ");
			System.out.println(" Trafic Flow optimised for peak hours  ");
			
			
			
		}
		 
	 }
 
 class AiTrafficController{
	 
	 public static AiTrafficController instance ;
	 
	 private AiTrafficController() {}
	 
	 public static AiTrafficController getInstance() {
		 if(instance == null) {
			 
			 instance = new AiTrafficController();
			 
			 
		 }
		 return instance ;
		 
		  
	 }
	 public void TrackPatterns(ArrayList<TrafficDevice> a) {
		 
		 System.out.println("Analysing the Trafic Patterns : ");
		 
		 for(TrafficDevice Device : a ) {
			 
			 Device.adaptiveControl();
			 
			 
		 }
		 System.out.println("Trafiic System Will auto Adjust Signals  Dynalmically");
		 
		 
	 }
 }
 
 class  TrafficSystem {
	 
	 
	 ArrayList<TrafficDevice> Devices = new ArrayList<>();
	 public void addDevice(TrafficDevice a) {
		 
		 Devices.add(a);
		 System.out.println(a.Did+"Has been Succsfully Added ");
		 
		 
		 
	 }
	 
	 public ArrayList<TrafficDevice> getDevices() {
		 
		 return Devices;
	 }
	 
	 
 }
public class Question2 {

	public static void main(String[] args) {
		
		TrafficSystem TS = new TrafficSystem();
		
		TrafficSignal ts = new TrafficSignal("123","Battupally");
		SurveillanceCamera Sc = new SurveillanceCamera("456","Warangal");
		EmergencyAlert ea = new EmergencyAlert ("789","Karimnagar");
		
		TS.addDevice(ts);
		TS.addDevice(Sc);
		TS.addDevice(ea);
		
		ts.acitivate();
		Sc.acitivate();
		ea.acitivate();
		ea.deactivate();
		
		
		AiTrafficController ai = AiTrafficController.getInstance();
		ai.TrackPatterns(TS.getDevices());
		
		
		
		

	}

}
