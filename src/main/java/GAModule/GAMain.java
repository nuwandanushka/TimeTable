/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GAModule;

import RosterManager.RosterManager;

/**
 *
 * @author nuwan_rates
 */
public class GAMain {
    
    public void algorithmBegins(String startDate, String EndDate){
        RosterManager.setStartEndDate(startDate, EndDate);
        Population pop=new Population(1, true);		
	pop.dispaly();
        System.out.println("Initial distance: " + pop.getFittest().getFitness()+"\n");

        // Evolve population for 100 generations
            pop = GeneticOperator.evolvePopulation(pop);
            for (int i = 0; i < 100; i++) {
                pop = GeneticOperator.evolvePopulation(pop);
            }
    }
    
}
