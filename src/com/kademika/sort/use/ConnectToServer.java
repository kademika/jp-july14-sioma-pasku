package com.kademika.sort.use;

import com.kademika.sort.action.*;
import com.kademika.sort.action.Action;
import com.kademika.sort.domains.Bmw;
import com.kademika.sort.domains.TovarCar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.*;
import java.util.List;

/**
 * Created by Админ on 09.09.2014.
 */
public class ConnectToServer extends JPanel {
    private JFrame f;
    private List<TovarCar> listOfCar;
    private Queue<Pokupatel>listOfBuyer;
    private int currentPoint;
    private Vector data;

    public ConnectToServer() {
        listOfCar = new ArrayList<>();
        f = new JFrame("connect to Sort");
        f.setLocation(100, 150);
        f.setMinimumSize(new Dimension(700, 420));
        f.setResizable(false);
        f.getContentPane().add(this);
        this.setLayout(new BorderLayout());
        createSellaPannel();
        f.pack();
        f.setVisible(true);
         data = new Vector();
        data.add("Model");
        data.add("Price");
        data.add("Type");
        data.add("Remain");

    }

int i=0;
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private JPanel panel1;
    private JComboBox petList;

    private void createSellaPannel() {
        GridLayout layout = new GridLayout(1, 1);
        panel1 = new JPanel();
        panel1.setLayout(layout);
        final JTextField txt = new JTextField(10);
        txt.setSize(new Dimension(250, 50));
        JButton button = new JButton("Get");
        button.setSize(new Dimension(250, 50));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(txt.getText().equals("get the buyers")){
                    connectToSortServer1(txt.getText());
                    for (Pokupatel buyer : listOfBuyer) {
                        petList.addItem(buyer.getNameOfBuyer());
                    }
                }
                else {
                    connectToSortServer(txt.getText());
                    for (TovarCar car : listOfCar) {
                        petList.addItem(car.getName());
                    }
                }
            }
        });
        panel1.add(txt);
        panel1.add(button);

        petList = new JComboBox();
        petList.setSize(new Dimension(300,100));
        petList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                currentPoint = cb.getSelectedIndex();
                add("South", addTheTable(currentPoint));

            }
        });
        this.add("North", panel1);
        this.add("Center", petList);
    }
    private JTable addTheTable(int i) {
        Vector data1 = new Vector();
        Vector data2 = new Vector();
        if (!listOfCar.isEmpty()) {
            data1.add(listOfCar.get(i).getName());
            data1.add(listOfCar.get(i).getCost());
            data1.add(listOfCar.get(i).getKategoryi());
            data1.add(listOfCar.get(i).getKolModel());
        }

        data2.add(data1);
        return new JTable(data2,data);
    }

    private void connectToSortServer(String data) {
        try (
                Socket socket = new Socket("localhost", 4444);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                InputStream in1 = socket.getInputStream();
                ObjectInputStream in = new ObjectInputStream(in1);
        ) {
            out.writeObject(data);
            try {
                listOfCar = (List<TovarCar>) in.readObject();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (EOFException e) {
                System.err.println("UPS!!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void connectToSortServer1(String data) {
        try (
                Socket socket = new Socket("localhost", 4444);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                InputStream in1 = socket.getInputStream();
                ObjectInputStream in = new ObjectInputStream(in1);
        ) {
            out.writeObject(data);
            try {
                listOfBuyer = (Queue<Pokupatel>) in.readObject();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (EOFException e) {
                System.err.println("UPS!!!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ConnectToServer();
    }


}
