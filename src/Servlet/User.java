package Servlet;

import java.io.Serializable;

public class User
  implements Serializable
{
  private String Name;
  private String Email;
  private String Type;
  
  public User()
  {
    Name = "";
    Email = "";
    Type = "";
  }
  
  public String getName()
  {
    return Name;
  }
  
  public void setName(String Name) {
    this.Name = Name;
  }
  
  public String getEmail()
  {
    return Email;
  }
  
  public void setEmail(String Email) {
    this.Email = Email;
  }
  
  public String getType()
  {
    return Type;
  }
  
  public void setType(String Type) {
    this.Type = Type;
  }
}
