package pe.joedayz.ejemplos;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;


@ManagedBean
@RequestScoped
public class BypassUpdatesBean {

	@Length(min = 3, message = "Name must be at least {min} characters long")
	private String name;
	@Email(message = "Invalid email address")
	private String email;
	@Min(value = 1, message = "Age must be greater than 0")
	private Integer age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
