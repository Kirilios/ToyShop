package ToyShop;

import java.util.PriorityQueue;

public class ToyQueue {
    static PriorityQueue<Toy> toyQueue = new PriorityQueue<>(new ToyComparator());

    public void put(int id, String name, int frequency) {
        Toy newToy = new Toy(id, name, frequency);
        toyQueue.add(newToy);
    }
    public void setFrequency(int toyId, int newFrequency) {
        for (Toy toy : toyQueue) {
            if (toy.getId() == toyId) {
                toy.frequency = newFrequency;
                toyQueue = new PriorityQueue<>(toyQueue);
                break;
            }
        }
    }
}
