/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLayer;



/**
 *
 * @author nuwan_rates
 */
public class ShiftDependency{
    
    private int shiftDependencyId;
    private String previousShift;
    private String nextShift;
    private int previousShiftHours;
    private int nextShiftHours;
    /**
     * @return the shiftDependencyId
     */
    public int getShiftDependencyId() {
        return shiftDependencyId;
    }

    /**
     * @param shiftDependencyId the shiftDependencyId to set
     */
    public void setShiftDependencyId(int shiftDependencyId) {
        this.shiftDependencyId = shiftDependencyId;
    }

    /**
     * @return the previousShift
     */
    public String getPreviousShift() {
        return previousShift;
    }

    /**
     * @param previousShift the previousShift to set
     */
    public void setPreviousShift(String previousShift) {
        this.previousShift = previousShift;
    }

    /**
     * @return the nextShift
     */
    public String getNextShift() {
        return nextShift;
    }

    /**
     * @param nextShift the nextShift to set
     */
    public void setNextShift(String nextShift) {
        this.nextShift = nextShift;
    }

    /**
     * @return the previousShiftHours
     */
    public int getPreviousShiftHours() {
        return previousShiftHours;
    }

    /**
     * @param previousShiftHours the previousShiftHours to set
     */
    public void setPreviousShiftHours(int previousShiftHours) {
        this.previousShiftHours = previousShiftHours;
    }

    /**
     * @return the nextShiftHours
     */
    public int getNextShiftHours() {
        return nextShiftHours;
    }

    /**
     * @param nextShiftHours the nextShiftHours to set
     */
    public void setNextShiftHours(int nextShiftHours) {
        this.nextShiftHours = nextShiftHours;
    }
}
