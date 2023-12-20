package hw_22_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class CreateTextDoc<T> implements ICreateDocument {
    @Override
    public IDocument<T> CreateNew() {
        return (IDocument<T>) new TextDocument("Безымянный");
    }

    @Override
    public IDocument<T> CreateOpen(String path) throws FileNotFoundException {
        BufferedReader file = new BufferedReader(new FileReader(path));
        return (IDocument<T>) new TextDocument(path, file.lines().collect(Collectors.joining("\n")));
    }
}
