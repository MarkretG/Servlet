package logicalLayer;
import bankingManagement.Account;
import bankingManagement.Customer;
import inMemoryStorageHandling.InMemoryStorageDAO;
import inMemoryStorageHandling.InMemoryStorageDAOImpl;
import persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum LogicalHandler {
    INSTANCE;
	PersistenceDAO persistence=new PersistenceDAOImpl();
	InMemoryStorageDAO inMemoryStorageDAO=new InMemoryStorageDAOImpl();

     LogicalHandler(){
        //initially store customer table and account table in hashmap
        try {
        	
            //get all customers and store in customer HashMap
            List<Customer> customers = persistence.getAllCustomers();
            inMemoryStorageDAO.storeCustomersInCustomerMap(customers);

            //get all Accounts and store in Hashmap account HashMap
            List<Account> accounts = persistence.getAllAccounts();
            inMemoryStorageDAO.storeAccountsInAccountMap(accounts);
        } catch (PersistenceException  e) {
            e.printStackTrace();
            System.out.println("ERROR CODE:"+e.getErrorCode() + " " + e.getMessage()+" "+e.getCause());
        }
		/*
		 * catch (LogicalException e) { e.printStackTrace();
		 * System.out.println("ERROR CODE:"+e.getErrorCode() + " " +
		 * e.getMessage()+" "+e.getCause()); }
		 */
    }
    public void handleNewCustomer(List<Customer> customers, List<Account> accounts){
    
          if (customers.isEmpty()|| accounts.isEmpty())
          {
            System.out.println("Handle new customers:"+"customers or accounts list is empty");
           }
        try {
            //insert customers in customer table and get generated customer ids
            List<Long> customer_ids = persistence.addCustomers(customers);

            //map the inserted customer id and matching account info
            Map<Long, Account> account = getAccounts(customer_ids, accounts);

            //insert accounts in account table and get inserted customer ids
            List<Long> customer_id = persistence.addAccounts(account);

            //get all inserted customers
            List<Customer> customers1 = persistence.getCustomers(customer_ids);

            //store in customer HashMap
            inMemoryStorageDAO.storeCustomersInCustomerMap(customers1);

            // get all inserted Accounts
            List<Account> accounts1 = persistence.getAccounts(customer_id);

            //store in account HashMap
            inMemoryStorageDAO.storeAccountsInAccountMap(accounts1);
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("ERROR CODE:"+e.getErrorCode() + ":" + e.getMessage()+" "+e.getCause());
        }
       
      }
    public void addNewAccountForExistingCustomer(long customer_id,double balance){
        if (customer_id<=0||balance<=0.0)
        {
            System.out.println("Add new account for existing customer:"+"customer id or balance is  less than zero");
        }
        try {
            //add new account for existing customer
             long account_id=persistence.addAccount(customer_id, balance);
            
             persistence.activateCustomer(customer_id);

             Account account=getAccountObject(customer_id,account_id,balance);

            //store in account hashMap
             inMemoryStorageDAO.storeAccountInAccountMap(account);
        }

        catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("ERROR CODE:"+e.getErrorCode() + " " + e.getMessage()+" "+e.getCause());
        }
		/*
		 * catch (LogicalException e) { e.printStackTrace();
		 * System.out.println("ERROR CODE:"+e.getErrorCode() + " " +
		 * e.getMessage()+" "+e.getCause()); }
		 */

    }
    public Customer getCustomerObject(String name,int age,long phone)
    {
        //create customer object
        Customer customer = new Customer();
        //customer.setCustomer_id(customer_id);
        customer.setName(name);
        customer.setAge(age);
        customer.setPhone(phone);
        return customer;
    }
    public Account getAccountObject(double balance)
    {
        //create account object
        Account account=new Account();
        account.setBalance(balance);
        return account;
    }

    public Account getAccountObject(long customer_id,long account_id,double balance)
    {
        //create account object
        Account account=new Account();
        account.setCustomer_id(customer_id);
        account.setAccount_id(account_id);
        account.setBalance(balance);
        return account;
    }
    public Map<Long,Account> getAccounts(List<Long> customer_ids,List<Account> accounts)
    {
        Map<Long,Account> account = new HashMap<>();

        for (int i = 0; i < customer_ids.size(); i++) {
            account.put(customer_ids.get(i), accounts.get(i));
        }
        return account;

    }

    public Map<Long, Account> getAccountsInfo(long customer_id) throws LogicalException {
        Map<Long,Map<Long,Account>> accountMap=inMemoryStorageDAO.getAccountsMap();
        Map<Long,Account>  accountInfoMap=accountMap.get(customer_id);
	
		 if (accountInfoMap==null||accountInfoMap.isEmpty()) { 
			 throw new LogicalException("Account not found for given customer id",100); }
		 
        return accountInfoMap;
    }

    public void deleteAccount(long customerId,long accountId) throws LogicalException, PersistenceException {
        if (customerId<=0||accountId<=0)
        {
            System.out.println("Delete account:"+"account id or customer id is zero");
        }
        //System.out.println("after remove");
        persistence.removeAccount(accountId);
        //System.out.println("after remove");
        Map<Long,Account> accountMap=getAccountsInfo(customerId);
        //System.out.println("Before if");
        if(accountMap.size()==1)
        {
        	//System.out.println("inside for");
            persistence.deactivateCustomer(customerId);
        }
       // System.out.println("Before for");
       for (Map.Entry<Long,Account> entry: accountMap.entrySet())
       {
    	   //System.out.println("Entered for loop");

           if(entry.getKey()==accountId)
           {
        	   //System.out.println("Entered for if");
               accountMap.remove(entry.getKey(),entry.getValue());
               break;
           }
       }
    }
    public void deleteCustomer(long customerId) throws PersistenceException {
        if (customerId<=0)
        {
            System.out.println("Delete customer:"+ "customer id is zero or less than" );
        }
        //System.out.println("after remove");
        persistence.deactivateCustomer(customerId);
        persistence.deactivateAccount(customerId);
        //System.out.println("after remove");
        inMemoryStorageDAO.getAccountsMap().remove(customerId);
    }
    public String transactionOfWithdraw(long customer_id,long account_id,double balance) throws LogicalException, PersistenceException{
    	System.out.println("submit withdraw***before get account map");
      Map<Long,Account> accountHashMap=getAccountsInfo(customer_id);
      System.out.println("submit withdraw***after get account map");
      System.out.println("submit withdraw***"+accountHashMap);
		/*
		 * if(accountHashMap==null) { return
		 * "given account id not available for given customer id"; }
		 */
      Account account=accountHashMap.get(account_id);
      if(account.getBalance()<=balance)
      {
    	  return "Insufficient balance";
      }   
       persistence.updateAccount(account_id,(account.getBalance()-balance)); 
       account.setBalance(account.getBalance()-balance);
		/*
		 * for (Map.Entry<Long,Account> entry: accountHashMap.entrySet()) {
		 * if(entry.getKey()==account_id) {
		 * entry.getValue().setBalance((entry.getValue().getBalance())-balance);
		 * //return "withdraw successfully"; } }
		 */
        return " withdraw successsfully";

    }
    public String transactionOfDeposit(long customer_id,long account_id,double balance) throws LogicalException, PersistenceException{
        Map<Long,Account> accountHashMap=getAccountsInfo(customer_id);
       
		/*
		 * Account account=accountHashMap.get(account_id);
		 * if(account.getBalance()<=balance) { return "Insufficient balance"; }
		 */ 
        Account account=accountHashMap.get(account_id);
         persistence.updateAccount(account_id,(account.getBalance()+balance)); 
         account.setBalance(account.getBalance()+balance);
			/*
			 * for (Map.Entry<Long,Account> entry: accountHashMap.entrySet()) {
			 * if(entry.getKey()==account_id) {
			 * entry.getValue().setBalance(entry.getValue().getBalance()+balance); //return
			 * "deposit successfully"; } }
			 */
          return "deposit successfully";

      }
    public void closeConnection() throws LogicalException {
        Controller.getPersistenceDAOHandler().cleanUp();
    }


}
