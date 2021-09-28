package composite.organization;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Organization startup;

		startup = new OrganizationImpl("Bob", 50000, Gender.UNDISCLOSED);

		startup.addEmployee("Bill", 20000, Gender.MALE, "Bob");
		startup.addEmployee("Michelle", 30000, Gender.FEMALE, "Bob");
		startup.addContractEmployee("Mark", 10000, Gender.MALE, "Bill", 1, 9, 2018);
		startup.addEmployee("Amit", 10000, Gender.MALE, "Bill");
		startup.addContractEmployee("Chuck", 10000, Gender.UNDISCLOSED, "Michelle", 1, 12, 2018);

		startup.addContractEmployee("Tom", 10000, Gender.MALE, "Bill", 15, 10, 2018);

		startup.addContractEmployee("Tim", 5000, Gender.MALE, "Michelle", 15, 9, 2018);
		System.out.println(startup.getSize());

	}

}
