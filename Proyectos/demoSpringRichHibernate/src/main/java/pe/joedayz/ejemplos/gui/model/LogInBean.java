package pe.joedayz.ejemplos.gui.model;

import pe.joedayz.ejemplos.persistence.entity.User;
import pe.joedayz.ejemplos.service.businesslogic.ILoginService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component
@Scope("request")
public class LogInBean extends BaseBean {

	private static final long serialVersionUID = 199L;

    private SessionBean sessionBean;
    private ILoginService loginService;
	private String loginName = "admin";
	private String password;

	public String doLogin() {
		User user = null;
//		user = loginService.getByLoginInformation(loginName, password);
		if ("admin".equals(loginName) && "admin".equals(password)){
			user = new User();
			user.setUserName("admin");
			user.setFirstName("Admin");
			user.setLastName("Admin");
		}
		if (user == null) {
			addErrorMessage("ERROR.WRONG.LOGINDATA_"); // from resourceBundle
			// addErrorMessageText("ERROR", "Username or password wrong.");
			return null;
		}
		sessionBean.setUser(user);
		return "/page/welcome";
	}

	public SessionBean getSessionBean() {
		return sessionBean;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

}
