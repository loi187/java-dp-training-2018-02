package adapter;

import java.util.Arrays;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class EmployeeTableModelAdapter implements TableModel {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private List<Employee> employees;

    public EmployeeTableModelAdapter(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public int getRowCount() {
        return employees.size();
    }

    @Override
    public List<Column> getColumns() {
        return Arrays.asList(
                new Column<Employee>() {
                    @Override
                    public String getName() {
                        return "Name";
                    }

                    @Override
                    public String getValue(Employee employee) {
                        return employee.getName();
                    }
                },
                new Column<Employee>() {
                    @Override
                    public String getName() {
                        return "Date of birth";
                    }

                    @Override
                    public String getValue(Employee employee) {
                        return FORMATTER.format(employee.getDateOfBirth());
                    }
                }
        );
    }

    @Override
    public String getValueAt(int row, Column column) {
        return column.getValue(employees.get(row));
    }
}
