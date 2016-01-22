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
        dataSource.setDatabaseName("unicornpheonix");
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
            	pst.setDate(5, p.getDOB());
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
            	pst.setDate(5, p.getDOB());
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
            
            if(p.getPersonID() != 0)
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
                p.setFname(rs.getString("fname"));
                p.setMname(rs.getString("mname"));
                p.setLname(rs.getString("lname"));
                p.setGender(rs.getString("gender"));
                p.setDOB(rs.getDate("DOB"));
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
                p.setFname(rs.getString("fname"));
                p.setMname(rs.getString("mname"));
                p.setLname(rs.getString("lname"));
                p.setGender(rs.getString("gender"));
                p.setDOB(rs.getDate("DOB"));
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
                a.setType(rs.getString("type"));
                
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
                a.setType(rs.getString("type"));
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
            pst = con.prepareStatement("insert into Allergy (Name,PersonID) " +
            "values(?,?);");
            
            if(a.getName() != null)
            {
            	pst.setString(1, a.getName());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(a.getPersonID() != 0)
            {
            	pst.setInt(2, a.getPersonID());
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
            
            if(a.getPersonID() != 0)
            {
            	pst.setInt(2, a.getPersonID());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
                        
            if(a.getAllergyID() != 0)
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
                a.setPersonID(rs.getInt("PersonID"));
                
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
                a.setPersonID(rs.getInt("PersonID"));
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
            pst = con.prepareStatement("insert into Email (Email,Type,PersonID) " +
            "values(?,?,?);");
            
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
                    
            if(e.getPersonID() != 0)
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
    public void updateEmail(Email e)
    {
        try
        {       
            con = dataSource.getConnection();
            con = dataSource.getConnection();
            pst = con.prepareStatement("update email set Email = ?,Type = ?,PersonId = ? " +
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
            
            if(e.getPersonID() != 0)
            {
            	pst.setInt(3, e.getPersonID());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(e.getEmailID() != 0)
            {
            	pst.setInt(4, e.getEmailID());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
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
                e.setPersonID(rs.getInt("PersonID"));
                
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
                e.setPersonID(rs.getInt("PersonID"));
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
    public void addMedicalHistory(MedicalHistory m)
    {
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("insert into MedicalHistory (BloodType,CurrentWeight,CurrentHeight) " +
            "values(?,?,?);");
            
            if(m.getBloodType() != null)
            {
            	pst.setString(1, m.getBloodType());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(m.getCurrentWeight() != 0)
            {
            	pst.setInt(2, m.getCurrentWeight());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(m.getCurrentHeight() != 0)
            {
            	pst.setInt(3, m.getCurrentHeight());
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
    public void updateMedicalHistory(MedicalHistory m)
    {
        try
        {       
            con = dataSource.getConnection();
            con = dataSource.getConnection();
            pst = con.prepareStatement("update MedicalHistory set BloodType = ?,CurrentWeight = ?,CurrentHeight = ? " +
            "where MedicalHistoryID = ?;");
                        
            if(m.getBloodType() != null)
            {
            	pst.setString(1, m.getBloodType());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(m.getCurrentWeight() != 0)
            {
            	pst.setInt(2, m.getCurrentWeight());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(m.getCurrentHeight() != 0)
            {
            	pst.setInt(3, m.getCurrentHeight());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(m.getPersonID() != 0)
            {
            	pst.setInt(4, m.getPersonID());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
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
    public ArrayList<MedicalHistory> getMedicalHistorys()
    {
        ArrayList<MedicalHistory> MedicalHistorys = new ArrayList<MedicalHistory>();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from MedicalHistory;");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                MedicalHistory m = new MedicalHistory();
                
                m.setMedicalHistoryID(rs.getInt("MedicalHistoryID"));
                m.setBloodType(rs.getString("BloodType"));
                m.setCurrentWeight(rs.getInt("CurrentWeight"));
                m.setCurrentHeight(rs.getInt("CurrentHeight"));
                m.setPersonID(rs.getInt("PersonID"));
                
                MedicalHistorys.add(m);
                
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
        
        return MedicalHistorys;
    }
    public MedicalHistory getMedicalHistory(String id)
    {
        MedicalHistory m = new MedicalHistory();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from MedicalHistory where MedicalHistoryID = '" + id + "';");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                m.setMedicalHistoryID(Integer.parseInt(id));
                m.setBloodType(rs.getString("BloodType"));
                m.setCurrentWeight(rs.getInt("CurrentWeight"));
                m.setCurrentHeight(rs.getInt("CurrentHeight"));
                m.setPersonID(Integer.parseInt(id));
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
        
        return m;
    }
    public void deleteMedicalHistory(String id)
    {        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("delete from MedicalHistory where MedicalHistoryID = '" + id + "';");  
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
    public void addPhoneNumber(PhoneNumber p)
    {
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("insert into PhoneNumber (Pnumber,Type) " +
            "values(?,?);");
            
            if(p.getPnumber() != 0)
            {
            	pst.setInt(1, p.getPnumber());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(p.getType() != null)
            {
            	pst.setString(2, p.getType());
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
    public void updatePhoneNumber(PhoneNumber p)
    {
        try
        {       
            con = dataSource.getConnection();
            con = dataSource.getConnection();
            pst = con.prepareStatement("update PhoneNumber set Pnumber = ?,Type = ? " +
            "where PhoneNumberID = ?;");
                        
            if(p.getPnumber() != 0)
            {
            	pst.setInt(1, p.getPnumber());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(p.getType() != null)
            {
            	pst.setString(2, p.getType());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
                        
            if(p.getPersonID() != 0)
            {
            	pst.setInt(3, p.getPersonID());
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
    public ArrayList<PhoneNumber> getPhoneNumbers()
    {
        ArrayList<PhoneNumber> phonenumbers = new ArrayList<PhoneNumber>();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from phonenumber;");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                PhoneNumber p = new PhoneNumber();
                
                p.setPhoneNumberID(rs.getInt("PhoneNumberID"));
                p.setPnumber(rs.getInt("Pnumber"));
                p.setType(rs.getString("Type"));
                p.setPersonID(rs.getInt("PersonID"));
                
                phonenumbers.add(p);
                
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
        
        return phonenumbers;
    }
    public PhoneNumber getPhoneNumber(String id)
    {
        PhoneNumber p = new PhoneNumber();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from phonenumber where PhoneNumberID = '" + id + "';");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                p.setPhoneNumberID(Integer.parseInt(id));
                p.setPnumber(rs.getInt("Pnumber"));
                p.setType(rs.getString("Type"));
                p.setPersonID(Integer.parseInt(id));
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
    public void deletePhoneNumber(String id)
    {        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("delete from phonenumber where PhoneNumberID = '" + id + "';");  
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
    public void addRecentSurgery(RecentSurgery r)
    {
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("insert into RecentSurgery (Name) " +
            "values(?);");
            
            if(r.getName() != null)
            {
            	pst.setString(1, r.getName());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
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
    public void updateRecentSurgery(RecentSurgery r)
    {
        try
        {       
            con = dataSource.getConnection();
            con = dataSource.getConnection();
            pst = con.prepareStatement("update recentsurgery set Name = ? " +
            "where RSID = ?;");
                        
            if(r.getName() != null)
            {
            	pst.setString(1, r.getName());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
                        
            if(r.getPersonID() != 0)
            {
            	pst.setInt(2, r.getPersonID());
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
    public ArrayList<RecentSurgery> getRecentSurgeries()
    {
        ArrayList<RecentSurgery> recentsurgeries = new ArrayList<RecentSurgery>();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from recentsurgery;");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                RecentSurgery r = new RecentSurgery();
                
                r.setRSID(rs.getInt("RSID"));
                r.setName(rs.getString("Name"));
                r.setPersonID(rs.getInt("PersonID"));
                
                recentsurgeries.add(r);
                
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
        
        return recentsurgeries;
    }
    public RecentSurgery getRecentSurgery(String id)
    {
        RecentSurgery r = new RecentSurgery();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from recentsurgery where RSID = '" + id + "';");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                r.setRSID(Integer.parseInt(id));
                r.setName(rs.getString("Name"));
                r.setPersonID(Integer.parseInt(id));
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
        
        return r;
    }
    public void deleteRecentSurgery(String id)
    {        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("delete from recentsurgery where RSID = '" + id + "';");  
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
    public void addVisit(Visit v)
    {
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("insert into Visit (DateOfVisit,Height,BloodPressure,Weight,Result,Type) " +
            "values(?,?,?,?,?,?);");
            
            if(v.getDateOfVisit() != null)
            {
            	pst.setDate(1, v.getDateOfVisit());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(v.getHeight() != 0)
            {
            	pst.setInt(2, v.getHeight());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(v.getBloodPressure() != 0)
            {
            	pst.setInt(3, v.getBloodPressure());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(v.getWeight() != 0)
            {
            	pst.setInt(4, v.getWeight());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
            }
            
            if(v.getResult() != null)
            {
            	pst.setString(5, v.getResult());
            }
            else
            {
            	pst.setNull(5, Types.NULL);
            }
            
            if(v.getType() != null)
            {
            	pst.setString(6, v.getType());
            }
            else
            {
            	pst.setNull(6, Types.NULL);
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
    public void updateVisit(Visit v)
    {
        try
        {       
            con = dataSource.getConnection();
            con = dataSource.getConnection();
            pst = con.prepareStatement("update visit set DateOfVisit = ?,Height = ?,BloodPressure = ?,Weight = ?,Result = ?,Type = ? " +
            "where VisitID = ?;");
                        
            if(v.getDateOfVisit() != null)
            {
            	pst.setDate(1, v.getDateOfVisit());
            }
            else
            {
            	pst.setNull(1, Types.NULL);
            }
            
            if(v.getHeight() != 0)
            {
            	pst.setInt(2, v.getHeight());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(v.getBloodPressure() != 0)
            {
            	pst.setInt(3, v.getBloodPressure());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(v.getWeight() != 0)
            {
            	pst.setInt(4, v.getWeight());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
            }
            
            if(v.getResult() != null)
            {
            	pst.setString(5, v.getResult());
            }
            else
            {
            	pst.setNull(5, Types.NULL);
            }
            
            if(v.getType() != null)
            {
            	pst.setString(6, v.getType());
            }
            else
            {
            	pst.setNull(6, Types.NULL);
            }
            
            if(v.getPersonID() != 0)
            {
            	pst.setInt(7, v.getPersonID());
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
    public ArrayList<Visit> getVisits()
    {
        ArrayList<Visit> visits = new ArrayList<Visit>();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from visit;");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
                Visit v = new Visit();
                
                v.setVisitID(rs.getInt("VisitID"));
                v.setDateOfVisit(rs.getDate("DateOfVisit"));
                v.setHeight(rs.getInt("Height"));
                v.setBloodPressure(rs.getInt("BloodPressure"));
                v.setWeight(rs.getInt("Weight"));
                v.setResult(rs.getString("Result"));
                v.setType(rs.getString("Type"));
                v.setPersonID(rs.getInt("PersonID"));
                
                visits.add(v);
                
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
        
        return visits;
    }
    public Visit getVisit(String id)
    {
        Visit v = new Visit();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from visit where VisitID = '" + id + "';");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
            	v.setVisitID(rs.getInt("VisitID"));
                v.setDateOfVisit(rs.getDate("DateOfVisit"));
                v.setHeight(rs.getInt("Height"));
                v.setBloodPressure(rs.getInt("BloodPressure"));
                v.setWeight(rs.getInt("Weight"));
                v.setResult(rs.getString("Result"));
                v.setType(rs.getString("Type"));
                v.setPersonID(rs.getInt("PersonID"));
                
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
        
        return v;
    }
    public void deleteVisit(String id)
    {        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("delete from visit where VisitID = '" + id + "';");  
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
    public void addBilling(BillingInformation b)
    {
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("insert into BillingInformation (IsInsurance,CreditCardNumber,ExpirationDate,CSV,ProviderId,PlanCode,GroupCode) " +
            "values(?,?,?,?,?,?,?);");
            
            pst.setBoolean(1, b.isInsurance());
            
            if(b.getCreditCardNumber() != null)
            {
            	pst.setString(2, b.getCreditCardNumber());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(b.getExpirationDate() != null)
            {
            	pst.setDate(3, b.getExpirationDate());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(b.getCSV() != null)
            {
            	pst.setString(4, b.getCSV());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
            }
            
            if(b.getProviderID() != 0)
            {
            	pst.setInt(5, b.getProviderID());
            }
            else
            {
            	pst.setNull(5, Types.NULL);
            }
            
            if(b.getPlanCode() != null)
            {
            	pst.setString(6, b.getPlanCode());
            }
            else
            {
            	pst.setNull(6, Types.NULL);
            }
            
            if(b.getGroupCode() != null)
            {
            	pst.setString(7, b.getGroupCode());
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
    public void updateBilling(BillingInformation b)
    {
        try
        {       
            con = dataSource.getConnection();
            con = dataSource.getConnection();
            pst = con.prepareStatement("update billingInformation set IsInsurance = ?,CreditCardNumber = ?,ExpirationDate = ?,CSV = ?,ProviderId = ?,PlanCode = ?,GroupCode = ? " +
            "where BillingID = ?;");
                        
            pst.setBoolean(1, b.isInsurance());
            
            if(b.getCreditCardNumber() != null)
            {
            	pst.setString(2, b.getCreditCardNumber());
            }
            else
            {
            	pst.setNull(2, Types.NULL);
            }
            
            if(b.getExpirationDate() != null)
            {
            	pst.setDate(3, b.getExpirationDate());
            }
            else
            {
            	pst.setNull(3, Types.NULL);
            }
            
            if(b.getCSV() != null)
            {
            	pst.setString(4, b.getCSV());
            }
            else
            {
            	pst.setNull(4, Types.NULL);
            }
            
            if(b.getProviderID() != 0)
            {
            	pst.setInt(5, b.getProviderID());
            }
            else
            {
            	pst.setNull(5, Types.NULL);
            }
            
            if(b.getPlanCode() != null)
            {
            	pst.setString(6, b.getPlanCode());
            }
            else
            {
            	pst.setNull(6, Types.NULL);
            }
            
            if(b.getGroupCode() != null)
            {
            	pst.setString(7, b.getGroupCode());
            }
            else
            {
            	pst.setNull(7, Types.NULL);
            }
            
            if(b.getPersonID() != 0)
            {
            	pst.setInt(8, b.getPersonID());
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
    public ArrayList<BillingInformation> getBillings()
    {
        ArrayList<BillingInformation> billings = new ArrayList<BillingInformation>();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from billingInformation;");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
            	BillingInformation b = new BillingInformation();
                
                b.setBillingID(rs.getInt("BillinbID"));
                b.setIsInsurance(rs.getBoolean("IsInsurance"));
                b.setCreditCardNumber(rs.getString("CreditCardNumber"));
                b.setExpirationDate(rs.getDate("ExpirationDate"));
                b.setCSV(rs.getString("CSV"));
                b.setProviderID(rs.getInt("ProviderId"));
                b.setPlanCode(rs.getString("PlanCode"));
                b.setGroupCode(rs.getString("GroupCode"));
                b.setPersonID(rs.getInt("PersonID"));
                
                billings.add(b);
                
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
        
        return billings;
    }
    public BillingInformation getBilling(String id)
    {
    	BillingInformation b = new BillingInformation();
        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("select * from billingInformation where BillingInformationID = '" + id + "';");
            rs = pst.executeQuery();

            while (rs.next()) 
            {
            	b.setBillingID(rs.getInt("BillingInformationID"));
                b.setIsInsurance(rs.getBoolean("IsInsurance"));
                b.setCreditCardNumber(rs.getString("CreditCardNumber"));
                b.setExpirationDate(rs.getDate("ExpirationDate"));
                b.setCSV(rs.getString("CSV"));
                b.setProviderID(rs.getInt("ProviderId"));
                b.setPlanCode(rs.getString("PlanCode"));
                b.setGroupCode(rs.getString("GroupCode"));
                b.setPersonID(rs.getInt("PersonID"));
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
        
        return b;
    }
    public void deleteBilling(String id)
    {        
        try
        {       
            con = dataSource.getConnection();
            pst = con.prepareStatement("delete from billingInformation where BillingInformationID = '" + id + "';");  
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


