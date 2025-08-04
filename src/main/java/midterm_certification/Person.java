package midterm_certification;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private double money;
    private List<Product> bag;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.bag = new ArrayList<>();
    }

    // Геттеры и сеттеры с валидацией
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.trim().length() < 3) {
            throw new IllegalArgumentException("Имя не может быть пустым или короче 3 символов!");
        }
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными!");
        }
        this.money = money;
    }

    public List<Product> getBag() {
        return new ArrayList<>(bag);
    }

    public boolean canAfford(Product product) {
        return money >= product.getPrice();
    }

    public void addToBag(Product product) {
        if (canAfford(product)) {
            bag.add(product);
            money -= product.getPrice();
            System.out.printf("%s купил %s\n", name, product.getName());
        } else {
            System.out.printf("%s не может позволить себе %s\n", name, product.getName());
        }
    }

    @Override
    public String toString() {
        if (bag.isEmpty()) {
            return name + ": Ничего не куплено";
        }
        return name + ": " + bag.toString() + ", осталось денег: " + String.format("%.2f", money) + " руб.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(person.money, money) == 0 &&
                Objects.equals(name, person.name) &&
                Objects.equals(bag, person.bag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, bag);
    }
}
