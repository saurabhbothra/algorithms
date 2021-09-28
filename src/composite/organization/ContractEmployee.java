package composite.organization;

public class ContractEmployee extends NonManagerEmployee{
	
	private int day;
	private int month;
	private int year;
	
	public ContractEmployee(String name, double pay, Gender gender, int day, int month, int year) {
		super(name, pay, gender);
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public int terminatedBefore(int date, int month, int year) {
		// TODO Auto-generated method stub
		if(this.year <= year && this.month <= month && this.day < date) {
			return 1;
		}
		return 0;
	}
	
	

}
