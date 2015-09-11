/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SmartNurse.UserPrivilege;

import UI.MDIForm;
import Database_Layer.Database_Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
/**
 *
 * @author nuwan_rates
 */
public class User {
    private int userId;
    private String Name;
    private String userName;
    private String password;
    private List<Role> roles;;

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Role> getRoles() {
        if (roles == null) {
            roles = new LinkedList<Role>();
        }
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

   public void validation(String username, String password){
    
       String sql="{call GetUser('"+username+"' , '"+password+"' )}";
       Database_Connection db=Database_Connection.GetInstance();
       ResultSet result=db.getData(sql);
       
        try {
           
            if (result.next()){
              JOptionPane.showMessageDialog(null, "Thank you" );
              new MDIForm().setVisible(true);
              setUserName(result.getString("USERNAME"));
              setPassword(result.getString("PASSWORD"));
              MDIForm.ulable.setText(getUserName()+", Smart Nurse");
            }
            else {
              JOptionPane.showMessageDialog(null, "User invalid, please type correct username and password", "Error" + "", JOptionPane.ERROR_MESSAGE);
            }  
        } 
        catch (SQLException ex) 
        {
          Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
               Database_Connection.closeConnection();
            }catch (SQLException ex) {
               Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
       
       
   }
   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;

        return new EqualsBuilder().append(this.userName, user.getUserName()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.userName).toHashCode();
    }

    
}
