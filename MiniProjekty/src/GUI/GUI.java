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
    private JPanel hotelPanel;
    private JPanel hotelUpperPanel;
    private JPanel hotelLowerPanel;
    private JLabel hotelLabel;
    private JComboBox hotelComboBox;
    private JPanel roomPanel;
    private JPanel roomUpperPanel;
    private JPanel roomLowerPanel;
    private JLabel roomLabel;
    private JList roomList;
    private JComboBox roomComboBox;
    private JList hotelList;
    private JButton addAnimalButton;
    private JPanel animalFormPanel;
    private JPanel animalFormUpperPanel;
    private JPanel animalFormLowerPanel;
    private JLabel animalFormLabel;
    private JButton okButton;
    private JPanel animalForm;
    private JTextField nameTextField;
    private JLabel nameLabel;
    private JLabel birthDateLabel;
    private JTextField birthDateTextField;
    private JLabel weightLabel;
    private JTextField weightTextField;
    private JPanel resrvationPAnel;
    private JPanel reservationUpperPanel;
    private JPanel reservationLowerPanel;
    private JLabel reservationLabel;
    private JButton acceptButton;
    private JButton cancelButton;
    private JPanel reservationDetailsPanel;
    private JPanel reservationButtonsPanel;
    private JTable deailsTable;
    private JPanel datePanel;
    private JPanel dateUpperPanel;
    private JPanel dateLowerPanel;
    private JLabel dateLabel;
    private JButton dateOkButton;
    private JPanel dateForm;
    private JLabel dateFromLabel;
    private JTextField dateFromTextField;
    private JLabel dateToLabel;
    private JTextField dateToTextField;

    public GUI(){
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.add(mainPanel);

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
