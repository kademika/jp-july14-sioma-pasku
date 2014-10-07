package com.kademika.sort.use;

/**
 * Created by Админ on 11.07.2014.
 */

import com.kademika.sort.action.Action;
import com.kademika.sort.domains.TovarCar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import javax.swing.JComponent;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableColumn;


public class Sort implements Serializable{
    Graphics g;
    private Action a;
    private int prodIndex = 0;
    private int id = 0;
    JPanel pProducts;
    MyPanel jPanel;
    MyPanel jPanel1;
    MyPanel jPanel2;
    MyPanel jPanel3;
    JFrame f;
    Vector<String> dataForTable;
    Vector<String> dataForTable1;
    Vector<Vector> dataForTable2;
    Vector<String> data;
    Vector<Vector> data1;
    private int size = 0;
    private int summ = 0;
    private static Queue<Pokupatel> listOfPokupatel;
    private File file;

    public static Queue<Pokupatel> getListOfPokupatel() {
        return listOfPokupatel;
    }
    public static void wr(File file, Pokupatel p) throws IOException {
        try(ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));){
            os.writeObject(p);
        }
    }
    public Sort() {
        file = new File("sort.txt");
        listOfPokupatel=new LinkedBlockingQueue<>();
        a = new Action();
        data = new Vector();
        data1 = new Vector();
        data.add("time");
        data.add("buyew");
        data.add("pokupla");
        data.add("pokupla");
        data.add("pokupla");
        data.add("pokupla");
        data.add("pokupla");
        data1.add(data);
        dataForTable1 = new Vector();
        dataForTable2 = new Vector();
        f = new JFrame("Sort of car");
        f.setLocation(100, 150);
        f.setMinimumSize(new Dimension(700, 420));
        f.setResizable(false);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createSellaPannel();
        paintEl(0);
        f.getContentPane().add(jPanel1);
        f.pack();
        f.setVisible(true);
    }


    private void createSellaPannel() {
        jPanel1 = new MyPanel();
        jPanel2 = new MyPanel();
        jPanel3 = new MyPanel();
        BorderLayout br = new BorderLayout();
        jPanel1.setLayout(br);
        jPanel = new MyPanel();
        jPanel.setMaximumSize(new Dimension(700, 250));
        jPanel1.add(BorderLayout.CENTER,jPanel);
        jPanel.setLayout(new GridBagLayout());
//        jPanel.setSize(new Dimension(f.getWidth(), f.getHeight()));
        JLabel label1 = new JLabel("Name of buyer", JLabel.LEFT);
        final JTextField tfName = new JTextField(10);
        jPanel.add(label1, new GridBagConstraints(0, 0, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        jPanel.add(tfName, new GridBagConstraints(1, 0, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, 0, new Insets(-40, 10, 0, 0),
                100, 0));
        JLabel label2 = new JLabel("Choose the goods");
        Vector listOfCar = new Vector();
        for (int i = 0; i < a.getCar().size(); i++) {
            if (!checkTheName(listOfCar, a.getCar().get(i).getName().substring(0, a.getCar().get(i).getName().indexOf("_")))) {
                listOfCar.add(a.getCar().get(i).getName().substring(0, a.getCar().get(i).getName().indexOf("_")));
            }
        }
        JComboBox petList = new JComboBox(listOfCar);
        petList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                pProducts.setVisible(false);
                pProducts = null;
                id = cb.getSelectedIndex();
                paintEl(id);
                pProducts.setVisible(true);
                jPanel.repaint();

            }

        });
        final JPanel pProd = new JPanel();
        pProd.add(petList);
        jPanel.add(label2, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, 0, new Insets(-70, 0, 0, 0), 0,
                0));
        jPanel.add(petList, new GridBagConstraints(1, 1, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, 0, new Insets(-75, 10, 0, 0), 0,
                0));

        JLabel label3 = new JLabel("Amount of goods", JLabel.LEFT);
        label3.setHorizontalTextPosition(JLabel.LEFT);
        jPanel.add(label3,
                new GridBagConstraints(0, 2, 1, 1, 0, 0,
                        GridBagConstraints.LINE_START, 0, new Insets(10, 0, 0,
                        0), 0, 0));
        NumberFormat nf = NumberFormat.getNumberInstance();
        final JFormattedTextField tfCount = new JFormattedTextField(nf);
        tfCount.setValue(1);

        jPanel.add(tfCount, new GridBagConstraints(1, 2, 1, 1, 0, 0,
                GridBagConstraints.LINE_START, 0, new Insets(10, 10, 0, 0), 0,
                0));
        label1.setFont(new Font("Verdana", Font.BOLD, 10));

        label2.setFont(new Font("Verdana", Font.BOLD, 10));

        label3.setFont(new Font("Verdana", Font.BOLD, 10));

        JButton b1 = new JButton("buy");
        jPanel.add(b1, new GridBagConstraints(1, 3, 1, 1, 0, 0, 21, 0, new Insets(5,
                10, 0, 0), 0, 0));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (tfName.getText().equals("")) {
                    JOptionPane.showConfirmDialog(null,
                            "please, enable your name", "Warning!!!",
                            JOptionPane.PLAIN_MESSAGE);
                } else {
                    Pokupatel p = new Pokupatel();
                    p.setNameOfBuyer(tfName.getText());
                    p.setVozrast(new Random().nextInt(65));
                    TovarCar t1 = a.getCar().get(prodIndex);
                    int count = Integer.parseInt(tfCount.getText());
                            p.setPayment(t1.getCost());
                    listOfPokupatel.add(p);
                    writePokupatelToFile(p);
                    try {
                        wr(file,p);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
//                    a.sell(t1, p.getNameOfBuyer(), count);
                    summ += count * t1.getCost();
                    paintResult(t1, count, p);

                }
            }
        });
    }

    private void writePokupatelToFile(Pokupatel p){
        try(ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));){
            os.writeObject(p);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public  List<Pokupatel> readFromFile(){
        Pokupatel s=null;
        List<Pokupatel>pok = new ArrayList<>();
        try(ObjectInputStream oi = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));){
            int i=0;
          while(i<2){
              pok.add(s);
                i++;
          }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return pok;
        }
    }
    private int flag12 = 0;

    private void paintResult(TovarCar t1, int count, Pokupatel p) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MMM/yyyy");

        dataForTable1.add("№");
        dataForTable1.add("name of tovar");
        dataForTable1.add("Buyer");
        dataForTable1.add("time      ");
        dataForTable1.add("how many");
        dataForTable1.add("cost");
        dataForTable1.add("in general");
        dataForTable = new Vector();
        dataForTable.add(size + ")");
        dataForTable.add(t1.getName());
        dataForTable.add(p.getNameOfBuyer());
        dataForTable.add(sdf.format(new Date()) + "");
        dataForTable.add(count + "");
        dataForTable.add(t1.getCost() + "");
        dataForTable.add(summ + "");
        size++;
        if (flag12 == 0) {
            dataForTable2.add(dataForTable1);
            flag12 = 1;
        }
        dataForTable2.add(dataForTable);
        JTable jTable = new JTable(dataForTable2, data);
//        jPanel3.add(jTable, new GridBagConstraints(0, 0, 0,0, 0, 0, 0, 0, new Insets(0,
//                0, 0, 0), 0, 0));
        jPanel.setAutoscrolls(true);
//        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(jTable);
        jPanel2.setBorder(BorderFactory.createLineBorder(Color.RED));
        jTable.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
        jPanel1.add(BorderLayout.SOUTH,jPanel2);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        jPanel.repaint();
        jPanel2.repaint();
        jPanel1.repaint();
    }

    private int k;

    private boolean checkTheName(Vector v, String name) {
        for (Object n : v) {
            if (n != null && n.toString().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkChooseTovar(int i, String name) {
        if (i == 0 && name.equals("Bmw")) {
            return true;
        } else if (i == 1 && name.equals("Audi")) {
            return true;
        } else if (i == 2 && name.equals("Mosckvich")) {
            return true;
        }
        return false;
    }

    private void paintEl(int id1) {
        int size = 0;
        ButtonGroup productsGroup = new ButtonGroup();
        pProducts = new JPanel();

        pProducts.setBorder(BorderFactory.createLineBorder(Color.CYAN));
        ActionListener rListener = new RBListener();
        for (int i = 0; i < a.getCar().size(); i++) {
            JRadioButton rb;
            if (checkChooseTovar(id1, a.getCar().get(i).getName().substring(0, a.getCar().get(i).getName().indexOf("_")))) {
                rb = new JRadioButton(a.getCar().get(i).getName());
                rb.setActionCommand(String.valueOf(i));
                rb.addActionListener(rListener);
                rb.setSelected(true);
                productsGroup.add(rb);
                pProducts.add(rb);
                size++;
            }
        }
        pProducts.setLayout(new GridLayout(size, 0));
        jPanel.add(pProducts,
                new GridBagConstraints(2, 1, 1, 1, 0, 0,
                        GridBagConstraints.LINE_START, 0, new Insets(-5, 0, 0,
                        0), 0, 0));
    }

    public List<TovarCar> printCar(List<TovarCar> car) {
        List<TovarCar> car1 = new ArrayList<>();
        for (int i = 0; i < car.size(); i++) {
            fillCar(car.get(i), car1);
        }
        return car1;

    }

    private void fillCar(TovarCar car, List<TovarCar> car1) {
        for (int i = 0; i < car1.size(); i++) {
            if (car1 == null || !car1.get(i).getClass().getComponentType().getClass().getSimpleName().equals(car.getClass().getSimpleName())) {
                car1.add(car);
                break;
            }
        }
    }


    public class RBListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            prodIndex = Integer.parseInt(e.getActionCommand());

        }

    }


    public class MyPanel extends JPanel {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }
}
