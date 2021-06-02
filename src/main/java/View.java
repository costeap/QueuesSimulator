import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JFrame frame;
    private JPanel contentPane;
    private JTextField numarClienti;
    private JTextField numarCozi;
    private JTextField tMaxSim;
    private JTextField tMinArr;
    private JTextField tMaxArr;
    private JTextField tMinSer;
    private JTextField tMaxSer;
    private JLabel nrcl;
    private JLabel nrc;
    private JLabel tSimulation;
    private JLabel tMinMaxArr;
    private JLabel tMinMaxService;
    private JButton goButton;
    private JScrollPane inf;
    private JLabel text;
    public String txt;
    public JTextArea textArea=new JTextArea();
    private JScrollPane scrollPane;

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.orange);

        numarClienti = new JTextField();
        numarClienti.setBounds(120, 56, 96, 19);
        contentPane.add(numarClienti);

        numarCozi = new JTextField();
        numarCozi.setBounds(120, 85, 96, 19);
        contentPane.add(numarCozi);

        tMaxSim = new JTextField();
        tMaxSim.setBounds(120, 115, 96, 19);
        contentPane.add(tMaxSim);

        tMinArr = new JTextField();
        tMinArr.setBounds(120, 144, 96, 19);
        contentPane.add(tMinArr);

        tMaxArr = new JTextField();
        tMaxArr.setBounds(220, 144, 96, 19);
        contentPane.add(tMaxArr);

        tMinSer = new JTextField();
        tMinSer.setBounds(120, 173, 96, 19);
        contentPane.add(tMinSer);

        tMaxSer = new JTextField();
        tMaxSer.setBounds(220, 173, 96, 19);
        contentPane.add(tMaxSer);

        nrcl = new JLabel("Numar clienti");
        nrcl.setFont(new Font("Ink Free", Font.BOLD, 12));
        nrcl.setBounds(20, 56, 73, 13);
        contentPane.add(nrcl);

        tSimulation = new JLabel("T Max Simulation");
        tSimulation.setFont(new Font("Ink Free", Font.BOLD, 12));
        tSimulation.setBounds(20, 118, 96, 13);
        contentPane.add(tSimulation);

        tSimulation = new JLabel("T Min/Max Arrival");
        tSimulation.setFont(new Font("Ink Free", Font.BOLD, 12));
        tSimulation.setBounds(20, 147, 100, 13);
        contentPane.add(tSimulation);

        tSimulation = new JLabel("T Min/Max Service");
        tSimulation.setFont(new Font("Ink Free", Font.BOLD, 12));
        tSimulation.setBounds(20, 176, 100, 13);
        contentPane.add(tSimulation);

        nrc = new JLabel("Numar cozi");
        nrc.setFont(new Font("Ink Free", Font.BOLD, 12));
        nrc.setBounds(20, 85, 73, 13);
        contentPane.add(nrc);

        goButton = new JButton("GO");
        goButton.setBounds(120, 220, 96, 19);
        contentPane.add(goButton);

    }

    public String getNumarClientiv() {
        return this.numarClienti.getText();
    }

    public String getNumarCoziv() {
        return this.numarCozi.getText();
    }

    public String getTMaxSimulationv() {
        return this.tMaxSim.getText();
    }

    public String getTMinArrivalv() {
        return this.tMinArr.getText();
    }

    public String getTMaxArrivalv() {
        return this.tMaxArr.getText();
    }

    public String getTMinServicev() {
        return this.tMinSer.getText();
    }

    public String getTMaxServicev() {
        return this.tMaxSer.getText();
    }

    public void goButtonListener(ActionListener actionListener) {
        this.goButton.addActionListener(actionListener);
    }

    public void updateTextField(String value) {
        this.textArea.append(value + "\n");
    }

    public String afisare() {
        return this.txt;
    }

    public void addText(String value) {
        this.textArea.append(value);
    }

}

