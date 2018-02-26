package factorymethod;

public class CsvBookReaderFactory implements BookReaderFactory {

    @Override
    public BookReader create() {
        return new CsvBookReader();
    }

    @Override
    public String supports() {
        return "csv";
    }
}
