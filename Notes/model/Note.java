package Notes.model;

public class Note {
    private int id;
    private String name;
    private String text;
    private String date;
    
    public Note(int id, String name, String text) {
        this.id = id;
        this.name = name;
        this.text = text;
    }

    public Note(int id, String name, String text, String date) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.date = date;
    }

    public Note(String name, String text, String date) {
        this.name = name;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
