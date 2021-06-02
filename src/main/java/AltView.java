import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AltView extends JFrame {
    private JPanel contentPane;
    private JFrame frame;
    private JScrollPane inf;
    private JLabel text;
    private JButton closeButton;

    public AltView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 620, 550);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.orange);

        text = new JLabel();
        text.setBounds(100, 100, 100, 100);
        contentPane.add(text);


        inf = new JScrollPane();
        inf.setBounds(100, 100, 400, 300);
        inf.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        contentPane.add(inf);

        closeButton = new JButton("Close");
        closeButton.setFont(new Font("Ink Free", Font.BOLD, 12));
        closeButton.setBounds(420, 420, 85, 21);
        contentPane.add(closeButton);
    }

    public void addCloseListener(ActionListener actionListener) {
        this.closeButton.addActionListener(actionListener);
    }

    public void updateTextField(String value) {
        this.text.setText(value);
    }

    public void addText(JLabel value) {
        this.inf.add(value);
    }
}
