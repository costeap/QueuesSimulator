import java.util.Comparator;

public class SortareTimpSosire implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        return o1.tArrival - o2.tArrival;
    }
}

