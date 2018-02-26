package simplefactory;

import org.junit.Test;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ReadBookTest {

    @Test
    public void testReadCsv() {
        Book book = new BookReaderFactory()
                .reader("csv")
                .readBook(new InputStreamReader(ReadBookTest.class.getResourceAsStream("book.csv"), StandardCharsets.UTF_8));
        assertThat(book.getAuthors(), equalTo("Erich Gamma"));
        assertThat(book.getTitle(), equalTo("Design Patterns"));
    }

    @Test
    public void testReadXml() {
        Book book = new BookReaderFactory()
                .reader("xml")
                .readBook(new InputStreamReader(ReadBookTest.class.getResourceAsStream("book.xml"), StandardCharsets.UTF_8));
        assertThat(book.getAuthors(), equalTo("Erich Gamma"));
        assertThat(book.getTitle(), equalTo("Design Patterns"));
    }
}
