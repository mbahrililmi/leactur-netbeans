
package Manipulasi_APIarray;

import java.util.Arrays;
/**
 *
 * @author M.BAHRIL.I
 */
public class API_kelasArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //array urutan data
        double [] doubleArray = {2.8, 1.1, 1.2, 5.9, 2.4};
        Arrays.sort(doubleArray);
        System.out.printf("\ndoubleArray: ");
        for(double nArray : doubleArray){
           System.out.printf("%.1f ", nArray); 
        }
     
    
        //onput pada 10-element array dengan nilai 8
        int[] filledIntArray = new int [10];
        Arrays.fill(filledIntArray, 8);
        tampilArray(filledIntArray, "filledIntArray");
    
    
        //salin dari yArray ke yArray copy
        int[]yArray = {1, 2, 3, 4, 5, 6};
        int[]yArrayCopy = new int[yArray.length];
        System.arraycopy(yArray, 0, yArrayCopy, 0, yArray.length);
        tampilArray(yArray,"yArray awal");
        tampilArray(yArrayCopy, "yArray copy");
        
        //membandingkan yArray dengan yArrayCopy
        boolean b= Arrays.equals(yArray, yArrayCopy);
        System.out.printf("\n\nyArray %s yArrayCopy\n", 
                        (b ? "==" : "!="));
        
        
        //pencarian yArray untuk nilai element 5
        int location =Arrays.binarySearch(yArray, 5);
        if (location >= 0) {
            System.out.printf("Ditemukan 5 pada element %d di yArray\n", location);
        } else {
            System.out.println("5 tidak di tumukan di yArray");
        }
    }   
        //output nilai elemen dimasing masing array
        public static void tampilArray(int[] array, String keterangan){
            System.out.printf("\n%s: ", keterangan);
            for(int nilai : array){
               System.out.printf("%d ", nilai); 
            }
        }
    
}

