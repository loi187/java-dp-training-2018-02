package builder;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Employee {
	
	private String name;
	
	private LocalDate dateOfBirth;

	private List<Phone> phones;

	public Employee(String name, LocalDate dateOfBirth, List<Phone> phones) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public List<Phone> getPhones() {
		return Collections.unmodifiableList(phones);
	}
}
