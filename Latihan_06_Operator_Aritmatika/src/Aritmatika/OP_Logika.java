
package Aritmatika;

/**
 *
 * @author M.BAHRIL.I
 */
public class OP_Logika {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // AND &&, OR ||, NOT !
        
        boolean A = true;
        boolean B = false;
        
        System.out.println("Nilai A = " + A + "&&" + "Nilai B " + B +"\n"+ (A&&B));
        System.out.println("Nilai A = " + A + "||" + "Nilai B " + B +"\n"+ (A||B));
        System.out.println("Nilai A = " + A + "!" + "Nilai B " + B +"\n"+ !(A&&B));
        
    }
    
}
