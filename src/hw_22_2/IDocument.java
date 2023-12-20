package hw_22_2;

import java.io.IOException;

public interface IDocument<T> {
    String getName();

    void setName(String name);

    String getContent();

    void setContent(String content);

    void save() throws IOException;
}
