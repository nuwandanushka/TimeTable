/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author nuwan_rates
 */
public enum StaffRequestProperties {
DAY_SHIFT ("Day/Shift"),
EXCEPT_DAY_SHIFT ("Except Day/Shift"),
REQUEST_SHIFT ("Request Shift"),
EXCEPT_SHIFT ("Except Shift"); 

private String property;

    private StaffRequestProperties(String property) {
        this.property = property;
    }

    
    public String getProperty() {
        return property;
    }
}
