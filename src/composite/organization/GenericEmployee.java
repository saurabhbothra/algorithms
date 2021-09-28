package composite.organization;

public abstract class GenericEmployee implements Employee {

	protected String name;
	protected Gender gender;
	protected double pay;
	
	protected GenericEmployee(String name, Gender gender, double pay) {
		this.name = name;
		this.gender = gender;
		this.pay = pay;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public Gender getGender() {
		// TODO Auto-generated method stub
		return this.gender;
	}

	@Override
	public double getAnnualPay() {
		// TODO Auto-generated method stub
		return this.pay;
	}
	
}
