package ToyShop;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ToyQueue {
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>(new ToyComparator());
    private List<Toy> prizes = new ArrayList<>();

    public void put(int id, String name, int frequency) {
        Toy newToy = new Toy(id, name, frequency);
        toyQueue.add(newToy);
    }

    public void setFrequency(int toyId, int newFrequency) {
        for (Toy toy : toyQueue) {
            if (toy.getId() == toyId) {
                toy.setFrequency(newFrequency);
                break;
            }
        }
    }

    public void addPrizeToy() {
        if (!prizes.isEmpty()) {
            Toy prizeToy = prizes.remove(0);
            decreaseToyCount(prizeToy.getId());
        } else {
            System.out.println("Больше нет призов.");
        }
    }

    public List<Toy> getPrizes() {
        return prizes;
    }

    public void getPrizeToy() {
        if (!prizes.isEmpty()) {
            Toy prizeToy = prizes.remove(0);
            decreaseToyCount(prizeToy.getId());
            System.out.println("Вы получили призовую игрушку: " + prizeToy.getName());
        } else {
            System.out.println("Нет больше призовых игрушек.");
        }
    }

    public void writePrizeToFile(Toy prizeToy) {
        try (FileWriter writer = new FileWriter("results.txt", true)) {
            writer.write("Игрушка - ID: " + prizeToy.getId() +
                    ", Name: " + prizeToy.getName() +
                    ", Frequency: " + prizeToy.getFrequency() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decreaseToyCount(int toyId) {
        for (Toy toy : toyQueue) {
            if (toy.getId() == toyId && toy.getFrequency() > 0) {
                toy.setFrequency(toy.getFrequency() - 1);
                if (toy.getFrequency() == 0) {
                    prizes.add(toy);
                }
                break;
            }
        }
    }

    public void printPrizeToys() {
        if (!toyQueue.isEmpty()) {
            System.out.println("Игрушки в очереди:");
            for (Toy toy : toyQueue) {
                System.out.println("ID: " + toy.getId() +
                        ", Name: " + toy.getName() +
                        ", Frequency: " + toy.getFrequency());
            }
        } else {
            System.out.println("Очередь игрушек пуста.");
        }

        if (!prizes.isEmpty()) {
            System.out.println("Призовые игрушки:");
            for (Toy toy : prizes) {
                System.out.println("ID: " + toy.getId() +
                        ", Name: " + toy.getName() +
                        ", Frequency: " + toy.getFrequency());
            }
        } else {
            System.out.println("Нет призовых игрушек.");
        }
    }

    // Remove toys from toyQueue after processing each round
    public void removeProcessedToys() {
        toyQueue.removeIf(toy -> toy.getFrequency() == 0);
        prizes.removeIf(toy -> toy.getFrequency() == 0);
    }
}

