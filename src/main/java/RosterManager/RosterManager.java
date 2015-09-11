/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RosterManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import SmartNurse.Employee;
import BusinessLayer.Shift;
import SmartNurse.StaffSkillLevels;
import SmartNurse.StaffRequest;
import BusinessLayer.ShiftDependency;
 

public class RosterManager {

    private static ArrayList<Employee> nurseList=new ArrayList<Employee>();
    private static ArrayList<Shift> shiftStructure=new ArrayList<Shift>();
    private static ArrayList<StaffSkillLevels> staffLevels=new ArrayList<StaffSkillLevels>();
    private static HashMap<Shift,Shift> shiftDepend=new HashMap<Shift,Shift>();
    private static ArrayList<StaffRequest> staffRequest=new ArrayList<StaffRequest>();
    private static String startDate;
    private static String endDate;
    private static ArrayList<String> dayList=new ArrayList<String>() ;
	
    public static void addNurse(Employee nurse){
	nurseList.add(nurse);
    }
    public static int sizeNurse(){
	return nurseList.size();
    }
    public static void addStaffRequests(StaffRequest requests){
	staffRequest.add(requests);
    }
    public static ArrayList<StaffRequest> getStaffRequests(){
	return staffRequest;
    }
    public static StaffRequest getStaffRequest(int index){
		
        return getStaffRequests().get(index);
    }
	
    public static int staffRequestSize(){
	return getStaffRequests().size();
    }
    
    public static void addSkillLevels(StaffRequest staffRequest){
	getStaffRequests().add(staffRequest);
    }
    public static void addShiftStructure(Shift shift){
	getShiftStructure().add(shift);
    }
	
    public static void addShiftDepend(Shift previous, Shift next){
	getShiftDepend().put(previous, next);
    }
    public static Shift NextShift(Shift previous){
	return getShiftDepend().get(previous);
    }
    public static boolean isPreviousShift(Shift previous){
	return getShiftDepend().containsKey(previous);
    }
    public static boolean isNextShift(Shift next){
	return getShiftDepend().containsValue(next);
    }
	
    public static Employee getNurse(int index){
	
	return nurseList.get(index);
    }
	
    public static Shift getShift(int index){
		
	return getShiftStructure().get(index);
    }
	
    public static int shiftStrutureSize(){
	return getShiftStructure().size();
    }
    public static void addShift(Shift shift){
	getShiftStructure().add(shift);
    }

    /**
     * @return the shiftStructure
     */
    public static ArrayList<Shift> getShiftStructure() {
        return shiftStructure;
    }
	
    public static int getNurseIndex(Employee nurse){
        return nurseList.indexOf(nurse);
    }
    public static void setStartEndDate(String Start, String End){
	startDate=Start;
	endDate=End;
		
    }
    public static void datesBetweenStartAndEnd(){
	SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
	try {	
		Date date1 = myFormat.parse(startDate);
		Date date2 = myFormat.parse(endDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		cal.add(Calendar.DAY_OF_MONTH, -1);
		while (cal.getTime().before(date2)) {
                    cal.add(Calendar.DAY_OF_MONTH, 1);
		    addDay(myFormat.format(cal.getTime()));

		}
	} catch (ParseException e) {
		// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
    public static int dateDiff() throws ParseException{
	SimpleDateFormat myFormat = new SimpleDateFormat("yyyy/MM/dd");
	   
	Date sDate=myFormat.parse(startDate);
	Date eDate=myFormat.parse(endDate);
	long startTime = sDate.getTime();
        long endTime = eDate.getTime();
	long differenceMillis = endTime - startTime;
	long MILLIS_PER_DAY=TimeUnit.DAYS.toMillis(1);
	        // divide by the number of millis per day
	int differenceInDays = (int) Math.ceil(differenceMillis / TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
	return differenceInDays;
    }
    public static int shiftlength(){
	return getShiftStructure().size();
    }
	
    public static void addDay(String day_){
	dayList.add(day_);
    }
    public static String getDay(int index){
		
	return dayList.get(index);
    }
        
    public static int getIndex(String day_){
        return dayList.indexOf(day_);
    }
	/**
	 * @return the dayList
	 */
    public static ArrayList<String> getDayList() {
	return dayList;
    }
	/**
	 * @param dayList the dayList to set
	 */
    public static void setDayList(ArrayList<String> dayList) {
	RosterManager.dayList = dayList;
    }
	
    /**
     * @return the shiftDepend
     */
    public static HashMap<Shift,Shift> getShiftDepend() {
        return shiftDepend;
    }

    /**
     * @return the staffLevels
     */
    public static ArrayList<StaffSkillLevels> getStaffLevels() {
        return staffLevels;
    }

    /**
     * @param aStaffLevels the staffLevels to set
     */
    public static void setStaffLevels(ArrayList<StaffSkillLevels> aStaffLevels) {
        staffLevels = aStaffLevels;
    }
    public static StaffSkillLevels getSkillLevels(int index){
		
	return getStaffLevels().get(index);
    }
	
    public static int skillLevelsSize(){
	return getStaffLevels().size();
    }
    
    public static void addSkillLevels(StaffSkillLevels skillLevel){
	getStaffLevels().add(skillLevel);
    }
    
    
    
}

