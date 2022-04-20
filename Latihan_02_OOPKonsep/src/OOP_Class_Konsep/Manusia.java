package OOP_Class_Konsep;

/**
 *
 * @author 
 */
public class Manusia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mahasiwa Mhs1 = new Mahasiwa();
        Mahasiwa Mhs2 = new Mahasiwa();
        Mhs1.nama = "M. BAHRIL ILMI";
        Mhs1.usia = 19;
        Mhs2.nama = "NOVIYANTI PUTRI WIDHAYANI";
        Mhs2.usia = 20;
        System.out.println("Mahasiswa 1");
        System.out.println("Nama \t" +Mhs1.nama +"\nUsia \t "+Mhs1.usia );
        System.out.println("Mahasiswa 2");
        System.out.println("Nama \t" +Mhs2.nama +"\nUsia \t "+Mhs2.usia );
    }
    
}
