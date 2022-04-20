
package IF;

/**
 *
 * @author M.BAHRIL.I
 */
public class Percabangan_IFELSE_IFELSE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte i =90;
        if (i>=90) {
            System.out.println("Bebas Pertemuan Kuis");
        } 
        else if (i>=80) {
            System.out.println("Konversi Nilai A");
        } 
        else if (i>=75) {
            System.out.println("Konversi Nilai B+");
        }
        else if (i>=70) {
            System.out.println("Konversi Nilai B");
        }
        else if (i>=65) {
            System.out.println("Konversi Nilai C+");
        }
        else if (i>=60) {
            System.out.println("Konversi Nilai C");
        }
        else if (i>=50) {
            System.out.println("Konversi Nilai D");
        }
        else if (i>=1) {
            System.out.println("Konversi Nilai E");
        }
        else {
            System.out.println("Tidak Ada Nilai");
        }
    }
    
}
