package OOP_Metode_Konsep;

/**
 *
 * @author 
 */
class Mahasiwa {

    String nama;
    int usia;

public void panggilCetak(){
    System.out.println("nama\t"+nama+"\nusia \t"+usia);
}

    public Mahasiwa(String nama, int usia) {
        this.nama = nama;
        this.usia = usia;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public String getNama() {
        return nama;
    }

    public int getUsia() {
        return usia;
    }


}
