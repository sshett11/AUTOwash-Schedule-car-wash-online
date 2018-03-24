package Servlet;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.mail.MessagingException;



public class DBServlet
{
  public DBServlet() {}
  
  public static User getUser(String email)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String type = null;
    String query = "SELECT * FROM user WHERE Email = ?";
    
    try
    { 
      ps = connection.prepareStatement(query);
      ps.setString(1, email);
      rs = ps.executeQuery();
      User user = null;
      if (rs.next())
      {
        user = new User();
        user.setName(rs.getString("Name"));
        user.setEmail(rs.getString("Email"));
        user.setType(rs.getString("Type"));
      }
      return user;
    } catch (SQLException e) { User localUser1;
      System.out.println(e);
      return null;
    } finally {
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }
  

  public static boolean emailExists(String email)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    String query = "SELECT Email FROM user WHERE Email = ?";
    try
    {
      ps = connection.prepareStatement(query);
      ps.setString(1, email);
      rs = ps.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      System.out.println(e);
      return false;
    } finally {
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }
  

  public static boolean passMatch(String encryptedPass, String email)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    String query = "SELECT * FROM user WHERE Password = ? And Email= ?";
    try
    {
      ps = connection.prepareStatement(query);
      ps.setString(1, encryptedPass);
      ps.setString(2, email);
      rs = ps.executeQuery();
      return rs.next();
    } catch (SQLException e) {
      System.out.println(e);
      return false;
    } finally {
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }
  

  public static String getType(String email)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    String type = null;
    String query = "SELECT Type FROM user WHERE Email = ?";
    try
    {
      ps = connection.prepareStatement(query);
      ps.setString(1, email);
      rs = ps.executeQuery();
      if (rs.next())
        type = rs.getString("Type");
      return type;
    } catch (SQLException e) {
      System.out.println(e);
      return null;
    } finally {
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }
  

  public static String insertUser(String email, String encryptedPass, String name)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    int rs = 0;
    String query = "INSERT into user(Email,Password,Type,Name)  values(?, ?,?,?) ";
    
    try
    {
      ps = connection.prepareStatement(query);
      ps.setString(1, email);
      ps.setString(2, encryptedPass);
      ps.setString(3, "P");
      ps.setString(4, name);
      
      rs = ps.executeUpdate();
      
      return "User updated";
    } catch (SQLException e) {
      System.out.println(e);
      return "User not updated";
    }
    finally {
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }
  


  public static ArrayList<Organisation> getCar_type(String car_type)
  {
    ArrayList organisationList = new ArrayList();
    
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    String query = "SELECT * FROM org WHERE car_type = ? and amount > ?";
    try
    {
      ps = connection.prepareStatement(query);
      ps.setString(1, car_type);
      ps.setInt(2, 0);
      rs = ps.executeQuery();
      Organisation organisation = null;
      while (rs.next()) {
        organisation = new Organisation();
        
        organisation.setCname(rs.getString("cname"));
        organisation.setCar_type(rs.getString("car_type"));
        organisation.setTime_required(rs.getInt("time_required"));
        organisation.setAmount(rs.getInt("amount"));
        organisationList.add(organisation);
      }
      return organisationList;
    } catch (SQLException e) {
      System.out.println(e); }
    return null;
  }
  





  public static ArrayList<Organisation> getListAmount(int min, int max)
  {
    ArrayList organisationList = new ArrayList();
    
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    String query = "SELECT * FROM org WHERE amount > ? and amount < ?";
    try
    {
      ps = connection.prepareStatement(query);
      ps.setInt(1, min);
      ps.setInt(2, max);
      rs = ps.executeQuery();
      Organisation organisation = null;
      while (rs.next()) {
        organisation = new Organisation();
        
        organisation.setCname(rs.getString("cname"));
        organisation.setCar_type(rs.getString("car_type"));
        organisation.setTime_required(rs.getInt("time_required"));
        organisation.setAmount(rs.getInt("amount"));
        organisationList.add(organisation);
      }
      return organisationList;
    } catch (SQLException e) {
      System.out.println(e); }
    return null;
  }
  




  public static ArrayList<Organisation> getListCount(int min, int max)
  {
    ArrayList organisationList = new ArrayList();
    
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    String query = "SELECT * FROM org WHERE time_required > ? and time_required < ? and amount > ? ";
    try
    {
      ps = connection.prepareStatement(query);
      ps.setInt(1, min);
      ps.setInt(2, max);
      ps.setInt(3, 0);
      rs = ps.executeQuery();
      Organisation organisation = null;
      while (rs.next()) {
        organisation = new Organisation();
        
        organisation.setCname(rs.getString("cname"));
        organisation.setCar_type(rs.getString("car_type"));
        organisation.setTime_required(rs.getInt("time_required"));
        organisation.setAmount(rs.getInt("amount"));
        organisationList.add(organisation);
      }
      return organisationList;
    } catch (SQLException e) {
      System.out.println(e); }
    return null;
  }
  





  public static ArrayList<Organisation> getList()
  {
    ArrayList organisationList = new ArrayList();
    
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    String query = "SELECT * FROM org WHERE amount > ?";
    try
    {
      ps = connection.prepareStatement(query);
      ps.setInt(1, 0);
      rs = ps.executeQuery();
      Organisation organisation = null;
      while (rs.next()) {
        organisation = new Organisation();
        organisation.setCname(rs.getString("cname"));
        organisation.setCar_type(rs.getString("car_type"));
        organisation.setTime_required(rs.getInt("time_required"));
        organisation.setAmount(rs.getInt("amount"));
        organisationList.add(organisation);
      }
      return organisationList;
    } catch (SQLException e) {
      System.out.println(e); }
    return null;
  }
  






  public static ArrayList<Organisation> getCustomers()
  {
    ArrayList organisationList = new ArrayList();
    
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    String query = "SELECT * FROM customer WHERE status = ?";
    try
    {
      ps = connection.prepareStatement(query);
      ps.setString(1, "n");
      
      rs = ps.executeQuery();
      Organisation organisation = null;
      while (rs.next()) {
        organisation = new Organisation();
        
        organisation.setCname(rs.getString("cname"));
        organisation.setName(rs.getString("Name"));
        organisation.setEmail(rs.getString("Email"));
        
        organisation.setPhone(rs.getString("phone"));
        organisationList.add(organisation);
      }
      return organisationList;
    } catch (SQLException e) {
      System.out.println(e); }
    return null;
  }
  




  public static String SendEmail(String email, String name)
  {
    String to = email;
    String from = "surajcool999@gmail.com";
    String subject = "NC AUTOwash - Thank You";
    String body = "Dear " + name + "\n \n Thanks for showing your interest . We have your information. Our team will get back to you regarding payment";
    






    boolean isBodyHTML = false;
    try {
      MailUtilLocal.sendMail(to, from, subject, body, isBodyHTML);
      return "success";


    }
    catch (MessagingException e)
    {


      return "ERROR: Unable to send email. Check Tomcat logs for details.<br>NOTE: You may need to configure your system as described in chapter 14.<br>ERROR MESSAGE: " + e.getMessage();
    }
  }
  



  public static String insertCustomer(String email, String name, String phone, String cname)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    int rs = 0;
    
    String query = "INSERT into customer(email,name,phone,cname,status)  values(?, ?,?,?,?) ";
    try
    {
      ps = connection.prepareStatement(query);
      ps.setString(1, email);
      ps.setString(2, name);
      ps.setString(3, phone);
      ps.setString(4, cname);
      ps.setString(5, "n");
      rs = ps.executeUpdate();
      return "Customer updated";

    }
    catch (SQLException e)
    {
      System.out.println(e);
      return "Error while updating";
    }
    finally
    {
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }
  


  public static String addAmount(String cname, String amount, int amount1)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps2 = null;
    int rs2 = 0;
    String query2 = "update customer set status=? where cname=? ";
    try {
      ps2 = connection.prepareStatement(query2);
      ps2.setString(1, "r");
      ps2.setString(2, cname);
      rs2 = ps2.executeUpdate();
      return " updated";

    }
    catch (SQLException e)
    {
      System.out.println(e);
      return "Error while updating";
    }
    finally
    {
      DBUtil.closePreparedStatement(ps2);
      pool.freeConnection(connection);
    }
  }
  

  public static int getAmount(String cname)
  {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    int result = 0;
    
    String query = "SELECT * FROM org WHERE cname = ?";
    try
    {
      ps = connection.prepareStatement(query);
      ps.setString(1, cname);
      
      rs = ps.executeQuery();
      if (rs.next())
      {
        result = rs.getInt("amount");
      }
      return result;
    }
    catch (SQLException e)
    {
      System.out.println(e);
      return 0;
    }
    finally {
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }
}

