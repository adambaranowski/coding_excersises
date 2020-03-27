package InternetConectionTesting;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Conectiontest2 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://daddy.usermd.net/");

        HttpURLConnection con = (HttpURLConnection)url.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        con.getContent();
        System.out.println(con.getContent());

    }
}
