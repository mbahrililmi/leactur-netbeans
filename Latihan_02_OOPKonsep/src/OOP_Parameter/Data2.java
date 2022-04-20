
package OOP_Parameter;

/**
 *
 * @author M.BAHRIL.I
 */
class Data2 {
    
    Data2(){
        
    }
    
    Data2(boolean Hasil){
        System.out.println("Hasil " + Hasil);
        
    }
    //ciri utama konstruktor
    //tidak memiliki nilai balik(return,kata kunci void
    // sama dengan nama kelas
    //
    Data2(String nama, int npm, String alamat, String kelas, String nohp) {
        System.out.println("Nama " + nama);
        System.out.println("NPM " + npm);
        System.out.println("Alamat " + alamat);
        System.out.println("Kelas " + kelas);
        System.out.println("Contac " + nohp);
        
    }
    
}
