package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Model a todo list.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 */
public class TodoListModel implements Serializable {
    
    private ArrayList<Todo> todoList;
    
    public TodoListModel() {
        super();
        
        todoList = new ArrayList<Todo>();
        
        //populate the list with some sample todos
        //TODO
        //for( int i = 0; i < 20; i++) {
            todoList.add(new Todo("Eat"));
            todoList.add(new Todo("Sleep"));
            todoList.add(new Todo("Study"));
        //}
    }

    public void append( Todo newTodo ) {
        todoList.add( newTodo );
    }

    public ArrayList<Todo> getTodoList() {
        return todoList;
    }

    public int getNumberOfTodos() {
        return todoList.size();
    }
}
