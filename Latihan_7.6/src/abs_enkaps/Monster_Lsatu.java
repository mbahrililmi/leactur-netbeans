
package abs_enkaps;

/**
 *
 * @author M.BAHRIL.I
 */
public abstract class Monster_Lsatu {
    private String nama, lokasi;
    private double demage = 10.15;
   
public Monster_Lsatu (String nama, String lokasi){
    this.nama=nama;
    this.lokasi=lokasi;
    this.demage=demage;
    }
public void cek_index(){
    System.out.println("Monster Level satu Koordinat lokasi"+this.lokasi);
    System.out.println(this.nama+"Demage"+this.demage+"\tOn Game== tersedia");
}
public String toString(){
   return nama + ""+lokasi+""+demage; 
}
public String getNama(){
    return nama;
}
public String getLokasi(){
    return lokasi;
}
public double getDemage(){
    return demage;
}
}

