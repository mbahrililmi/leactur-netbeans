
package polimorpis;

/**
 *
 * @author M.BAHRIL.I
 */
public class Harimau extends genusKucingBesar{
    public Harimau(){
        size = 20;
        int kecepatan = 10;
        double lompat = 5;
    }
    public void bergerak(){
        System.out.println("Harimau berjalan kemudian berlari ."
                + "\n\'ini dari kelas Harimau\'");
    }
    public void bergerakK(float kecepatan){
        System.out.println("Berlari kencang "+kecepatan+" max");
    }
    public void bergerakL(double lompat){
        int menerkam = 20;
        System.out.println("Melompat tinggi " + lompat+" max"+"     Kekuatan menerkam = "+menerkam+" max");
    }
    public void cetakUkuranHr(){
        System.out.println("Harimau \t"+size);
    }
}
