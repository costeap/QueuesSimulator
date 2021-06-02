import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Controller {
    private View db;
    public int t=0;
    public int numarCozi=0;
    public int numarClienti=0;
    public int tMaxSimulation=0;
    public int tMaxArrival=0;
    public int tMinArrival=0;
    public int tMaxWaiting=0;
    public int tMinWaiting=0;

    public Controller(View db)
    {
        this.db=db;
        this.db.goButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                numarCozi=Integer.parseInt(db.getNumarCoziv());
                numarClienti = Integer.parseInt(db.getNumarClientiv());
                tMaxSimulation = Integer.parseInt(db.getTMaxSimulationv());
                tMaxArrival = Integer.parseInt(db.getTMaxArrivalv());
                tMinArrival = Integer.parseInt(db.getTMinArrivalv());
                tMaxWaiting = Integer.parseInt(db.getTMaxServicev());
                tMinWaiting = Integer.parseInt(db.getTMinServicev());


                Eveniment ev=new Eveniment();
                ev.setNumarClienti(numarClienti);
                ev.setNumarCozi(numarCozi);
                ev.settMaxSimulation(tMaxSimulation);
                ev.settMaxArrival(tMaxArrival);
                ev.settMinArrival(tMinArrival);
                ev.settMaxWaiting(tMaxWaiting);
                ev.settMinWaiting(tMinWaiting);
                Thread t=new Thread(ev);
                t.start();

            }
        });
    }


}
