package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerServlet extends HttpServlet
{
  public ControllerServlet() {}
  
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String url = "/page1.jsp";
    String msg = "";
    HttpSession session = request.getSession();
    
    String action = request.getParameter("action");
    if (action == null)
    {
      action = "initial";
    }
    

    if (action.equals("initial"))
    {
      url = "/page1.jsp";


    }
    else if (action.equals("login")) {
      String email = request.getParameter("email");
      String pass = request.getParameter("password");
      if (DBServlet.emailExists(email))
    	  
      { PasswordService pws = new PasswordService();
		String encryptedPass = pws.encrypt(pass);
        if (DBServlet.passMatch(encryptedPass, email))
        {
          String type = DBServlet.getType(email);
          if (type.equals("P"))
          {
            User user = DBServlet.getUser(email);
            session.setAttribute("theUser", user);
            url = "/page4.jsp";

          }
          else
          {
            User user = DBServlet.getUser(email);
            session.setAttribute("theAdmin", user);
            ArrayList<Organisation> organisationList = new ArrayList();
            organisationList = DBServlet.getCustomers();
            request.setAttribute("theOrganisation", organisationList);
            url = "/admin.jsp";
          }
        }
        else
        {
          msg = "ERROR:Password don't match.Please try again";
          url = "/page2.jsp";
        }
        
      }
      else
      {
        msg = "ERROR:User doesnot exist";
        url = "/page2.jsp";
      }
      

    }
    else if (action.equals("logout"))
    {
      if ((session.getAttribute("theUser") != null) || (session.getAttribute("theAdmin") != null))
      {
        session.removeAttribute("theUser");
        session.removeAttribute("theAdmin");
        url = "/page1.jsp";
      }
      else
      {
        url = "/page1.jsp";

      }
      

    }
    else if (action.equals("signup"))
    {
      String email = request.getParameter("email");
      String name = request.getParameter("name");
      String type = "P";
      String pass1 = request.getParameter("password");
      String pass2 = request.getParameter("confirm_password");
      if (DBServlet.emailExists(email))
      {
        msg = "ERROR:Email already exists";
        url = "/page3.jsp";

      }
      else if (!pass1.equals(pass2))
      {
        msg = "ERROR:Password don't match.Please try again";
        url = "/page3.jsp";

      }
      else
      { PasswordService pws = new PasswordService();
		String encryptedPass = pws.encrypt(pass2);
        DBServlet.insertUser(email, encryptedPass, name);
        User user = DBServlet.getUser(email);
        session.setAttribute("theUser", user);
        url = "/page4.jsp";
      }
      

    }
    else if (action.equals("car_type"))
    {
      String car_type = request.getParameter("car_type");
      if (session.getAttribute("theUser") != null)
      {

        ArrayList<Organisation> organisationList = new ArrayList();
        organisationList = DBServlet.getCar_type(car_type);
        request.setAttribute("theOrganisation", organisationList);
        
        url = "/page9.jsp";
      }
      else
      {
        url = "/page1.jsp";
      }
      
    }
    else if (action.equals("amount"))
    {
      int min = Integer.parseInt(request.getParameter("min"));
      int max = Integer.parseInt(request.getParameter("max"));
      if (session.getAttribute("theUser") != null)
      {

        ArrayList<Organisation> organisationList = new ArrayList();
        organisationList = DBServlet.getListAmount(min, max);
        request.setAttribute("theOrganisation", organisationList);
        
        url = "/page9.jsp";
      }
      else
      {
        url = "/page1.jsp";
      }
      

    }
    else if (action.equals("count"))
    {
      int min = Integer.parseInt(request.getParameter("min"));
      int max = Integer.parseInt(request.getParameter("max"));
      if (session.getAttribute("theUser") != null)
      {

        ArrayList<Organisation> organisationList = new ArrayList();
        organisationList = DBServlet.getListCount(min, max);
        request.setAttribute("theOrganisation", organisationList);
        
        url = "/page9.jsp";
      }
      else
      {
        url = "/page1.jsp";
      }
      
    }
    else if (action.equals("list"))
    {
      if (session.getAttribute("theUser") != null)
      {

        ArrayList<Organisation> organisationList = new ArrayList();
        organisationList = DBServlet.getList();
        request.setAttribute("theOrganisation", organisationList);
        
        url = "/page9.jsp";
      }
      else
      {
        url = "/page1.jsp";
      }
      
    }
    else if (action.equals("customer"))
    {
      String email = request.getParameter("email");
      String name = request.getParameter("name");
      String phone = request.getParameter("spamount");
      String cname = request.getParameter("cname");
      DBServlet.insertCustomer(email, name, phone, cname);
      DBServlet.SendEmail(email, name);
      
      url = "/page11.jsp";



    }
    else if (action.equals("received"))
    {
      String cname = request.getParameter("cname");
      String amount = request.getParameter("spamount");
      int amount1 = DBServlet.getAmount(cname);
      


      url = "/admin.jsp";
      DBServlet.addAmount(cname,amount, amount1);
    }
    else if (action.equals("main"))
    {
      if (session.getAttribute("theUser") != null)
      {
        url = "/page4.jsp";
      }
      else if (session.getAttribute("theAdmin") != null)
      {
        url = "/admin.jsp";
      }
      else
      {
        url = "/page1.jsp";
      }
      

    }
    else
    {
      url = "/page1.jsp";
    }
    
    request.setAttribute("msg", msg);
    getServletContext()
      .getRequestDispatcher(url)
      .forward(request, response);
  }
  




  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }
}
