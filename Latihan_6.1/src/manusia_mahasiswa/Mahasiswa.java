
package manusia_mahasiswa;

/**
 *
 * @author M.BAHRIL.I
 */
interface beasiswa{
  public void gpokok();
  public void gbersih();

}

class Mahasiswa extends Manusia implements beasiswa{
    public void panggilCetak(){
        System.out.println("Nama \t"+nama+"\nUsia \t"+usia);
    }
    public float pokok =0;
    
    @Override
    public void gpokok(){
        System.out.println(pokok+"\t merupakan gajih pokok");     
    } 
    
    @Override
    public void gbersih(){
        System.out.println(pokok-(pokok*0.25)+"\t merupakan gajih bersihnya");     
    } 
    
}
