package banking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import bankingManagement.Account;
import bankingManagement.Customer;
import logicalLayer.LogicalException;
import logicalLayer.LogicalHandler;
import persistence.PersistenceDAO;
import persistence.PersistenceDAOImpl;
import persistence.PersistenceException;

/**
 * Servlet implementation class Bankingservlet
 */
@WebServlet("/BankingServlet")
public class BankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PersistenceDAO db=new PersistenceDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("123");
		doPost(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	    String name=request.getParameter("link");
	    //System.out.println(name);
	    //String input=request.getParameter("innerLink");
		//response.setContentType("text/html");//setting the content type  
		PrintWriter pw=response.getWriter();//get the stream to write the data    
		//writing html in the stream
		 if(name.equalsIgnoreCase("Customer"))
		 {
			  //System.out.println(name);
		     try {
				ArrayList<Customer> customerList=(ArrayList<Customer>) db.getAllCustomers();
				request.setAttribute("customerList", customerList);
	            request.getRequestDispatcher("jsp/Customer.jsp").forward(request, response);
	          
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		 }
		 else if(name.equalsIgnoreCase("Account"))
		 {
			 //System.out.println(name);
			 try {
					ArrayList<Account> accountList=(ArrayList<Account>) db.getAllAccounts();
					request.setAttribute("accountList", accountList);
		            request.getRequestDispatcher("jsp/Account.jsp").forward(request, response);
				} catch (PersistenceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		 }
		 else if(name.equalsIgnoreCase("Transaction"))
		 {
			 //System.out.println(name);
			 RequestDispatcher display=request.getRequestDispatcher("jsp/Transaction.jsp");
			 display.forward(request,response);
		 }
		 else if(name.equalsIgnoreCase("withdraw"))
		 {
			 RequestDispatcher display=request.getRequestDispatcher("jsp/WithDraw.jsp");
			 display.forward(request,response);
		 }
		 else if(name.equalsIgnoreCase("deposit"))
		 {
			 RequestDispatcher display=request.getRequestDispatcher("jsp/Deposit.jsp");
			 display.forward(request,response);
		 }
		 else if(name.equalsIgnoreCase("AddCustomers"))
         {
			// System.out.println(name);
         	request.getRequestDispatcher("jsp/AddCustomers.jsp").forward(request, response);
         }
		 else if(name.equalsIgnoreCase("AddAccounts"))
         {
			 //System.out.println(name);
         	request.getRequestDispatcher("jsp/AddAccounts.jsp").forward(request, response);
         }
		 else if(name.equalsIgnoreCase("submitCustomer"))
		 {
			 //System.out.println(name);
			 ArrayList<Customer> customerList=new ArrayList<>();
			 ArrayList<Account>  accountList=new ArrayList<>();
			 String customerName=(String) request.getParameter("fname");
			 int age=Integer.parseInt(request.getParameter("age"));
			 long phone=Long.parseLong( request.getParameter("phone"));
			 double balance=Double.parseDouble(request.getParameter("balance")); 
			 Customer customer=new Customer();
			 Account account=new Account();
			 customer.setName(customerName);
			 customer.setAge(age);
			 customer.setPhone(phone);
			 account.setBalance(balance);
			 System.out.println(customer);
			 System.out.println(account);
			 customerList.add(customer);
			 accountList.add(account);
			 LogicalHandler.INSTANCE.handleNewCustomer(customerList, accountList);
			 pw.println("add customer successfully");
		 }
		 else if(name.equalsIgnoreCase("submitAccount"))
		 {
			// System.out.println(name);
		// System.out.println("hi account");
		 long customerId=Long.parseLong(request.getParameter("fname"));
		 double balance=Double.parseDouble(request.getParameter("lname"));
		 try {
		 LogicalHandler.INSTANCE.addNewAccountForExistingCustomer(customerId, balance);
		 pw.println("add account successfully");
		 }
		 catch(Exception e)
		 {
			 System.out.print(e);
		 }
		 }
		 else if(name.equalsIgnoreCase("DeleteAccounts"))
		 {
			 //System.out.println(name);
			 String[] arr=request.getParameterValues("selectedAccounts");
			 for(String str:arr)
			 {
				 String[] s=str.split(",");
				 try {
					LogicalHandler.INSTANCE.deleteAccount(Long.parseLong(s[0]), Long.parseLong(s[1]));
				} catch (NumberFormatException | LogicalException | PersistenceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pw.println("Account Id:"+Long.parseLong(s[1])+"deleted successfully");	 
			 }
		 }
		 else if(name.equalsIgnoreCase("DeleteCustomers"))
		 {
			 System.out.println("delete customers***"+name);
			 String[] arr=request.getParameterValues("selectedCustomers");
			 for(String str:arr)
			 {
				 System.out.println("delete customer id***"+str);
				 
					try {
						LogicalHandler.INSTANCE.deleteCustomer(Long.parseLong(str));
					} catch (NumberFormatException | PersistenceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
				pw.println("customer id:"+"deleted successfully");	 
			
			 }
		 }
		 else if(name.equalsIgnoreCase("submitWithdraw")) {
			 
			 System.out.println("submit withdraw***"+name);
			 long customer_id=Long.parseLong(request.getParameter("customerId"));
			 System.out.println("submit withdraw***"+customer_id);
			 long account_id=Long.parseLong(request.getParameter("accountId"));
			 System.out.println("submit withdraw***"+account_id);
			 double balance=Double.parseDouble(request.getParameter("amount"));
			 System.out.println("submit withdraw***"+balance);
			 try {
				 System.out.println("submit withdraw***before logical handler");
				String result=LogicalHandler.INSTANCE.transactionOfWithdraw(customer_id, account_id, balance);
				System.out.println("submit withdraw***after logical handler");
				pw.println(result);
			} catch (LogicalException | PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
			 else if(name.equalsIgnoreCase("submitDeposit")) {
				 
				 long customer_id=Long.parseLong(request.getParameter("customerId"));
				 long account_id=Long.parseLong(request.getParameter("accountId"));
				 double balance=Double.parseDouble(request.getParameter("amount"));
				 try {
					String result=LogicalHandler.INSTANCE.transactionOfDeposit(customer_id, account_id, balance);
					pw.println(result);
				} catch (LogicalException | PersistenceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
		 }
			/*meter(
			 * if(name.equals("Customer")) { response.sendRedirect("jsp/Customer.jsp"); }
			 * else if(name.equals("Customer")) { response.sendRedirect("jsp/Customer.jsp");
			 * } if(name.equals("Customer")) { response.sendRedirect("jsp/Customer.jsp"); }
			 */
		//pw.println("<html><head></head><body>Welcome markret </body></html>");  
	//	pw.close();//closing the stream  
	}

}
