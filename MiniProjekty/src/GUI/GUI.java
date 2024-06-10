package GUI;

import MP04.Animal;
import MP04.AnimalSpecies.Cat;
import MP04.AnimalSpecies.Dog;
import MP04.Hotel;
import MP04.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
    private JPanel roomPanel;
    private JPanel roomUpperPanel;
    private JPanel roomLowerPanel;
    private JLabel roomLabel;
    private JList roomList;
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
    private JPanel reservationPanel;
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
    private JPanel dateInputPanel;
    private JPanel calendarPanel;
    private JLabel typeLabel;
    private JComboBox typeComboBox;

    public GUI(){
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultListModel<Animal> animalListModel = new DefaultListModel<>();
        animalList.setModel(animalListModel);
        animalListModel.addElement(new Cat("Mruczek", "2020-03-01"));
        animalListModel.addElement(new Dog("Azor    ", "2010-02-10"));

        DefaultListModel<Hotel> hotelListModel = new DefaultListModel<>();
        hotelList.setModel(hotelListModel);
        Hotel h1 = new Hotel("Zwierzakowo Warszawa", "ul. Karowa 8, Warszawa");
        Hotel h2 = new Hotel("Zwierzakowo Lublin    ", "ul. Pana Balcera 20, Lublin");

        h1.addRoom(Room.createRoom(h1, 0, 1, 3));
        h1.addRoom(Room.createRoom(h1, 1, 2, 2));
        h1.addRoom(Room.createRoom(h1, 2, 3, 4));

        h2.addRoom(Room.createRoom(h2, 3, 1, 3));
        h2.addRoom(Room.createRoom(h2, 4, 2, 3));

        hotelListModel.addElement(h1);
        hotelListModel.addElement(h2);

        DefaultListModel<Room> roomListModel = new DefaultListModel<>();
        roomList.setModel(roomListModel);
        for(Room room : h1.getRooms()){
            roomListModel.addElement(room);
        }

        enum AnimalSpecies{
            kot, pies, papuga
        }

        typeComboBox.addItem(AnimalSpecies.kot);
        typeComboBox.addItem(AnimalSpecies.pies);
        typeComboBox.addItem(AnimalSpecies.papuga);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Label");
        tableModel.addColumn("Value");
        deailsTable.setRowHeight(65);
        deailsTable.setModel(tableModel);
        tableModel.addRow(new Object[]{"Hotel", h1.getName()});
        tableModel.addRow(new Object[]{"Pokój", h1.getRooms().get(0).getNumber()});
        tableModel.addRow(new Object[]{"Data od", "2024-07-08"});
        tableModel.addRow(new Object[]{"Data do", "2024-07-10"});
        tableModel.addRow(new Object[]{"Zwierzę", Animal.getAllAnimals().get(1).getName()});

        mainFrame.add(mainPanel);

        mainViewPanel.setVisible(false);
        animalsViewPanel.setVisible(false);
        hotelPanel.setVisible(false);
        datePanel.setVisible(false);
        roomPanel.setVisible(false);
        animalFormPanel.setVisible(false);
        reservationPanel.setVisible(true);


        mainFrame.setSize(980, 700);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUI();});
    }
}
