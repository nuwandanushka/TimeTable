/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SmartNurse.UserPrivilege;

import BusinessLayer.Shift;
import BusinessLayer.ShiftDependency;
import Database_Layer.Database_Connection;
import SmartNurse.Employee;
import SmartNurse.InValidDay;
import SmartNurse.InValidShift;
import SmartNurse.StaffRequest;
import SmartNurse.Ward;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nuwan_rates
 */
public class AdminUser {

    public void addWard(Ward ward) {

        String sql = "{call Wards_Adding('" + ward.getWardId() + "' , '" + ward.getWardName() + "' )}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {

            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Inserted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void UpdateWard(Ward ward) {

        String sql = "{call UpdatingWard('" + ward.getWardId() + "' , '" + ward.getWardName() + "' )}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void DeleteWard(String id) {

        String sql = "{call Deleteward('" + id + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String isAvilabile(int nurseId) {
        String sql = "{call returnCount('" + nurseId + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        ResultSet result = dbConnection.getData(sql);
        try {
            if (result.next()) {
                String outPut = result.getString("Status");

                return outPut;
            }

        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void addNurse(Employee nurse) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String sql = "{call NurseAdding('" + nurse.getEmployeeId()
                + "' , '" + nurse.getEmpName()
                + "' , '" + nurse.getNic()
                + "' , '" + nurse.getAddress()
                + "' , '" + nurse.getSkillType()
                + "' , '" + df.format(nurse.getDOB())
                + "' , '" + nurse.getHourseOfWorkInMonth()
                + "' , '" + nurse.getWardName()
                + "' , '" + nurse.getGender()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Inserted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updateNurse(Employee nurse) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String sql = "{call UpdatingNurse('" + nurse.getEmployeeId()
                + "' , '" + nurse.getEmpName()
                + "' , '" + nurse.getNic()
                + "' , '" + nurse.getAddress()
                + "' , '" + nurse.getSkillType()
                + "' , '" + df.format(nurse.getDOB())
                + "' , '" + nurse.getHourseOfWorkInMonth()
                + "' , '" + nurse.getWardName()
                + "' , '" + nurse.getGender()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Employee searchNurse(int nurseId) {

        String sql = "{call NurseSearch('" + nurseId + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        ResultSet result = dbConnection.getData(sql);
        try {
            if (result.next()) {
                Employee nurse = new Employee();
                nurse.setEmpName(result.getString("NURSE_NAME"));
                nurse.setNic(result.getString("NIC"));
                nurse.setAddress(result.getString("ADDRESS"));
                nurse.setSkillType(result.getString("SKILL_TYPE"));
                nurse.setDOB(result.getDate("DOB"));
                nurse.setHourseOfWorkInMonth(Integer.parseInt(result.getString("HOURS_OF_WORKED")));
                nurse.setWardName(result.getString("WARD_NAME"));
                nurse.setGender(result.getString("GENDER"));

                return nurse;
            } else {
                JOptionPane.showMessageDialog(null, "Record Not Already Exist");

            }

        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void DeleteNurse(int id) {

        String sql = "{call DeleteNurse('" + id + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addShift(Shift shift) {

        String sql = "{call Shift_Adding('" + shift.getShiftId()
                + "' , '" + shift.getShiftName()
                + "' , '" + shift.getHours()
                + "' , '" + shift.getComment()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Inserted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updateShift(Shift shift) {

        String sql = "{call UpdatingShift('" + shift.getShiftId()
                + "' , '" + shift.getShiftName()
                + "' , '" + shift.getHours()
                + "' , '" + shift.getComment()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Shift searchShift(String shiftName) {

        String sql = "{call ShiftSearch('" + shiftName + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        ResultSet result = dbConnection.getData(sql);
        try {
            if (result.next()) {
                Shift shift = new Shift();
                shift.setShiftId(Integer.parseInt(result.getString("SHIFT_ID")));
                shift.setHours(Integer.parseInt(result.getString("HOURS")));
                shift.setComment(result.getString("COMMENT"));

                return shift;
            } else {
                JOptionPane.showMessageDialog(null, "Record Not Already Exist");

            }

        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void DeleteShift(int id) {

        String sql = "{call DeleteShift('" + id + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addStaffRequest(StaffRequest staffRequest) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String sql = "{call RequestAdding('" + staffRequest.getRequestType()
                + "' , '" + df.format(staffRequest.getRequestDate())
                + "' , '" + staffRequest.getRequestShift()
                + "' , '" + staffRequest.getWardName()
                + "' , '" + staffRequest.getNurseId()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Inserted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updateStaffRequest(StaffRequest staffRequest) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String sql = "{call UpdatingStaffRequest('" + staffRequest.getRequestType()
                + "' , '" + df.format(staffRequest.getRequestDate())
                + "' , '" + staffRequest.getRequestShift()
                + "' , '" + staffRequest.getWardName()
                + "' , '" + staffRequest.getNurseId()
                + "' , '" + staffRequest.getRequestId()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void DeleteStaffRequest(int id) {

        String sql = "{call StaffRequestDelete('" + id + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addDependencyShift(ShiftDependency shiftdependency) {

        String sql = "{call ConsecutiveShiftAdding('" + shiftdependency.getPreviousShift()
                + "' , '" + shiftdependency.getPreviousShiftHours()
                + "' , '" + shiftdependency.getNextShift()
                + "' , '" + shiftdependency.getNextShiftHours()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Inserted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updateDependencyShift(ShiftDependency shiftdependency) {

        String sql = "{call UpdatingConsecutiveShift('" + shiftdependency.getPreviousShift()
                + "' , '" + shiftdependency.getPreviousShiftHours()
                + "' , '" + shiftdependency.getNextShift()
                + "' , '" + shiftdependency.getNextShiftHours()
                + "' , '" + shiftdependency.getShiftDependencyId()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ShiftDependency consecutiveShiftSearch(String prevShift) {

        String sql = "{call ConsecutiveShiftSearch('" + prevShift + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        ResultSet result = dbConnection.getData(sql);
        try {
            if (result.next()) {
                ShiftDependency dependencyShift = new ShiftDependency();
                dependencyShift.setShiftDependencyId(Integer.parseInt(result.getString("CONSECUTIVE_SHIFT_ID")));
                dependencyShift.setPreviousShift(result.getString("PREVIOUS_SHIFT"));
                dependencyShift.setPreviousShiftHours(Integer.parseInt(result.getString("PREVIOUS_SHIFT_HOURS")));
                dependencyShift.setNextShift(result.getString("NEXT_SHIFT"));
                dependencyShift.setNextShiftHours(Integer.parseInt(result.getString("NEXT_SHIFT_HOURS")));

                return dependencyShift;
            } else {
                JOptionPane.showMessageDialog(null, "Record Not Already Exist");

            }

        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void DeleteConsecutiveShift(String prevShift) {

        String sql = "{call DeleteConsecutiveShift('" + prevShift + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addInvalidShift(InValidShift invalidShift) {
        
        String sql = "{call Invalid_Shift_Adding('" + invalidShift.getRelevantShift()
                + "' , '" + invalidShift.getWardName()
                + "' , '" + invalidShift.getNurseId()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Inserted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updateInvalidShift(InValidShift invalidShift) {
        
        String sql = "{call UpdatingInvalidShift('" + invalidShift.getRelevantShift()
                + "' , '" + invalidShift.getWardName()
                + "' , '" + invalidShift.getNurseId()
                + "' , '" + invalidShift.getValidShiftId()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public InValidShift invalidShiftSearch(int nurseId) {

        String sql = "{call InvalidShiftSearch('" + nurseId + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        ResultSet result = dbConnection.getData(sql);
        try {
            if (result.next()) {
                InValidShift invalidShift = new InValidShift();
                invalidShift.setRelevantShift(result.getString("SHIFT_TYPE"));
                invalidShift.setWardName(result.getString("WARD_NAME"));
                invalidShift.setValidShiftId(Integer.parseInt(result.getString("INVALID_SHIFT_ID")));

                return invalidShift;
            } else {
                JOptionPane.showMessageDialog(null, "Record Not Already Exist");

            }

        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void deleteInvalidShift(int invalidShiftId) {

        String sql = "{call DeleteInvalidShift('" + invalidShiftId + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void addInvalidDay(InValidDay invalidDay) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String sql = "{call Invalid_Day_Adding('" + df.format(invalidDay.getInValidDay())
                + "' , '" + invalidDay.getWardName()
                + "' , '" + invalidDay.getNurseId()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Inserted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void updateInvalidDay(InValidDay invalidDay) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String sql = "{call UpdatingInvalidDay('" + df.format(invalidDay.getInValidDay())
                + "' , '" + invalidDay.getWardName()
                + "' , '" + invalidDay.getNurseId()
                + "' , '" + invalidDay.getValidDayId()
                + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Updated");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public InValidDay invalidDaySearch(int nurseId) {

        String sql = "{call InvalidDaySearch('" + nurseId + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        ResultSet result = dbConnection.getData(sql);
        try {
            if (result.next()) {
                InValidDay invalidDay= new InValidDay();
                invalidDay.setInValidDay(result.getDate("INVALID_DATE"));
                invalidDay.setWardName(result.getString("WARD_NAME"));
                invalidDay.setValidDayId(Integer.parseInt(result.getString("INVALID_DAY_ID")));

                return invalidDay;
            } else {
                JOptionPane.showMessageDialog(null, "Record Not Already Exist");

            }

        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void deleteInvalidDay(int invalidDayId) {

        String sql = "{call DeleteInvalidDay('" + invalidDayId + "')}";
        Database_Connection dbConnection = Database_Connection.GetInstance();
        try {
            dbConnection.InsertValues(sql);
            JOptionPane.showMessageDialog(null, "Deleted");
        } catch (Exception ex) {
            Logger.getLogger(AdminUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Database_Connection.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
