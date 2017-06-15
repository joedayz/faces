package accounts.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import accounts.Account;
import accounts.AccountDataModel;
import accounts.internal.service.AccountManager;

@Component("accountList")
@Scope("request")
public class AccountList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1227637581783372307L;

	private Account selectedAccount;

	private AccountDataModel accountsModel;

	public AccountList() {

	}

	@Autowired
	public AccountList(AccountManager accountManager) {
		List<Account> accounts = accountManager.getAllAccounts();
		accountsModel = new AccountDataModel(accounts);
	}

	public AccountDataModel getAccountsModel() {
		return accountsModel;
	}

	public Account getSelectedAccount() {
		return selectedAccount;
	}

	public void setSelectedAccount(Account selectedAccount) {
		this.selectedAccount = selectedAccount;
	}

	
	public String addAccount() {
		
		return "accountDetails?faces-redirect=true";
	}	
	
	public void onRowSelect(SelectEvent event) {

		System.out.println(selectedAccount);

		Flash flash = FacesContext.getCurrentInstance().getExternalContext()
				.getFlash();
		flash.put("id", selectedAccount.getEntityId().toString());  

		ConfigurableNavigationHandler handler = (ConfigurableNavigationHandler) FacesContext
				.getCurrentInstance().getApplication().getNavigationHandler();
		handler.performNavigation("accountDetails?faces-redirect=true");

	}

}