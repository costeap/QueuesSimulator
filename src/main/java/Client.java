public class Client  {
    public int id;
    public int tArrival;
    public int tService;

    public Client(int id, int tArrival, int tService) {
        this.id = id;
        this.tArrival = tArrival;
        this.tService = tService;
    }

    public int getId() {
        return id;
    }

    public int gettArrival() {
        return tArrival;
    }

    public int gettService() {
        return tService;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void settArrival(int tArrival) {
        this.tArrival = tArrival;
    }

    public void settService(int tService) {
        this.tService = tService;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", tArrival=" + tArrival +
                ", tService=" + tService +
                '}';
    }

}
