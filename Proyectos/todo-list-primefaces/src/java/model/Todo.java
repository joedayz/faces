package model;

import java.io.Serializable;
import java.util.Date;

/**
 * Model a todo item.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 */
public class Todo implements Serializable {

    private Date dateCreated;
    private Date dateModified;

    private String todo;

    private Todo() {}

    public Todo( String todo ) {
        super();
        
        this.todo = todo;
        
        dateCreated = dateModified = new Date();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
        
        dateModified = new Date();
    }

    @Override
    public String toString() {
        return todo;
    }
}
