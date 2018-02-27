package bridge.docbook;

import bridge.Paragraph;

import java.io.BufferedWriter;
import java.io.IOException;

public class DocBookParagraph implements Paragraph {

    private BufferedWriter writer;

    public DocBookParagraph(BufferedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void setContent(String s) {
        try {
            writer.write("<para>");
            writer.write(s);
            writer.write("</para>");
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot write", ioe);
        }
    }
}
