/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SmartNurse;
import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author nuwan_rates
 */
public class Employee {
    
    // /////Persistent fields///////
    private int employeeId;
    private String empName;
    private String address;
    private String nic;
    private Date DOB;
    private String skillType;
    private int hourseOfWorkInMonth;
    private String wardName;
    private String gender;
    // Joined Fields /////
    private Skill skill;
    private InValidDay inValidDay;
    private InValidShift inValidShift;
    private ArrayList<String> invalidDayList=new ArrayList<String>();
    private ArrayList<String> invalidShiftList=new ArrayList<String>();
    // getter Setters
    /**
     * @return the employeeId
     */
    public Employee(int id, String name, String address, String nic, Date dob, String sType, int hours, String ward, String gender){
        this.employeeId=id;
        this.empName=name;
        this.address=address;
        this.nic=nic;
        this.DOB=dob;
        this.skillType=sType;
        this.hourseOfWorkInMonth=hours;
        this.wardName=ward;
        this.gender=gender;
    }
    public Employee(){}
    
    public Employee(String name, String sType, int hours, String ward){
        this.empName=name;
        this.skillType=sType;
        this.hourseOfWorkInMonth=hours;
        this.wardName=ward;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the nic
     */
    public String getNic() {
        return nic;
    }

    /**
     * @param nic the nic to set
     */
    public void setNic(String nic) {
        this.nic = nic;
    }

    /**
     * @return the DOB
     */
    public Date getDOB() {
        return DOB;
    }

    /**
     * @param DOB the DOB to set
     */
    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    /**
     * @return the skill
     */
    public Skill getSkill() {
        return skill;
    }

    /**
     * @param skill the skill to set
     */
    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    /**
     * @return the ValidDay
     */
    public InValidDay getValidDay() {
        return inValidDay;
    }

    /**
     * @param validDay the ValidDay to set
     */
    public void setValidDay(InValidDay inValidDay) {
        this.inValidDay = inValidDay;
    }

    /**
     * @return the validShift
     */
    public InValidShift getValidShift() {
        return inValidShift;
    }

    /**
     * @param validShift the validShift to set
     */
    public void setValidShift(InValidShift validShift) {
        this.inValidShift = validShift;
    }

    /**
     * @return the skillId
     */
    public String getSkillType() {
        return skillType;
    }

    /**
     * @param skillId the skillId to set
     */
    public void setSkillType(String skillId) {
        this.skillType = skillId;
    }

    /**
     * @return the hourseOfWorkInMonth
     */
    public int getHourseOfWorkInMonth() {
        return hourseOfWorkInMonth;
    }

    /**
     * @param hourseOfWorkInMonth the hourseOfWorkInMonth to set
     */
    public void setHourseOfWorkInMonth(int hourseOfWorkInMonth) {
        this.hourseOfWorkInMonth = hourseOfWorkInMonth;
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
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void addInvalidDay(String day){
	invalidDayList.add(day);
    }
	
    public String getInvalidDay(int index){
	return invalidDayList.get(index);
		
    }

	/**
	 * @return the invalidDayList
	 */
    public ArrayList<String> getInvalidDayList() {
	return invalidDayList;
    }

	/**
	 * @param invalidDayList the invalidDayList to set
	 */
    public void setInvalidDayList(ArrayList<String> invalidDayList) {
	this.invalidDayList = invalidDayList;
    }
    public void addInvalidStaffLevel(String shift){
	invalidShiftList.add(shift);
    }
	
    public String getInvalidShift(int index){
	return invalidShiftList.get(index);
		
    }
    
    public ArrayList<String> getInvalidShiftList() {
	return invalidShiftList;
    }

	/**
	 * @param invalidShiftList the invalidShiftList to set
	 */
    public void setInvalidShiftList(ArrayList<String> invalidShiftList) {
	this.invalidShiftList = invalidShiftList;
		
    }
    
    public int hashCode()
    {
	return employeeId;
    }
	
    public boolean equals( Object obj )
    {
	boolean flag = false;
	Employee emp = ( Employee )obj;
	if( emp.employeeId == employeeId )
            flag = true;
	return flag;
    }
    
	
             
}
