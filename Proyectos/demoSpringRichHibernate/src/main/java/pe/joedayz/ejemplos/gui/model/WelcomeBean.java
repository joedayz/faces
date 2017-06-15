package pe.joedayz.ejemplos.gui.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("request")
public class WelcomeBean {
	
	private String text;
    private Date date;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		System.out.println(text);
		this.text = text;
	}

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}