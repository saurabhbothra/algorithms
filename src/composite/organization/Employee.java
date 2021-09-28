package composite.organization;

import java.util.List;

public interface Employee {
	
	String getName();
	
	Gender getGender();
	
	double getAnnualPay();
	
	Employee addSupervisee(String supervisorName, Employee supervisee);
	
	int count();
	
	int countByGender(Gender gender);
	
	int terminatedBefore(int date, int month, int year);
	
	List<Employee> toList();
	
	int countPayAbove(double amount);

}
