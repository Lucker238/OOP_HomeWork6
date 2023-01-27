package Notes;

import Notes.controllers.Controller;
import Notes.model.NotebookEdit;
import Notes.model.NotebookEditor;
import Notes.model.NotebookFile;
import Notes.model.NotebookFileOperation;
import Notes.views.Viev;

public class Main {
    public static void main(String[] args) {
        NotebookFile fileOperator = new NotebookFileOperation("Notebook.txt");
        NotebookEdit notebook = new NotebookEditor(fileOperator);
        Controller controller = new Controller(notebook);
        Viev view = new Viev(controller);
        view.openNotebook();
        }
    }

