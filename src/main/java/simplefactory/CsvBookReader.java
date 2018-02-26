package simplefactory;

import java.io.BufferedReader;
import java.io.Reader;

public class CsvBookReader implements BookReader {

    private static Book parse(String s) {
        String[] parts = s.split(";");
        String authors = parts[0];
        String title = parts[1];
        return new Book(authors, title);
    }

    @Override
    public Book readBook(Reader reader) {
        return new BufferedReader(reader)
                .lines()
                .findFirst()
                .map(CsvBookReader::parse)
                .orElseThrow(() -> new IllegalArgumentException("Invalid file"));
    }
}
