package CW_1;

/**
 * Created by java-2-06 on 22.01.2017.
 */
public class Test2 {
    public static void main(String[] args) {

        String str = new String("str");
        String str1 = "str";
        System.out.println(str == str1);
        String str2 = "str";
        System.out.println(str1 == str2);

        str=str.intern();                   //меняем ссілку
        System.out.println(str==str1);

        if(str.equals(str1)){
            System.out.print(true);
        }
    }
}
