package Notes.model;

import java.util.List;

public interface NotebookFile {
    List<String> readAllLines();
    void saveAllLines(List<String> lines);

}
