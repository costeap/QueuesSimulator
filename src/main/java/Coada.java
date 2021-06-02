import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Coada implements Runnable {
    public Thread thread;
    public int nrClienti;
    public int tInchidere;
    public AtomicInteger tAsteptare;
    public int temp;
    public List<Client> clienti = Collections.synchronizedList(new ArrayList<Client>());

    public int getNrClienti() {
        return nrClienti;
    }

    public int gettInchidere() {
        return tInchidere;
    }

    public AtomicInteger gettAsteptare() {
        return tAsteptare;
    }

    public int getTemp() {
        return temp;
    }

    public void setNrClienti(int nrClienti) {
        this.nrClienti = nrClienti;
    }

    public void settInchidere(int tInchidere) {
        this.tInchidere = tInchidere;
    }

    public void settAsteptare(AtomicInteger tAsteptare) {
        this.tAsteptare = tAsteptare;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public Coada(int tInchidere) {
        tAsteptare = new AtomicInteger(0);
        this.tInchidere = tInchidere;
    }

    public void adaugaClient(Client client) {
        this.nrClienti = this.nrClienti + 1;
        if (this.nrClienti > 1)
            client.settService(client.gettService() - 1);
        this.clienti.add(client);
        tAsteptare.addAndGet(client.gettService());

    }

    public synchronized void removeClient() throws InterruptedException {
        while (clienti.size() == 0) {
            wait();
        }
        int i = 0;
        this.clienti.remove(i);
        this.nrClienti--;
        notifyAll();
    }


    @Override
    public synchronized void run() {
        while (clienti.isEmpty() == false || temp < tInchidere) {
            try {
                Thread.sleep(1000);
                if (this.clienti.isEmpty() == false) {
                    System.out.println("Okay");
                    Client a;
                    a = this.clienti.get(0);
                    int t = a.gettService();
                    for (int i = 0; i < t; i++) {
                        int aux;
                        aux = a.gettService() - 1;
                        a.settService(aux);
                        Thread.sleep(1050);
                        temp++;
                        this.tAsteptare.decrementAndGet();
                    }
                    this.removeClient();
                }


            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void pornire() {
        temp = 0;
        thread = new Thread(this);
        thread.start();

    }

    public int getSize() {
        return this.clienti.size();
    }
}
