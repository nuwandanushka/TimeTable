/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BusinessLayer;

import GAModule.Gene;
import RosterManager.RosterManager;
import SmartNurse.StaffRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import util.StaffRequestProperties;

/**
 *
 * @author nuwan_rates
 */
public class RequirmentIndicator {
    
    public static double proceedStaffRequest(StaffRequest request, ArrayList<Shift> Shiftist) {
           SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
           double fitness=0;
           if(StaffRequestProperties.DAY_SHIFT.getProperty().equals(request.getRequestType())){
               if(Shiftist.get(RosterManager.getIndex(myFormat.format(request.getRequestDate()))).getShiftName().equals(request.getRequestShift())){
                   fitness ++;
                   
               }
  
           }
           else if(StaffRequestProperties.EXCEPT_DAY_SHIFT.getProperty().equals(request.getRequestType())){
               
               if(!Shiftist.get(RosterManager.getIndex(myFormat.format(request.getRequestDate()))).getShiftName().equals(request.getRequestShift())){
                   fitness ++;
               }
               
           }
           else if (StaffRequestProperties.EXCEPT_SHIFT.getProperty().equals(request.getRequestType())){
               Shift shift=new Shift();
               shift.setShiftName(request.getRequestShift());
               if(!Shiftist.contains(shift)==true){
                   fitness ++;
               }
               
           }
           else if(StaffRequestProperties.REQUEST_SHIFT.getProperty().equals(request.getRequestType())){
               Shift shift=new Shift();
               shift.setShiftName(request.getRequestShift());
               if(Shiftist.contains(shift)==true){
                   fitness ++;
               }
               
           }
        return fitness;
       
               
  
        
       
    }
    
}
