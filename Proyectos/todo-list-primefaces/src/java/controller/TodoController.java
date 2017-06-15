package controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import model.Todo;
import model.TodoListModel;

/**
 * Controller for a todo list.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 */
@ManagedBean( name="controller")
@SessionScoped
public class TodoController implements Serializable {
    
    private           TodoListModel model;
    
    //TODO :: transient to prevent GF run-time error
    private transient UIInput       newTodoText;
    
    //TODO :: transient to prevent GF run-time error
    private transient Todo          selectedTodo;
    
    public TodoController() {
        super();
        
        model = new TodoListModel();
        
        newTodoText = new UIInput();
    }
    
    public int compareTodos( Object todo1, Object todo2 ) {
        return todo1.toString().compareToIgnoreCase( todo2.toString() );
    }

    public TodoListModel getModel() {
        return model;
    }

    public UIInput getNewTodoText() {
        return newTodoText;
    }

    public Todo getSelectedTodo() {
        return selectedTodo;
    }

    public void handleNewTodo() {
        if (newTodoText.getValue() == null )
            return;
        
        if ( newTodoText.getValue().toString().equals("") )
            return;
        
        //GET new todo from the View
        Todo newTodo = new Todo( newTodoText.getValue().toString() );
        
        //SET Model to new state (i.e. append new todo)
        model.append(newTodo);
        
        newTodoText.setValue( "" );
    }
    
    public void setNewTodoText(UIInput newTodoText) {
        this.newTodoText = newTodoText;
    }

    public void setSelectedTodo(Todo selectedTodo) {
        this.selectedTodo = selectedTodo;
    }
}
