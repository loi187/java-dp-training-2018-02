package adapter;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class HtmlRendererTest {

    @Test
    public void render() {
        List<Employee> employeeList = Arrays.asList(
                new Employee("John Doe", LocalDate.of(2000, 1, 1)),
                new Employee("Jane Doe", LocalDate.of(2000, 1, 1))
        );
        HtmlRenderer htmlRenderer = new HtmlRenderer();
        String html = htmlRenderer.render(new EmployeeTableModelAdapter(employeeList));
        assertThat(html, CoreMatchers.containsString("<td>John Doe</td>"));
        assertThat(html, CoreMatchers.containsString("<td>2000-01-01</td>"));
    }
}
