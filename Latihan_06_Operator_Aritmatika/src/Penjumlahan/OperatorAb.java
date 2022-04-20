package Penjumlahan;

import java.util.Scanner;
//merupakan classinputan dari java

/**
 *
 * @author M.BAHRIL.I
 */
public class OperatorAb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner inputan = new Scanner(System.in);
        byte angkain1;
        byte angkain2;
        byte total = 0;
        System.out.println("Input angka pertama = ");
        angkain1 = inputan.nextByte();
        System.out.println("Input angka kedua = ");
        angkain2 = inputan.nextByte();

        total = (byte) (angkain1 + angkain2);
        System.out.println("Hasil \t" + angkain1 + " + " + angkain2 + " = " + total);

    }

}
