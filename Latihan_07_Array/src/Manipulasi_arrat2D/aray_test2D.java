
package Manipulasi_arrat2D;

/**
 *
 * @author M.BAHRIL.I
 */
public class aray_test2D {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [][] NilaiArray ={
            {87, 96, 70},
            {68, 57, 90},
            {94, 100, 90},
            {100, 81, 82},
            {83, 65, 85},
            {50, 87, 65},
            {85, 50, 83},
            {71, 94, 90},
            {76, 72, 54},
            {70, 93, 63}};
        duaDimensi_array n2 = new duaDimensi_array("PBO1", NilaiArray);
        n2.tampilPesan();
    }
    
}
