import java.util.Scanner;

public class Problem3 {
    public static void solve(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String str = sc.nextLine() + " ";

        String current = "";
        int min = Integer.MAX_VALUE;
        String word = "";

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != ' ') current += str.charAt(i);
            else{
                char[] arr = new char[current.length()];

                for(int j = 0; j < current.length(); j++)
                    arr[j] = ' ';

                for (int j = 0; j < current.length(); j++){
                    for(int k = 0; k < current.length(); k++) {
                        if (arr[k] == ' ')
                            arr[k] = current.charAt(j);
                        if (arr[k] == current.charAt(j)) break;
                    }
                }
                int c = 0;
                for(int j = 0; j < current.length(); j++)
                    if (arr[j] != ' ') c++;
                if (c < min) {min = c; word = current;}
                current = "";
            }
        }
        System.out.println(word);
    }
}
