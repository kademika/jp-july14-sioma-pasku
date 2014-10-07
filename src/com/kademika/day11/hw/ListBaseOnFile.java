package com.kademika.day11.hw;

import com.kademika.day11.f7.Characters;
import com.perforce.p4java.impl.mapbased.rpc.CommandEnv;

import java.io.*;
import java.rmi.activation.ActivationGroupDesc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Админ on 07.08.2014.
 */
public class ListBaseOnFile implements ISimpleList {
    private File file;
    private List<String> stringList;
    private String objectStr = null;
    private int containsElement, numberOfAdded;
    private int position, elementAddedInList;

    public ListBaseOnFile(File file) {
        this.file = file;
        try {
            loadListFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getElementAddedInList() {
        int lastedAddedNumber, returnedNumber = 0;
        for (String list : stringList) {
            if (list.length() > 1) {
                lastedAddedNumber = Integer.parseInt(list.toString().substring(0, list.toString().indexOf(")")));
                if (lastedAddedNumber >= stringList.size() && lastedAddedNumber >= returnedNumber) {
                    returnedNumber = lastedAddedNumber + 1;
                } else if (stringList.size() == 0) {
                    returnedNumber = stringList.size();
                }
            }
        }
        return returnedNumber;
    }

    @Override
    public void add(Object object) {
        checkObject(object);
        int count = 0;//flag
        numberOfAdded++;
        try {
            loadListFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i <= stringList.size(); i++) {
                if (i == stringList.size()) {
                    if (count == 0) {
                        bw.write(((getElementAddedInList())) + ")" + objectStr + "\n");
                        position += 1;
                    }
                } else if (stringList.get(i) != null && !stringList.get(i).substring((stringList.get(i).indexOf(")") + 1)).equals("")) {
                    bw.write(stringList.get(i) + "\n");
                } else if (stringList.get(i).substring((stringList.get(i).indexOf(")") + 1)).equals("") && count == 0) {
                    bw.write(((getElementAddedInList())) + ")" + objectStr + "\n");
                    count = 1;
                } else if (count == 1) {
                    bw.write(stringList.get(i) + "\n");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void checkObject(Object object) {
        if (object instanceof String) {
            objectStr = (String) object;
        } else {
            objectStr = object.getClass().getSimpleName();
        }
    }

    @Override
    public boolean contains(Object object) {
        containsElement = 0;
        checkObject(object);
        try {
            loadListFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String list : stringList) {
            if (list.length() > 3 && (list.toString().substring(2).equals(objectStr) || list.toString().substring(3).equals(objectStr))) {
                return true;
            }
            containsElement++;
        }

        return false;
    }

    @Override
    public void remove(Object object) {
        if (contains(object)) {
            stringList.set((containsElement), stringList.get(containsElement).substring(0, stringList.get(containsElement).indexOf(")")) + ")");
            writeToFile();
        }
    }

    private void writeToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < stringList.size(); i++) {
                if (stringList.get(i) != null) {
                    bw.write(stringList.get(i), 0, stringList.get(i).length());
                    bw.write("\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadListFromFile() throws Exception {
        BufferedReader br = null;
        stringList = new LinkedList<>();
        br = new BufferedReader(new FileReader(file));
        String i;
        int j = 0;
        position = 0;
        while ((i = br.readLine()) != null) {
            stringList.add(i);
            position++;
        }
        br.close();
    }

    private int readFromFile() {
        int size = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file));) {
            String i;
            while ((i = br.readLine()) != null) {
                size++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return size;
    }

    private void sortList(String[] m) {
        String current;
        int t = 0;
        while (t < m.length) {
            for (int i = 0; i < m.length; i++) {
                if ((i + 1) < m.length && m[i + 1] != null) {
                    if (Integer.parseInt(m[i].substring(0, m[i].indexOf(")"))) > Integer.parseInt(m[i + 1].substring(0, m[i + 1].indexOf(")")))) {
                        current = m[i];
                        m[i] = m[i + 1];
                        m[i + 1] = current;
                    }
                }
            }
            t++;
        }

    }

    @Override
    public int size() {
        try {
            loadListFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readFromFile();
    }

    @Override
    public Iterator iterator() {
//        return  stringList.iterator();
        return new FileIterator();
    }


    class FileIterator implements Iterator {
        private int countOfElementIterator;
        private List newStr;
        private boolean flag;
        private String previous, next;

        public FileIterator() {
            try {
                loadListFromFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            newStr = new ArrayList();
            fillSortList();
        }

        private void fillSortList() {
            String[] str = new String[stringList.size()];
            for (int h = 0; h < stringList.size(); h++) {
                str[h] = stringList.get(h);
            }
            sortList(str);
            for (int i = 0; i < str.length; i++) {
                newStr.add(str[i]);
            }
        }

        @Override
        public boolean hasNext() {
            int n = countOfElementIterator;
            while (n < newStr.size()) {
                if (flag) {
                    next = (String) newStr.get(countOfElementIterator);
                    countOfElementIterator++;
                    flag = false;
                }
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            flag = true;
            if (hasNext()) {
                return next;
            }
            return null;
        }

        @Override
        public void remove() {
            for (int i = 0; i < stringList.size(); i++) {
                if (stringList.get(i + 1) == null) {
                    stringList.remove(i);
                    break;
                }
            }
        }
    }
}
