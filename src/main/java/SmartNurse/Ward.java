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
public class Ward {
    
    private int wardId;
    private String wardName;
    
    private Employee employee;

    public Ward(int id, String name){
        this.wardId=id;
        this.wardName=name;
    }
    /**
     * @return the wardId
     */
    public int getWardId() {
        return wardId;
    }


    /**
     * @return the wardName
     */
    public String getWardName() {
        return wardName;
    }


}
