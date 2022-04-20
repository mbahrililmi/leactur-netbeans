
package Switch_Case;

/**
 *
 * @author M.BAHRIL.I
 */
public class Switch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        byte nilai = 3;
        switch (nilai){
            case 10:
                System.out.println("Baik sekali");
                break;
            case 9:
            case 8:
            case 7:
                System.out.println("Baik");
                break;
            case 6:
                System.out.println("Cukup");
                break;
            case 5:
            case 4:
            case 3:
                System.out.println("Kurang");
                break;
                default:
                    System.out.println("Tidak ada grade");
        }
        System.out.println("Nilai Anda " + nilai);
    }
    
}
