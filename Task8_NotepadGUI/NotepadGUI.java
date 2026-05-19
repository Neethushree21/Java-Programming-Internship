import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class NotepadGUI extends JFrame implements ActionListener {

    JTextArea textArea;

    JMenuItem open, save;

    public NotepadGUI() {

        setTitle("Simple Notepad");

        textArea = new JTextArea();

        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");

        open = new JMenuItem("Open");
        save = new JMenuItem("Save");

        open.addActionListener(this);
        save.addActionListener(this);

        fileMenu.add(open);
        fileMenu.add(save);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        setSize(500, 500);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        JFileChooser chooser = new JFileChooser();

        if(e.getSource() == open) {

            int option = chooser.showOpenDialog(this);

            if(option == JFileChooser.APPROVE_OPTION) {

                File file = chooser.getSelectedFile();

                try {

                    BufferedReader br =
                            new BufferedReader(new FileReader(file));

                    textArea.read(br, null);

                    br.close();

                } catch(Exception ex) {
                    System.out.println(ex);
                }
            }
        }

        if(e.getSource() == save) {

            int option = chooser.showSaveDialog(this);

            if(option == JFileChooser.APPROVE_OPTION) {

                File file = chooser.getSelectedFile();

                try {

                    BufferedWriter bw =
                            new BufferedWriter(new FileWriter(file));

                    textArea.write(bw);

                    bw.close();

                } catch(Exception ex) {
                    System.out.println(ex);
                }
            }
        }
    }

    public static void main(String[] args) {

        new NotepadGUI();
    }
}