
package Struktur_Data;

/**
 *
 * @author M.BAHRIL.I
 */
public class Data_ArrayMulti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [][] xData = {{0,2,0},{3,9,9}}; 
        int [][] yData = {{0,2,0},{3,9,9}}; 
        System.out.println("XData");
        cetakArray(xData);
        System.out.println("YData");
        cetakArray(yData);
        
    }

    private static void cetakArray(int[][] array) {
        for (int baris = 0; baris < array.length; baris++) {
            for (int kolom = 0; kolom < array.length; kolom++) {
                System.out.printf("%d ", array[baris][kolom]);  
            }
            System.out.println("\n");
        }
    }
}
