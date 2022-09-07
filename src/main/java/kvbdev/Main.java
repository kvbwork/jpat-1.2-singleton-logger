package kvbdev;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        try (Scanner scanner = new Scanner(System.in)) {
            logger.log("Запускаем программу");
            logger.log("Просим пользователя ввести входные данные для списка");

            System.out.print("Введите размер списка: ");
            int listSize = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите верхнюю границу для значений: ");
            int upperLimit = Integer.parseInt(scanner.nextLine());

            logger.log("Создаём и наполняем список");
            List<Integer> randomIntList = createRandomIntList(listSize, upperLimit);

            System.out.println("Вот случайный список: " + randomIntList);

            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.print("Введите порог для фильтра: ");
            int filterThreshold = Integer.parseInt(scanner.nextLine());

            logger.log("Запускаем фильтрацию");
            Filter filter = new Filter(filterThreshold);
            List<Integer> filteredIntList = filter.filterOut(randomIntList);

            logger.log("Выводим результат на экран");
            System.out.println("Отфильтрованный список: " + filteredIntList);

            logger.log("Завершаем программу");

        } catch (NumberFormatException ex) {
            logger.log("Ошибка! Некорректный ввод.7");
        }

    }

    private static List<Integer> createRandomIntList(int size, int upperLimit) {
        Random random = new Random();
        return random.ints(size, 0, upperLimit)
                .boxed()
                .collect(Collectors.toList());
    }

}
