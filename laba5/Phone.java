public class Phone {
    private String number;
    private String model;
    private double weight;

    Phone() {
        this.number = "";
        this.model = "";
        this.weight = 0.0;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number) {
        this.number = number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return this.number;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return this.weight;
    }

    public void infoPhone(Phone phone) {
        System.out.println("Number: " + this.number + ", Model: " + this.model + ", Weight: " + this.weight);
    }

    public void receiveCall(String nameCaller) {
        System.out.println("Звонит: " + nameCaller);
    }

    public void receiveCall(String nameCaller, String callerNumber) {
        System.out.println("Звонит: " + nameCaller + " , Номер " + callerNumber);
    }

    public void sendMessage(String... phoneNumbers) {
        System.out.println("Сообщение отправлено:");
        for (String number : phoneNumbers) {
            if (number.length() == 12)
                System.out.println(number);
            else
                System.out.println("Нет такого номера.");
        }
    }
}