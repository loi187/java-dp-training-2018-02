package factorymethod;

import org.springframework.context.annotation.Bean;

import java.util.List;

public class Configuration {

    @Bean
    public BookReaderFactory csvBookReaderFactory() {
        return new CsvBookReaderFactory();
    }

    @Bean
    public BookReaderFactory xmlBookReaderFactory() {
        return new XmlBookReaderFactory();
    }

    @Bean
    public BookReaderFactoryProvider bookReaderFactoryProvider(List<BookReaderFactory> bookReaderFactories) {
        return new BookReaderFactoryProvider(bookReaderFactories);
    }
}
