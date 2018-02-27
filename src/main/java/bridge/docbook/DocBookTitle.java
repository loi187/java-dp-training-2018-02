package bridge.docbook;

import bridge.Title;

import java.io.BufferedWriter;
import java.io.IOException;

public class DocBookTitle implements Title {

    private BufferedWriter writer;

    public DocBookTitle(BufferedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void setContent(String s) {
        try {
            writer.write("<title>");
            writer.write(s);
            writer.write("</title>");
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot write", ioe);
        }
    }
}
