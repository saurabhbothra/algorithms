package composite.organization;

import java.util.ArrayList;
import java.util.List;

public class Supervisor extends GenericEmployee {

	private List<Employee> supervisee;

	public Supervisor(String name, double pay, Gender gender) {
		super(name, gender, pay);
		this.supervisee = new ArrayList<>();
	}

	@Override
	public Employee addSupervisee(String supervisorName, Employee supervisee) {
		// TODO Auto-generated method stub
		if (this.name.equals(supervisorName)) {
			this.supervisee.add(supervisee);
			return this;
		}
		for (int i = 0; i < this.supervisee.size(); i++) {
			this.supervisee.set(i, this.supervisee.get(i).addSupervisee(supervisorName, supervisee));
		}
		return this;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int count = 1;
		for (Employee c : this.supervisee) {
			count += c.count();
		}
		return count;
	}

	@Override
	public int countByGender(Gender gender) {
		// TODO Auto-generated method stub
		int count = 0;
		if (this.gender == gender) {
			count = 1;
		}
		for (Employee e : this.supervisee) {
			count += e.countByGender(gender);
		}
		return count;
	}

	@Override
	public int terminatedBefore(int date, int month, int year) {
		// TODO Auto-generated method stub
		int count = 0;
		for (Employee e : this.supervisee) {
			count += e.terminatedBefore(date, month, year);
		}
		return count;
	}

	@Override
	public List<Employee> toList() {
		// TODO Auto-generated method stub
		List<Employee> result = new ArrayList<>();
		result.add(this);
		for (Employee e : this.supervisee) {
			result.addAll(e.toList());
		}
		return result;
	}

	@Override
	public int countPayAbove(double amount) {
		// TODO Auto-generated method stub
		int count = 0;
		if (this.pay > amount) {
			count = 1;
		}
		for (Employee e : this.supervisee) {
			count += e.countPayAbove(amount);
		}
		return count;
	}

}
