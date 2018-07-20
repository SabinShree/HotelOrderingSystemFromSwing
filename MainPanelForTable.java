package NewOne;

import NewOne.model.DishItemFileSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainPanelForTable extends JPanel {
    private String[] column = new String[]{"Dish No.", "Category", "Dish Name", "Spiciness", "Price"};
    private static DefaultTableModel defaultTableModel;
    private JTable table;
    private JScrollPane scrollPane;
    private boolean firstTimeRun = false;
    private JButton select;
    private JComboBox<String> a = new JComboBox<>(column);
    private JButton clearTable;

    MainPanelForTable() {

        defaultTableModel = new DefaultTableModel(null, column);
        table = new JTable(defaultTableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(130);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
        table.setBackground(new Color(255, 255, 250));
        table.setForeground(new Color(0, 0, 40));
        table.setEnabled(false);
        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 19));
        table.getTableHeader().setBackground(new Color(142, 126, 210));
        table.getTableHeader().setForeground(new Color(255, 255, 252));
        table.setBorder(BorderFactory.createLineBorder(new Color(122, 1, 1), 1, false));
        table.getTableHeader().setReorderingAllowed(false);
        table.setFont(new Font("Courier", Font.PLAIN, 18));
        table.getTableHeader().setEnabled(false);
        table.setBorder(null);
        table.setRowHeight(27);

        scrollPane = new JScrollPane(table);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setForeground(Color.WHITE);
        scrollPane.setBounds(1, 170, 901, 380);
        add(scrollPane);

        select = new JButton("Get");
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int coun = 0;
                String selectedIndex = (String) a.getSelectedItem();
                for (DishItem dishItem : DishItemFileSystem.getOurInstance().getDishItemArrayList()) {
                    if (dishItem.getCategory().equalsIgnoreCase(selectedIndex)) {
                        coun++;
                    }
                }
                JOptionPane.showMessageDialog(null, "Found , There are " + coun + " " + selectedIndex + " in the table", (coun >= 1) ? "Found" : "Not Found", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        select.setFocusPainted(false);
        select.setFont(new Font("Arial", Font.BOLD, 18));
        select.setBackground(new Color(112, 12, 12));
        select.setForeground(new Color(255, 245, 245));
        select.setBounds(720, 570, 150, 40);
        add(select);

        String[] comboBoxItems = new String[]{"Pasta", "Salad", "Curry", "Soup", "Roast", "AntiPasti", "Pizza"};
        a = new JComboBox<>(comboBoxItems);
        a.setBackground(new Color(123, 123, 13));
        a.setFont(new Font("Arial", Font.BOLD, 18));
        a.setBounds(550, 570, 150, 40);
        a.setSelectedIndex(0);
        add(a);

        clearTable = new JButton("Clear Table");
        clearTable.setFocusPainted(false);
        clearTable.setFont(new Font("Arial", Font.BOLD, 18));
        clearTable.setBackground(new Color(255, 42, 12));
        clearTable.setForeground(new Color(255, 245, 245));
        clearTable.setBounds(10, 570, 150, 40);
        clearTable.addActionListener(e -> {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure?","WARNING", dialogButton);
            if (dialogButton == JOptionPane.YES_OPTION) {
                ((DefaultTableModel) table.getModel()).setNumRows(0);
            }
        });
        add(clearTable);

        setLayout(null);
        setBounds(40, 500, 900, 700);
        addFirst();
    }

    public static void addTable(int dishNumber, String name, String category, String spiceness, int price) {
        defaultTableModel.addRow(new String[]{String.valueOf(dishNumber), name, category, String.valueOf(spiceness), String.valueOf(price)});
    }


    public void addFirst() {
        if (!firstTimeRun) {
            DishItem dishItem1 = new DishItem(1, "Pasta curry", "Pasta", 0, 220);
            DishItem dishItem2 = new DishItem(2, "Momo", "curry", 2, 230);
            DishItem dishItem3 = new DishItem(3, "Chowmin", "Pizza", 1, 150);
            DishItem dishItem4 = new DishItem(4, "Chow chow soup", "Soup", 0, 90);
            DishItem dishItem5 = new DishItem(5, "Chicken Roast", "Roast", 1, 170);

            DishItemFileSystem.getOurInstance().AddDishItems(dishItem1);
            DishItemFileSystem.getOurInstance().AddDishItems(dishItem2);
            DishItemFileSystem.getOurInstance().AddDishItems(dishItem3);
            DishItemFileSystem.getOurInstance().AddDishItems(dishItem4);
            DishItemFileSystem.getOurInstance().AddDishItems(dishItem5);

            for (DishItem a : DishItemFileSystem.getOurInstance().getDishItemArrayList()) {
                defaultTableModel.addRow(new String[]{String.valueOf(a.getDishNumber()), a.getDishName(), a.getCategory(), String.valueOf(a.getSpicinessName()), String.valueOf(a.getPrice())});
            }
            firstTimeRun = true;
        }
    }
}
