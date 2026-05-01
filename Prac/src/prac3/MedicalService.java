package prac3;

public interface MedicalService {
	
	void ScheduleAppointment(String Date) throws Exception;
	void CancelAppointment(String Date);

}
