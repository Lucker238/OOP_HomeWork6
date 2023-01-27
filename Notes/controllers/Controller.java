package Notes.controllers;

import java.util.List;

import Notes.model.Note;
import Notes.model.NotebookEdit;

/**
 * Controller
 */
public class Controller {
    private NotebookEdit notebook;

    public Controller(NotebookEdit notebook) {
        this.notebook = notebook;
    }

    public void saveNote (Note note){
        notebook.createNote(note);
    } 
    
    public Note readNote(int noteID) throws Exception{
        List<Note> notes = notebook.getAllNotes();
        for (Note note : notes) {
            if(note.getId()==noteID) {
                return note;
            }
        }
        throw new Exception("No such a note here");
    }

    public List<Note> readAllNotes() {
        List<Note> notes = notebook.getAllNotes();
        return notes;
    }

    public void updateNote(int ID, Note newNote) throws Exception{
        checkIDPresence(ID);
        newNote.setId(ID);
        notebook.updateNote(newNote);
    }

    public void deleteNote(int ID) throws Exception{
        checkIDPresence(ID);
        Note delNote = readNote(ID);
        notebook.deleteNote(delNote);
    }

    public void checkIDPresence(int updateID) throws Exception{
        List<Note> notes = notebook.getAllNotes();
        for (Note note : notes) {
            if(note.getId() == updateID){
                return;
            }
        }
        throw new Exception("ID not found");
    }

}