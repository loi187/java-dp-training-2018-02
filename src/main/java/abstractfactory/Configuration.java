package abstractfactory;

import org.springframework.context.annotation.Bean;

import java.util.List;

public class Configuration {

    @Bean
    public BookIoFactory csvBookIoFactory() {
        return new CsvBookIoFactory();
    }

    @Bean
    public BookIoFactory xmlBookIoFactory() {
        return new XmlBookIoFactory();
    }

    @Bean
    public BookIoFactoryProvider bookIoFactoryProvider(List<BookIoFactory> bookReaderFactories) {
        return new BookIoFactoryProvider(bookReaderFactories);
    }
}
