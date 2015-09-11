/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GAModule;

import BusinessLayer.RequirmentIndicator;
import BusinessLayer.Shift;
import RosterManager.RosterManager;
import SmartNurse.Employee;
import SmartNurse.StaffRequest;
import SmartNurse.StaffSkillLevels;
import java.text.ParseException;
import java.util.ArrayList;
import util.AppProperties;
import java.util.Random;

/**
 *
 * @author nuwan_rates
 */
public class Chromosome {

    private Gene[][] gene;
    private double fitness=0;

    /**
     * @return the empName
     */
    /**
     * @return the gene
     */
    public Gene[][] getGene() {
        return gene;
    }

    /**
     * @param gene the gene to set
     */
    public void setGene(Gene[][] gene) {
        this.gene = gene;
    }

    public Chromosome() {
        
        try {
            //this.weekDays=new DateFormatSymbols().getWeekdays();
            gene = new Gene[RosterManager.sizeNurse()][RosterManager.dateDiff() + 1];
            RosterManager.datesBetweenStartAndEnd();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void generateIndividual() {
        for (int staffMemberIndex = 0; staffMemberIndex < ChromosomeRowSize(); staffMemberIndex++) {
            Employee nurse = RosterManager.getNurse(staffMemberIndex);
            for (int dateIndex = 0; dateIndex < chromosomeColumnCount(); dateIndex++) {
                Gene gn = new Gene();
                if (isValidDay(RosterManager.getDay(dateIndex), nurse) == false) {

                    if (dateIndex != 0) {
                        if (isConsecutiveShift(previousShift(staffMemberIndex, dateIndex)) == true) {

                            gn.setShift(getNext(staffMemberIndex, dateIndex));
                        } else {
                            gn.setShift(randomizeTrueShift(nurse, randomizeShiftGeneration()));
                        }
                    } else {
                        gn.setShift(randomizeTrueShift(nurse, randomizeShiftGeneration()));
                    }

                } else {
                    Shift notWorking = new Shift("Not Working", 0);
                    gn.setShift(notWorking);
                }

                gene[staffMemberIndex][dateIndex] = gn;
            }
			//for(int nurseIndex=0; nurseIndex<RosterManager.sizeNurse();nurseIndex++){
            //Nurse nurse=RosterManager.getNurse(nurseIndex);
            //}

        }
    }

    public int ChromosomeRowSize() {
        return gene.length;
    }

    public int chromosomeColumnCount() {
        return gene[0].length;
    }

    public double getFitness() {
        
        return fitness = staffLevelFitness() + empWorkingHoursFitness() + softConstraintsFittness();

    }

    public ArrayList<StaffSkillLevels> getStaffLevel(ArrayList<Gene> dayRoster) {
        ArrayList<StaffSkillLevels> staffLevel = new ArrayList<StaffSkillLevels>();
        for (Shift shift : RosterManager.getShiftStructure()) {
            StaffSkillLevels staffSkill = new StaffSkillLevels();
            staffSkill.setShift(shift.getShiftName());
            int unTrainedNurseCount = 0;
            int TrainedNurseCount = 0;
            int siteNurseCount = 0;
            int TotalNumberOfNurse = 0;
            for (int geneIndex = 0; geneIndex < dayRoster.size(); geneIndex++) {
                if (dayRoster.get(geneIndex).getShift().getShiftName().equals(shift.getShiftName()) && dayRoster.get(geneIndex).getShift().getHours() != 0) {

                    if (AppProperties.UNTRAINED_NURSE.getProperty().equals(RosterManager.getNurse(geneIndex).getSkillType())) {
                        unTrainedNurseCount++;
                    } else if (AppProperties.TRAINED_NURSE.getProperty().equals(RosterManager.getNurse(geneIndex).getSkillType())) {
                        TrainedNurseCount++;
                    } else if (AppProperties.SITE_NURSE.getProperty().equals(RosterManager.getNurse(geneIndex).getSkillType())) {
                        siteNurseCount++;
                    }
                }
            }
            TotalNumberOfNurse = unTrainedNurseCount + TrainedNurseCount + siteNurseCount;
            staffSkill.setMinUntrainnedStaff(unTrainedNurseCount);
            staffSkill.setMinTrainnedStaff(TrainedNurseCount);
            staffSkill.setSiteNurseCount(siteNurseCount);
            staffSkill.setMaxNumberOfEmployee(TotalNumberOfNurse);
            staffLevel.add(staffSkill);

        }

        return staffLevel;

    }

    public double staffLevelFitness() {
        double totalFitness = 0;
        for (int dayIndex = 0; dayIndex < chromosomeColumnCount(); dayIndex++) {
            ArrayList<Gene> dayRoster = new ArrayList<Gene>();
            for (int staffMember = 0; staffMember < ChromosomeRowSize(); staffMember++) {
                dayRoster.add(retrieveGene(staffMember, dayIndex));
            }
            ArrayList<StaffSkillLevels> skillLevel = getStaffLevel(dayRoster);
            totalFitness += generateStaffLevelFitness(skillLevel);
        }
        return totalFitness;
    }

    public double generateStaffLevelFitness(ArrayList<StaffSkillLevels> rosterSkillLevel) {
        double staffFitness = 0;
        for (StaffSkillLevels skillLevel : RosterManager.getStaffLevels()) {
            for (int rosterSkillIndex = 0; rosterSkillIndex < rosterSkillLevel.size(); rosterSkillIndex++) {
                if (rosterSkillLevel.get(rosterSkillIndex).getShift().equals(skillLevel.getShift())) {
                    if (rosterSkillLevel.get(rosterSkillIndex).getMinUntrainnedStaff() >= skillLevel.getMinUntrainnedStaff()) {
                        staffFitness++;
                    }
                    if (rosterSkillLevel.get(rosterSkillIndex).getMinTrainnedStaff() >= skillLevel.getMinTrainnedStaff()) {
                        staffFitness++;
                    }
                    if (rosterSkillLevel.get(rosterSkillIndex).getSiteNurseCount() == skillLevel.getSiteNurseCount()) {
                        staffFitness++;
                    }
                    if (rosterSkillLevel.get(rosterSkillIndex).getMaxNumberOfEmployee() <= skillLevel.getMaxNumberOfEmployee()) {
                        staffFitness++;
                    }

                }
            }
            staffFitness += staffFitness;
        }
        return staffFitness;

    }

    public double empWorkingHoursFitness() {
        double empWorkingHoursFitness = 0;
        for (int staffIndex = 0; staffIndex < ChromosomeRowSize(); staffIndex++) {
            ArrayList<Shift> shiftSet = new ArrayList<Shift>();
            for (int dayIndex = 0; dayIndex < chromosomeColumnCount(); dayIndex++) {
                shiftSet.add(getShift(staffIndex, dayIndex));
            }
            empWorkingHoursFitness += generateWorkingHoursFitness(RosterManager.getNurse(staffIndex), shiftSet);
        }
        return empWorkingHoursFitness;

    }

    public double generateWorkingHoursFitness(Employee nurse, ArrayList<Shift> shiftSet) {
        double numberOfHours = 0;
        double empWorkingHoursFitness = 0;
        for (Shift s : shiftSet) {
            numberOfHours += s.getHours();
        }

        if (nurse.getHourseOfWorkInMonth() <= numberOfHours) {
            empWorkingHoursFitness = 1;
        } else {
            empWorkingHoursFitness = 0;
        }
        return empWorkingHoursFitness;
    }

    public double softConstraintsFittness() {
        double softFitness = 0;
        for (StaffRequest level : RosterManager.getStaffRequests()) {
            Employee nurse = new Employee();
            nurse.setEmployeeId(level.getNurseId());
            ArrayList<Shift> empRoster = new ArrayList<Shift>();
            for (int dateIndex = 0; dateIndex < chromosomeColumnCount(); dateIndex++) {

                empRoster.add(getShift(RosterManager.getNurseIndex(nurse), dateIndex));

            }

            softFitness += RequirmentIndicator.proceedStaffRequest(level, empRoster);

        }
        return softFitness;

    }

    public Shift previousShift(int staffIndex, int dayIndex) {
        return gene[staffIndex][dayIndex - 1].getShift();
    }

    public boolean isValidDay(String date, Employee nurse) {
        return nurse.getInvalidDayList().contains(date);
    }

    public boolean isConsecutiveShift(Shift previous) {
        return RosterManager.isPreviousShift(previous);
    }

    public Shift getNext(int staffIndex, int dayIndex) {
        return RosterManager.NextShift(previousShift(staffIndex, dayIndex));
    }

    public static Shift randomizeShiftGeneration() {

        int i = (int) (Math.random() * RosterManager.shiftStrutureSize());
        return RosterManager.getShift(i);
    }

    public boolean isValidShift(Employee nurse, Shift shift) {

        return nurse.getInvalidShiftList().contains(shift.getShiftName());

    }

    public Shift randomizeTrueShift(Employee nurse, Shift shift) {

        if (isValidShift(nurse, shift) == false) {

            return shift;
        } else {
            return randomizeTrueShift(nurse, randomizeShiftGeneration());
        }

    }

    public Shift getShift(int row, int column) {
        return gene[row][column].getShift();
    }

    public Gene retrieveGene(int row, int column) {
        return gene[row][column];
    }

    public void saveGene(int row, int column, Gene gene) {
        this.gene[row][column] = gene;
    }

}
