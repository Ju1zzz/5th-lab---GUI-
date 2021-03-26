package com.company;


import com.company.data.Monarchy;
import com.company.data.Republic;
import com.company.data.State;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JTable table;
    private JButton buttonAdd,  buttonFind,buttonDelete;
    private MyModel model;
    private JTextField filterText;
    private TableRowSorter<MyModel> sorter;
    public MainWindow() {
        super("United Nations");
        setSize(600, 300);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        model = new MyModel();
        table = new JTable(model);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        JScrollPane jScrollPane = new JScrollPane(table);
        this.add(jScrollPane);
        table.setSelectionForeground(Color.darkGray);
        table.setSelectionBackground(Color.pink);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(MenuChange());
        JPanel b = new JPanel();
        b.setLayout(new FlowLayout());
        init();
        b.add(buttonAdd);
        b.add(buttonDelete);
        add(menuBar, BorderLayout.SOUTH);
        JLabel label = new JLabel("Search");
        b.add(label);
        filterText = new JTextField(10);
        b.add(filterText);
        b.add(buttonFind);
        add(b, BorderLayout.NORTH);
        buttonDelete.addActionListener(new MyListener());
        buttonFind.addActionListener(new MyListener());
        buttonAdd.addActionListener(new MyListener());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void init() {
        buttonAdd = new JButton("Add");
        buttonFind = new JButton("Find country");
        buttonDelete = new JButton("Delete sign");
    }
    private JMenu MenuChange(){
        JMenu menu=new JMenu("Change");
        JMenuItem m=new JMenuItem("Monarchy");
        JMenuItem r=new JMenuItem("Republic");
        menu.setPreferredSize(new Dimension(600,30));
         m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Change();
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(MainWindow.this, "Choose sign!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (ClassCastException exc){ JOptionPane.showMessageDialog(MainWindow.this, "Choose Monarchy!", "Error", JOptionPane.ERROR_MESSAGE); }

            }
        });

        r.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Change1();
               } catch (IndexOutOfBoundsException ex1) {
                    JOptionPane.showMessageDialog(MainWindow.this, "Choose sign!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (ClassCastException exc1){ JOptionPane.showMessageDialog(MainWindow.this, "Choose Republic!", "Error", JOptionPane.ERROR_MESSAGE); }
            }
        });

        menu.add(m); menu.add(r);
        return menu;
    }
    class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Delete sign")) {
                try {
                    model.Remove(table.getSelectedRow());
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(MainWindow.this, "Choose sign!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (e.getActionCommand().equals("Find country")) {
                String text = filterText.getText();
                if (text.length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter(text));
                }
            }
            else if (e.getActionCommand().equals("Add")) {
                new Addition();
            }
        }
    }
    class Addition extends JFrame {
        JTextField  textTitle,textArea, textPopulation, textLivelihood,textYears, textNameBoss;
        JLabel title,area,population,livelihood,years,nameboss;
        JTextField textId1, textTitle1,textArea1, textPopulation1, textLivelihood1;
        JLabel title1,area1,population1,livelihood1;
        JButton add, add1;
        public Addition(){
            super("Addition");
            setSize(600, 300);
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JTabbedPane tabs = new JTabbedPane();
            JPanel Monarchy=new JPanel();
            JPanel Republic = new JPanel();
            tabs.addTab("Monarchy", Monarchy);
            tabs.addTab("Republic", Republic);
            init1();
            GridLayout gl = new GridLayout(12, 2, 1, 3);
            Monarchy.setLayout(gl);
            Republic.setLayout(gl);
            Monarchy.add(title); Monarchy.add(textTitle); Monarchy.add(area);Monarchy.add(textArea);
            Monarchy.add(population); Monarchy.add(textPopulation);Monarchy.add(livelihood); Monarchy.add(textLivelihood);
            Monarchy.add(nameboss); Monarchy.add(textNameBoss); Monarchy.add(add);
            Republic.add(title1); Republic.add(textTitle1); Republic.add(area1);Republic.add(textArea1);
            Republic.add(population1); Republic.add(textPopulation1);Republic.add(livelihood1); Republic.add(textLivelihood1);
            Republic.add(years); Republic.add(textYears); Republic.add(add1);
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try { int id= table.getRowCount();
                        model.Add(new Monarchy(textTitle.getText(), Float.parseFloat(textArea.getText()),
                                Float.parseFloat(textPopulation.getText()), textNameBoss.getText(),Integer.parseInt(textLivelihood.getText())));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Addition.this, "Enter correct value!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    textTitle.setText(null);
                    textArea.setText(null);
                    textPopulation.setText(null);
                    textNameBoss.setText(null);
                    textLivelihood.setText(null);
                }
            });
            add1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try { int id = table.getRowCount();
                        model.Add(new Republic(textTitle1.getText(), Float.parseFloat(textArea1.getText()),
                                Float.parseFloat(textPopulation1.getText()), Integer.parseInt(textLivelihood1.getText()), Integer.parseInt(textYears.getText())));
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Addition.this, "Enter correct value!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    textTitle.setText(null);
                    textArea.setText(null);
                    textPopulation.setText(null);
                    textYears.setText(null);
                    textLivelihood.setText(null);
                }
            });
            tabs.setBackground(Color.darkGray);
            tabs.setForeground(Color.gray);
            this.add(tabs);
            this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }
        private void init1(){
            textTitle = new JTextField(50);
            textArea = new JTextField(10);
            textPopulation = new JTextField(20);
            textLivelihood = new JTextField(10);
            textYears = new JTextField(10);
            textNameBoss = new JTextField(50);
            title = new JLabel("Title");
            area = new JLabel("Area");
            population = new JLabel("Population");
            livelihood = new JLabel("Livelihood");
            years = new JLabel("Years of management");
            nameboss = new JLabel("Name of Leader");
            textId1 = new JTextField(10);
            textTitle1 = new JTextField(50);
            textArea1 = new JTextField(10);
            textPopulation1 = new JTextField(20);
            textLivelihood1 = new JTextField(10);
            title1 = new JLabel("Title");
            area1 = new JLabel("Area");
            population1 = new JLabel("Population");
            livelihood1 = new JLabel("Livelihood");
            add = new JButton("Add");
            add1=new JButton("Add");
        }}
    class Change extends JFrame{
        public Change(){
            super("Change");
            setSize(600, 300);
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            State state=model.getValueAt(table.getSelectedRow());
            JPanel panel=new JPanel();
            JButton button=new JButton("Change");
            GridLayout gl = new GridLayout(5, 1, 1, 3);
            panel.setLayout(gl);

            JTextField title = new JTextField(20); title.setText(state.getTitle());
            JTextField area = new JTextField(10);  area.setText(String.valueOf(state.getArea()));
            JTextField population = new JTextField(20); population.setText(String.valueOf(state.getPopulation()));
            JTextField nameboss = new JTextField(10);  nameboss.setText(String.valueOf(((Monarchy) state).getNameBoss()));
            JTextField livelihood = new JTextField(20); livelihood.setText(String.valueOf(state.getLiveLihood()));

            int id=table.getSelectedRow();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   model.setValueAt(new Monarchy(title.getText(),Float.parseFloat(area.getText()), Float.parseFloat(population.getText()),nameboss.getText(), Integer.parseInt(livelihood.getText())), id);
                dispose();
                }
            });
            panel.add(title); panel.add(area); panel.add(population);panel.add(nameboss);panel.add(livelihood);
            add(button, BorderLayout.SOUTH);
            add(panel);
            this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
        }

}
    class Change1 extends JFrame{
        public Change1(){
            super("Change");
            setSize(600, 300);
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            State state1=model.getValueAt(table.getSelectedRow());
            JPanel panel=new JPanel();
            JButton button=new JButton("Change");
            GridLayout gl = new GridLayout(5, 1, 1, 3);
            panel.setLayout(gl);

            JTextField title = new JTextField(20); title.setText(state1.getTitle());
            JTextField area = new JTextField(10);  area.setText(String.valueOf(state1.getArea()));
            JTextField population = new JTextField(20); population.setText(String.valueOf(state1.getArea()));
            JTextField years = new JTextField(10);  years.setText(String.valueOf(((Republic) state1).getYears()));
            JTextField livelihood = new JTextField(20); livelihood.setText(String.valueOf(state1.getLiveLihood()));

            int id=table.getSelectedRow();
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setValueAt(new Republic(title.getText(),Float.parseFloat(area.getText()), Float.parseFloat(population.getText()),Integer.parseInt(years.getText()), Integer.parseInt(livelihood.getText())), id);
                    dispose();
                }
            });
            panel.add(title); panel.add(area); panel.add(population);panel.add(years);panel.add(livelihood);
            add(button, BorderLayout.SOUTH);
            add(panel);
            this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
    }
}}
