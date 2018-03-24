package Servlet;

import java.sql.Statement;

public class DBUtil
{
  public DBUtil() {}
  
  public static void closeStatement(Statement s) {
    try {
      if (s != null) {
        s.close();
      }
    } catch (java.sql.SQLException e) {
      System.out.println(e);
    }
  }
  
  public static void closePreparedStatement(Statement ps) {
    try {
      if (ps != null) {
        ps.close();
      }
    } catch (java.sql.SQLException e) {
      System.out.println(e);
    }
  }
  
  public static void closeResultSet(java.sql.ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (java.sql.SQLException e) {
      System.out.println(e);
    }
  }
}
