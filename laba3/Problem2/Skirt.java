package Problem2;

public class Skirt extends Clothes implements WomenClothes{
    public Skirt(Size size, int price, Color color) {
        super(size, price, color);
    }

    public Skirt(){
        super();
    }
    @Override
    public void DressWomen(){
        System.out.println("Женщина одета в юбку, " + "цвет - " + getColor() + ", размер - " + getSize() + ", цена - " + getPrice());
    }
}