package Notes.model;

import java.util.List;

public interface NotebookEdit {
    
    List<Note> getAllNotes();
    int createNote(Note note);
    void updateNote(Note note);
    void deleteNote(Note note);
    
}
