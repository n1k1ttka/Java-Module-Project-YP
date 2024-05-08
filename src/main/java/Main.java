import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("На какое количество человек разделить счёт?");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input == 1) {
                    System.out.println("Нет смысла ничего считать и делить");
                    System.out.println("Пожалуйста введите значение больше единицы");
                } else if (input < 1) {
                    System.out.println("Это некорректное значение для подсчёта");
                    System.out.println("Пожалуйста введите корректное значение для подсчёта");
                } else {
                    Calculator calculator = new Calculator();
                    while (true) {
                        calculator.aboutProduct();
                        System.out.println("Хотите ли вы ввести еще один товар?");
                        String thatsAll = scanner.next();
                        if (thatsAll.equalsIgnoreCase("завершить")) break;
                    }
                    calculator.result(input);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введены некорректные символы, пожалуйста введите целое число больше 1!");
                scanner.next();
            }
        }
    }
}