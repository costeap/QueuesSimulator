import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Eveniment implements Runnable {

    public int semafor = 1;
    public int medieClienti = 0;
    public int timpMediuAsteptare;
    public Thread thread;
    public int timp = 0;
    View aw = new View();
    private int tMaxSimulation;
    private int tMinArrival;
    private int tMaxArrival;
    private int tMinWaiting;
    private int tMaxWaiting;
    private int numarClienti;
    private int numarCozi;
    private JFrame jf = new JFrame();

    public void redirectionareClient(List<Coada> cozi, Client a, Informatie inf) throws InterruptedException {
        int coada = 0;
        coada = inf.obtineCoadaMin();
        cozi.get(coada).adaugaClient(a);
    }

    @Override
    public void run() {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\paula\\Teme_TP\\TP_tema2\\a.txt");
            Informatie inf = new Informatie(aw, numarCozi, numarClienti, tMaxSimulation, tMaxArrival, tMinArrival, tMaxWaiting, tMinWaiting);
            while (timp <= inf.gettMaxSimulation()) {
                try {
                    if ((inf.getClientiInAsteptare().size() != 0) && (inf.getClientiInAsteptare().get(0).gettArrival() == timp)) {
                        while (inf.getClientiInAsteptare().get(0).gettArrival() == timp) {
                            redirectionareClient(inf.cozi, inf.clientiInAsteptare.get(0), inf);
                            inf.getClientiInAsteptare().remove(0);
                            if (inf.getClientiInAsteptare().size() == 0) break;
                        }

                    }
                    Thread.sleep(1050);
                    afisareRezultate(inf.getCozi(), inf.getNumarCozi(), timp, inf.getClientiInAsteptare(), inf.getNumarClienti(), fw);
                    timp++;
                } catch (InterruptedException e1) {
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            fw.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void afisareRezultate(List<Coada> cozi, int nrCozi, int timp, ArrayList<Client> clientiInAsteptare, int nrClienti, FileWriter fw) throws IOException {
        JTextArea textArea = new JTextArea();
        JScrollPane inf = new JScrollPane(textArea);
        inf.setBounds(500, 56, 500, 300);
        inf.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jf.add(inf);
        jf.setVisible(true);

        String s = "";
        s = s + "Time:" + timp + " ";

        fw.write("Time:" + timp + "\n");
        fw.write("Waiting clients: ");
        s = s + "Waiting clients: ";


        //textArea.append(s);

        for (Client c : clientiInAsteptare) {
            fw.write("(" + c.getId() + " " + c.gettArrival() + " " + c.gettService() + ")");
            s = s + "(" + c.getId() + " " + c.gettArrival() + " " + c.gettService() + ")";

        }
        fw.write("\n");
        s = s + "\n\n";

        for (int i = 1; i <= nrCozi; i++) {
            fw.write("Queue " + i + ":");
            s = s + "Queue " + i + ":";

            if (cozi.get(i - 1).getSize() == 0) {
                fw.write("closed");
                s = s + "closed";


            } else {
                for (Client c : cozi.get(i - 1).clienti) {
                    int n = c.gettService() + 1;
                    fw.write("(" + c.getId() + " " + c.gettArrival() + " " + n + ")");
                    s = s + "(" + c.getId() + " " + c.gettArrival() + " " + n + ")";

                }
            }
            fw.write("\n");
            s = s + "\n";

            textArea.append(s);

        }
    }




    public void setSemafor(int semafor) {
        this.semafor = semafor;
    }

    public void settMaxSimulation(int tMaxSimulation) {
        this.tMaxSimulation = tMaxSimulation;
    }

    public void settMinArrival(int tMinArrival) {
        this.tMinArrival = tMinArrival;
    }

    public void settMaxArrival(int tMaxArrival) {
        this.tMaxArrival = tMaxArrival;
    }

    public void settMinWaiting(int tMinWaiting) {
        this.tMinWaiting = tMinWaiting;
    }

    public void settMaxWaiting(int tMaxWaiting) {
        this.tMaxWaiting = tMaxWaiting;
    }

    public void setNumarClienti(int numarClienti) {
        this.numarClienti = numarClienti;
    }

    public void setNumarCozi(int numarCozi) {
        this.numarCozi = numarCozi;
    }

    public int getSemafor() {
        return semafor;
    }

    public int gettMaxSimulation() {
        return tMaxSimulation;
    }

    public int gettMinArrival() {
        return tMinArrival;
    }

    public int gettMaxArrival() {
        return tMaxArrival;
    }

    public int gettMinWaiting() {
        return tMinWaiting;
    }

    public int gettMaxWaiting() {
        return tMaxWaiting;
    }

    public int getNumarClienti() {
        return numarClienti;
    }

    public int getNumarCozi() {
        return numarCozi;
    }
}
