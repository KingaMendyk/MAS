package AProjektKoncowy.GUI;

import AProjektKoncowy.Animal;
import AProjektKoncowy.AnimalOwner;
import AProjektKoncowy.AnimalSpecies.Cat;
import AProjektKoncowy.Enums.ReservationState;
import AProjektKoncowy.Hotel;
import AProjektKoncowy.Room;
import AProjektKoncowy.AnimalSpecies.Dog;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

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

    //Obsługa klas
    private Hotel selectedHotel;
    private Room selectedRoom;
    private Animal selectedAnimal;
    private LocalDate dateFrom;
    private LocalDate dateTo;

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

        tableModel.addRow(new Object[]{"Hotel", "hotel name"});
        tableModel.addRow(new Object[]{"Pokój", "room number"});
        tableModel.addRow(new Object[]{"Data od", "date from"});
        tableModel.addRow(new Object[]{"Data do", "date to"});
        tableModel.addRow(new Object[]{"Zwierzę", "animal name"});

        //Selection Listener
        ListSelectionListener roomSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if (!listSelectionEvent.getValueIsAdjusting()) {
                    System.out.println("Room");
                    selectedRoom = (Room) roomList.getSelectedValue();

                    owner.makeReservation(selectedRoom, dateFrom.toString(), dateTo.toString());

                    animalListModel.removeAllElements();
                    for (Animal animal : owner.getAnimals()) {
                        animalListModel.addElement(animal);
                    }

                    roomPanel.setVisible(false);
                    animalsViewPanel.setVisible(true);
                    animalLabel.setText("Wybierz zwierzę");
                    backButton.setVisible(false);
                }
            }
        };

        ListSelectionListener hotelSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if(!listSelectionEvent.getValueIsAdjusting()) {
                    selectedHotel = (Hotel) hotelList.getSelectedValue();
                    dateFromTextField.setText("");
                    dateToTextField.setText("");

                    hotelPanel.setVisible(false);
                    datePanel.setVisible(true);
                }
            }
        };

        ListSelectionListener animalSelectionListener = new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                if(selectedRoom != null && !listSelectionEvent.getValueIsAdjusting()){
                    selectedAnimal = (Animal)animalList.getSelectedValue();
                    owner.getLatestReservation().setAnimal(selectedAnimal);

                    tableModel.setValueAt(selectedHotel.getName(), 0, 1);
                    tableModel.setValueAt(selectedRoom.getRoomNumber(), 1, 1);
                    tableModel.setValueAt(dateFrom, 2, 1);
                    tableModel.setValueAt(dateTo, 3, 1);
                    tableModel.setValueAt(selectedAnimal.getName(), 4, 1);

                    animalsViewPanel.setVisible(false);
                    reservationPanel.setVisible(true);
                }
            }
        };


        //Strona główna
        showAnimalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                animalListModel.removeAllElements();
                for(Animal animal : owner.getAnimals()){
                    animalListModel.addElement(animal);
                }

                animalLabel.setText("Twoje zwierzęta");
                backButton.setVisible(true);
                mainViewPanel.setVisible(false);
                animalsViewPanel.setVisible(true);
            }
        });

        reserveRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hotelList.removeListSelectionListener(hotelSelectionListener);
                hotelListModel.removeAllElements();
                for(Hotel hotel : Hotel.getAllHotels()){
                    hotelListModel.addElement(hotel);

                }
                hotelList.addListSelectionListener(hotelSelectionListener);

                mainViewPanel.setVisible(false);
                hotelPanel.setVisible(true);
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

                animalList.removeListSelectionListener(animalSelectionListener);
                animalListModel.removeAllElements();;
                for(Animal animal : owner.getAnimals()){
                    animalListModel.addElement(animal);
                }
                animalList.addListSelectionListener(animalSelectionListener);

                animalFormPanel.setVisible(false);
                animalsViewPanel.setVisible(true);
            }
        });

        //Panel formularza dat
        dateOkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dateFrom = LocalDate.parse(dateFromTextField.getText());
                dateTo = LocalDate.parse(dateToTextField.getText());
                System.out.println(selectedHotel);

                List<Room> availableRooms = selectedHotel.getAvailableRooms(dateFrom, dateTo);

                if(availableRooms.size() == 0){
                    JOptionPane.showOptionDialog(datePanel,
                            "Brak wolnych pokoi w podanym terminie. Wybierz inny termin lub anuluj",
                            "Brak dostępnego pokoju",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            new String[]{"Anuluj", "OK"},
                            "default");
                }
                else {
                    roomList.removeListSelectionListener(roomSelectionListener);
                    roomListModel.removeAllElements();
                    for(Room room : availableRooms){
                        roomListModel.addElement(room);
                    }
                    roomList.addListSelectionListener(roomSelectionListener);

                    datePanel.setVisible(false);
                    roomPanel.setVisible(true);
                }
            }
        });

        //Panel rezerwacji
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int res = JOptionPane.showOptionDialog(reservationPanel, "Rezerwacja anulowana",
                        "Rezerwacja anulowana", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, null, null);
                owner.getLatestReservation().changeState(ReservationState.Cancelled);

                if(res == 0){
                    reservationPanel.setVisible(false);
                    mainViewPanel.setVisible(true);
                }
                selectedHotel = null;
                selectedRoom = null;
                selectedAnimal = null;
            }
        });
        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int res = JOptionPane.showOptionDialog(reservationPanel, "Rezerwacja zatwierdzona",
                        "Rezerwacja zatwierdzona", JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE, null, null, null);
                owner.getLatestReservation().changeState(ReservationState.Accepted);

                if(res == 0){
                    reservationPanel.setVisible(false);
                    mainViewPanel.setVisible(true);
                }
                selectedHotel = null;
                selectedRoom = null;
                selectedAnimal = null;
            }
        });


        mainFrame.add(mainPanel);

        mainViewPanel.setVisible(true);
        animalsViewPanel.setVisible(false);
        hotelPanel.setVisible(false);
        datePanel.setVisible(false);
        roomPanel.setVisible(false);
        animalFormPanel.setVisible(false);
        reservationPanel.setVisible(false);

        mainFrame.setSize(980, 700);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }
}
