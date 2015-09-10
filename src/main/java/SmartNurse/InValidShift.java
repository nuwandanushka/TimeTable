/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SmartNurse;
/**
 *
 * @author nuwan_rates
 */
public class InValidShift {
  private int inValidShiftId;
  private String relevantShift;
  private String wardName;
  private int nurseId;
  
public InValidShift(int id, String shift, String ward, int nid){
    this.inValidShiftId=id;
    this.relevantShift=shift;
    this.wardName=ward;
    this.nurseId=nid;
}
public InValidShift(){}
    /**
     * @return the validShiftId
     */
public int getValidShiftId() {
        return inValidShiftId;
}

    /**
     * @param validShiftId the validShiftId to set
     */
public void setValidShiftId(int validShiftId) {
        this.inValidShiftId = validShiftId;
}

    /**
     * @return the relevantShift
     */
public String getRelevantShift() {
        return relevantShift;
}

    /**
     * @param relevantShift the relevantShift to set
     */
public void setRelevantShift(String relevantShift) {
        this.relevantShift = relevantShift;
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
