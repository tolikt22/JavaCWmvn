package CW_2.HW_2;

import java.io.*;

public class InputOutputStream {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        String dirPath_ = "c://TMPdir";
        String fileName = "readme.txt";
        String path = dirPath_ + "//" + fileName;
        File dirPath = new File(dirPath_);
        dirPath.mkdirs();

        writeTextToFile(text, path);
        readTextFromFile(path);
    }

    public static void writeTextToFile(String text, String path) {
        try (FileOutputStream fos = new FileOutputStream(path);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {

            byte[] buffer = text.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readTextFromFile(String path) {
        try {
            FileInputStream fin = new FileInputStream(path);
            InputStreamReader isr = new InputStreamReader(fin, "UTF-8");
            BufferedReader bis = new BufferedReader(isr);
            int i;
            while ((i = bis.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
