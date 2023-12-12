package hw_19;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ListDirectoryContents {
    public static void main(String[] args) {
        String directoryPath = "";

        List<String> fileList = listFilesInDirectory(directoryPath);

        System.out.println("Первые 5 элементов в каталоге:");
        for (int i = 0; i < 5 && i < fileList.size(); i++) {
            System.out.println(fileList.get(i));
        }
    }

    public static List<String> listFilesInDirectory(String directoryPath) {
        List<String> fileList = new ArrayList<>();

        Path path = Paths.get(directoryPath);
        if (Files.exists(path) && Files.isDirectory(path)) {
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
                for (Path file : directoryStream) {
                    fileList.add(file.getFileName().toString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Указанный путь не является директорией или не существует.");
        }

        return fileList;
    }
}

