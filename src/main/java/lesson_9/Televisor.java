package lesson_9;

public class Televisor {
    private String color;
    private String screen;
    private int diagonal;
    double price;
    private String model;
    private String brand;
    private int chanelCount;
    static Boolean state = false;

    public Televisor(String color, String screen, int diagonal,
                     double price, String model, String brand, int chanelCount) {
        this.color = color;
        this.screen = screen;
        this.diagonal = diagonal;
        this.price = price;
        this.model = model;
        this.brand = brand;
        this.chanelCount = chanelCount;
    }

    String getColor(){
        return  this.color;
    }
     void setColor(String newColor){
         this.color = newColor;
    }

    String getScreen(){
        return this.screen;
    }
    void getScreen(String newScreen){
        this.screen = newScreen;
    }

    int getDiagonal(){
        return this.diagonal;
    }

    void setDiagonal(int newDiagonal){
        this.diagonal = newDiagonal;
    }
    double getPrice(){
        return this.price;
    }
    void setPrice(double newPrice){
        this.price = newPrice;
    }
    String getModel(){
        return this.model;
    }
    void setModel(String newModel){
        this.model = newModel;
    }
    String getBrand(){
        return this.brand;
    }
    void setBrand(String newBrand){
        this.brand = newBrand;
    }
    int getChanelCount(){
        return this.chanelCount;
    }
    void setChanelCount(int newChanelCount){
        this.chanelCount = newChanelCount;
    }

    public String  turnOnOff(int number) {
        String turn = "";

        switch (number) {
            case 0:
                turn = "Выключен. До скорых встреч. Ваш"+ this.brand;
                break;
            default:
                turn = "Включен. Приятного просмотра";
        }
        return turn;




    }
    double discount(double discount){
//        setPrice(this.price);
//
//        return  ;

        return this.price = this.price* (1-discount/100);

//        this.price = this.price*  (1-discount/100);
    }
    void info(){
        System.out.println(
                this.brand +" "+ this.model + " стоит " + String.format("%.3f", this.price)+"рублей"
        );
    }

}









