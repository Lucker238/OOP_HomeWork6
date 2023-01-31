package Notes.model;

import java.util.ArrayList;
import java.util.List;

public class NotebookEditor implements NotebookEdit{
    private Mapper mapper = new NoteMapper();
    private NotebookFile notebookFile;


    public NotebookEditor(NotebookFile notebookFile) {
        this.notebookFile = notebookFile;
    }


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
    public int createNote(Note note) {
        List<Note> notes = getAllNotes();
        int maxID = 0;
        for (Note note2 : notes) {
            int id = note2.getId();
            if(maxID < id) {
                maxID = id;
            }
        }
        int newID = maxID + 1;
        note.setId(newID);
        notes.add(note);
        writeDown(notes);
        return newID;
    }

    @Override
    public void updateNote(Note note) {
        List<Note> notes = getAllNotes();
        Note noteForEdid = notes.stream().filter(i -> i.getId() == note.getId()).findFirst().get();
        noteForEdid.setName(note.getName());
        noteForEdid.setText(note.getText());
        noteForEdid.setDate(note.getDate());
        writeDown(notes);
    }

    @Override
    public void deleteNote(Note note) {
        List<Note> notes = getAllNotes();
        Note noteForDelete = notes.stream().filter(i -> i.getId() == note.getId()).findFirst().get();
        notes.remove(noteForDelete);
        edditList(notes);
    }

    private void writeDown(List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note note : notes) {
            lines.add(mapper.map(note));
        }
        notebookFile.saveAllLines(lines);
    }

    private void edditList(List<Note> notes) {
        int id = 1;
        for (Note note : notes) {
            note.setId(id);
            id += 1;
        }
        writeDown(notes);
    }
    
}
