package ToyShop;

import java.util.Objects;

public class Toy implements Comparable<Toy>{
    private final int id;
    private final String name;
    private int frequency;

    public Toy(int id, String name, int frequency) {
        this.id = id;
        this.name = name;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", frequency=" + frequency +
                '}';
    }


    @Override
    public int compareTo(Toy o) {
        return Integer.compare(o.frequency, this.frequency);
    }

}
