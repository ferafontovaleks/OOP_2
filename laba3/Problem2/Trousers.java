package Problem2;

public class Trousers extends Clothes implements MenClothes, WomenClothes{
    public Trousers(Size size, int price, Color color) {
        super(size, price, color);
    }

    public Trousers(){
        super();
    }
    @Override
    public void DressMen(){
        System.out.println("Мужчина одет в брюки, " + "цвет - " + getColor() + ", размер - " + getSize() + ", цена - " + getPrice());
    }
    @Override
    public void DressWomen(){
        System.out.println("Женщина одета в брюки, " + "цвет - " + getColor() + ", размер - " + getSize() + ", цена - " + getPrice());
    }
}