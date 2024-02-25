package ToyShop;

import ToyShop.Toy;

import java.util.Comparator;

public class ToyComparator implements Comparator<Toy> {
    @Override
    public int compare(Toy toy1, Toy toy2) {
        return Integer.compare(toy1.getFrequency(), toy2.getFrequency());
    }
}
