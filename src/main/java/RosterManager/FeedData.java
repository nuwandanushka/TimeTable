/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RosterManager;
import BusinessLayer.Shift;
import Database_Layer.Database_Connection;
import SmartNurse.Employee;
import SmartNurse.StaffRequest;
import SmartNurse.StaffSkillLevels;
import SmartNurse.UserPrivilege.AdminUser;
import SmartNurse.UserPrivilege.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nuwan_rates
 */
public class FeedData {
    
    private Date startDate;
    private Date endDate;
    private String wardName;
    
    public FeedData (Date start, Date end, String ward){
        this.startDate=start;
        this.endDate=end;
        this.wardName=ward;
    }
    
    public void feedNurse(){
      try{ 
          String sql="{call FeedNurse('"+this.wardName+"')}";
          Database_Connection dbConnection=Database_Connection.GetInstance();
          ResultSet result= dbConnection.getData(sql);
          
          while(result.next()){
              Employee nurse=new Employee();
              nurse.setEmployeeId(Integer.parseInt(result.getString("NURSE_ID")));
              nurse.setEmpName(result.getString("NURSE_NAME"));
              nurse.setSkillType(result.getString("SKILL_TYPE"));
              nurse.setHourseOfWorkInMonth(Integer.parseInt(result.getString("HOURS_OF_WORKED")));
              nurse.setWardName(result.getString("WARD_NAME"));              
              
              if(invalidShiftIsAvailable(nurse.getEmployeeId()).contains("TRUE")){
                  nurse.setInvalidShiftList(invalidShift(nurse.getEmployeeId()));
                  if(invalidDayIsAvailable(nurse.getEmployeeId()).contains("TRUE")){
                      nurse.setInvalidDayList(invalidDay(nurse.getEmployeeId()));
                      RosterManager.addNurse(nurse);
                  }
                  else{
                       RosterManager.addNurse(nurse);
                  }
              }
              else{
                  
                  if(invalidDayIsAvailable(nurse.getEmployeeId()).contains("TRUE")){
                      nurse.setInvalidDayList(invalidDay(nurse.getEmployeeId()));
                      RosterManager.addNurse(nurse);
                  }
                  else{
                       RosterManager.addNurse(nurse);
                  }
                  
              }
              
             
          }
      }
      catch (Exception ex) {
           Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           try {
               Database_Connection.closeConnection();
           } catch (SQLException ex) {
               Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
        

    }
    
    public String invalidShiftIsAvailable(int nurseId){
       String sql="{call returnValidShiftCount('"+nurseId+"')}";
       Database_Connection dbConnection=Database_Connection.GetInstance();
       ResultSet result= dbConnection.getData(sql);
       try {
           if(result.next()){
             String outPut=result.getString("Status");
           
             return outPut;  
           }
           
 
       } 
       catch (Exception ex) {
           Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           try {
               Database_Connection.closeConnection();
           } catch (SQLException ex) {
               Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        return null;
    }
    
    public String invalidDayIsAvailable(int nurseId){
       String sql="{call returnDayCount('"+nurseId+"')}";
       Database_Connection dbConnection=Database_Connection.GetInstance();
       ResultSet result= dbConnection.getData(sql);
       try {
           if(result.next()){
             String outPut=result.getString("Status");
           
             return outPut;  
           }
           
 
       } 
       catch (Exception ex) {
           Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
       }finally{
           try {
               Database_Connection.closeConnection();
           } catch (SQLException ex) {
               Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        return null;
    }

    public ArrayList<String> invalidShift(int nurseId){
        try{
          ArrayList<String> invalidShift=new ArrayList<String>();   
          String sql="{call InvalidShiftFeed('"+nurseId+"')}";
          Database_Connection dbConnection=Database_Connection.GetInstance();
          ResultSet result= dbConnection.getData(sql);
          
          while(result.next()){
              

              invalidShift.add(result.getString("SHIFT_TYPE"));
              
              
          }
          return invalidShift;
                  
        }
        catch (Exception ex){
                Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                Database_Connection.closeConnection();
            }   catch (SQLException ex){
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return null;
    }
    
    public ArrayList<String> invalidDay(int nurseId){
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        try{
            ArrayList<String> invalidDay=new ArrayList<String>();   
            String sql="{call InvalidDayFeed('"+nurseId+"')}";
            Database_Connection dbConnection=Database_Connection.GetInstance();
            ResultSet result= dbConnection.getData(sql);
          
            while(result.next()){
              

              invalidDay.add(df.format(result.getDate("INVALID_DATE")));
              
              
            }
            return invalidDay;
              
            
                  
        }
        catch (Exception ex){
                Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                Database_Connection.closeConnection();
            }   catch (SQLException ex){
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        return null;
    }
    
    public void feedShift(){
        try{
              
            String sql="{call ShiftSearch}";
            Database_Connection dbConnection=Database_Connection.GetInstance();
            ResultSet result= dbConnection.getData(sql);
          
            while(result.next()){
              
                Shift shift=new Shift();
                shift.setShiftId(Integer.parseInt(result.getString("SHIFT_ID")));
                shift.setShiftName(result.getString("SHIFT_NAME"));
                shift.setHours(Integer.parseInt(result.getString("HOURS")));
   
                RosterManager.addShiftStructure(shift);

              
              
              
            }
            
              
            
                  
        }
        catch (Exception ex){
                Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                Database_Connection.closeConnection();
            }   catch (SQLException ex){
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    public void feedShiftDependecy(){
        try{
              
            String sql="{call ShiftDependency}";
            Database_Connection dbConnection=Database_Connection.GetInstance();
            ResultSet result= dbConnection.getData(sql);
          
            while(result.next()){
              
                Shift prevShift=new Shift();
                Shift nextShift=new Shift();
                prevShift.setShiftName(result.getString("PREVIOUS_SHIFT"));
                prevShift.setHours(Integer.parseInt(result.getString("PREVIOUS_SHIFT_HOURS")));
                
                nextShift.setShiftName(result.getString("NEXT_SHIFT"));
                nextShift.setHours(Integer.parseInt(result.getString("NEXT_SHIFT_HOURS")));
                prevShift.setShiftId(Integer.parseInt(result.getString("SHIFT_ID")));
                
                RosterManager.addShiftDepend(prevShift,nextShift);

              
              
              
            }
            
              
            
                  
        }
        catch (Exception ex){
                Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                Database_Connection.closeConnection();
            }   catch (SQLException ex){
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    public void feedStaffLevels(){
      try{
              
            String sql="{call StaffLevelSearch('"+wardName+"')}";
            Database_Connection dbConnection=Database_Connection.GetInstance();
            ResultSet result= dbConnection.getData(sql);
          
            while(result.next()){
              
                StaffSkillLevels staffLevel=new StaffSkillLevels();
                staffLevel.setShift(result.getString("SHIFT_NAME"));
                staffLevel.setMaxNumberOfEmployee(Integer.parseInt(result.getString("MAX_NO_EMPLOYEES")));
                staffLevel.setMinTrainnedStaff(Integer.parseInt(result.getString("MIN_TRAINNED_STAFF")));
                staffLevel.setMinUntrainnedStaff(Integer.parseInt(result.getString("MIN_UNTRAINNED_STAFF")));
                staffLevel.setSiteNurseCount(Integer.parseInt(result.getString("SITE_NURSE_COUNT")));
                RosterManager.addSkillLevels(staffLevel);

            }

        }
        catch (Exception ex){
                Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                Database_Connection.closeConnection();
            }   catch (SQLException ex){
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
          
    }
    
    public void feedStaffRequest(){
        try{
              
            String sql="{call RequestSearch('"+wardName+"')}";
            Database_Connection dbConnection=Database_Connection.GetInstance();
            ResultSet result= dbConnection.getData(sql);
          
            while(result.next()){
              
                StaffRequest staffRequest=new StaffRequest();
                staffRequest.setRequestType(result.getString("REQUEST_TYPE"));
                staffRequest.setRequestDate(result.getDate("REQUEST_DATE"));
                staffRequest.setRequestShift(result.getString("REQUEST_SHIFT"));
                staffRequest.setWardName(result.getString("WARD_NAME"));
                staffRequest.setNurseId(Integer.parseInt(result.getString("NURSE_ID")));
                RosterManager.addStaffRequests(staffRequest);

            }
   
        }
        catch (Exception ex){
                Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                Database_Connection.closeConnection();
            }   catch (SQLException ex){
                    Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        
    }
    
    
}
