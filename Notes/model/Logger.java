package Notes.model;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {


    public void makeLog(String log) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(log);
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
        }
    }

}
