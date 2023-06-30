import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PhysicsGUI {

    private JFrame frame;
    private JTextField initialVelocityField;
    private JTextField finalVelocityField;
    private JTextField timeField;
    private JLabel resultLabel;

    public void initialize() {
        frame = new JFrame("Physics Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));

        JLabel initialVelocityLabel = new JLabel("Initial Velocity:");
        JLabel finalVelocityLabel = new JLabel("Final Velocity:");
        JLabel timeLabel = new JLabel("Time:");
        JButton calculateButton = new JButton("Calculate");

        initialVelocityField = new JTextField();
        finalVelocityField = new JTextField();
        timeField = new JTextField();
        resultLabel = new JLabel("");

        frame.add(initialVelocityLabel);
        frame.add(initialVelocityField);
        frame.add(finalVelocityLabel);
        frame.add(finalVelocityField);
        frame.add(timeLabel);
        frame.add(timeField);
        frame.add(calculateButton);
        frame.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAcceleration();
            }
        });

        frame.setVisible(true);
    }

    private void calculateAcceleration() {
        try {
            double initialVelocity = Double.parseDouble(initialVelocityField.getText());
            double finalVelocity = Double.parseDouble(finalVelocityField.getText());
            double time = Double.parseDouble(timeField.getText());

            double acceleration = (finalVelocity - initialVelocity) / time;

            resultLabel.setText("Acceleration: " + acceleration);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numeric values.");
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(frame, "Cannot divide by zero. Please enter a non-zero value for time.");
        }
    }

    public static void main(String[] args) {
        PhysicsGUI physicsGUI = new PhysicsGUI();
        physicsGUI.initialize();
    }
}
