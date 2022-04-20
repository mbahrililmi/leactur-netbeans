
package polimorpis;

/**
 *
 * @author M.BAHRIL.I
 */
public class Jaguar extends genusKucingBesar{
    public Jaguar(){
        size =10.2;
    }
    public void bergerak(){
        System.out.println("Harimau berjalan kemudian berlari .+"
                + "\n\'ini dari kelas Harimau\'");
    }
    public void cetakUkuranJg(){
        System.out.println("Harimau \t"+size);
    }
}
