
package Multi_Exception;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author M.BAHRIL.I
 */
public class Contoh_Exception {

    public static int Div(int BilAwal, int bilpembagi){
        return BilAwal / bilpembagi;
    }
    public static void main(String[] args) {
        try{
        Scanner scanner = new Scanner (System.in);
        System.out.print("Input bilangan integer awal: ");
        int a = scanner.nextInt();
        System.out.print("Input integer pembagi: ");
        int b = scanner.nextInt(); // apabila pembagi = text 'hallo' ??
        int result = Div(a,b);
        System.out.printf("\nResult: %d / %d = %d\n", a,b,result);
        } catch(ArithmeticException ar){
             System.out.println("Pembagi = 0 tidak dapat bisa di lanjutkan ataupun diproses");
        } catch(InputMismatchException inputansalah){
            System.out.println("inputan" + inputansalah);
    }    
    }
} 

