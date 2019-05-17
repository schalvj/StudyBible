package sample;

import javafx.collections.ObservableList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class API {

    public static String getBible(){

        JSONParser parser = new JSONParser();

        String bible = null;
        Document doc = null;
        try{
            URL url = new URL("https://api.scripture.api.bible/v1/bibles?language=eng");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("api-key", "a40fb89ccdfd0024f46450e72065d34e");
            con.setRequestProperty("Accept", "application/json");
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error Code : " + con.getResponseCode());
            }
            Object object = new JSONParser().parse(new InputStreamReader(con.getInputStream()));
            JSONObject jOB = (JSONObject) object;
            JSONObject refined = (JSONObject) jOB.get("data");
            bible = (String) refined.get("content");
            System.out.println(bible);
            doc = Jsoup.parse(bible);
            bible = doc.text();

            con.disconnect();

        } catch(Exception e){
            System.out.println("Exception in NetClientGet:- " + e);
        }

        return bible;
    }


}