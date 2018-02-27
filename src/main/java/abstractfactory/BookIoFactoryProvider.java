package abstractfactory;

import java.util.List;

public class BookIoFactoryProvider {

    private List<BookIoFactory> bookReaderFactories;

    public BookIoFactoryProvider(List<BookIoFactory> bookReaderFactories) {
        this.bookReaderFactories = bookReaderFactories;
    }

    public BookIoFactory getBookIoFactory(String fileType) {
        return bookReaderFactories.stream().filter((f) -> f.supports().equals(fileType)).findFirst().orElseThrow(() -> new IllegalArgumentException("Illegal format: " + fileType));
    }
}
