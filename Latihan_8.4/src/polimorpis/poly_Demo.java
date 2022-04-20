
package polimorpis;

/**
 *
 * @author M.BAHRIL.I
 */
public class poly_Demo {
    public static void main(String[] args) {
        genusKucingBesar b = new genusKucingBesar();
        System.out.println(b.size);
        Jaguar j = new Jaguar();
        j.cetakUkuranJg();
        Harimau hr = new Harimau();
        hr.cetakUkuranHr();
        hr.bergerakgkb();
        hr.bergerak();
        hr.bergerakK(10f);
        hr.bergerakL(5d);
    }
    
}
