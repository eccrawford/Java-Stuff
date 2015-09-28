import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class FruitStand extends JFrame {
    // The cost of one piece of each kind of fruit
    public static final double APPLE_PRICE = 1.00;
    public static final double ORANGE_PRICE = 1.50;
    // One button for each kind of fruit
    public JButton appleButton = new JButton("apple");
    public JButton orangeButton = new JButton("orange");
    // A text box where you can type in the number of pieces of fruit you want,
    // with a label before it
    public JLabel countLabel = new JLabel("count: ");
    public JTextField countField = new JTextField(10);
    // A text box showing your total order, with a label before it
    public JLabel totalLabel = new JLabel("total: ");
    public JTextField totalField = new JTextField(10);
    public JButton OKButton = new JButton("OK");

    public boolean apple = true;
    public boolean orange = false;
    public static float total;
    public int count;

    public FruitStand() {
        setLayout(new GridLayout(0,1));
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(appleButton);
        panel1.add(orangeButton);
        add(panel1);
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.add(countLabel, BorderLayout.WEST);
        panel2.add(countField, BorderLayout.CENTER);
        add(panel2);
        JPanel panel3 = new JPanel(new FlowLayout());
        panel3.add(OKButton);
        add(panel3);
        JPanel panel4 = new JPanel(new BorderLayout());
        panel4.add(totalLabel, BorderLayout.WEST);
        panel4.add(totalField, BorderLayout.CENTER);
        add(panel4);
        // The user may type characters into the count field, but
        // not the total field
        countField.setEditable(true);
        totalField.setEditable(false);
        // Initial total is zero
        totalField.setText("$0");
        // apple button is initially selected
        appleButton.setForeground(Color.RED);
        orangeButton.setForeground(Color.BLACK);

        appleButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    appleButton.setForeground(Color.RED);
                    orangeButton.setForeground(Color.BLACK);
                    apple = true;
                    orange = false;
                }
            });

        orangeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    appleButton.setForeground(Color.BLACK);
                    orangeButton.setForeground(Color.RED);
                    apple = false;
                    orange = true;
                }
            });

        OKButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String stringCount = countField.getText();
                    try {
                        count = Integer.parseInt(stringCount);
                    } catch (NumberFormatException error) {
                        count = 0;
                    }
                    if (count >= 0) {
                        if (orange) {
                            total += (count * ORANGE_PRICE);
                            totalField.setText("$" + ""+total);
                        }
                        else if (apple) {
                            total += (count * APPLE_PRICE);
                            totalField.setText("$" + ""+total);
                        }
                    }
                    else {
                        errorPopUp();
                    }
                }
            });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    } // end constructor
    /*
     * This method pops up a little window reporting an internal error.
     * The window will stay in front of the frame, making it impossible to
     * interact with the frame, until the user hits the "OK" button. I'm
     * providing this for your use because we didn't talk much about
     * JOptionPanes this term.
     */
    public void errorPopUp() {
        JOptionPane.showMessageDialog(this, "INTERNAL ERROR!");
    } // end errorPopUp
    public static void main(String args[]) {
        new FruitStand();
    } // end main
} // end classFruitStand