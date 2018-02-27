package prototype;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.SerializationUtils;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

public class EmployeeTest {

    @Test
    public void testDeepCopy() {
        Employee employee = new Employee("John Doe",
                LocalDate.of(2000, 1, 1),
                Arrays.asList(new Phone("home", "111"), new Phone("work", "222")));
        Employee other = new Employee(employee);
        assertThat(other.getName(), equalTo(employee.getName()));
        assertThat(other.getDateOfBirth(), equalTo(employee.getDateOfBirth()));
        assertThat(other.getPhones().get(0).getType(), equalTo(employee.getPhones().get(0).getType()));
        assertThat(other.getPhones().get(0), not(sameInstance(employee.getPhones().get(0))));
    }

    @Test(expected =  InstantiationException.class)
    public void testBeanUtilsClone() throws Exception {
        // Nincs üres konstruktor

        Employee employee = new Employee("John Doe",
                LocalDate.of(2000, 1, 1),
                Arrays.asList(new Phone("home", "111"), new Phone("work", "222")));

        // Üres konstruktort berakva: null marad, hiszen nincs setter
        Employee other = (Employee) BeanUtils.cloneBean(employee);
        assertThat(other.getName(), equalTo(employee.getName()));
    }

    @Test
    public void testSerializationUtilsClone() {
        Employee employee = new Employee("John Doe",
                LocalDate.of(2000, 1, 1),
                Arrays.asList(new Phone("home", "111"), new Phone("work", "222")));

        Employee other = (Employee) SerializationUtils.clone(employee);
        assertThat(other.getName(), equalTo(employee.getName()));
        assertThat(other.getPhones().get(0).getType(), equalTo(employee.getPhones().get(0).getType()));
        assertThat(other.getPhones().get(0), not(sameInstance(employee.getPhones().get(0))));
    }
}
