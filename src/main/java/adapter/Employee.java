package adapter;

import builder.Phone;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Employee {
	
	private String name;
	
	private LocalDate dateOfBirth;

	public Employee(String name, LocalDate dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
}
