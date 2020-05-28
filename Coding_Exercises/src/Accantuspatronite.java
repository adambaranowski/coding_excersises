import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Accantuspatronite {
    public static void main(String[] args) throws URISyntaxException, IOException {
        URL url = new URL("https://patronite.pl/accantus");
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream())
        );

        String inputString;
        StringBuilder content = new StringBuilder();
        while ((inputString = in.readLine()) != null) {
            content.append(inputString);
            content.append("\n");
        }
        in.close();
        String htmlDoc = content.toString();

        List<String> patronsCount = new ArrayList<>();

        for (int i = 0; i < htmlDoc.length() - 12; i++) {
            if (htmlDoc.substring(i, i + 12).equals("<p>Patroni: ")) {
                String count = "";
                int j = 0;
                while (!htmlDoc.substring(i + 12 + j, i + 13 + j).equals("<")) {
                    count += htmlDoc.substring(i + 12 + j, i + 13 + j);
                    j++;
                }
                patronsCount.add(count);
            }
        }

        int[] donations = {5, 10, 20, 30, 50, 100, 200, 500, 1000};
        int patronsTotal = 0;
        int incomeTotal = 0;

        System.out.println("***PATRONI***");
        for (int i = 0; i < patronsCount.size(); i++) {
            patronsTotal += Integer.parseInt(patronsCount.get(i));
            incomeTotal += Integer.parseInt(patronsCount.get(i)) * donations[i];

            System.out.println(donations[i] + "zł - " + patronsCount.get(i) + " patronów");
        }
        System.out.println("Wszystkich Patronów: " + patronsTotal);
        System.out.println("Cały przychod: " + incomeTotal + "zł");
        String s = "II";

}
}
