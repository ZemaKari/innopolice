package homework07;

import java.time.LocalDate;
import java.util.Objects;
// наследованный клас от класса Product
public class DiscountProduct extends Product {
    private int discountPercent; // Скидка в процентах (целое число)
    private LocalDate discountEndDate;// Дата окончания скидки

    public DiscountProduct(String name, double price, int discountPercent, LocalDate discountEndDate) {
        super(name, price);
        setDiscountPercent(discountPercent);
        setDiscountEndDate(discountEndDate);
    }
// геттеры и сеттеры с валидацией
    public int getDiscountPercent() {
        return discountPercent;
    }


    public void setDiscountPercent(int discountPercent) {
        if (discountPercent < 0) {
            throw new IllegalArgumentException("Скидка не может быть отрицательной!");
        }
        if (discountPercent > 100) {
            throw new IllegalArgumentException("Скидка не может быть больше 100%!");
        }
        this.discountPercent = discountPercent;
    }

    public LocalDate getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(LocalDate discountEndDate) {
        if (discountEndDate == null) {
            throw new IllegalArgumentException("Дата окончания скидки не может быть пустой!");
        }
        if (discountEndDate.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Дата окончания скидки не может быть в прошлом!");
        }
        this.discountEndDate = discountEndDate;
    }

    /**
     * метод возвращает цену с учетом скидки в процентах
     * @return
     */

    @Override
    public double getPrice() {
        if (isDiscountActive()) {
            double discountAmount = super.getPrice() * discountPercent / 100;
            return super.getPrice() - discountAmount;
        }
        return super.getPrice();
    }

    /**
     * метод возвращает введенную скидку в процентах если скидка активна
     * @return
     */
    public double getDiscountAmount() {
        if (isDiscountActive()) {
            return super.getPrice() * discountPercent / 100;
        }
        return 0;
    }

    public double getOriginalPrice() {
        return super.getPrice();
    }

    /**
     * метод который проверяет актуальность скидки
     * @return
     */
    public boolean isDiscountActive() {
        return LocalDate.now().isBefore(discountEndDate) ||
                LocalDate.now().isEqual(discountEndDate);
    }

    @Override
    public String toString() {
        if (isDiscountActive()) {
            return String.format("%s (%.2f руб. -%d%% = %.2f руб., скидка действует до %s)",
                    getName(), getOriginalPrice(), discountPercent, getPrice(), discountEndDate);
        } else {
            return String.format("%s (%.2f руб., скидка закончилась %s)",
                    getName(), getPrice(), discountEndDate);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return discountPercent == that.discountPercent &&
                Objects.equals(discountEndDate, that.discountEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discountPercent, discountEndDate);
    }
}
