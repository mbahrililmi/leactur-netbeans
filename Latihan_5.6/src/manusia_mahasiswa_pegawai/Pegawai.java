
package manusia_mahasiswa_pegawai;

/**
 *
 * @author M.BAHRIL.I
 */
public class Pegawai extends Manusia{
    public Pegawai(String vnama, String vdivisi, int vusia, int vgaji, int vpotongan){super(vnama,vdivisi,vusia,vgaji,vpotongan);
    }
    public void panggilMetodeHitung(){
        System.out.println("Nama \t"+nama+"\ndivisi \t"+divisi+"\nusia\t"+usia+"\ngaji\t"+gaji+"\nptotongan \t"+"("+potongan+")\t\nGahi Bersih = \t"+(gaji-potongan)+"");
    }
}
