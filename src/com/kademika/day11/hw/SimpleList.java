package com.kademika.day11.hw;

import com.kademika.day11.f7.Characters;

import java.io.*;
import java.util.Iterator;

/**
 * Created by Админ on 18.07.2014.
 */
public class SimpleList<T> implements ISimpleList {
    private File file;
    private String[] str;
    private int sizeOfFile;
    private boolean sweatchByDelene = false;

    public <T> SimpleList(File file) {
        this.file = file;
    }

    private void addStringToFile(Object o) {
        int count = 0;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < str.length; i++) {
                if (str[i] != null) {
                    bw.write(Characters.printCodePointerInfo(Integer.parseInt(str[i])));
                    bw.write(str[i]);
                }
                if (count == 0 && str[i] != null && str[i + 1] != null) {
                    if ((Integer.parseInt(str[i]) == 32 && Integer.parseInt(str[(i + 1)]) == 32)) {
                        writeToFile(bw, o);
                        count = 2;

                    } else if (str[i + 1] == null) {
                        writeToFile(bw, o);
                        return;
                    }
                } else if (str[i] == null) {
                    writeToFile(bw, o);
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(BufferedWriter bw, Object o) throws Exception {
        if (o.getClass().getSimpleName().equals("String")) {
            bw.write(o.toString() + " ");
        } else if (o instanceof Object) {
            bw.write(o.getClass().getSimpleName() + " ");
        }
        if (sizeOfFile != 0) {
            bw.write(" ");
        }
    }

    public void addToEndList(Object o) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            str = new String[(int) file.length()];
            int i = 0;
            int h = 0;
            do {
                str[h] = br.readLine();
                h++;
                if (i == -1) {
                    addObjectToEndList(o);
                    return;
                }
            } while ((i = br.read()) != -1);

        } catch (Exception e) {
        }

    }

    private void addObjectToEndList(Object o) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (int i = 0; i < str.length; i++) {
                bw.write(str[i]);
            }
            bw.write(o.toString());
        } catch (Exception e) {
        }
    }

    @Override
    public void add(Object o) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            sizeOfFile = (int) file.length();
            if (sizeOfFile != 0) {
                str = new String[sizeOfFile + 1];
            } else {
                str = new String[1024];
            }
            int i = 0;
            int i1 = 0;
            while ((i = br.read()) != -1) {
                str[i1] = i + "";
                i1++;
            }
            addStringToFile(o);
        } catch (Exception e) {
        }
    }

    @Override
    public boolean contains(Object o) {
        String gh = o.toString();
        try (BufferedWriter bg = new BufferedWriter(new FileWriter(file))) {
            int i = 0;
            int str1 = 0;
            for (int j = 0; j < str.length; j++) {
                if (str[j] != null) {
                    i = str[j].length();
                }
                for (int f2 = 0; f2 < i; f2++) {
                    if (str[j] != null && str[j].indexOf(f2, (gh.length() + f2)) < i && str[j].substring(f2, (gh.length() + f2)).equals(gh) && str1 == 0) {
                        if (sweatchByDelene) {
                            str[j] = str[j].replace(gh, " ");
                            sweatchByDelene = false;
                        }
                        str1++;
                        break;
                    }
                }
                if (bg != null && str[j] != null) {
                    bg.write(str[j]);
                    return true;
                }
            }
        } catch (Exception r) {
            r.printStackTrace();
        }

        return false;
    }

    @Override
    public void remove(Object o) {
        sweatchByDelene = false;
        String gh = o.toString();
        try (BufferedReader bg = new BufferedReader(new FileReader(file))) {
            sizeOfFile = (int) file.length();
            str = new String[sizeOfFile];
            int i = 0;
            while ((str[i] = bg.readLine()) != null) {
                i++;
            }
        } catch (Exception r) {
            System.err.print("Warning 1");
        }
        contains(o);
    }

    @Override
    public int size() {

        return sizeOfFile;
    }

    @Override
    public Iterator iterator() {
        return new FileIteraror();
    }

    public class FileIteraror implements Iterator {
        private void checkStream(){
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){

            }catch(Exception e){}
        }

        @Override
        public boolean hasNext() {
            for (int i = 0; i < str.length; i++) {
//               if(str[i].equals())
            }
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }
}
