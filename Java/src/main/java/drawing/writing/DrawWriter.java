package drawing.writing;

import java.io.IOException;

public interface DrawWriter {
    void write(char[] cbuf, int off, int len) throws IOException;

    void flush() throws IOException;

    void close() throws IOException;

    void write(char[] jpeg) throws IOException;
}
