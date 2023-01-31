package Notes.model;

public class NoteMapper implements Mapper{
    
    @Override
    public String map(Note note) 
    {
        if(note.getDate().isBlank()) {
            return String.format("%d,%s,%s,%s", note.getId(), note.getName(), note.getText());
        }
        return String.format("%d,%s,%s,%s", note.getId(), note.getName(), note.getText(), note.getDate());
    }

    @Override
    public Note map(String str) 
    {
        String[] strgs = str.split(",");
        if (strgs.length == 3) {
            return new Note(Integer.parseInt(strgs[0]), strgs[1], strgs[2]);
        }
        return new Note(Integer.parseInt(strgs[0]), strgs[1], strgs[2], strgs[3]);
    }

}
