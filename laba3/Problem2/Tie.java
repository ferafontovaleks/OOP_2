package Problem2;

public class Tie extends Clothes implements MenClothes{
    public Tie(Size size, int price, Color color) {
        super(size, price, color);
    }

    public Tie(){
        super();
    }
    @Override
    public void DressMen(){
        System.out.println("Мужчина одет в галстук, " + "цвет - " + getColor() + ", размер - " + getSize() + ", цена - " + getPrice());
    }
}