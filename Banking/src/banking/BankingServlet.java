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
import logicalLayer.LogicalHandler;
import persistence.PersistenceDAO;
import persistence.PersistenceDAOImpl;
import persistence.PersistenceException;

/**
 * Servlet implementation class Bankingservlet
 */
@WebServlet("/Bankingservlet")
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
		doPost(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	    String name=request.getParameter("link");
	    System.out.println(name);
	    //String input=request.getParameter("innerLink");
		response.setContentType("text/html");//setting the content type  
		PrintWriter pw=response.getWriter();//get the stream to write the data    
		//writing html in the stream  
		 pw.println("welcome"+" "+name);
		 if(name.equalsIgnoreCase("Customer"))
		 {
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
			 RequestDispatcher display=request.getRequestDispatcher("jsp/Transaction.jsp");
			 display.forward(request,response);
		 }
		 else if(name.equalsIgnoreCase("AddCustomers"))
         {
         	request.getRequestDispatcher("jsp/AddCustomers.jsp").forward(request, response);
         }
		 else if(name.equalsIgnoreCase("AddAccounts"))
         {
         	request.getRequestDispatcher("jsp/AddAccounts.jsp").forward(request, response);
         }
		 else if(name.equalsIgnoreCase("submitCustomer"))
		 {
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
		 }
			/*
			 * if(name.equals("Customer")) { response.sendRedirect("jsp/Customer.jsp"); }
			 * else if(name.equals("Customer")) { response.sendRedirect("jsp/Customer.jsp");
			 * } if(name.equals("Customer")) { response.sendRedirect("jsp/Customer.jsp"); }
			 */
		//pw.println("<html><head></head><body>Welcome markret </body></html>");  
		pw.close();//closing the stream  
	}

}
