package Notes.views;

import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

import Notes.controllers.Controller;
import Notes.model.Logger;
import Notes.model.Note;

public class Viev {
    private Controller controller;
    private Logger logger = new Logger();

    public Viev(Controller controller) {
        this.controller = controller;
    }

    public void openNotebook() {
        Commands commands = Commands.NONE;
        System.out.println("Command List:\nLIST\nCREATE\nUPDATE\nDELETE\nREAD\nCLOSE or EXIT");
        while(true) {
            String command = prompt("Введите команду: ");
            commands = Commands.valueOf(command.toUpperCase());
            String messageForLog = command + "\n";
            if(commands == Commands.EXIT || commands == Commands.CLOSE) {
                return;
            }
            try{
                switch(commands) {
                    case NONE:
                        messageForLog += "Ничего не произошло";
                        System.out.println("Ничего не произошло");
                        logger.makeLog(messageForLog);
                        break;
                    case CREATE:
                        String name = prompt("Название: ");
                        String text = prompt("Текст: ");
                        String date = prompt("Дата: ");
                        Note newNote = new Note(name, text, date);
                        controller.saveNote(newNote);
                        messageForLog += newNote.toString();
                        logger.makeLog(messageForLog);
                        break;
                    case READ:
                        int id = Integer.parseInt(prompt("Введите ID: "));
                        Note note = controller.readNote(id);
                        System.out.println(note);
                        messageForLog += "Введите ID: " + Integer.toString(id) + "\n" + note.toString();
                        logger.makeLog(messageForLog);
                        break;
                    case LIST:
                        List<Note> notes = controller.readAllNotes();
                        for (Note note2 : notes) {
                            System.out.println(note2+"\n");
                            messageForLog += note2.toString();
                        }
                        logger.makeLog(messageForLog);
                        break;
                    case UPDATE:
                        int updateID = Integer.parseInt(prompt("Введите ID для обновления: "));
                        controller.checkIDPresence(updateID);
                        controller.updateNote(updateID, newNote());
                        messageForLog += "Введите ID для обновления: " + Integer.toString(updateID) + "\n" + "Запись обновлена.";
                        logger.makeLog(messageForLog);
                        break;
                    case DELETE:
                        int delID = Integer.parseInt(prompt("Введите ID для удаления: "));
                        controller.checkIDPresence(delID);
                        controller.deleteNote(delID);
                        messageForLog += "Введите ID для удаления: " + Integer.toString(delID) + "\n" + "Запись удалена.";
                        logger.makeLog(messageForLog);
                        break;
                }
            }
            catch (Exception e) {
                messageForLog += e.getMessage();
                logger.makeLog(messageForLog);
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
