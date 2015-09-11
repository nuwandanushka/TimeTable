package TestPackages;


import BusinessLayer.Shift;
import SmartNurse.Employee;
import SmartNurse.InValidShift;
import SmartNurse.StaffRequest;
import SmartNurse.UserPrivilege.AdminUser;
import SmartNurse.Ward;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.Test;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nuwan_rates
 */
public class AddModulesTest {
   
    @Test
    public void NurseAdd() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
    
        Employee nurse=new Employee(120, "NuwanTharaka", "211/9 Puwakwatta road", "911480263V", df.parse("2015/05/12"),"Trainning", 180, "OPD", "MALE");
        AdminUser admin=new AdminUser();
        admin.addNurse(nurse);
    }
    @Test
    public void ShiftAdd() throws ParseException {
      
    
        Shift shift =new Shift(1, "Test", 6, "");
        AdminUser admin=new AdminUser();
        admin.addShift(shift);
    }
    
    @Test
    public void staffRequestAdd() throws ParseException {
      
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        StaffRequest request =new StaffRequest("Day/Shift", df.parse("2015/05/12"), "Night", "OPD", 2);
        AdminUser admin=new AdminUser();
        admin.addStaffRequest(request);
    } 
    
   
    
}
