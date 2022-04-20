
package manusia_mahasiswa_pegawai;

/**
 *
 * @author M.BAHRIL.I
 */
public class Mahasiswa extends Manusia{
    public Mahasiswa(String vnama,String vdivisi, int vusia, int vgaji, int vpotongan){
        super(vnama, vdivisi, vusia, vgaji, vpotongan);
    }
    public void panggilCetak(){
        System.out.println("Nama \t"+nama+"\nUssia\t"+usia+"\n");
    }
}