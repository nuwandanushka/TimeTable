/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SmartNurse;
import java.util.Date;
/**
 *
 * @author nuwan_rates
 */
public class InValidDay {
   private int inValidDayId;
   private Date inValidDay;
   private String wardName;
   private int nurseId;
    /**
     * @return the validDayId
     */
    public int getValidDayId() {
        return inValidDayId;
    }

    /**
     * @param validDayId the validDayId to set
     */
    public void setValidDayId(int validDayId) {
        this.inValidDayId = validDayId;
    }

    /**
     * @return the inValidDay
     */
    public Date getInValidDay() {
        return inValidDay;
    }

    /**
     * @param inValidDay the inValidDay to set
     */
    public void setInValidDay(Date inValidDay) {
        this.inValidDay = inValidDay;
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
     * @return the nurseId
     */
    public int getNurseId() {
        return nurseId;
    }

    /**
     * @param nurseId the nurseId to set
     */
    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    
 }
