package Aritmatika;

import java.util.Scanner;

/**
 *
 * @author M.BAHRIL.I
 */
public class OP_Aritmatika {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float angkain1 = 0;
        float angkain2 = 0;
        float total = 0;
        byte opsi = 0;

        Scanner inputan = new Scanner(System.in);
        
        System.out.println("Inputkan Angka Pertama = ");
        angkain1 = inputan.nextByte();
        System.out.println("Inputkan Angka Kedua = ");
        angkain2 = inputan.nextByte();
        System.out.println("Pilihan Menu Operator Aritmatika \n 1(+) : 2(-) : 3(*) : 4(/) : 0 ( Keluar )");
        opsi = inputan.nextByte();
        switch (opsi){
            case 0:
                System.out.println("Keluar");
                break;
            case 1:
                total = (byte)(angkain1+angkain2);
                System.out.println("Total = " + total);
                break;
            case 2:
                total = (byte)(angkain1-angkain2);
                System.out.println("Total = " + total);
                break;
            case 3:
                total = (byte)(angkain1*angkain2);
                System.out.println("Total = " + total);
                break;
            case 4:
                total = (float)(angkain1/angkain2);
                System.out.println("Total = " + total);
                break;
                default:
                
            }
        }
    }


