package ToyShop;

import java.util.Random;

public class RandomToy {

    public int getRandomToy() {
        Random random = new Random();
        int randomValue = random.nextInt(100);

        if (randomValue < 20) {
            return 1;
        } else if (randomValue < 40) {
            return 2;
        } else {
            return 3;
        }

    }

    public String getRandomToy(int weight) {
        switch (weight) {
            case 1:
                return "конструктор " + weight;
            case 2:
                return "робот " + weight;
            case 3:
                return "кукла " + weight;
            default:
                return "неизвестная игрушка";
        }
    }
}
