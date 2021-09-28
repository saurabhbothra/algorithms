package composite.organization;

import java.util.ArrayList;
import java.util.List;

public class NonManagerEmployee extends GenericEmployee {
	
	public NonManagerEmployee(String name, double pay, Gender gender) {
		super(name, gender, pay);
	}

	@Override
	public Employee addSupervisee(String supervisorName, Employee supervisee) {
		// TODO Auto-generated method stub
		if(this.name.equals(supervisorName)) {
			Supervisor newSelf = new Supervisor(this.name, this.pay, this.gender);
			newSelf.addSupervisee(supervisorName, supervisee);
			return newSelf;
		}
		return this;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int countByGender(Gender gender) {
		// TODO Auto-generated method stub
		if(this.gender == gender) {
			return 1;
		}
		return 0;
	}

	@Override
	public int terminatedBefore(int date, int month, int year) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Employee> toList() {
		// TODO Auto-generated method stub
		List<Employee> result = new ArrayList<>();
		result.add(this);
		return result;
	}

	@Override
	public int countPayAbove(double amount) {
		// TODO Auto-generated method stub
		if(this.pay > amount) {
			return 1;
		}
		return 0;
	}

}
