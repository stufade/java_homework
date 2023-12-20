package hw_22_2;

import java.io.FileNotFoundException;

public interface ICreateDocument<T> {
    IDocument<T> CreateNew();

    IDocument<T> CreateOpen(String path) throws FileNotFoundException;
}
