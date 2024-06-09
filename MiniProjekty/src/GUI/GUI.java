package GUI;

import javax.swing.*;

public class GUI {
    private JFrame mainFrame;
    private JPanel mainPanel;
    private JPanel mainViewPanel;
    private JPanel bannerPanel;
    private JPanel lowePanel;
    private JPanel imagePanel;
    private JPanel buttonsPanel;
    private JButton showAnimalsButton;
    private JButton reserveRoomButton;
    private JLabel mainLabel;
    private JPanel animalsViewPanel;
    private JLayeredPane layeredPane1;
    private JLabel animalLabel;
    private JPanel animalBannerPanel;
    private JPanel animalLowerPanel;
    private JList animalList;

    public GUI(){
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.add(mainPanel);
        //mainFrame.add(animalsViewPanel);

        mainViewPanel.setVisible(false);
        animalsViewPanel.setVisible(true);


        mainFrame.setSize(980, 700);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUI();});
    }
}
