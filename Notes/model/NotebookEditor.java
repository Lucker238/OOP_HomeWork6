package Notes.model;

import java.util.ArrayList;
import java.util.List;

public class NotebookEditor implements NotebookEdit{
    private NoteMapper mapper = new NoteMapper();
    private NotebookFile notebookFile;

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = notebookFile.readAllLines();
        List<Note> notes = new ArrayList<>();
        for(String line: lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public String createNote(Note note) {
        List<Note> notes = getAllNotes();
        int maxID = 0;
        for (Note note2 : notes) {
            int id = note2.getId();
            if(maxID < id) {
                maxID = id;
            }
        }
        int newID = maxID + 1;
        String id = Integer.toString(newID);
        note.setId(newID);
        notes.add(note);
        writeDown(notes);
        return null;
    }

    @Override
    public void updateNote(Note note) {
        // List<Note> notes = getAllNotes();
    }

    @Override
    public void deleteNote(Note note) {
        // TODO Auto-generated method stub
        
    }

    private void writeDown(List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note note : notes) {
            lines.add(mapper.map(note));
        }
        notebookFile.saveAllLines(lines);
    }
    
}
