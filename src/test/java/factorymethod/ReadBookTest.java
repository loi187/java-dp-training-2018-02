package factorymethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuration.class)
public class ReadBookTest {

    @Autowired
    private BookReaderFactoryProvider bookReaderFactoryProvider;

    @Test
    public void testReadCsv() {
        Book book = bookReaderFactoryProvider
                .getBookReaderFactory("csv")
                .create()
                .readBook(new InputStreamReader(ReadBookTest.class.getResourceAsStream("book.csv"), StandardCharsets.UTF_8));
        assertThat(book.getAuthors(), equalTo("Erich Gamma"));
        assertThat(book.getTitle(), equalTo("Design Patterns"));
    }

    @Test
    public void testReadXml() {
        Book book = bookReaderFactoryProvider
                .getBookReaderFactory("xml")
                .create()
                .readBook(new InputStreamReader(ReadBookTest.class.getResourceAsStream("book.xml"), StandardCharsets.UTF_8));
        assertThat(book.getAuthors(), equalTo("Erich Gamma"));
        assertThat(book.getTitle(), equalTo("Design Patterns"));
    }
}
