
package Manipulasi_Array;

/**
 *
 * @author M.BAHRIL.I
 */
public class NilaiUjian_array {
    private String MataKuliah="";
    private int []nilaiUjian;

    public NilaiUjian_array(String nama, int[] nilaiUjian) {
        this.nilaiUjian = nilaiUjian; //inisialisasi nilai ujian
        this.MataKuliah = nama; //inisialisasi mata kuliah
    }

    public void setMataKuliah(String nama) {
        MataKuliah = nama;
    }

    public String getMataKuliah() {
        return MataKuliah;
    }
    
    public void tampilPesan(){
        System.out.println("Selamat datang dijural Penilaian kelas ");
        prosesUjian();
        System.out.printf("\n Nilai Rata2 kelas %.2f\n", prosesRatarata());
        System.out.printf("Nilai Tertinggi %d\n Nilai Rendah %d\n\n", prosesMaksimum(),prosesMinimum());
    }
    
    public void prosesUjian(){
        System.out.println("Jurnal Nilai");
        for (int mahasiswa = 0; mahasiswa < nilaiUjian.length; mahasiswa++) {
            int i = nilaiUjian[mahasiswa];
            System.out.printf("Mahasiswa %2d: %3d\n", mahasiswa +1, nilaiUjian[mahasiswa]);
            
        }
    }
    
    public  double prosesRatarata(){
       int total =0;
       for (int grade : nilaiUjian){
           total += grade;
       }
       return (double) total/nilaiUjian.length;
    }
    
    public int prosesMinimum(){
        int nMin = nilaiUjian[0];
        for (int grade : nilaiUjian){
            if (grade<nMin){
                nMin = grade;
            }
        }
        return nMin;
    }
    
    public int prosesMaksimum() {
        int max = nilaiUjian[0];
        for (int grademax : nilaiUjian){
            if (grademax > max){
                max = grademax;
            }
        }
        return max;
    }
    
    
}
