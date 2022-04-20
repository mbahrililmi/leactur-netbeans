
package Manipulasi_arrat2D;

/**
 *
 * @author M.BAHRIL.I
 */
public class duaDimensi_array {
    private String MataKuliah = "";
    private int[][] nilaiUjian;
    
    public duaDimensi_array(String nama, int[][] nilaiUjian){
        this.nilaiUjian= nilaiUjian;
        this.MataKuliah= nama;
    }
    
    public void setMataKuliah(String nama){
        MataKuliah=nama;
    }
    
    public  String getMataKuliah(){
        return MataKuliah;
    }
    
    public void tampilPesan(){
        System.out.println("Jurnal Penilaian Kelas pada Mata Kuliah:\n" + MataKuliah);
        System.out.print("              ");
        for (int test = 0; test < nilaiUjian.length; test++) {
            System.out.printf("Tugas ke -%d", test +1);
        }
        System.out.println("    Rata-rata");
        for (int mahasiswa = 0; mahasiswa < nilaiUjian.length; mahasiswa++) {
           System.out.printf("Mahasiswa %2d\t", mahasiswa +1);
            for (int test: nilaiUjian[mahasiswa]){
                System.out.printf("%15d", test);
            }
            double average = prosesRata2 (nilaiUjian[mahasiswa]);
            System.out.printf("%9.2f\n", average);
        }
        tampilJural();
    }
    
    public void tampilJural(){
         System.out.printf("\n%s %d\n%s %d\n\n", 
                 "Nilai rendah ", prosesMinimum(),
                 "Nilai tinggi ", prosesMaxsimum());
    }
    
    public  double prosesRata2(int[] setNilai){
       int total =0;
       for (int grade : setNilai){
           total += grade;
       }
       return (double) total/setNilai.length;
    }
    
    public int prosesMinimum(){
        int nilairendah = nilaiUjian[0][0];
        for (int[] nilaiMhs : nilaiUjian){
            for (int grade : nilaiMhs)
            if (grade<nilairendah){
                nilairendah= grade;
            }
        }
        return nilairendah;
    }
    
    public int prosesMaxsimum() {
        int nilaitinggi = nilaiUjian[0][0];
        for (int[] nilaiMhs : nilaiUjian){
            for(int grade : nilaiMhs){
            if (grade > nilaitinggi){
                nilaitinggi = grade;
            }
        }
    }
        return nilaitinggi;
    
}
}
