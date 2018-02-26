package factorymethod;

import java.util.List;

public class BookReaderFactoryProvider {

    private List<BookReaderFactory> bookReaderFactories;

    public BookReaderFactoryProvider(List<BookReaderFactory> bookReaderFactories) {
        this.bookReaderFactories = bookReaderFactories;
    }

    public BookReaderFactory getBookReaderFactory(String fileType) {
        return bookReaderFactories.stream().filter((f) -> f.supports().equals(fileType)).findFirst().orElseThrow(() -> new IllegalArgumentException("Illegal format: " + fileType));
    }
}
