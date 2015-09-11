/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GAModule;

import RosterManager.RosterManager;
import java.util.Vector;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nuwan_rates
 */
public class Population {

    private Chromosome[] chrome;

    public Population(int populationSize, boolean initialise) {
        chrome = new Chromosome[populationSize];

        if (initialise) {
            for (int i = 0; i < populationSize; i++) {
                Chromosome newRoster = new Chromosome();
                newRoster.generateIndividual();
                saveIndividual(i, newRoster);
            }

        }
    }

    public void saveIndividual(int index, Chromosome chrome) {
        this.chrome[index] = chrome;
    }

    public Chromosome getIndividual(int index) {
        return this.getChrome()[index];

    }

    /**
     * @return the chrome
     */
    public Chromosome[] getChrome() {
        return chrome;
    }

    public Chromosome getFittest() {
        Chromosome fittest = getChrome()[0];
        // Loop through individuals to find fittest
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    // Gets population size
    public int populationSize() {
        return this.getChrome().length;
    }

    public void dispaly() {

        for (Chromosome ch : getChrome()) {

            for (int i = 0; i < ch.ChromosomeRowSize(); i++) {
                for (int j = 0; j < ch.chromosomeColumnCount(); j++) {

                    System.out.print("| " + ch.getShift(i, j).getShiftName() + " |");

                }
                System.out.print("\n");
            }
            System.out.print("\n");
            System.out.print("\n");
            System.out.print("\n");
        }

        for (Chromosome ch : getChrome()) {
            GeneticOperator.mutate(ch);

            for (int i = 0; i < ch.ChromosomeRowSize(); i++) {
                for (int j = 0; j < ch.chromosomeColumnCount(); j++) {

                    System.out.print("| " + ch.getShift(i, j).getShiftName() + " |");

                }
                System.out.print("\n");
            }
            System.out.print("\n");
            System.out.print("\n");
            System.out.print("\n");
        }

    }

    public void displayTable(JTable table) {

        Vector columns = new Vector(getIndividual(0).chromosomeColumnCount() + 1);

        columns.add("Staff Names");

        for (int i = 0; i < getIndividual(0).chromosomeColumnCount(); i++) {
            columns.add(RosterManager.getDay(i));

        }

        Vector data = new Vector();
        Vector row;

        for (int row1 = 0; row1 < getIndividual(0).ChromosomeRowSize(); row1++) {

            row = new Vector(getIndividual(0).chromosomeColumnCount());
            row.add(RosterManager.getNurse(row1).getEmpName());
            for (int col = 0; col < getIndividual(0).chromosomeColumnCount(); col++) {
                row.add(getIndividual(0).getShift(row1, col).getShiftName());

            }
            data.add(row);
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columns);

        table.setModel(tableModel);
        TableColumnModel model = table.getColumnModel();
        for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
            model.getColumn(columnIndex).setPreferredWidth(200);

        }
        table.setColumnModel(model);

    }

    public void excelExport(JTable table, File file) throws IOException {
        TableModel model = table.getModel();
        FileWriter excel = new FileWriter(file);
        BufferedWriter bw=new BufferedWriter(excel);
        for (int i = 0; i < model.getColumnCount(); i++) {
            bw.write(model.getColumnName(i) + "\t");
        }
        excel.write("\n");
        for (int i = 0; i < model.getRowCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                bw.write(model.getValueAt(i, j).toString() + "\t");
            }
            bw.write("\n");
        }
        bw.close();
    }
}
