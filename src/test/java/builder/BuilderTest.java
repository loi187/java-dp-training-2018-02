package builder;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class BuilderTest {

    @Test(expected = IllegalStateException.class)
    public void emptyName() {
        new EmployeeBuilder().build();
    }

    @Test
    public void defaultDateOfBirth() {
        Employee employee = new EmployeeBuilder().withName("John Doe").build();
        assertThat(employee.getName(), equalTo("John Doe"));
        assertThat(employee.getDateOfBirth(), equalTo(LocalDate.of(1970, 01, 01)));
    }

    @Test
    public void phones() {
        Employee employee = new EmployeeBuilder()
                .withName("John Doe")
                .addPhone("home", "+11-11-111-111")
                .addPhone("work", "+22-22-222-222")
                .build();
        assertThat(employee.getPhones().get(0).getNumber(), equalTo("+11-11-111-111"));
        assertThat(employee.getPhones().get(1).getType(), equalTo("work"));
    }
}
