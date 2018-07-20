package NewOne;

import NewOne.model.DishItemFileSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TitleAndSearch extends JPanel implements ActionListener {
    private JButton searchItem;
    private JButton addItem;
    private JFormattedTextField searchField;
    private SearchAndSort a = new SearchAndSort();
    private ArrayList<DishItem> dishItem;
    private DishItem dishItems;

    TitleAndSearch() {

        setBorder(BorderFactory.createLineBorder(Color.red, 2, true));
        JLabel jLabelBrandName;
        jLabelBrandName = new JLabel("<html><u>Naya baje ko sekuwa</u></html>");
        jLabelBrandName.setForeground(new Color(139, 25, 24));
        jLabelBrandName.setBackground(new Color(3, 23, 20));
        jLabelBrandName.setFont(new Font("Sans-serif", Font.BOLD, 30));
        jLabelBrandName.setBounds(250, 15, 500, 60);
        add(jLabelBrandName);

        JLabel brandSlogan = new JLabel("We are here to serve you.");
        brandSlogan.setForeground(new Color(29, 155, 254));
        brandSlogan.setBounds(478, 40, 700, 60);
        brandSlogan.setBackground(new Color(3, 23, 20));
        brandSlogan.setFont(new Font("Sans-serif", Font.BOLD, 15));
        add(brandSlogan);

        JSeparator separator = new JSeparator();
        separator.setBounds(1, 100, 900, 10);
        add(separator);

        addItem = new JButton("Add Item");
        addItem.addActionListener(this);
        addItem.setBounds(10, 120, 130, 35);
        addItem.setBorder(BorderFactory.createLineBorder(new Color(228, 31, 12), 2, true));
        addItem.setFont(new Font("Sans-serif", Font.BOLD, 18));
        addItem.setForeground(new Color(255, 255, 230));
        addItem.setBackground(new Color(67, 48, 93));
        addItem.setFocusPainted(false);
        add(addItem);

        searchField = new JFormattedTextField();
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    searchItem();
                }
            }
        });

        searchField.setHorizontalAlignment(JTextField.CENTER);
        searchField.setFont(new Font("Times New Roman", Font.BOLD, 18));
        searchField.setBounds(580, 120, 160, 35);
        add(searchField);

        searchItem = new JButton("Search");
        searchItem.addActionListener(this);
        searchItem.addActionListener(event -> searchItem());
        searchItem.setBounds(750, 120, 140, 35);
        searchItem.setFocusPainted(false);
        searchItem.setBorder(BorderFactory.createLineBorder(new Color(239, 132, 123), 2, true));
        searchItem.setFont(new Font("Sans-serif", Font.BOLD, 18));
        searchItem.setForeground(new Color(255, 255, 230));
        searchItem.setBackground(new Color(20, 109, 209));
        add(searchItem);
        setLayout(null);
        setBounds(1, 1, 900, 170);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addItem)) {
            SmallFieldWindow a = new SmallFieldWindow();
        }
    }

    public void searchItem() {
        String price = searchField.getText().trim();
        SearchAndSort.merge(DishItemFileSystem.getOurInstance().getDishItemArrayList());
        int index = -1;
        index = SearchAndSort.binarySearch(DishItemFileSystem.getOurInstance().getDishItemArrayList(), 0, DishItemFileSystem.getOurInstance().getDishItemArrayList().size() - 1, Integer.parseInt(price));
        if (index >= 0) {
            dishItems = DishItemFileSystem.getOurInstance().getDishItemArrayList().get(index);
            JOptionPane.showMessageDialog(null, "Found the content\nDish Number : " + dishItems.getDishNumber() + "\nDish Name : " + dishItems.getDishName() + "\nCategory : " + dishItems.getCategory() + "\nPrice : " + dishItems.getPrice(), "Found", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "NO item in that price", "Not Found", JOptionPane.ERROR_MESSAGE);
        }
    }
}
