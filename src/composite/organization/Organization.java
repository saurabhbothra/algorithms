package composite.organization;

import java.util.List;

public interface Organization {
	
	void addEmployee(String name, double pay, Gender gender, String supervisorName);
	
	void addContractEmployee(String name, double pay, Gender gender, String supervisorName, int endDate, int endMonth, int endYear);
	
	int getSize();
	
	int getSizeByGender(Gender gender);
	
	List<String> allEmployees();
	
	int countPayAbove(double amount);
	
	int terminatedBefore(int date, int month, int year);

}
