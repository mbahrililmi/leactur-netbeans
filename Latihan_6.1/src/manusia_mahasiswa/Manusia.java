
package manusia_mahasiswa;

/**
 *
 * @author M.BAHRIL.I
 */
public class Manusia {
    String nama, divisi;
    int usia, gaji, potongan;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa();
        mhs1.nama="M.BAHRIL ILMI";
        mhs1.usia=20;
        mhs1.panggilCetak();
        mhs1.pokok=1000;
        mhs1.gpokok();
        mhs1.gbersih();
        
        
        
    }
    
}
