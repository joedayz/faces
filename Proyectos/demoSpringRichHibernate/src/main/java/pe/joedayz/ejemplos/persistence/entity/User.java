package pe.joedayz.ejemplos.persistence.entity;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 5634914903775684072L;
    private Long id;
	private String userName;
	private String password;
	private String email;
	private Boolean sex;
	private String firstName;
	private String lastName;
	private Boolean enabled = Boolean.FALSE;
	private String credential;


	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		if (id != null ? !id.equals(user.id) : user.id != null) return false;
		return true;
	}

	public String getName(){
		StringBuffer sb = new StringBuffer();
		sb.append(getFirstName());
		sb.append(" ");
		sb.append(getLastName());
		return sb.toString();
	}

	public int hashCode() {
		return (id != null ? id.hashCode() : 0);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}


}
