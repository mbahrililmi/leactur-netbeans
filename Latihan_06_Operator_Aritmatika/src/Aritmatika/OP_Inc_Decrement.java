
package Aritmatika;

/**
 *
 * @author M.BAHRIL.I
 */
public class OP_Inc_Decrement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // ++, --
        /**
         * Increment ++
         * ++A disebut prefix Operator Increment
         * A++ disebut postfix Operator Increment
         * 
         * Decrement --
         * --A disebut prefix Operator Increment
         * A-- disebut postfix Operator Increment
         */
        int A = 9;
            System.out.println("Nilai A awal \t " + A);
            //uji coba prefix
            //System.out.println("prefix ++A \t " + (--A));
            //uji coba posfix inc
            System.out.println("posfix A++ \t " + (A--));
            System.out.println("A \t " + (A));
       
    }
    
}
