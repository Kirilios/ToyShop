package ToyShop;

import java.io.FileWriter;
import java.io.IOException;

public class ToyService {

    public static void main(String[] args) {
        ToyQueue toyQueue = new ToyQueue();
        RandomToy randomToy = new RandomToy();

        toyQueue.put(1, "конструктор", 2);
        toyQueue.put(2, "робот",2);
        toyQueue.put(3, "кукла", 3);

        toyQueue.setFrequency(2,5);

        String filename = "results.txt";

        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < 10; i++) {
                int weight = randomToy.getRandomToy();
                String result = randomToy.getRandomToy(weight);
                System.out.println("Магазин игрушек поздравляет вас, Пользователь " + (i + 1) + ": " + result);
                writer.write("Магазин игрушек поздравляет вас, Пользователь " + (i + 1) + ": " + result + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
