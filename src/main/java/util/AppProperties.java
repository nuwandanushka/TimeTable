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
public enum AppProperties {
    UNTRAINED_NURSE("UN-TRAINED_NURSE"),
    TRAINED_NURSE("TRAINED_NURSE"),
    SITE_NURSE("SITE_NURSE");
    
    
    private String property;

    private AppProperties(String property) {
        this.property = property;
    }

    
    public String getProperty() {
        return property;
    }
    
}
