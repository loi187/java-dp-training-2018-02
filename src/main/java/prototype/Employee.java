package prototype;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Employee implements Serializable {
	
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
