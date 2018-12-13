package com.example.conted.internetconnection;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsynchronousHttpURLConnector extends AsyncTask<Void,Integer,String> {

    public String urlString;
    private HttpURLConnectionProcessorInterface httpURLConnectionProcessorInterface;
    private TextView textViewProgress;

    public AsynchronousHttpURLConnector( HttpURLConnectionProcessorInterface httpURLConnectionProcessorInterface,String urlString, TextView textViewProgress) {
        this.urlString = urlString;
        this.httpURLConnectionProcessorInterface = httpURLConnectionProcessorInterface;
        this.textViewProgress = textViewProgress;
    }

    @Override
    protected String doInBackground(Void... params) {
        String urlConnectionResultString="";
        HttpURLConnection  httpURLConnection= null;

        try{
            System.out.println("----------->"+ urlString);
            httpURLConnection= (HttpURLConnection) new URL(urlString).openConnection();
            InputStream urlConnectionInputStream= httpURLConnection.getInputStream();
            System.out.println("-------------urlConnectionInputStream: "+urlConnectionInputStream);
            urlConnectionResultString=inputStreamToString(urlConnectionInputStream);
        }catch (Exception ex){
            httpURLConnectionProcessorInterface.failureHandler(ex);
        }
        return urlConnectionResultString;
    }

    private String inputStreamToString(InputStream urlConnectionInputStream) {
        BufferedReader bufferedReader=null;
        StringBuilder stringBuilder=new StringBuilder();
        InputStreamReader inputStreamReader=new InputStreamReader(urlConnectionInputStream);
        bufferedReader= new BufferedReader(inputStreamReader);
        String oneLine=null;
        int counter=0;

        try{
            while((oneLine=bufferedReader.readLine())!=null){
                stringBuilder.append(oneLine);
                publishProgress(counter++);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("--------------> result string : "+stringBuilder.toString());
        return stringBuilder.toString();
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        System.out.println("----------> onPostExecute "+s );
        httpURLConnectionProcessorInterface.successHandler(s);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        textViewProgress.setText("Number of lines in loaded web page "+ String.valueOf(values[0]));
        textViewProgress.setTextSize(16);
        System.out.println("Number of lines in loaded web page "+ String.valueOf(values[0]));
    }
}
