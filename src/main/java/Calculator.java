import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    ArrayList<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void aboutProduct(){
        scanner.useLocale(Locale.ENGLISH);
        System.out.println("Введите название товара");
        String name = scanner.nextLine();
        double price;
        while (true) {
            System.out.println("Введите стоимость товара в формате: рубли.копейки");
            try {
                price = scanner.nextDouble();
                if (price < 0) {
                    System.out.println("Цена не может быть отрицательной!");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Цена должна являться неотрицательным числом!");
                scanner.nextLine();
            }
        }
        products.add(new Product(name, price));
        System.out.println("Продукт успешно добавлен!");
        scanner.nextLine();
    }

    public void result(int guests) {
        System.out.println("Добавленные товары:");
        Iterator<Product> iterator = products.iterator();
        Double sum = 0.00;
        while (iterator.hasNext()) {
            Product current = iterator.next();
            String out = String.format("%s : %.2f руб.",current.name, current.price);
            sum += current.price;
            System.out.println(out);
        }
        sum = sum / guests;
        System.out.println("Итого с человека: " + Formatter.formatRubles(sum));
    }
}