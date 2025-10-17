import javax.swing.*;
import java.awt.*;

public class ReseauElectrique extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(2));
        g2.setFont(new Font("Arial", Font.BOLD, 14));

        // Positions des générateurs et moteurs
        int xG = 100; // position des générateurs
        int xM = 300; // position des moteurs

        int yG1 = 200;
        int yG2 = 100;

        int yM1 = 50;
        int yM2 = 120;
        int yM3 = 200;
        int yM4 = 270;

        // Dessiner les rectangles (noeuds)
        g2.drawRect(xG - 20, yG1 - 15, 40, 30);
        g2.drawRect(xG - 20, yG2 - 15, 40, 30);

        g2.drawRect(xM - 20, yM1 - 15, 40, 30);
        g2.drawRect(xM - 20, yM2 - 15, 40, 30);
        g2.drawRect(xM - 20, yM3 - 15, 40, 30);
        g2.drawRect(xM - 20, yM4 - 15, 40, 30);

        // Noms
        g2.drawString("G1", xG - 10, yG1 + 5);
        g2.drawString("G2", xG - 10, yG2 + 5);
        g2.drawString("M1", xM - 10, yM1 + 5);
        g2.drawString("M2", xM - 10, yM2 + 5);
        g2.drawString("M3", xM - 10, yM3 + 5);
        g2.drawString("M4", xM - 10, yM4 + 5);

        // Puissances
        g2.drawString("60kW", xG - 70, yG1 + 5);
        g2.drawString("60kW", xG - 70, yG2 + 5);
        g2.drawString("40kW", xM + 30, yM1 + 5);
        g2.drawString("40kW", xM + 30, yM2 + 5);
        g2.drawString("20kW", xM + 30, yM3 + 5);
        g2.drawString("10kW", xM + 30, yM4 + 5);

        // Lignes reliant générateurs et moteurs
        g2.drawLine(xG, yG2, xM, yM1);
        g2.drawLine(xG, yG2, xM, yM2);
        g2.drawLine(xG, yG1, xM, yM3);
        g2.drawLine(xG, yG1, xM, yM4);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Réseau Électrique");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ReseauElectrique());
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
