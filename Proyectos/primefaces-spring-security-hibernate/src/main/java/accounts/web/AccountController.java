package accounts.web;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import accounts.Account;
import accounts.internal.service.AccountManager;

/**
 * A Spring MVC @Controller controller handling requests for both the account
 * summary and the account details pages. The accountDetails() method return an
 * account, corresponding to a given entity id. The accountSummary() method
 * returns a list with all accounts.
 */
@Component("accountForm")
@Scope("request")
public class AccountController extends BasePage {

	private AccountManager accountManager;
	private Account account = new Account();
	private String id;

	public AccountController(){
		
	}
	
	
	@Autowired
	public AccountController(AccountManager accountManager) {

		this.accountManager = accountManager;
		Flash flash = FacesContext.getCurrentInstance().  
                getExternalContext().getFlash();  
		//preserve messages across redirect  
		flash.setKeepMessages(true);  
		String id = (String) flash.get("id");
		
		if(id != null){
			account = this.accountManager.getAccount(new Long(id));
			this.setId(id);
		}		
	}

	public String updateAccount() {
		if (account.getEntityId() == null
				|| StringUtils.isBlank(account.getEntityId().toString())
				|| account.getEntityId().toString().equalsIgnoreCase("0")) {

			account.setEntityId(null);
		}
		accountManager.update(account);
		return "accountSummary?faces-redirect=true";
	}

	public String deleteAccount() {
		accountManager.delete(account.getEntityId());
		return "accountSummary?faces-redirect=true";
	}
	
	
	public String cancelAccount() {
		
		return "accountSummary?faces-redirect=true";
	}	

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}