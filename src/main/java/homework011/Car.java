package homework011;

public class Car {
    // Поля с модификатором private
    private String number;
    private String model;
    private String color;
    private int mileage;
    private double price;

    // Конструктор
    public Car(String number, String model, String color, int mileage, double price) {
        this.number = number;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    // Геттеры и сеттеры
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    // Переопределение метода toString
    @Override
    public String toString() {
        return "Car{" +
                "number='" + number + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
