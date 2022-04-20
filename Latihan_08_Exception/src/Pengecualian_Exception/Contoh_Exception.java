
package Pengecualian_Exception;

/**
 *
 * @author M.BAHRIL.I
 */
public class Contoh_Exception {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        byte xArray[] = {1,2,3,4,5,6,7,8,9,0};
        System.out.println("Tampilkan nilai element index ke 1\t" + xArray[1]);
        
        String kata = "5";
            System.out.println(kata.length());
        int angka = Integer.parseInt (kata);  
            System.out.println ("Angka \t" + angka);
    }catch (ArrayIndexOutOfBoundsException out){
        System.err.println("diluar rentang xAray");
    }catch (NullPointerException panjangkata){
       System.out.println("Panjang kata null");
    }catch (NumberFormatException parse){
        System.out.println("Bukan bilangan integer");
    }
}
}