package factorymethod;

public interface BookReaderFactory {

    BookReader create();

    String supports();
}
