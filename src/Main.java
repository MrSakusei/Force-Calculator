import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForceCalculator implements ActionListener {
    private JFrame frame;
    private JLabel massLabel, accelerationLabel, resultLabel;
    private JTextField massField, accelerationField;
    private JButton calculateButton;

    public ForceCalculator() {
        frame = new JFrame("Force Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        massLabel = new JLabel("Mass (kg):");
        massField = new JTextField(10);

        accelerationLabel = new JLabel("Acceleration (m/s^2):");
        accelerationField = new JTextField(10);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        resultLabel = new JLabel();

        frame.add(massLabel);
        frame.add(massField);
        frame.add(accelerationLabel);
        frame.add(accelerationField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        double mass, acceleration;
        try {
            mass = Double.parseDouble(massField.getText());
            acceleration = Double.parseDouble(accelerationField.getText());

            double force = mass * acceleration;
            resultLabel.setText("Force = " + force + " N");
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ForceCalculator();
            }
        });
    }
}
