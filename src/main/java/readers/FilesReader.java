package readers;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilesReader {
    private final String fileName;

    public FilesReader(String fileName) {
        this.fileName = fileName;
    }

    public List<List<String>> read() throws IOException {
        List<List<String>> calls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] call = line.split(", ");
                calls.add(Arrays.asList(call));
            }
        }
        return calls;
    }
}
