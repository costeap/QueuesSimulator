import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Informatie {
    private View db=new View();
    public Controller controller = new Controller(db);
    private int tMaxSimulation;
    private int tMinArrival;
    private int tMaxArrival;
    private int tMinWaiting;
    private int tMaxWaiting;
    private int numarClienti;
    private int numarCozi;
    public int suma = 0;
    public int sumah = 0;

    public List<Coada> cozi = Collections.synchronizedList(new ArrayList<Coada>());
    public ArrayList<Client> clientiInAsteptare = new ArrayList<Client>();


    public synchronized int obtineCoadaMin() {
        int t1 = 0;
        int t2 = 0;
        int tServireMinim = 0;
        int coadaMsize = this.cozi.get(0).getSize();
        int indexC = 0;
        for (int i = 0; i < this.numarCozi; i++) {
            if (this.cozi.get(i).getSize() == 0) {
                return i;
            }
        }
        for (int i = 0; i < this.cozi.get(0).clienti.size(); i++) {
            tServireMinim = tServireMinim + this.cozi.get(0).clienti.get(i).gettService();
        }
        List<Client> coadaM = this.cozi.get(0).clienti;
        for (int j = 1; j < this.numarCozi; j++) {
            if (this.cozi.get(j).getSize() < coadaMsize) {
                coadaMsize = this.cozi.get(j).getSize();
                coadaM = this.cozi.get(j).clienti;
                for (int i = 0; i < this.cozi.get(j).clienti.size(); i++)
                    tServireMinim = tServireMinim + this.cozi.get(j).clienti.get(i).gettService();
                indexC = j;
            }
            if (this.cozi.get(j).getSize() == coadaMsize) {
                t1 = 0;
                for (int i = 0; i < this.cozi.get(j).clienti.size(); i++)
                    t1 = t1 + this.cozi.get(j).clienti.get(i).gettService();
                if (t1 < tServireMinim) {
                    coadaMsize = this.cozi.get(j).getSize();
                    tServireMinim = t1;
                    indexC = j;
                }

            }
        }
        return indexC;

    }


    public ArrayList<Client> clientiRandom(int tMaxArrival, int tMinArrival, int tMaxWaiting, int tMinWaiting, int numarClienti, int numarCozi, ArrayList<Client> clientiInAsteptare) {
        for (int i = 0; i < numarClienti; i++) {
            Client a = new Client(0, 0, 0);
            Random rand1 = new Random();
            Random rand2 = new Random();
            a.setId(i + 1);
            int at = this.tMinArrival + rand1.nextInt(this.tMaxArrival - this.tMinArrival + 1);
            int st = this.tMinWaiting + rand2.nextInt(this.tMaxWaiting - this.tMinWaiting + 1);
            a.settArrival(at);
            a.settService(st);
            this.clientiInAsteptare.add(a);
            suma = suma + st;
            sumah = sumah + at;
        }

        Collections.sort(this.clientiInAsteptare, new SortareTimpSosire());
        Collections.sort(this.clientiInAsteptare, new SortareTimpAsteptare());
        return clientiInAsteptare;

    }

    public void initializare(List<Coada> cozi, int timp, int numarCozi) {
        for (int i = 0; i < numarCozi; i++) {
            Coada c;
            c = new Coada(timp);
            this.cozi.add(c);
        }
        for (int j = 0; j < numarCozi; j++) {
            this.cozi.get(j).pornire();
        }
    }


    public Informatie(View db, int numarCozi, int numarClienti, int tMaxSimulation, int tMaxArrival, int tMinArrival, int tMaxWaiting, int tMinWaiting) {

        this.numarCozi = numarCozi;
        this.numarClienti = numarClienti;
        this.tMaxSimulation = tMaxSimulation;
        this.tMaxArrival = tMaxArrival;
        this.tMinArrival = tMinArrival;
        this.tMaxWaiting = tMaxWaiting;
        this.tMinWaiting = tMinWaiting;

        System.out.println(numarCozi);
        System.out.println("\n");
        System.out.println(numarClienti);
        System.out.println("\n");
        System.out.println(tMaxSimulation);
        System.out.println("\n");
        System.out.println(tMaxArrival);
        System.out.println("\n");
        System.out.println(tMinArrival);
        System.out.println("\n");
        System.out.println(tMaxWaiting);
        System.out.println("\n");
        System.out.println(tMinWaiting);
        System.out.println("\n");

        this.db = db;
        this.clientiInAsteptare = clientiRandom(this.tMaxArrival, this.tMinArrival, this.tMaxWaiting, this.tMinWaiting, this.numarClienti, this.numarCozi, this.clientiInAsteptare);
        initializare(cozi, tMaxSimulation, numarCozi);
    }

    public int gettMaxSimulation() {
        return this.tMaxSimulation;
    }

    public int getNumarClienti() {
        return this.numarClienti;
    }

    public int getNumarCozi() {
        return this.numarCozi;
    }

    public List<Coada> getCozi() {
        return this.cozi;
    }

    public int gettMinWaiting() {
        return this.tMinWaiting;
    }

    public int gettMaxWaiting() {
        return this.tMaxWaiting;
    }

    public ArrayList<Client> getClientiInAsteptare() {
        return this.clientiInAsteptare;
    }
}
