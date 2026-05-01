// HospitalSystem.java

import java.util.ArrayList;
import java.util.List;

// 1. Define the HospitalService interface
interface HospitalService {
    String getServiceName();
    int getMaxPatients();
    boolean admitPatient(String patientName);
    int getCurrentPatients();
}

// 2. Abstract base class to avoid duplication
abstract class BaseService implements HospitalService {
    protected String serviceName;
    protected int maxPatients;
    protected List<String> patients;

    public BaseService(String serviceName, int maxPatients) {
        this.serviceName = serviceName;
        this.maxPatients = maxPatients;
        this.patients = new ArrayList<>();
    }

    @Override
    public String getServiceName() {
        return serviceName;
    }

    @Override
    public int getMaxPatients() {
        return maxPatients;
    }

    @Override
    public boolean admitPatient(String patientName) {
        if (maxPatients == -1 || patients.size() < maxPatients) { // -1 means unlimited
            patients.add(patientName);
            return true;
        } else {
            System.out.println("Admission failed: capacity reached for " + serviceName);
            return false;
        }
    }

    @Override
    public int getCurrentPatients() {
        return patients.size();
    }
}

// 3. Concrete service classes
class OutpatientService extends BaseService {
    public OutpatientService() {
        super("Outpatient", 50);
    }
}

class InpatientService extends BaseService {
    public InpatientService() {
        super("Inpatient", 200);
    }
}

class EmergencyService extends BaseService {
    public EmergencyService() {
        super("Emergency", -1); // unlimited
    }
}

// 4. Department class to manage services and prevent conflicts
class Department {
    private String name;
    private List<HospitalService> services;

    public Department(String name) {
        this.name = name;
        this.services = new ArrayList<>();
    }

    public void addService(HospitalService service) {
        // Conflict rule: Emergency cannot coexist with Outpatient
        if (service instanceof EmergencyService) {
            for (HospitalService s : services) {
                if (s instanceof OutpatientService) {
                    System.out.println("Conflict: Emergency cannot coexist with Outpatient in " + name);
                    return;
                }
            }
        }
        if (service instanceof OutpatientService) {
            for (HospitalService s : services) {
                if (s instanceof EmergencyService) {
                    System.out.println("Conflict: Outpatient cannot coexist with Emergency in " + name);
                    return;
                }
            }
        }
        services.add(service);
        System.out.println(service.getServiceName() + " service added to " + name);
    }

    public void listServices() {
        System.out.println("Services in " + name + ":");
        for (HospitalService s : services) {
            System.out.println("- " + s.getServiceName() + " (Capacity: " +
                (s.getMaxPatients() == -1 ? "Unlimited" : s.getMaxPatients()) + ")");
        }
    }

    public void admit(String type, String patientName) {
        for (HospitalService s : services) {
            if (s.getServiceName().equalsIgnoreCase(type)) {
                boolean success = s.admitPatient(patientName);
                if (success) {
                    System.out.println(patientName + " admitted to " + type);
                }
                return;
            }
        }
        System.out.println("Service " + type + " not found in " + name);
    }
}

// 5. Demo class
public class HospitalSrvice {
    public static void main(String[] args) {
        Department dept = new Department("General Medicine");

        dept.addService(new OutpatientService());
        dept.addService(new InpatientService());
        dept.addService(new EmergencyService()); // should trigger conflict

        dept.listServices();

        // Admit patients
        for (int i = 1; i <= 55; i++) {
            dept.admit("Outpatient", "Patient" + i);
        }

        dept.admit("Inpatient", "PatientX");
    }
}
