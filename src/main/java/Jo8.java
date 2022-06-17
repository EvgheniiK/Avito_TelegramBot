import java.io.*;

public class Jo8 {
    public static void main(String[] args) throws IOException {

        try (FileWriter writer = new FileWriter("notes3.txt", true)) {
            // запись всей строки
            String text = "qwerty";
//            writer.write(text, 2, 2);
//            // запись по символам
//            writer.append('\n');
//            writer.append("1234", 2, 4);
//
//            writer.flush();

//rw- read/write, файл открыт и для чтения и для записи
            RandomAccessFile raf = new RandomAccessFile("notes3.txt", "rw");

//пишем в файл строку, начиная с 0-го байта
          //  raf.writeBytes("It is a string");
            long ff = raf.length()-14;
//ставим курсор на 8-й символ
            raf.seek(ff);
//печатаем в файл строку surprise!
            byte[] b ;

            raf.writeBytes("sur \n");

//закрываем файл
            raf.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }




    }
}

