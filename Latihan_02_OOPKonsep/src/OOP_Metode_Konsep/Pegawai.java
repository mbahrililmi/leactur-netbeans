package OOP_Metode_Konsep;

/**
 *
 * @author 
 */
public class Pegawai {
    String nama, divisi;
    int usia, gaji, potongan;
//      int usia =0;
//      int gaji =0;
//      int potongan =0; 
    
    public void panggilMetodeHitung(){
        System.out.println("Nama \t" +nama+ "\nUsia \t" +usia+"\nGaji \t"+gaji+"\nPotongan\t"+potongan+ "\ngaji bersih = \t");
        System.out.println(gaji-potongan);
    }
}
