/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOP_Parameter;

/**
 *
 * @author M.BAHRIL.I
 */
public class Parameter_Multi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /**
     * Proses Overloaded konstruktor
     * langkah2
     * memanggil class (class data2)
     * membuat sebuak member objek
     * menggunakan kata kunci = new kemudian pilih konstruktor
     * ..
     * dengan demikian passing parameter(pesan) dapat disesuaikan
     * dengan banyaknya penampungan parameter didalam konstruktor.
     */
        Data2 p0 = new Data2();
        Data2 H1 = new Data2(true);
        Data2 P2 = new Data2("M. BAHRIL ILMI",18630762,"HKSN KOMP SURYA GEMILANG","REG 4C PAGI BJM","081350375976 \n");
        Data2 P3 = new Data2("NOVIYANTI",19630001, "BANJARMASIN", "REG 2C BJM PAGI", "081350375976");
    }
    
}
