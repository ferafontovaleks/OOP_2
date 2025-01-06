import java.util.Scanner;

public class Problem2 {
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = sc.nextLine();
        System.out.println(str.charAt(str.length() / 2 - 1) + "" + str.charAt(str.length() / 2));
    }
}
