
package Struktur_Data;

/**
 *
 * @author M.BAHRIL.I
 */
public class Data_Array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     /**
      * Array tunggal
      * Konsep Dasar
      * Tipe data nama Kelompok Array[] = new Tipedata[Elemet];
      */
     
     int NData[] = new int[10]; //Inputkan range data nElement
     int MData[] = {90, 57, 3, 1, 4};
     int totalnilaielemet = 0;
        //Maka NData memiliki 10 elemet
        System.out.printf("%s%8s","Index\t","Element\n"); //header
        for (int i = 0; i < MData.length; i++) {
            int j = MData[i];
        totalnilaielemet +=MData[1];    
        System.out.printf("%s%8s\n",i,MData[i]);   
        }
        System.out.println("Struktu_data Total Nilai Element \t" + totalnilaielemet);
    }
    
}
