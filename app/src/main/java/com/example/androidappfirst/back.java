package com.example.androidappfirst;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class back extends AsyncTask<String , Void , String> {
    String bs="";
    String data="";
    String Singlepase="";
    public String bns;
    @Override
    protected String doInBackground(String... urls) {
        String result="";
        try {
            URL url = new URL(urls[0]);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            InputStream in=con.getInputStream();
            InputStreamReader ir= new InputStreamReader(in);
            int data=ir.read();
            while(data != -1){
                char c = (char)data;
                result =result+c;
                data=ir.read();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jb= new JSONObject(s);
            String sb = MainActivity.best;
            String st = jb.getString("response");
            JSONObject j =new JSONObject(st);
            String rwe = j.getString(sb);
            Log.d("Akshay",""+rwe);
           float t= Float.valueOf(MainActivity.bn );
           float t1=t*Float.valueOf(rwe);
           bns= String.valueOf(t1);
            MainActivity.usd.setText(bns);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
