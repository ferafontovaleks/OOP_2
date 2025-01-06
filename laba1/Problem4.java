import java.util.Locale;
import java.util.Scanner;

public class Problem4 {
    public static void solve() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = sc.nextLine() + " ";
        String current = "";
        int k = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') current += str.charAt(i);
            else {
                int l = 0;
                current = current.toLowerCase();
                for (int j = 0; j < current.length(); j++)
                    if ((current.charAt(j) >= 'a') && (current.charAt(j) <= 'z')) l++;
                if (l == current.length()) k++;
            }
        }
        System.out.println(k);
    }
}