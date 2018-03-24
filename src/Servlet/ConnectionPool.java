package Servlet;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Servlet.ConnectionPool;


public class ConnectionPool
{
  private static ConnectionPool pool = null;
  private static DataSource dataSource = null;
  
  private ConnectionPool() {
    try {
      InitialContext ic = new InitialContext();
      dataSource = (DataSource)ic.lookup("java:/comp/env/jdbc/autowash");
    } catch (NamingException e) {
      System.out.println(e);
    }
  }
  
  public static synchronized ConnectionPool getInstance() {
    if (pool == null) {
      pool = new ConnectionPool();
    }
    return pool;
  }
  
  public Connection getConnection()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection("jdbc:mysql://localhost:3306/autowash?autoReconnect=true&user=root&password=uncc");
      /*return DriverManager.getConnection("jdbc:mysql://tiger.ceonkd3lm0ub.us-east-2.rds.amazonaws.com:3306/autowash?autoReconnect=true&user=kashwath&password=tigerlion");*/
    }
      catch (Exception e)
    {
      System.out.println(e); }
    return null;
  }
  
  public void freeConnection(Connection c)
  {
    try {
      c.close();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }
}
