package composite.organization;

import java.util.ArrayList;
import java.util.List;

public class OrganizationImpl implements Organization {

	private Employee root;

	public OrganizationImpl(String nameCeo, double pay, Gender gender) {
		// TODO Auto-generated constructor stub
		this.root = new NonManagerEmployee(nameCeo, pay, gender);
	}

	@Override
	public void addEmployee(String name, double pay, Gender gender, String supervisorName) {
		// TODO Auto-generated method stub
		Employee newEmployee = new NonManagerEmployee(name, pay, gender);
		this.root = this.root.addSupervisee(supervisorName, newEmployee);

	}

	@Override
	public void addContractEmployee(String name, double pay, Gender gender, String supervisorName, int endDate,
			int endMonth, int endYear) {
		// TODO Auto-generated method stub
		Employee newEmployee = new ContractEmployee(name, pay, gender, endDate, endMonth, endYear);
		this.root = this.root.addSupervisee(supervisorName, newEmployee);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return this.root.count();
	}

	@Override
	public int getSizeByGender(Gender gender) {
		// TODO Auto-generated method stub
		return this.root.countByGender(gender);
	}

	@Override
	public List<String> allEmployees() {
		// TODO Auto-generated method stub
		List<Employee> result = this.root.toList();
		List<String> names = new ArrayList<>();
		for(Employee e: result) {
			names.add(e.getName());
		}
		return names;
	}

	@Override
	public int countPayAbove(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int terminatedBefore(int date, int month, int year) {
		// TODO Auto-generated method stub
		return this.root.terminatedBefore(date, month, year);
	}

}
