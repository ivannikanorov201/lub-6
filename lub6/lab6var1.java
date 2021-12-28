import java.io.*;
import java.util.Scanner;

/*Переписать в результирующий файл слова, начинающиеся с гласных букв.*/

public class lab6var1 {

    public static boolean check(String words) {
        String letters = "ёЁуУеЕыЫаАоОэЭяЯиИюЮ";
        char firstChar = words.charAt(0);
        for (int i = 0; i < letters.length(); i++) {
            if (firstChar == letters.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        InputStream in = null;
        Reader file = null;
        BufferedReader buf = null;

        OutputStream out = null;
        Writer wr = null;
        try {
            in = new FileInputStream("C:\\java\\in.txt");
            file = new InputStreamReader(in, "utf-8");
            buf = new BufferedReader(file);

            File f1 = new File("C:\\java\\out.txt");
            f1.createNewFile();
            out = new FileOutputStream(f1);
            wr = new OutputStreamWriter(out, "utf-8");
            String line = " ";
            String[] words;
            while ((line = buf.readLine()) != null) {
                words = line.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if(check(words[i])){
                        wr.append(words[i] + " ");
                        System.out.println(words[i] + " ");
                        }
                    }
                wr.append("\n");
                System.out.println();
            }
        }
        catch(IOException io){
            io.printStackTrace();
        }
        finally{
            in.close();
            file.close();
            buf.close();
            wr.flush();
            wr.close();
            out.close();
        }
    }
}
