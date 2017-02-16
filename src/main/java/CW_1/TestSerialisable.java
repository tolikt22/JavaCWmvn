package CW_1;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vitaliy
 */
public class TestSerialisable {

    public void serialize(ClassForSerialize cfs) throws IOException {
        FileOutputStream fos = new FileOutputStream("C://SomeDir//object.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(cfs);
        oos.flush();
        oos.close();
    }

    public ClassForSerialize deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("C://SomeDir//object.out");
        ObjectInputStream oin = new ObjectInputStream(fis);
        return (ClassForSerialize) oin.readObject();
    }

    public static void main(String[] args) {
        TestSerialisable serialisable = new TestSerialisable();
        ClassForSerialize cfs = new ClassForSerialize();

        try {
            serialisable.serialize(cfs);
            System.out.println(serialisable.deserialize());
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(TestSerialisable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
