package AProjektKoncowy.GUI;

import AProjektKoncowy.Animal;
import AProjektKoncowy.AnimalOwner;
import AProjektKoncowy.AnimalSpecies.Cat;
import AProjektKoncowy.Hotel;
import AProjektKoncowy.Room;
import AProjektKoncowy.AnimalSpecies.Dog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel titleLabel;
    private JLabel reservationTitleLabel;
    private JLabel animalFormTitleLabel;
    private JLabel roomTitleLabel;
    private JLabel dateTitleLabel;
    private JLabel hotelTitleLabel;
    private JLabel animalTitleLabel;
    private JButton backButton;

    public GUI(AnimalOwner owner){
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Modele list
        DefaultListModel<Animal> animalListModel = new DefaultListModel<>();
        animalList.setModel(animalListModel);

        DefaultListModel<Hotel> hotelListModel = new DefaultListModel<>();
        hotelList.setModel(hotelListModel);

        DefaultListModel<Room> roomListModel = new DefaultListModel<>();
        roomList.setModel(roomListModel);

        enum AnimalSpecies{
            kot, pies, papuga
        }

        typeComboBox.addItem(AnimalSpecies.kot);
        typeComboBox.addItem(AnimalSpecies.pies);
        typeComboBox.addItem(AnimalSpecies.papuga);

        //Model tabeli
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Label");
        tableModel.addColumn("Value");

        Dimension dim = new Dimension(50, 2);
        deailsTable.setIntercellSpacing(dim);

        deailsTable.setRowHeight(65);
        deailsTable.setModel(tableModel);
        //tableModel.addRow(new Object[]{"Hotel", h1.getName()});
        //tableModel.addRow(new Object[]{"Pokój", h1.getRooms().get(2).getNumber()});
        //tableModel.addRow(new Object[]{"Data od", "2024-07-08"});
        //tableModel.addRow(new Object[]{"Data do", "2024-07-10"});
        //tableModel.addRow(new Object[]{"Zwierzę", Animal.getAllAnimals().get(1).getName()});

        //Strona główna
        showAnimalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                animalListModel.clear();
                for(Animal animal : owner.getAnimals()){
                    animalListModel.addElement(animal);
                }

                if(mainViewPanel.isVisible()) {
                    mainViewPanel.setVisible(false);
                    animalsViewPanel.setVisible(true);
                }
                else{
                    roomPanel.setVisible(false);
                    animalsViewPanel.setVisible(true);
                    animalLabel.setText("Wybierz zwierzę");
                    backButton.setVisible(false);
                }
            }
        });

        reserveRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainViewPanel.setVisible(false);
                hotelPanel.setVisible(true);
                hotelListModel.clear();
                for(Hotel hotel : Hotel.getAllHotels()){
                    hotelListModel.addElement(hotel);
                }
            }
        });

        //Panel zwierząt
        addAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                animalsViewPanel.setVisible(false);
                animalFormPanel.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                animalsViewPanel.setVisible(false);
                mainViewPanel.setVisible(true);
            }
        });

        //Panel formularza ze zwierzetami
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = nameTextField.getText();
                String dateOfBirth = birthDateTextField.getText();
                Double weight = Double.parseDouble(weightTextField.getText());
                switch(typeComboBox.getSelectedIndex()){
                    case 0 -> owner.addAnimal(new Cat(name, dateOfBirth, weight));
                    case 1 -> owner.addAnimal(new Dog(name, dateOfBirth, weight));
                    default -> {}
                }

                animalListModel.clear();;
                for(Animal animal : owner.getAnimals()){
                    animalListModel.addElement(animal);
                }
                animalFormPanel.setVisible(false);
                animalsViewPanel.setVisible(true);
            }
        });

        //Panel hoteli
        



        mainFrame.add(mainPanel);

        mainViewPanel.setVisible(true);
        animalsViewPanel.setVisible(false);
        hotelPanel.setVisible(false);
        datePanel.setVisible(false);
        roomPanel.setVisible(false);
        animalFormPanel.setVisible(false);
        reservationPanel.setVisible(false);

        cancelButton.addActionListener((l) -> {JOptionPane.showMessageDialog(reservationPanel, "Rezerwacja anulowana");});
        acceptButton.addActionListener((l) -> {JOptionPane.showMessageDialog(reservationPanel, "Rezerwacja zatwierdzona");});

        dateOkButton.addActionListener((l) -> {JOptionPane.showOptionDialog(datePanel,
                "Brak wolnych pokoi w podanym terminie. Wybierz inny termin lub anuluj",
                "Brak dostępnego pokoju",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new String[]{"Anuluj", "OK"},
                "default");});


        mainFrame.setSize(980, 700);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }
}
