import java.util.*;
import java.io.*;

class StringReader {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n"); // Append newline character
            }
            br.close();
            String str = sb.toString();
            System.out.println(str);
	    if(str.charAt(2) == '\n')	System.out.print("**");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
