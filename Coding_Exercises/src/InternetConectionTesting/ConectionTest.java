package InternetConectionTesting;

import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ConectionTest {
    public static void main(String[] args) throws IOException {

        URL url = new URL("http://daddy.usermd.net/");


        URLConnection urlConnection = url.openConnection();


        System.out.println(urlConnection.getContentType());
        System.out.println(urlConnection.getContent());

        InputStream stream=urlConnection.getInputStream();
        int i;
        while((i=stream.read())!=-1){
            System.out.print((char)i);
        }



    }
}
