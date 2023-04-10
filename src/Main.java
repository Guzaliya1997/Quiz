import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws IOException {
            String s;
            Questions qu = new Questions();
            CSVFile csv = new CSVFile();

            System.out.println("Как Вас зовут?");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            try (FileWriter fw = csv.fw; BufferedReader bufferedReader = csv.readfile) {
                // считываем построчно
                csv.line = null;
                Scanner scanner = null;


                s = br.readLine();
                csv.fw.write(s + "\r\n");


                while ((csv.line = csv.readfile.readLine()) != null) {
                    scanner = new Scanner(csv.line);
                    scanner.useDelimiter(qu.delimiter);
                    qu.delimiterSum = qu.countOfAnswers(csv.line);
                    while (scanner.hasNext()) {
                        csv.data = scanner.next();
                        qu.setQuestion(csv.data);
                        System.out.println(csv.data);

                    }
                    s = br.readLine();
                    qu.input = Integer.parseInt(s);
                    if (!qu.isUsable(qu.input))
                        System.out.println("Такого варианта не существует.");
                    else
                        csv.fw.write(s + "\r\n");

                }

            } catch (FileNotFoundException e) {
                System.out.println("exception io" + e);
            } catch (EOFException e) {
                throw new RuntimeException(e);
            }
            System.out.println("До свидания");
        }
}
