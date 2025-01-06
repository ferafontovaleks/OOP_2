public class Main {
    public static void main(String[] args) {

        Phone phone1 = new Phone("+79326438374", "Point");
        Phone phone2 = new Phone("+79326437894", "Lol", 0.15);
        Phone phone3 = new Phone("+79118234811", "SuperPhone",1.0);

        phone1.infoPhone(phone1);
        phone2.infoPhone(phone2);
        phone3.infoPhone(phone3);

        phone1.receiveCall("Ванька");
        System.out.println("Номер 1 телефона: " + phone1.getNumber());
        phone2.receiveCall("Анастасия");
        System.out.println("Номер 2 телефона: " + phone2.getNumber());
        phone3.receiveCall("Сергей Владимирович");
        System.out.println("Номер 3 телефона: " + phone3.getNumber());

        phone1.receiveCall("Владислав", "+79631454259");

        phone1.sendMessage("+79468485341", "+79669583421");

        Reader[] readers = new Reader[]{
                new Reader("Вдовин В. В.", "48539", "ФМИИТ", "2005-31-05", "+7954734142"),
                new Reader("Мулюгин А. Д.", "00000", "ФМИИТ", "2005-07-13", "+19434612353")
        };
        readers[0].takeBook(3);
        readers[0].takeBook("Колобок", "Репка", "Линейная алгебра");
        readers[1].takeBook(new Book("Идиот", "Ф. М. Достоевский"), new Book("Капитанская дочка", "А.С. Пушкин"), new Book("Дубровский", "А.С. Пушкин"));
    }
}