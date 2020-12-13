package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HttpUtils {

    public static String fetchDataGoogle(String _url) throws MalformedURLException, IOException{
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "server"); //remember if you are using SWAPI
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = "";
        
        while(scan.hasNext()) {
          jsonStr += scan.nextLine();
        }
        
        scan.close();
        
        return jsonStr;
  }
    
    public static String fetchDataCity(String _url) throws MalformedURLException, IOException {
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("x-rapidapi-key", "d12379afb6msh4e1abe29e50bca0p15e49ejsn56af46069613");
        con.setRequestProperty("x-rapidapi-host", "wft-geo-db.p.rapidapi.com");
        
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = "";
        
        while(scan.hasNext()) {
          jsonStr += scan.nextLine();
        }
        
        scan.close();
        
        return jsonStr;
    }
    
    public static String fetchDataCityDetails(String _url) throws MalformedURLException, IOException {
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("x-rapidapi-key", "d12379afb6msh4e1abe29e50bca0p15e49ejsn56af46069613");
        con.setRequestProperty("x-rapidapi-host", "wft-geo-db.p.rapidapi.com");

        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = "";
        
        while(scan.hasNext()) {
          jsonStr += scan.nextLine();
        }
        
        scan.close();
        
        return jsonStr;
    }
    
    public static String fetchData(String _url) throws MalformedURLException, IOException {
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("User-Agent", "server");

        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }

    public static String fetchData2(String _url) throws MalformedURLException, IOException {
        URL url = new URL(_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        //con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("x-rapidapi-key", "d12379afb6msh4e1abe29e50bca0p15e49ejsn56af46069613");
        con.setRequestProperty("x-rapidapi-host", "realtor.p.rapidapi.com");

        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext()) {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }
}
