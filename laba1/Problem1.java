public class Problem1 {
    public static void solve(){
        for (int i = 0; i <= 300; i++) {
            if ((i % 4 == 0) && (i % 6 != 0)) {
                int k = i, s = 0;

                while (k != 0) {
                    s += k % 10;
                    k /= 10;
                }

                if (s < 10) System.out.print(i + " ");
            }
        }
    }
}
