package NewOne;

import OldOne.MenuInfo;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainJFrame extends JFrame implements ActionListener {
    JMenuBar mb;
    JMenu file, help;
    JMenuItem openJMenuItem, exitMenuItem;

    public MainJFrame() {
        TitleAndSearch titleAndSearch = new TitleAndSearch();
        JPanel jPanelForTable = new MainPanelForTable();
        openJMenuItem = new JMenuItem("Open");
        openJMenuItem.addActionListener(this);
        exitMenuItem = new JMenuItem("Exit");
        mb = new JMenuBar();
        file = new JMenu("File");
        help = new JMenu("Help");
        file.add(openJMenuItem);
        file.add(exitMenuItem);
        exitMenuItem.addActionListener(this);
        mb.add(file);
        mb.add(help);
        add(mb);
        setJMenuBar(mb);
        setTitle("Song in.");
        add(titleAndSearch);
        add(jPanelForTable);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 251));
        setSize(917, 690);
        setLocationRelativeTo(null);
    }

    public void openFromJMenuBar() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        fileChooser.setFileFilter(imageFilter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(this, "File " + selectedFile.getName() + " File is opened", "Opened", JOptionPane.INFORMATION_MESSAGE);
            try {
                Desktop.getDesktop().open(new File(selectedFile.toURI()));
            } catch (IOException ex) {
                Logger.getLogger(MenuInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(exitMenuItem)) {
            System.exit(0);
        }
        if (e.getSource().equals(openJMenuItem)) {
            openFromJMenuBar();
        }
    }
}
