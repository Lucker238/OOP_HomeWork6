package Notes.views;

import java.util.List;
import java.util.Scanner;

import Notes.controllers.Controller;
import Notes.model.Note;

public class Viev {
    private Controller controller;

    public Viev(Controller controller) {
        this.controller = controller;
    }

    public void openNotebook() {
        Commands commands = Commands.NONE;
        System.out.println("Command List:\nLIST\nCREATE\nUPDATE\nDELETE\nREAD\nCLOSE or EXIT");
        while(true) {
            String command = prompt("Введите команду: ");
            commands = Commands.valueOf(command.toUpperCase());
            if(commands == Commands.EXIT || commands == Commands.CLOSE) {
                return;
            }
            try{
                switch(commands) {
                    case NONE:
                        System.out.println("Ничего не произошло");
                        break;
                    case CREATE:
                        String name = prompt("Название: ");
                        String text = prompt("Текст: ");
                        String date = prompt("Дата: ");
                        controller.saveNote(new Note(name, text, date));
                        break;
                    case READ:
                        int id = Integer.parseInt(prompt("Введите ID: "), 0, 0, 0);
                        Note note = controller.readNote(id);
                        System.out.println(note);
                        break;
                    case LIST:
                        List<Note> notes = controller.readAllNotes();
                        for (Note note2 : notes) {
                            System.out.println(note2+"\n");
                        }
                        break;
                    case UPDATE:
                        int updateID = Integer.parseInt(prompt("Введите ID для обовления: "));
                        controller.checkIDPresence(updateID);
                        controller.updateNote(updateID, newNote());
                        break;
                    case DELETE:
                        int delID = Integer.parseInt(prompt("Введите ID для удаления: "));
                        controller.checkIDPresence(delID);
                        controller.deleteNote(delID);
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    
    }

    private String prompt(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        return input.nextLine();
    }

    private Note newNote() {
        String name = prompt("Название: ");
        String text = prompt("Текст: ");
        String date = prompt("Дата: ");
        Note note = new Note(name, text, date);
        return note;
    }

    
}
