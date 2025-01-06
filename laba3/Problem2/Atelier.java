package Problem2;

public class Atelier {
    public void dressMen(Clothes[] clothesArray) {
        for (Clothes clothes : clothesArray) {
            if (clothes instanceof MenClothes) {
                ((MenClothes) clothes).DressMen();
            }
        }
    }

    public void dressWomen(Clothes[] clothesArray){
        for(Clothes clothes:clothesArray){
            if(clothes instanceof WomenClothes){
                ((WomenClothes) clothes).DressWomen();

            }
        }
    }
}