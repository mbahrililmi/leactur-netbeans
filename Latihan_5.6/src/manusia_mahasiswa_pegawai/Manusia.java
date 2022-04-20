package manusia_mahasiswa_pegawai;

/**
 *
 * @author M.BAHRIL.I
 */
public class Manusia {
    String nama,divisi;
    int usia, gaji, potongan;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //casting
        Object obj = new Mahasiswa("Niska","",26,0,0);
        if(obj instanceof Mahasiswa){
            Mahasiswa Mhs1=(Mahasiswa)obj;
            Mhs1.panggilCetak();
        }
        Pegawai p1=new Pegawai("Arsyad","Supv",23,1000,20);
        p1.panggilMetodeHitung();
        }
public  Manusia (String vnama, String vdivisi, int vusia, int vgaji, int vpotongan){
    nama=vnama; divisi=vdivisi; usia=vusia; gaji=vgaji; potongan=vpotongan;}

    public void setNama(String Newnama){
        nama=Newnama;
    }
    public void setDivisi(String Newdivisi){
        divisi=Newdivisi;
    }
    public void setUsia(int Newusia){
        usia=Newusia;
    }
    public void setGaji(int Newgaji){
        gaji=Newgaji;
    }
    public void setPotongan(int Newpotongan){
        potongan=Newpotongan;
    }
}
 
  

