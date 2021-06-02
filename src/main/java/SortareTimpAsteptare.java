import java.util.Comparator;

public class SortareTimpAsteptare implements Comparator<Client> {

    @Override
    public int compare(Client o1, Client o2) {
        if (o1.tArrival == o2.tArrival)
            return o1.tService - o2.tService;
        else
            return 0;
    }
}
