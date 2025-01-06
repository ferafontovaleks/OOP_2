package Problem2;

public abstract class Clothes {
    private Size size;
    private int price;
    private Color color;

    Clothes(Size size, int price, Color color){
        this.color = color;
        this.price = price;
        this.size = size;
    }

    Clothes(){
        this.size = Size.M;
        this.color = Color.RED;
        this.price = 1000;
    }

    public Size getSize(){
        return size;
    }
    public void setSize(Size size){
        this.size = size;
    }

    public Color getColor(){
        return color;
    }
    public void setColor(Color color){
        this.color = color;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
}
