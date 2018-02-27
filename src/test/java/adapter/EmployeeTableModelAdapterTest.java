package adapter;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class EmployeeTableModelAdapterTest {

    private List<Employee> employeeList = Arrays.asList(
            new Employee("John Doe", LocalDate.of(2000, 1, 1)),
            new Employee("Jane Doe", LocalDate.of(2000, 1, 1))
    );

    @Test
    public void testGetRowCount() {
        EmployeeTableModelAdapter adapter = new EmployeeTableModelAdapter(employeeList);
        assertThat(adapter.getRowCount(), equalTo(2));
    }

    @Test
    public void getColumns() {
        EmployeeTableModelAdapter adapter = new EmployeeTableModelAdapter(employeeList);
        assertThat(adapter.getColumns().size(), equalTo(2));
        assertThat(adapter.getColumns().get(0).getName(), equalTo("Name"));
        assertThat(adapter.getColumns().get(1).getName(), equalTo("Date of birth"));
    }

    @Test
    public void getValueAt() {
        EmployeeTableModelAdapter adapter = new EmployeeTableModelAdapter(employeeList);
        assertThat(adapter.getValueAt(0, adapter.getColumns().get(0)), equalTo("John Doe"));
        assertThat(adapter.getValueAt(1, adapter.getColumns().get(1)),
                equalTo("2000-01-01"));
    }
}
