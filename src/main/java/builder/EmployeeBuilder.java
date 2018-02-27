package builder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBuilder {

	private String name;
	
	private LocalDate dateOfBirth = LocalDate.of(1970, 01, 01);

	private List<Phone> phones = new ArrayList<>();
	
	public EmployeeBuilder withName(String name) {
		this.name = name;
		return this;
	}
	
	public EmployeeBuilder withDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public EmployeeBuilder addPhone(String type, String number) {
		phones.add(new Phone(type, number));
		return this;
	}
	
	public Employee build() {
		if (name == null || name.trim().equals("")) {
			throw new IllegalStateException("Empty name");
		}
		Employee employee = new Employee(name, dateOfBirth, phones);
		return employee;
	}
}
