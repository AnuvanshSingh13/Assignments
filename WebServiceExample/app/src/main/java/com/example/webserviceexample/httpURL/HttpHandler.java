package com.example.webserviceexample.httpURL;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHandler {

        private static final String TAG="HttpHandler";
    public HttpHandler(){

    }
    public String getJSONString(String requestUrl){
        String response =null;
        try{
            URL url=new URL(requestUrl);
            HttpURLConnection httpURLConnection =(HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            InputStream inputStream =new BufferedInputStream(httpURLConnection.getInputStream());
            response = convertStreamtoString(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }return response;
    }

    private String convertStreamtoString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder =new StringBuilder();
        String line;
        try{
            while ((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            inputStream.close();
        }return stringBuilder.toString();
    }
}
