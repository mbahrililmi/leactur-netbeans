package OOP_Metode_Konsep;


/**
 *
 * @author 
 */
public class Manusia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Mahasiwa mh1 = new Mahasiwa("M.BAHRIL ILMI", 0);
        mh1.panggilCetak();
            System.out.println("OOP Metode Konsep Setter Nama dan Usia)");
        mh1.setNama("BAHRIL");
        mh1.setUsia(20);
        mh1.panggilCetak();
        
    } 

    private static class pgl {

        private static int potongan;
        private static String divisi;

        public pgl() {
        }
    }
}
