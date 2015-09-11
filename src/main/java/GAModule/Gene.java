/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GAModule;

import BusinessLayer.Shift;
import RosterManager.RosterManager;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author nuwan_rates
 */
public class Gene {
  Shift shift;
	
	

	
	/**
	 * @param shift the shift to set
	 */
    public void setShift(Shift shift) {
        this.shift = shift;
    }

	/**
	 * @return the shift
	 */
    public Shift getShift() {
        return shift;
    }
	
    public Shift randomizeShiftGeneration(){
        int i=(int)(RosterManager.shiftlength()* Math.random());
		
        return RosterManager.getShift(i);
    }
     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Shift)) {
            return false;
        }
        Gene gene = (Gene) obj;

        return new EqualsBuilder().append(this.shift, gene.getShift()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.shift).toHashCode();
    }
    
	
}
