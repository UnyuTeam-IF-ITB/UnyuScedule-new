/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.genetic;

/**
 *
 * @author Esa_Lucu
 */
class Individual {
    static int defaultGeneLength = 8;
    private Kromosom[] kromosoms = new Kromosom[defaultGeneLength];
    // Cache
    private float fitness = 0f;
     
    void generateRandomIndividual() {
        int size = kromosoms.length; 
        for (int i = 0; i < size; i++) {
           Kromosom gene = Kromosom.GenerateKromosom();
           kromosoms[i] = gene;
        }
     
    }

    /* Public methods */
     public int size() {
         return kromosoms.length;
     }
     
     public Kromosom getKromosom(int index) {
         return kromosoms[index];
     }
     
     public float getFitness() {
         if (fitness == 0f) {
             this.fitness = FitnessCalc.getFitness(this);
         }
         return this.fitness;
     }
     
     public void setKromosom(int index, Kromosom value) {
         kromosoms[index] = value;
         fitness = 0;
     }

    
}
