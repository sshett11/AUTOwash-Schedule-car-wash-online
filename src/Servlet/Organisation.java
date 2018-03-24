package Servlet;

import java.io.Serializable;

public class Organisation
  implements Serializable
{
  private String Cname;
  private String Car_type;
  private int Time_required;
  private int Amount;
  private String Phone;
  private String Name;
  private String Email;
  private int orgId;
  
  public int getOrgId() {
	return orgId;
}

public void setOrgId(int orgId) {
	this.orgId = orgId;
}

public Organisation()
  {
    Cname = "";
    Car_type = "";
    Time_required = 0;
    Amount = 0;
    Phone = "0";
    Name = "";
    Email = "";
  }
  
  public String getCname()
  {
    return Cname;
  }
  
  public void setCname(String Cname) {
    this.Cname = Cname;
  }
  
  public String getCar_type()
  {
    return Car_type;
  }
  
  public void setCar_type(String Car_type) {
    this.Car_type = Car_type;
  }
  
  public int getTime_required()
  {
    return Time_required;
  }
  
  public void setTime_required(int Time_required) {
    this.Time_required = Time_required;
  }
  
  public int getAmount()
  {
    return Amount;
  }
  
  public void setAmount(int Amount) {
    this.Amount = Amount;
  }
  
  public String getPhone()
  {
    return Phone;
  }
  
  public void setPhone(String Phone) {
    this.Phone = Phone;
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
}
