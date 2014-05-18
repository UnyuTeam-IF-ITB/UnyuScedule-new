/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kel6.schedule.genetic;

import com.kel6.schedule.entities.Dosen;
import com.kel6.schedule.entities.KetersediaanDosen;
import com.kel6.schedule.entities.KetersediaanRuangan;
import com.kel6.schedule.entities.Topik;
import java.util.List;

/**
 *
 * @author Esa_Lucu
 */
class FitnessCalc {
    static Kromosom[] solution = new Kromosom[64];
    
    // Calculate inidividuals fittness by comparing it to our candidate solution
    public static float getFitness(Individual individual) {
         float fitness = 0f;
         int pinalty = 0;

         // Loop through our individuals genes and compare them to our cadidates
         for (int i = 0; i < individual.size(); i++) {
             pinalty += individual.getKromosom(i).getPinalty();

         }
         fitness = (float) 1/(1+pinalty);
         return fitness;
    }
     
    public static int getPinalty(Kromosom kromosom, Individual individual) {

         int pinalty = 0;
         // cek pinalty Dosen penguji dengan waktu
         pinalty += checkDosenPengujiSlotWaktu(kromosom);
         // cek pinalty Dosen pembimbing dengan waktu
         pinalty += checkDosenPembimbingSlotWaktu(kromosom);
         // cek pinalty dosen Penguji dengan topik
         pinalty += checkDosenPengujiTopik(kromosom);
         // cek pinalty dosen Penguji dengan pembimbing
         pinalty += checkDosenPengujiPembimbing(kromosom);
         // cek pinalty Ruangan dan waktu
         pinalty += checkDosenRuanganWaktu(kromosom);
         if (individual != null){
             pinalty += checkDuplicateWaktu(kromosom, individual);
        }
         return pinalty;
     }
     // Get optimum fitness
     static int getMaxFitness() {
         int maxFitness = 1;
         return maxFitness;
     }
     
     
    private static int checkDosenPengujiSlotWaktu (Kromosom kromosom){
        int pinalty = 0;
         boolean statusPinalty = true;
         for (int j=0; j<kromosom.getGenDosenPenguji().size(); j++){
             Dosen tempDosen = kromosom.getGenDosenPenguji().get(j);
             List<KetersediaanDosen> listSDosen = tempDosen.getKetersediaanDosenList();
             for (int i=0; i<listSDosen.size(); i++){
                int n=i;
                for (int m=0; m<kromosom.getGenWaktu().size(); m++){    
                    if (kromosom.getGenWaktu().get(m).getJam().getIdJam() ==  listSDosen.get(n+m).getIdJam().getIdJam() &&
                        kromosom.getGenDate().compareTo(listSDosen.get(n).getTanggalSedia()) == 0){
                            statusPinalty = false;
                            i = listSDosen.size();
                    }else
                            //statusPinalty = true;
                            i=n;
                            m=kromosom.getGenWaktu().size(); //klo ga sama ga usah dibandingin lg
                }
//                if (kromosom.getGenWaktu().get(0).getJam().getIdJam() ==  listSDosen.get(i).getIdJam().getIdJam() &&
//                    kromosom.getGenDate().compareTo(listSDosen.get(i).getTanggalSedia()) == 0){
//                        statusPinalty = false;
//                        i = listSDosen.size();
//                }
             }
             if (statusPinalty){
               // System.out.println("pinalty Dosen waktu ");
                pinalty++;
             }else{
                statusPinalty = true;
             }
         }

         return pinalty;
    }

    private static int checkDosenPembimbingSlotWaktu (Kromosom kromosom){
         int pinalty = 0;
         boolean statusPinalty = true;
         List<Dosen> tempPembimbing = kromosom.getGenKA().getDosenList();
         for (int j=0; j<tempPembimbing.size(); j++){
             statusPinalty = true;
             Dosen tempDosen = tempPembimbing.get(j);
             List<KetersediaanDosen> listSDosen = tempDosen.getKetersediaanDosenList();
             for (int i=0; i<listSDosen.size(); i++){
                int n=i;
                for (int m=0; m<kromosom.getGenWaktu().size(); m++){
                    if (kromosom.getGenWaktu().get(m).getJam().getIdJam() ==  listSDosen.get(n+m).getIdJam().getIdJam() &&
                        kromosom.getGenDate().compareTo(listSDosen.get(n).getTanggalSedia()) == 0){
                            statusPinalty = false;
                            i = listSDosen.size();
                    }else{
                            //statusPinalty = true;
                            i = n;
                            m=kromosom.getGenWaktu().size(); //klo ga sama ga usah dibandingin lg
                    }
                }
//                if (kromosom.getGenWaktu().get(0).getJam().getIdJam() ==  listSDosen.get(i).getIdJam().getIdJam() &&
//                    kromosom.getGenDate().compareTo(listSDosen.get(i).getTanggalSedia()) == 0){
//                    statusPinalty = false;
//                    i = listSDosen.size();
//                }
             }
             if (statusPinalty){
               // System.out.println("pinalty Dosen waktu ");
                pinalty++;
             }  
             
         }

         return pinalty;
    }

    private static int checkDosenPengujiTopik (Kromosom kromosom){
         int pinalty = 0;
         boolean statusPinalty = true;
         for (int j=0; j<kromosom.getGenDosenPenguji().size(); j++){
             Dosen tempDosen = kromosom.getGenDosenPenguji().get(j);
             List<Topik> listSDosen = tempDosen.getTopikList();
             for (int i=0; i<listSDosen.size(); i++){
                for (int k=0; k<kromosom.getGenKA().getTopikList().size(); k++){
                    if (kromosom.getGenKA().getTopikList().get(k).getIdTopik() ==  listSDosen.get(i).getIdTopik()){
                        statusPinalty = false;
                        k = kromosom.getGenKA().getTopikList().size();
                        i = listSDosen.size();
                    }
                }
             }
             if (statusPinalty){
               // System.out.println("pinalty Dosen waktu ");
                pinalty++;
             }else{
                statusPinalty = true;
             }
         }

         return pinalty;
    }
    
    private static int checkDosenPengujiPembimbing (Kromosom kromosom){
         int pinalty = 0;
         boolean statusPinalty = false;
         List<Dosen> listPembimbing = kromosom.getGenKA().getDosenList();
         for (int j=0; j<listPembimbing.size(); j++){
             Dosen pembimbing = listPembimbing.get(j);
             List<Dosen> listPenguji = kromosom.getGenDosenPenguji();
             for (int i=0; i<listPenguji.size(); i++){
                if (pembimbing.getNikDosen().equals(listPenguji.get(i).getNikDosen())){
                    statusPinalty = true;
                    i = listPenguji.size();
                }
             }
             if (statusPinalty){
               // System.out.println("pinalty Dosen waktu ");
                pinalty++;
             }else{
                statusPinalty = false;
             }
         }

         return pinalty;
    }
    
    private static int checkDosenRuanganWaktu (Kromosom kromosom){
         int pinalty = 0;
         boolean statusPinalty = true;
         List<KetersediaanRuangan> listSRuangan = kromosom.getGenRuangan().getKetersediaanRuanganList();
         for (int i=0; i<listSRuangan.size(); i++){
            int n=i;
            for (int m=0; m<kromosom.getGenWaktu().size(); m++){
                if (kromosom.getGenWaktu().get(m).getJam().getIdJam() ==  listSRuangan.get(m+n).getIdJam().getIdJam() &&
                    kromosom.getGenDate().compareTo(listSRuangan.get(n).getTanggal())== 0 ){
                    statusPinalty = false;
                    i = listSRuangan.size();
                }else{
                    //statusPinalty = true;
                    i = n;
                    m=kromosom.getGenWaktu().size(); //klo ga sama ga usah dibandingin lg
                }
            }
        
//            if (kromosom.getGenWaktu().get(0).getJam().getIdJam() ==  listSRuangan.get(i).getIdJam().getIdJam() &&
//                kromosom.getGenDate().compareTo(listSRuangan.get(i).getTanggal())== 0 ){
//                statusPinalty = false;
//                i = listSRuangan.size();
//            }
         }
         if (statusPinalty){
            //System.out.println("pinalty Ruangan waktu ");
            pinalty++;
          }else{
            statusPinalty = true;
         }

         return pinalty;
    }
    
    private static int checkDuplicateWaktu (Kromosom kromosom, Individual individual){
           int pinalty =0;

           for (int j = 0; j<individual.size();j++){
                    Kromosom pointer2 = individual.getKromosom(j);
                    if (pointer2 != null){
                        for (int m=0; m<kromosom.getGenWaktu().size(); m++){
                            if ((kromosom.getGenRuangan().getIdRuangan().equals(pointer2.getGenRuangan().getIdRuangan())) &&
                                (kromosom.getGenWaktu().get(m).getJam().getIdJam() == pointer2.getGenWaktu().get(m).getJam().getIdJam()) &&
                                (kromosom.getGenDate().compareTo(pointer2.getGenDate())==0) &&
                                (kromosom.getGenKA().getIdKa() != pointer2.getGenKA().getIdKa())){
                                 pinalty++;
                            }
                        }
                    }
            }
        return pinalty;
    }
}
