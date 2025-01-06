package Problem2;

public class TShirt extends Clothes implements WomenClothes, MenClothes {
    public TShirt(Size size, int price, Color color) {
        super(size, price, color);
    }

    public TShirt(){
        super();
    }

    @Override
    public void DressMen() {
        System.out.println("Мужчина одет в футболку, " + "цвет - " + getColor() + ", размер - " + getSize() + ", цена - " + getPrice());
    }

    @Override
    public void DressWomen() {
        System.out.println("Женщина одета в футболку, " + "цвет - " + getColor() + ", размер " + getSize() + ", цена - " + getPrice());
    }
}