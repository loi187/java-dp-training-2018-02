package factorymethod;

public class XmlBookReaderFactory implements BookReaderFactory {

    @Override
    public BookReader create() {
        return new XmlBookReader();
    }

    @Override
    public String supports() {
        return "xml";
    }
}
