package UnicornPhoenix.Database;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class UnicornPhoenixDB
{
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    MysqlDataSource dataSource = null; 
  
    public UnicornPhoenixDB()
    {
        dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("UnicornPhoenix");
    }
    public void addPerson(Person p)
    {
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("insert into Person (Fname,Mname,Lname,Gender,DOB,SSN,Type) " +
            "values(?,?,?,?,?,?,?);");
            
            if(p.getFname() != null)
            {
            	pst.setString(1, p.getFname());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(p.getMname() != null)
            {
            	pst.setString(2, p.getMname());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(p.getLname() != null)
            {
            	pst.setString(3, p.getLname());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(p.getGender() != null)
            {
            	pst.setString(4, p.getGender());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
            }
            
            if(p.getDOB() != null)
            {
            	pst.setString(5, p.getDOB());
            }
            else
            {
            	pst.setNull(5, Types.NULL);
            }
            
            if(p.getSSN() != null)
            {
            	pst.setString(6, p.getSSN());
            }
            else
            {
            	pst.setNull(6, Types.NULL);
            }
            
            if(p.getType() != null)
            {
            	pst.setString(7, p.getType());
            }
            else
            {
            	pst.setNull(7, Types.NULL);
            }
                        
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }        
    }
    public void updatePerson(Person p)
    {
        try
        {       
            con = dataSource.getConnection();
            con = dataSource.getConnection();
            pst = con.prepareStatement("update person set Fname = ?,Mname = ?,Lname = ?,Gender = ?,DOB = ?,SSN = ?,Type = ? " +
            "where PersonID = ?;");
                        
            if(p.getFname() != null)
            {
            	pst.setString(1, p.getFname());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(p.getMname() != null)
            {
            	pst.setString(2, p.getMname());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(p.getLname() != null)
            {
            	pst.setString(3, p.getLname());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(p.getGender() != null)
            {
            	pst.setString(4, p.getGender());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
            }
            
            if(p.getDOB() != null)
            {
            	pst.setString(5, p.getDOB());
            }
            else
            {
            	pst.setNull(5, Types.NULL);
            }
            
            if(p.getSSN() != null)
            {
            	pst.setString(6, p.getSSN());
            }
            else
            {
            	pst.setNull(6, Types.NULL);
            }
            
            if(p.getType() != null)
            {
            	pst.setString(7, p.getType());
            }
            else
            {
            	pst.setNull(7, Types.NULL);
            }
            
            if(p.getPersonID() != null)
            {
            	pst.setInt(8, p.getPersonID());
            }
            else
            {
            	pst.setNull(8, Types.NULL);
            }
            
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }        
    }
    public ArrayList<Person> getPeople()
    {
        ArrayList<Person> people = new ArrayList<Person>();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from person;");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                Person p = new Person();
                
                p.setPersonID(rs.getInt("PersonID"));
                p.setFname(rs.getString("firstname"));
                p.setMname(rs.getString("middlename"));
                p.setLname(rs.getString("lastname"));
                p.setGender(rs.getString("gender"));
                p.setDOB(rs.getLong("DOB"));
                p.setSSN(rs.getString("SSN"));
                p.setType(rs.getString("type"));
                
                people.add(p);
                
            }

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return people;
    }
    public Person getPerson(String id)
    {
        Person p = new Person();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from person where PersonID = '" + id + "';");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                p.setPersonID(Integer.parseInt(id));
                p.setFname(rs.getString("firstname"));
                p.setMname(rs.getString("middlename"));
                p.setLname(rs.getString("lastname"));
                p.setGender(rs.getString("gender"));
                p.setDOB(rs.getLong("DOB"));
                p.setSSN(rs.getString("SSN"));
                p.setType(rs.getString("type"));
            }

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return p;
    }
    public void deletePerson(String id)
    {        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("delete from person where personID = '" + id + "';");  
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
    }
    public Boolean isValidLogin(String username,String password)
    {
        Boolean valid = false;
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select count(*) as count from users where username = '" + username + "' and password = PASSWORD('" + password + "');");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                //If we found a valid login
                if(rs.getInt("count") == 1)
                {
                    valid = true;
                }
            }         
            
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return valid;
    }
    public void addAddress(Address a)
    {
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("insert into Address (Address,City,State,Zip,Type) " +
            "values(?,?,?,?,?);");
            
            if(a.getAddress() != null)
            {
            	pst.setString(1, a.getAddress());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(a.getCity() != null)
            {
            	pst.setString(2, a.getCity());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(a.getState() != null)
            {
            	pst.setString(3, a.getState());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(a.getZip() != null)
            {
            	pst.setString(4, a.getZip());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
            }
            
            if(a.getType() != null)
            {
            	pst.setString(5, a.getType());
            }
            else
            {
            	pst.setNull(5, Types.NULL);
            }
                        
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }        
    }
    public void updateAddress(Address a)
    {
        try
        {       
            con = dataSource.getConnection();
            con = dataSource.getConnection();
            pst = con.prepareStatement("update address set Address = ?,City = ?,State = ?,Zip = ?,Type = ? " +
            "where AddressID = ?;");
                        
            if(a.getAddress() != null)
            {
            	pst.setString(1, a.getAddress());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(a.getCity() != null)
            {
            	pst.setString(2, a.getCity());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(a.getState() != null)
            {
            	pst.setString(3, a.getState());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(a.getZip() != null)
            {
            	pst.setString(4, a.getZip());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
            }
            
            if(a.getType() != null)
            {
            	pst.setString(5, a.getType());
            }
            else
            {
            	pst.setNull(5, Types.NULL);
            }
            
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }        
    }
    public ArrayList<Address> getAddresses()
    {
        ArrayList<Address> addresses = new ArrayList<Address>();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from address;");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                Address a = new Address();
                
                a.setAddressID(rs.getInt("AddressID"));
                a.setAddress(rs.getString("address"));
                a.setCity(rs.getString("city"));
                a.setState(rs.getString("state"));
                a.setZip(rs.getString("zip"));
                a.setType(rs.getDate("type"));
                
                addresses.add(a);
                
            }

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return addresses;
    }
    public Address getAddress(String id)
    {
        Address a = new Address();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from address where AddressID = '" + id + "';");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                a.setAddressID(Integer.parseInt(id));
                a.setAddress(rs.getString("address"));
                a.setCity(rs.getString("city"));
                a.setState(rs.getString("state"));
                a.setZip(rs.getString("zip"));
                a.setType(rs.getDate("type"));
            }

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return a;
    }
    public void deleteAddress(String id)
    {        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("delete from address where AddressID = '" + id + "';");  
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
    }
    public void addAllergy(Allergy a)
    {
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("insert into Person (Name,PersonID) " +
            "values(?,?);");
            
            if(a.getName() != null)
            {
            	pst.setString(1, a.getName());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(a.getPersonID() != null)
            {
            	pst.setString(2, a.getPersonID());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }        
    }
    public void updateAllergy(Allergy a)
    {
        try
        {       
            con = dataSource.getConnection();
            con = dataSource.getConnection();
            pst = con.prepareStatement("update allergy set Name = ?,PersonID = ? " +
            "where AllergyID = ?;");
                        
            if(a.getName() != null)
            {
            	pst.setString(1, a.getName());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(a.getPersonID() != null)
            {
            	pst.setString(2, a.getPersonID());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
                        
            if(a.getAllergyID() != null)
            {
            	pst.setInt(3, a.getAllergyID());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }        
    }
    public ArrayList<Allergy> getAllergies()
    {
        ArrayList<Allergy> Allergies = new ArrayList<Allergy>();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from allergy;");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                Allergy a = new Allergy();
                
                a.setAllergyID(rs.getInt("AllergyID"));
                a.setName(rs.getString("name"));
                a.setPersonID(rs.getString("PersonID"));
                
                Allergies.add(a);
                
            }

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return Allergies;
    }
    public Allergy getAllergy(String id)
    {
        Allergy a = new Allergy();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from allergy where AllergyID = '" + id + "';");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                a.setAllergyID(Integer.parseInt(id));
                a.setName(rs.getString("name"));
                a.setPersonID(rs.getString("PersonID"));
            }

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return a;
    }
    public void deleteAllergy(String id)
    {        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("delete from allergy where AllergyID = '" + id + "';");  
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
    }
    public void addEmail(Email e)
    {
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("insert into Email (Email,Type) " +
            "values(?,?);");
            
            if(e.getEmail() != null)
            {
            	pst.setString(1, e.getEmail());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(e.getType() != null)
            {
            	pst.setString(2, e.getType());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
                        
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }        
    }
    public void updateEmail(Email e)
    {
        try
        {       
            con = dataSource.getConnection();
            con = dataSource.getConnection();
            pst = con.prepareStatement("update email set Email = ?,Type = ? " +
            "where EmailID = ?;");
                        
            if(e.getEmail() != null)
            {
            	pst.setString(1, e.getEmail());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(e.getType() != null)
            {
            	pst.setString(2, e.getType());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            
            if(e.getPersonID() != null)
            {
            	pst.setInt(3, e.getPersonID());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }        
    }
    public ArrayList<Email> getEmails()
    {
        ArrayList<Email> emails = new ArrayList<Email>();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from email;");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                Email e = new Email();
                
                e.setEmailID(rs.getInt("EmailID"));
                e.setEmail(rs.getString("email"));
                e.setType(rs.getString("Type"));
                e.setPersonID(rs.getString("PersonID"));
                
                emails.add(e);
                
            }

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return emails;
    }
    public Email getEmail(String id)
    {
        Email e = new Email();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from email where EmailID = '" + id + "';");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                e.setEmailID(Integer.parseInt(id));
                e.setEmail(rs.getString("email"));
                e.setType(rs.getString("type"));
                e.setPersonID(rs.getString("PersonID"));
            }

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
        return e;
    }
    public void deleteEmail(String id)
    {        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("delete from email where emailID = '" + id + "';");  
            pst.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        finally 
        {

            try
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (pst != null) 
                {
                    pst.close();
                }
                if (con != null) 
                {
                    con.close();
                }

            } 
            catch (SQLException ex) 
            {
                
            }
        }
        
    }
    
}


