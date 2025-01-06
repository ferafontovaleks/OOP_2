public class Reader {
    private String name;
    private String readerId;
    private String faculty;
    private String birthday;
    private Phone phone;

    public Reader(String name, String readerId, String faculty, String birthday, String number) {
        this.name = name;
        this.readerId = readerId;
        this.faculty = faculty;
        this.birthday = birthday;
        this.phone = new Phone(number);
    }

    public void takeBook(int numbers) {
        System.out.println(this.name + " взял " + numbers + " книг");
    }

    public void takeBook(String... bookTitles) {
        System.out.print(this.name + " взял следующие книги: ");
        System.out.println();
        for (String book : bookTitles) {
            System.out.println(book);
        }
    }

    public void takeBook(Book... bookTitles) {
        System.out.print(this.name + " взял следующие книги: ");
        System.out.println();
        for (Book book : bookTitles) {
            System.out.println(book.getTitle());
        }
    }

    public void returnBook(String... bookTitles) {
        System.out.print(this.name + " вернул следующие книги: ");
        for (String book : bookTitles) {
            System.out.println(book + ", ");
        }
    }

    public void returnBook(Book... bookTitles) {
        System.out.print(this.name + " вернул следующие книги: ");
        for (Book book : bookTitles) {
            System.out.println(book.getTitle() + ", ");
        }
    }
}