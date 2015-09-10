/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SmartNurse;

import BusinessLayer.Shift;

/**
 *
 * @author nuwan_rates
 */
public class StaffSkillLevels {
    private int skillLevelId;
    private String shift;
    private int maxNumberOfEmployee;
    private int minTrainnedStaff;
    private int minUntrainnedStaff;
    private int siteNurseCount;
    private String wardName;
    private int wardId;
    
    private Shift shifttype;
    
    
    
    
    
    public StaffSkillLevels(int id, String shiftName, int maxEmp, int minTrain, int minUnTrain,int sitNurse, String wardName){
        
        this.skillLevelId=id;
        this.shift=shiftName;
        this.maxNumberOfEmployee=maxEmp;
        this.minTrainnedStaff=minTrain;
        this.minUntrainnedStaff=minUnTrain;
        this.siteNurseCount=sitNurse;
        this.wardName=wardName;
                
    }
    
    public StaffSkillLevels(){
        
    }
    /**
     * @return the skillLevelId
     */
    public int getSkillLevelId() {
        return skillLevelId;
    }

    /**
     * @param skillLevelId the skillLevelId to set
     */
    public void setSkillLevelId(int skillLevelId) {
        this.skillLevelId = skillLevelId;
    }

    
    /**
     * @return the shift
     */
    public String getShift() {
        return shift;
    }

    /**
     * @param shift the shift to set
     */
    public void setShift(String shift) {
        this.shift = shift;
    }


    /**
     * @return the minNumberOfEmployee
     */
    public int getMaxNumberOfEmployee() {
        return maxNumberOfEmployee;
    }

    /**
     * @param minNumberOfEmployee the minNumberOfEmployee to set
     */
    public void setMaxNumberOfEmployee(int minNumberOfEmployee) {
        this.maxNumberOfEmployee = minNumberOfEmployee;
    }

    /**
     * @return the siteNurseCount
     */
    public int getSiteNurseCount() {
        return siteNurseCount;
    }

    /**
     * @param siteNurseCount the siteNurseCount to set
     */
    public void setSiteNurseCount(int siteNurseCount) {
        this.siteNurseCount = siteNurseCount;
    }

    /**
     * @return the wardName
     */
    public String getWardName() {
        return wardName;
    }

    /**
     * @param wardName the wardName to set
     */
    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

    /**
     * @return the wardId
     */
    public int getWardId() {
        return wardId;
    }

    /**
     * @param wardId the wardId to set
     */
    public void setWardId(int wardId) {
        this.wardId = wardId;
    }

    /**
     * @return the minTrainnedStaff
     */
    public int getMinTrainnedStaff() {
        return minTrainnedStaff;
    }

    /**
     * @param minTrainnedStaff the minTrainnedStaff to set
     */
    public void setMinTrainnedStaff(int minTrainnedStaff) {
        this.minTrainnedStaff = minTrainnedStaff;
    }

    /**
     * @return the minUntrainnedStaff
     */
    public int getMinUntrainnedStaff() {
        return minUntrainnedStaff;
    }

    /**
     * @param minUntrainnedStaff the minUntrainnedStaff to set
     */
    public void setMinUntrainnedStaff(int minUntrainnedStaff) {
        this.minUntrainnedStaff = minUntrainnedStaff;
    }

    
}   
