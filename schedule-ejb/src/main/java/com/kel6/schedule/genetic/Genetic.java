/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.genetic;

import com.kel6.schedule.entities.Dosen;
import com.kel6.schedule.entities.JdwlSmnSdg;
import com.kel6.schedule.entities.KaryaAkhir;
import com.kel6.schedule.entities.Periode;
import com.kel6.schedule.entities.Ruangan;
import com.kel6.schedule.entities.SlotWaktu;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Esa_Lucu
 */
public class Genetic implements Runnable{
    // Data Source
    List<Dosen> listDosen; 
    List<KaryaAkhir> listKaryaAkhir;
    List<Ruangan> listRuangan; 
    List<SlotWaktu> listSlotWaktu;
    Periode periode;
    
    //Genetic Attribute
    /* GA parameters */
     private static final double uniformRate = 0.5;
     private static final double mutationRate = 0.015;
     private static final int tournamentSize = 5;
     private static final boolean elitism = true;

    public Genetic(List<Dosen> listDosen, List<KaryaAkhir> listKaryaAkhir, List<Ruangan> listRuangan, List<SlotWaktu> listSlotWaktu, Periode periode) {
        this.listDosen = listDosen;
        this.listKaryaAkhir = listKaryaAkhir;
        this.listRuangan = listRuangan;
        this.listSlotWaktu = listSlotWaktu;
        this.periode = periode;
    }
    
    public void startNewThread(){
        Thread t = new Thread(this);
        t.start();
    }

    public Genetic() {
    }
    
    List<JdwlSmnSdg> jdwlGenerate ;

    public List<JdwlSmnSdg> getJdwlGenerate() {
        return jdwlGenerate;
    }

    public void setJdwlGenerate(List<JdwlSmnSdg> jdwlGenerate) {
        this.jdwlGenerate = jdwlGenerate;
    }
    public void generateJadwal(){
        jdwlGenerate = new ArrayList<JdwlSmnSdg>();
        // Create an initial population
        Population myPop = new Population(50, true);
        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        int konfergenCount = 0;
        float prevFitness = 0f;
        while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()  ) {
             generationCount++;
             System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
             if (myPop.getFittest().getFitness() == prevFitness){
                konfergenCount++;
             }else {
                konfergenCount = 0;
             }
             prevFitness = myPop.getFittest().getFitness();

             myPop = evolvePopulation(myPop);
         }
        
        System.out.println("Solution found!");
         System.out.println("Generation: " + generationCount+1);
         System.out.println("Fitnes: " + myPop.getFittest().getFitness());
         System.out.println("Genes:");
         System.out.println(myPop.getFittest());
         Individual result = myPop.getFittest();
         System.out.println("ID SLOT WAKTU" + "\t"+
                            "DATE" + "\t"+
                            "ID_RUANGAN" +"\t"+
                            "ID_KA"+"\t"+
                            "ID_PEMBIMBING"+"\t"+
                            "ID_DOSEN");
         Date genDate = Calendar.getInstance().getTime();
         for (int i = 0; i<result.size(); i++){
            Kromosom dataJadwal = result.getKromosom(i);
            System.out.println(dataJadwal.getGenWaktu().get(i).getJam().getIdJam() + "\t"+
                               dataJadwal.getGenDate().toString() + "\t"+
                               dataJadwal.getGenRuangan().getIdRuangan() +"\t"+
                               dataJadwal.getGenKA().getIdKa()+"\t"+
                               dataJadwal.getGenKA().getDosenList().get(0).getNikDosen()+"\t"+
                               dataJadwal.getGenDosenPenguji().get(0).getNikDosen());
            JdwlSmnSdg jdw = new JdwlSmnSdg();
            SlotWaktu slot = new SlotWaktu();
//            slot.
//            element.setDosenPenguji(dataJadwal.getGenDosenPenguji());
//            element.setGenerateDate(genDate);
//            element.setKaryaAkhir(dataJadwal.getGenKA());
//            element.setRuangan(dataJadwal.getGenRuangan());
//            element.setSlotWaktu(dataJadwal.getGenWaktu());
//            element.setTanggal(dataJadwal.getGenDate());
//            element.setStatusHasilPelaksanaan(BigInteger.valueOf(0));
//            element.setStatusPelaksanaan(BigInteger.valueOf(0));
//            jdwlGenerate.add(element);
         }
//        return jdwlGenerate;
    }
    public void run(){
        jdwlGenerate = new ArrayList<JdwlSmnSdg>();
        // Create an initial population
        Population myPop = new Population(50, true);
        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        int konfergenCount = 0;
        float prevFitness = 0f;
        while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()  ) {
             generationCount++;
             System.out.println("Generation: " + generationCount + " Fittest: " + myPop.getFittest().getFitness());
             if (myPop.getFittest().getFitness() == prevFitness){
                konfergenCount++;
             }else {
                konfergenCount = 0;
             }
             prevFitness = myPop.getFittest().getFitness();

             myPop = evolvePopulation(myPop);
         }
        
        System.out.println("Solution found!");
         System.out.println("Generation: " + generationCount+1);
         System.out.println("Fitnes: " + myPop.getFittest().getFitness());
         System.out.println("Genes:");
         System.out.println(myPop.getFittest());
         Individual result = myPop.getFittest();
         System.out.println("ID SLOT WAKTU" + "\t"+
                            "DATE" + "\t"+
                            "ID_RUANGAN" +"\t"+
                            "ID_KA"+"\t"+
                            "ID_PEMBIMBING"+"\t"+
                            "ID_DOSEN");
         Date genDate = Calendar.getInstance().getTime();
         for (int i = 0; i<result.size(); i++){
            Kromosom dataJadwal = result.getKromosom(i);
            System.out.println(dataJadwal.getGenWaktu().get(i).getJam().getIdJam() + "\t"+
                               dataJadwal.getGenDate().toString() + "\t"+
                               dataJadwal.getGenRuangan().getIdRuangan() +"\t"+
                               dataJadwal.getGenKA().getIdKa()+"\t"+
                               dataJadwal.getGenKA().getDosenList().get(0).getNikDosen()+"\t"+
                               dataJadwal.getGenDosenPenguji().get(0).getNikDosen());
            JdwlSmnSdg jdw = new JdwlSmnSdg();
            SlotWaktu slot = new SlotWaktu();
//            slot.
//            element.setDosenPenguji(dataJadwal.getGenDosenPenguji());
//            element.setGenerateDate(genDate);
//            element.setKaryaAkhir(dataJadwal.getGenKA());
//            element.setRuangan(dataJadwal.getGenRuangan());
//            element.setSlotWaktu(dataJadwal.getGenWaktu());
//            element.setTanggal(dataJadwal.getGenDate());
//            element.setStatusHasilPelaksanaan(BigInteger.valueOf(0));
//            element.setStatusPelaksanaan(BigInteger.valueOf(0));
//            jdwlGenerate.add(element);
         }
//        return jdwlGenerate;
    }
    
    // Evolve a population
     public static Population evolvePopulation(Population pop) {
         Population newPopulation = new Population(pop.size(), false);

        // Keep our best individual
         if (elitism) {
             newPopulation.saveIndividual(0, pop.getFittest());
         }

        // Crossover population
         int elitismOffset;
         if (elitism) {
             elitismOffset = 1;
         } else {
             elitismOffset = 0;
         }
         // Loop over the population size and create new individuals with
         // crossover
         for (int i = elitismOffset; i < pop.size(); i++) {
          //   System.out.println("cros : indv-" + i);
             Individual indiv1 = tournamentSelection(pop);
             Individual indiv2 = tournamentSelection(pop);
             Individual newIndiv = crossover(indiv1, indiv2);
             newPopulation.saveIndividual(i, newIndiv);
         }

        // Mutate population
         for (int i = elitismOffset; i < newPopulation.size(); i++) {
           //  System.out.println("mutasi : indv-" + i);
             mutate(newPopulation.getIndividual(i));
         }

        return newPopulation;
     }
     
     // Select individuals for crossover
     private static Individual tournamentSelection(Population pop) {
         // Create a tournament population
         Population tournament = new Population(tournamentSize, false);
         // For each place in the tournament get a random individual
         for (int i = 0; i < tournamentSize; i++) {
             int randomId = (int) (Math.random() * pop.size());
             tournament.saveIndividual(i, pop.getIndividual(randomId));
         }
         // Get the fittest
         Individual fittest = tournament.getFittest();
         return fittest;
     }
     
     // Mutate an individual
     private static void mutate(Individual indiv) {
         // Loop through genes
         for (int i = 0; i < indiv.size(); i++) {
           //  System.out.println("mutasi : k-" + i);
             Kromosom kromosom = indiv.getKromosom(i);
             if (kromosom.getPinalty() != 0){
            
                 // mutate Dosen Penguji
                 if (Math.random() <= mutationRate) {
                     // Create random gene
                     kromosom = Kromosom.UpdateGenDosen(kromosom);
                 }

                 // mutate Slot Waktu
                 if (Math.random() <= mutationRate) {
                     // Create random gene
                     kromosom = Kromosom.UpdateGenWaktu(kromosom);
                 }

                 // mutate Ruangan
                 if (Math.random() <= mutationRate) {
                     // Create random gene
                     kromosom = Kromosom.UpdateGenRuangan(kromosom);
                 }
                 // mutate Date
                  if (Math.random() <= mutationRate) {
                     // Create random gene
                     kromosom = Kromosom.UpdateGenDate(kromosom);
                 }
             
//             kromosom.setPinalty();
               kromosom.setPinalty(FitnessCalc.getPinalty(kromosom, indiv));
             }
         }
     }

     // Crossover individuals
     private static Individual crossover(Individual indiv1, Individual indiv2) {
         Individual newSol = new Individual();
         // Loop through genes
         for (int i = 0; i < indiv1.size(); i++) {
        //     System.out.println("cros : k-" + i);
             // Crossover
             Kromosom newKromosom;
             if (Math.random() <= uniformRate && indiv1.getKromosom(i).getPinalty() != 0) {
                 newKromosom = indiv1.getKromosom(i);
//                 for(int j=0;j<indiv1.getKromosom(i).getGenKA().getTopikList().size();j++){
//                    for(int k=0;k<indiv2.getKromosom(i).getGenKA().getTopikList().size();k++){
//                        if (indiv1.getKromosom(i).getGenKA().getTopikList().get(j).getIdTopik() ==
//                            indiv2.getKromosom(i).getGenKA().getTopikList().get(k).getIdTopik()){
//                            newKromosom.setGenDosenPenguji(indiv2.getKromosom(i).getGenDosenPenguji());
//                            k = indiv2.getKromosom(i).getGenKA().getTopikList().size();
//                            j = indiv1.getKromosom(i).getGenKA().getTopikList().size();
//                        }
//                    } 
//                 }
                 
                 
                 newKromosom.setGenDosenPenguji(indiv2.getKromosom(i).getGenDosenPenguji());
                 newKromosom.setGenRuangan(indiv2.getKromosom(i).getGenRuangan());
                 newKromosom.setGenWaktu(indiv2.getKromosom(i).getGenWaktu());
                 newKromosom.setGenDate(indiv2.getKromosom(i).getGenDate());
              //   newKromosom.setPinalty();
                 newKromosom.setPinalty(FitnessCalc.getPinalty(newKromosom, newSol));
                 newSol.setKromosom(i, newKromosom);
             } else {
                 indiv1.getKromosom(i).setPinalty(FitnessCalc.getPinalty(indiv1.getKromosom(i), newSol));
                 newSol.setKromosom(i, indiv1.getKromosom(i));
             }
         }
         return newSol;
     }
     
     
    public List<Dosen> getListDosen() {
        return listDosen;
    }

    public void setListDosen(List<Dosen> listDosen) {
        this.listDosen = listDosen;
    }

    public List<KaryaAkhir> getListKaryaAkhir() {
        return listKaryaAkhir;
    }

    public void setListKaryaAkhir(List<KaryaAkhir> listKaryaAkhir) {
        this.listKaryaAkhir = listKaryaAkhir;
    }

    public List<Ruangan> getListRuangan() {
        return listRuangan;
    }

    public void setListRuangan(List<Ruangan> listRuangan) {
        this.listRuangan = listRuangan;
    }

    public List<SlotWaktu> getListSlotWaktu() {
        return listSlotWaktu;
    }

    public void setListSlotWaktu(List<SlotWaktu> listSlotWaktu) {
        this.listSlotWaktu = listSlotWaktu;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }
    
    
    
}
