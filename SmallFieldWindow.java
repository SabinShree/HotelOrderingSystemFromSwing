package NewOne;

import NewOne.model.DishItemFileSystem;
import javafx.util.Callback;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class SmallFieldWindow extends JPanel implements ActionListener {
    private JFrame frame;
    private JTextField dishNumberfield;
    private JComboBox<String> category;
    private JTextField dishNameTextField;
    private JRadioButton veryHotButton;
    private JRadioButton mediumHotButton;
    private JRadioButton mildHotButton;
    private JTextField dishPrice;
    private JButton insertButton;
    private JButton clearButton;

    public SmallFieldWindow() {
        frame = new JFrame("TextBox Field");
        frame.setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setBorder(new LineBorder(Color.RED, 2, true));
        mainPanel.setSize(398, 418);

        JLabel titleName = new JLabel("<html><u>Fill the information.</u></html>");
        titleName.setBounds(105, 10, 220, 40);
        titleName.setFont(new Font("Times New Roman", Font.BOLD, 23));
        mainPanel.add(titleName);

        JLabel dishNumber = new JLabel("Dish Number : ");
        dishNumber.setFont(new Font("Arial", Font.BOLD, 16));
        dishNumber.setBounds(10, 55, 200, 50);
        mainPanel.add(dishNumber);

        dishNumberfield = new JTextField();
        dishNumberfield.setBounds(125, 68, 200, 24);
        mainPanel.add(dishNumberfield);

        JLabel categoryJLabel = new JLabel("Category");
        categoryJLabel.setFont(new Font("Arial", Font.BOLD, 16));
        categoryJLabel.setBounds(10, 95, 200, 50);
        mainPanel.add(categoryJLabel);

        String[] comboBoxItems = new String[]{"Pasta", "Salad", "Curry", "Soup", "Roast", "AntiPasti", "Pizza"};
        category = new JComboBox<>(comboBoxItems);
        category.setBounds(125, 108, 200, 25);
        category.setSelectedIndex(0);
        mainPanel.add(category);

        JLabel dishNameLabel = new JLabel("Dish Name");
        dishNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        dishNameLabel.setBounds(10, 137, 200, 50);
        mainPanel.add(dishNameLabel);

        dishNameTextField = new JTextField();
        dishNameTextField.setFont(new Font("Arial", Font.BOLD, 16));
        dishNameTextField.setBounds(125, 150, 200, 25);
        mainPanel.add(dishNameTextField);

/*        JLabel spicenesslabel = new JLabel("Spiciness");
        spicenesslabel.setBounds(10, 177, 200, 50);
        spicenesslabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(spicenesslabel);*/

        veryHotButton = new JRadioButton("Very Hot", true);
        mediumHotButton = new JRadioButton("Medium Hot");
        mildHotButton = new JRadioButton("Mild Hot");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(veryHotButton);
        buttonGroup.add(mediumHotButton);
        buttonGroup.add(mildHotButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(122, 172, 178));
        buttonPanel.setBounds(10, 200, 315, 50);
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.add(veryHotButton);
        buttonPanel.add(mediumHotButton);
        buttonPanel.add(mildHotButton);

        buttonPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Spiciness"));
        frame.add(buttonPanel);

        JLabel priceJLabel = new JLabel("Price");
        priceJLabel.setFont(new Font("Arial", Font.BOLD, 16));
        priceJLabel.setBounds(10, 258, 200, 50);
        mainPanel.add(priceJLabel);

        dishPrice = new JTextField();
        dishPrice.setFont(new Font("Arial", Font.BOLD, 16));
        dishPrice.setBounds(125, 270, 200, 25);
        mainPanel.add(dishPrice);

        insertButton = new JButton("Insert");
        insertButton.addActionListener(this);
        insertButton.setBounds(10, 318, 123, 30);
        insertButton.setFocusPainted(false);
        insertButton.setFont(new Font("sans-serif", Font.BOLD, 16));
        insertButton.setForeground(new Color(255, 255, 230));
        insertButton.setBackground(new Color(76, 185, 80));
        Border line;
        line = new LineBorder(new Color(255, 23, 23));
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        insertButton.setBorder(compound);
        mainPanel.add(insertButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        clearButton.setBounds(200, 318, 123, 30);
        clearButton.setFocusPainted(false);
        clearButton.setFont(new Font("sans-serif", Font.BOLD, 16));
        clearButton.setForeground(new Color(255, 255, 215));
        clearButton.setBackground(new Color(205, 0, 0));
        clearButton.setBorder(BorderFactory.createLineBorder(new Color(76, 185, 82), 2, true));
        mainPanel.add(clearButton);

        frame.add(mainPanel);
        frame.setSize(414, 460);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


    private void addItemsInTable() {
        try {
            String dishNumber = dishNumberfield.getText().trim();
            String categoryItems = Objects.requireNonNull(category.getSelectedItem()).toString().trim();
            String dishNames = dishNameTextField.getText().trim();
            int spiciness = getSelectedItems();
            String price = dishPrice.getText().trim();
            int priceInInt = Integer.parseInt(price);

            if (!validItemNumber(dishNumber)) {
                dishNumberfield.setBorder(new LineBorder(Color.RED, 1, true));
//                JOptionPane.showMessageDialog(frame, "Number format is not correct", "Oh ! Boy", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int dishNumberInInt = Integer.parseInt(dishNumber);
            if (!checkId(dishNumberInInt)) {
                return;
            }

            if (dishNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Dish number Text field is empty", "Check Dish Number", JOptionPane.ERROR_MESSAGE);
                dishNumberfield.setBorder(new LineBorder(Color.RED, 1, true));
                return;
            }
            if (dishNames.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Dish Name Text field is empty", "Check Dish Name", JOptionPane.ERROR_MESSAGE);
                dishNameTextField.setBorder(new LineBorder(Color.RED, 1, true));
                return;
            }
            if (price.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Dish Price Text field is empty", "Check Dish Price", JOptionPane.ERROR_MESSAGE);
                dishPrice.setBorder(new LineBorder(Color.RED, 1, true));
                return;
            }

            if (dishNumberInInt <= 0) {
                JOptionPane.showMessageDialog(this, "Dish Number is less than than 0.", "Check Dish number", JOptionPane.ERROR_MESSAGE);
                dishNumberfield.setBorder(new LineBorder(Color.pink, 1, true));
                return;
            }
            if (priceInInt <= 0) {
                JOptionPane.showMessageDialog(this, "Dish price is less than than 0.", "Check Dish price", JOptionPane.ERROR_MESSAGE);
                dishPrice.setBorder(new LineBorder(Color.pink, 1, true));
                return;
            }

            DishItem dishItem = new DishItem(dishNumberInInt, dishNames, categoryItems, spiciness, priceInInt);
            DishItemFileSystem.getOurInstance().AddDishItems(dishItem);
            System.out.println("Size " + DishItemFileSystem.getOurInstance().getDishItemArrayList().size());
//            addDishItem(dishItem);
            MainPanelForTable.addTable(dishItem.getDishNumber(), dishItem.getDishName(), dishItem.getCategory(), (dishItem.getSpicinessName()), dishItem.getPrice());
            JOptionPane.showMessageDialog(frame, "Dish number : " + dishItem.getDishNumber() + " Price : " + dishItem.getDishName() + " Name : " + dishItem.getDishName(), "Successfully added.", JOptionPane.INFORMATION_MESSAGE);

            for (DishItem a : DishItemFileSystem.getOurInstance().getDishItemArrayList()) {
                System.out.println(a.getDishName() + " " + a.getPrice() + " " + a.getDishNumber());
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Some thing caused error. ", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

//    public ArrayList<DishItem> addDishItem(DishItem a) {
//        ArrayList<DishItem> items = new ArrayList<>();
//        if (a != null) {
//            items.add(a);
//            return items;
//        } else {
//            return null;
//        }
//    }

    private boolean validItemNumber(String number) {
        for (char a : number.toCharArray()) {
            if (!Character.isDigit(a)) {
                JOptionPane.showMessageDialog(this, "Number shouldn't be Letter. ", "Error ", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public boolean checkId(int id) {
        Random random = new Random();
        for (DishItem dishItem : DishItemFileSystem.getOurInstance().getDishItemArrayList()) {
            if (dishItem.getDishNumber() == id) {
                JOptionPane.showMessageDialog(this, "Dish number is already exists", "Check Dish Number", JOptionPane.WARNING_MESSAGE);
                id = id + (random.nextInt(10));
                return false;
            }
        }
        return true;
    }

    public int getSelectedItems() {
        if (veryHotButton.isSelected()) {
            return 0;
        } else if (mediumHotButton.isSelected()) {
            return 1;
        } else {
            return 2;
        }
    }

    public void clearAll() {
        dishNameTextField.setText("");
        dishPrice.setText("");
        dishNumberfield.setText("");
        veryHotButton.isSelected();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(insertButton)) {
            addItemsInTable();
        }
        if (e.getSource().equals(clearButton)) {
            clearAll();
        }
    }
}

//  MainPanelForTable a = new MainPanelForTable();
//            DishItem dishItem = new DishItem(dishNumberInInt, categoryItems, dishNames, spiciness, priceInInt);
//            DishItemFileSystem.getOurInstance().AddDishItems(dishItem);
//            DishItem item = DishItemFileSystem.getOurInstance().getDishItemArrayList().get(DishItemFileSystem.getOurInstance().getDishItemArrayList().size() - 1);
////            a.defaultTableModel.addRow(new String[]{String.valueOf(item.getDishNumber()), item.getCategory(), item.getDishName(), item.getSpicinessName(), String.valueOf(item.getPrice())});
////            a.addFromNewData();
//            System.out.println("Array size " + DishItemFileSystem.getOurInstance().getDishItemArrayList().size());
//            JOptionPane.showMessageDialog(frame, "Dish number : " + item.getDishNumber() + " Price : " + item.getDishName() + " Name : " + item.getDishName(), "Done", JOptionPane.INFORMATION_MESSAGE);
//            System.out.println("Successfully inserted there.");
//            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//            DishItem ab = DishItemFileSystem.getOurInstance().getDishItemArrayList().get(DishItemFileSystem.getOurInstance().getDishItemArrayList().size() - 1);
