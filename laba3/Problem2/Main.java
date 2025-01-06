package Problem2;

public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {new Skirt(Size.XS, 1500, Color.GREEN), new TShirt(Size.L, 3500, Color.BLACK),
                new Trousers(Size.M, 1200, Color.BLUE), new Tie()};

        Atelier atelier = new Atelier();
        System.out.println("Одеваем женщину");
        atelier.dressWomen(clothes);
        System.out.println();
        System.out.println("Одеваем мужчину");
        atelier.dressMen(clothes);
    }
}