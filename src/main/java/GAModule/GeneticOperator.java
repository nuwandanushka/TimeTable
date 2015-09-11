/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GAModule;

import BusinessLayer.Shift;
import RosterManager.RosterManager;

/**
 *
 * @author nuwan_rates
 */
public class GeneticOperator {
    
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;
    
     public static Population evolvePopulation(Population pop) {
         Population newPopulation = new Population(pop.populationSize(), false);
         int elitismOffset = 0;
         if (elitism) {
            newPopulation.saveIndividual(0, pop.getFittest());
            elitismOffset = 1;
        }
         for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            // Select parents
            Chromosome parent1 = tournamentSelection(pop);
            Chromosome parent2 = tournamentSelection(pop);
            // Crossover parents
            Chromosome child = crossover(parent1, parent2);
            // Add child to new population
            newPopulation.saveIndividual(i, child);
        }

        // Mutate the new population a bit to add some new genetic material
        for (int i = elitismOffset; i < newPopulation.populationSize(); i++) {
            mutate(newPopulation.getIndividual(i));
        }

        return newPopulation;
     }
     public static Chromosome crossover(Chromosome parent1, Chromosome parent2) {
         Chromosome child = new Chromosome();
         int startPos = (int) (Math.random() * parent1.ChromosomeRowSize());
        int endPos = (int) (Math.random() * parent1.ChromosomeRowSize());

        // Loop and add the sub tour from parent1 to our child
        for (int staffMemberIndex = 0; staffMemberIndex < child.ChromosomeRowSize(); staffMemberIndex++) {
            // If our start position is less than the end position
            if (startPos < endPos && staffMemberIndex > startPos && staffMemberIndex < endPos) {
                for(int dayIndex=0; dayIndex< child.chromosomeColumnCount(); dayIndex++){
                    child.saveGene(staffMemberIndex,dayIndex,parent1.retrieveGene(staffMemberIndex, dayIndex));
                }
                
            } // If our start position is larger
            else if (startPos > endPos) {
                if (!(staffMemberIndex < startPos && staffMemberIndex > endPos)) {
                    for(int dayIndex=0; dayIndex< child.chromosomeColumnCount(); dayIndex++){
                       child.saveGene(staffMemberIndex,dayIndex,parent1.retrieveGene(staffMemberIndex, dayIndex));
                    }   
                }
            }
        }
         // Loop to find a spare position in the child's chromosome
        for (int staffMemberIndex = 0; staffMemberIndex < child.ChromosomeRowSize(); staffMemberIndex++) {
         // Spare position found, add gene
            if (child.retrieveGene(staffMemberIndex, 0) == null) {
                
                for(int dayIndex=0; dayIndex< child.chromosomeColumnCount(); dayIndex++){
                       child.saveGene(staffMemberIndex,dayIndex,parent2.retrieveGene(staffMemberIndex, dayIndex));
                }   
                
            }
        }
            
        
         return child;
     }
     // Mutate a tour using swap mutation
     public static void mutate(Chromosome chrome) {
 
        // Loop through tour cities
        for(int rosterNursePos1=0; rosterNursePos1 < chrome.ChromosomeRowSize(); rosterNursePos1++){
            for (int rosterDayPos1=0; rosterDayPos1<chrome.chromosomeColumnCount();rosterDayPos1++){
                if(RosterManager.isPreviousShift(chrome.getShift(rosterNursePos1, rosterDayPos1))==false || RosterManager.isNextShift(chrome.getShift(rosterNursePos1, rosterDayPos1))==false || chrome.getShift(rosterNursePos1, rosterDayPos1).getHours()!=0 ){
                     if(Math.random() < mutationRate){
                    // Get a second random position in the tour
                    int rosterNursePos2= rosterNursePos1;
                    int rosterDayPos2 = returnValidPos(rosterNursePos2, randomizeShiftGeneration(chrome), chrome );

                    // Get the cities at target position in tour
                    Gene gene1 = chrome.retrieveGene(rosterNursePos1, rosterDayPos1);
                    Gene gene2 = chrome.retrieveGene(rosterNursePos2, rosterDayPos2);

                    // Swap them around
                    chrome.saveGene(rosterNursePos1, rosterDayPos1, gene2);
                    chrome.saveGene(rosterNursePos2, rosterDayPos2, gene1);
                    
                }
                
                    
                } 
                // Apply mutation rate
               
            }
            
        }
    
         
     }
     public static int randomizeShiftGeneration(Chromosome chrome){
		
		int i=(int)(Math.random() * chrome.chromosomeColumnCount());
		return i;
    }
    
    public static int returnValidPos(int rosterNursePos2, int rosterDayPos2, Chromosome chrome ){
        if(RosterManager.isPreviousShift(chrome.getShift(rosterNursePos2, rosterDayPos2))==false || RosterManager.isNextShift(chrome.getShift(rosterNursePos2, rosterDayPos2))==false || chrome.getShift(rosterNursePos2, rosterDayPos2).getHours()!=0 ){
            return rosterDayPos2;
        }
        else{
            return returnValidPos(rosterNursePos2, randomizeShiftGeneration(chrome), chrome);
        }
    } 
    
      private static Chromosome tournamentSelection(Population pop) {
          Population tournament = new Population(tournamentSize, false);
          // For each place in the tournament get a random candidate tour and
        // add it
            for (int i = 0; i < tournamentSize; i++) {
                int randomId = (int) (Math.random() * pop.populationSize());
                tournament.saveIndividual(i, pop.getIndividual(randomId));
            }
          Chromosome fittest = tournament.getFittest();
          return fittest;
      }
     
    
}
