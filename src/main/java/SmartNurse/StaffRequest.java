/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SmartNurse;
import BusinessLayer.Shift;
import java.util.Date;
/**
 *
 * @author nuwan_rates
 */
public class StaffRequest{
    
    private int requestId;
    private String requestType;
    private Date requestDate;
    private String requestShift;
    private String wardName;
    private int nurseId;
    
    private Shift shift;

    /**
     * @return the requestId
     */
    public StaffRequest(String reqType, Date reqDate, String reqShift, String wName, int nurId){
        
        this.requestType=reqType;
        this.requestDate=reqDate;
        this.requestShift=reqShift;
        this.wardName=wName;
        this.nurseId=nurId;
        
    }
    
    public StaffRequest(){}

    /**
     * @return the requestType
     */
    public String getRequestType() {
        return requestType;
    }

    /**
     * @param requestType the requestType to set
     */
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    /**
     * @return the requestDate
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate the requestDate to set
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * @return the requestShift
     */
    public String getRequestShift() {
        return requestShift;
    }

    /**
     * @param requestShift the requestShift to set
     */
    public void setRequestShift(String requestShift) {
        this.requestShift = requestShift;
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

    /**
     * @return the requestId
     */
    public int getRequestId() {
        return requestId;
    }

    /**
     * @param requestId the requestId to set
     */
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }
    
}
