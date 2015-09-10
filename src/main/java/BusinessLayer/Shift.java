/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLayer;
import java.lang.String;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
/**
 *
 * @author nuwan_rates
 */
public class Shift {
    
    private int shiftId;
    private String shiftName;
    private int hours;
    private String comment;
    
    public Shift(int id, String shiftName, int hrs, String comment){
        
        this.shiftId=id;
        this.shiftName=shiftName;
        this.hours=hrs;
        this.comment=comment;
    }
    public Shift(){}
    
    public Shift(String name, int hrs){
        this.shiftName=name;
        this.hours=hrs;
    }
    /**
     * @return the shiftId
     */
    public int getShiftId() {
        return shiftId;
    }

    /**
     * @return the shiftName
     */
    public String getShiftName() {
        return shiftName;
    }

    /**
     * @return the startTime
     */
    public int getHours() {
        return hours;
    }

    /**
     * @return the endTime
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param shiftId the shiftId to set
     */
    public void setShiftId(int shiftId) {
        this.shiftId = shiftId;
    }

    /**
     * @param shiftName the shiftName to set
     */
    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(int hours) {
        this.hours = hours;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Shift)) {
            return false;
        }
        Shift shift = (Shift) obj;

        return new EqualsBuilder().append(this.shiftName, shift.getShiftName()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.shiftName).toHashCode();
    }
    
    
    
}
