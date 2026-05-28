package Package3;
import java.util.*;


   abstract class EnergyDevice implements EnergyControl{
	  
	  protected String Did;
	  protected String Name;
	  protected String Status = "Truned OFF";
	  protected String EnergyUsage;
	  
	  public EnergyDevice(String did, String name) {
		
		Did = did;
		Name = name;

	  }
	  
	  protected boolean isOn = false;

	  @Override
	  public void Turnon() {
		
		  if(!isOn) {
			  
			  System.out.println("Turned on ");
			  this.Status = "Turned On";
			  isOn = true;
			  
		  }
		 
		  
	  }

	  @Override
	  public void TurnOff() {
		  
		  if(isOn) {
			  
			  System.out.println("Turning off ");
			  this.Status = "Turned Off";
			  isOn = false;
			  
		  }
		
		  
	  }
		
		
	  

	  @Override
	  public void getStatus() {
		
		  System.out.println("Stauts : "+Status);
		
	  }

	  @Override
	abstract   public void adaptiveControl() ;
	  
	  
	  
  }
   
   class SmartMeter extends EnergyDevice{

	public SmartMeter(String did, String name) {
		super(did, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void adaptiveControl() {
		
		System.out.println("AI Advise : High Energy Detected . Reducing Conmsuption ");
		
	}
	   
   }
   
   class SolarPannels extends EnergyDevice{

	public SolarPannels(String did, String name) {
		super(did, name);
		// TODO Auto-generated constructor stub
	}



	@Override
	public void adaptiveControl() {
		
		System.out.println("AI Advise : INcreasing Soalr OUTPU T During Peak SUnlight . ");
		
	}
	   
   }
   
   class BAtteryStorage extends EnergyDevice{

	public BAtteryStorage(String did, String name) {
		super(did, name);
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void adaptiveControl() {
		
		System.out.println("Storing EXcsess ENrgy Efficiently.");
		
	}
	   
   }
   
   
   class AIEnergyManager{
	   
	   public static AIEnergyManager instance;
	   
	   private AIEnergyManager() {};
	   
	   
	   public static AIEnergyManager getInstance() {
		   if(instance== null) {
			   instance = new AIEnergyManager();
		   }
		   return instance;
	   }
	   
	   public void EnergyTracker(ArrayList<EnergyDevice> a) {
		   
		   System.out.println("Analysing Energy COnsumption .");
		   
		   for(EnergyDevice e : a) {
			   
			   e.adaptiveControl();
		   }
		   
		   
	   }
   }
   
 class EnergySystem{
	 
	 ArrayList <EnergyDevice> e = new ArrayList<>();
	 
	 public void addSystem(EnergyDevice a) {
		 
		 e.add(a);
		 
		 System.out.println(a.Name+"Has bEen Succesfully added ");
		 
		 
	 }
	 
	 public ArrayList<EnergyDevice> getDevices() {
		 
		 return e;
	 }
	 
 } 

public class Question3 {

	public static void main(String[] args) {
		
		
		EnergySystem Es = new EnergySystem();
		
		SmartMeter Sm = new SmartMeter("123","SmartMeter");

		SolarPannels Sp = new SolarPannels("153","SolarPannel");
		

		BAtteryStorage BS = new BAtteryStorage("123","Battety Storage");
		
		BS.Turnon();
		BS.TurnOff();
		
		Es.addSystem(BS);
		Es.addSystem(Sp);
		Es.addSystem(Sm);
		
		
		
		AIEnergyManager a = AIEnergyManager.getInstance();
		a.EnergyTracker(Es.getDevices());
	}

}
