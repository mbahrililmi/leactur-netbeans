
package ArrayList;

import java.util.ArrayList;

/**
 *
 * @author M.BAHRIL.I
 */
public class ArrayList_NamaMahasiswa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> mahasiswa = new ArrayList<String>();
            mahasiswa.add("bahril");    //0
            mahasiswa.add("novi");      //1
            mahasiswa.add("ilmi");      //3
            mahasiswa.add("yanti");     //4
            for (int i = 0; i < mahasiswa.size();  i++) {
                System.out.printf( " %s", mahasiswa.get(i));   
        }
           mahasiswa.set(0, "nemo");
           mahasiswa.remove(2);
            for (int i = 0; i < mahasiswa.size();  i++) {
                System.out.printf("\n");
                System.out.printf( " %s", mahasiswa.get(i));   
        }
          
    }
    
}
