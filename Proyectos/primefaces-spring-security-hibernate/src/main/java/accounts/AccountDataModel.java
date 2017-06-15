package accounts;

import java.io.Serializable;
import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

public class AccountDataModel extends ListDataModel<Account> 
			implements SelectableDataModel<Account>, Serializable {  

    /**
	 * 
	 */
	private static final long serialVersionUID = 1050103646317116769L;

	public AccountDataModel() {  
    }  
  
    public AccountDataModel(List<Account> data) {  
        super(data);  
    }  
    
	public Account getRowData(String rowKey) {
		 //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data  
        
        @SuppressWarnings("unchecked")
		List<Account> accounts = (List<Account>) 
        				getWrappedData();  
          
        for(Account account : accounts) {  
            if(account.getEntityId().equals(rowKey))  
                return account;  
        }  
          
        return null;  
	}

	public Object getRowKey(Account account) {
		return account.getEntityId();
	}

}
