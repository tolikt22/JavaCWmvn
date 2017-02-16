import java.util.Scanner;

public class Calc_1 {
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int i =sc.nextInt();
        String a = sc.next();
        int j =sc.nextInt();
        if(a.equals("/")) {
            System.out.print(i / j);
        }
        if(a.equals("*")){
            System.out.print(i*j);
        }
        if(a.equals("-")) {
            System.out.print(i - j);
        }
        if(a.equals("+")) {
            System.out.print(i + j);
        }

    }
}
