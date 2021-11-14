package new_project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;

// get all currencies and their respective rate
public class GetCurrencyInfo {

    String currency_API_KEY = "sUSZyyNzO3QytJjwCipDUfhG";
    String getCurrencyList = "https://web-services.oanda.com/rates/api/v2/currencies.json?api_key=" + currency_API_KEY;
    JSONObject data = null;
    JSONArray currencyArr = null;

    public GetCurrencyInfo() {

        try {
            URL url = new URL(getCurrencyList);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                data = new JSONObject(inputLine);

                currencyArr = data.getJSONArray("currencies");
            }

            in.close();

        } catch (Exception IOException) {
            System.out.println("Error retrieving currency list");
        }

    }

}
