package Leetcode_Problems.APICAllingJava;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import java.util.Scanner;

public class ApiCalling {

    public static void main(String[] args) {


        try {
            URL url = new URL("https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            // int responseCode = conn.getResponseCode();
            // if (responseCode != 200) {
            //     throw new RuntimeException("HttpResponseCode: " + responseCode);
            // } else {
                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());
                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();
                JSONParser parse = new JSONParser();
                JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));
                JSONObject[] allData = new JSONObject[dataObject.size()];
                for (int i = 0; i < dataObject.size(); i++) {
                    allData[i] = (JSONObject) dataObject.get(i);
                }
                System.out.println(allData[1].get("name"));
            // }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}