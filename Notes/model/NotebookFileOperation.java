package Notes.model;

import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class NotebookFileOperation implements NotebookFile{
    private String fileName;
    
    public NotebookFileOperation(String fileName) {
        this.fileName = fileName;
        try {
            File file = new File(fileName);
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            Writer writer = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<String> readAllLines() {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName);
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"));
            String line = bufferReader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                line = bufferReader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            bufferReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public void saveAllLines(List<String> lines) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line : lines) {
                writer.write(line);
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
