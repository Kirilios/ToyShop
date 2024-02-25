package ToyShop;

public class Toy implements Comparable<Toy>{
    private final int id;
    private final String name;
    int frequency;

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

    @Override
    public int compareTo(Toy o) {
        return Integer.compare(o.frequency, this.frequency);
    }

}
