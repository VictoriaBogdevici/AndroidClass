package com.example.conted.internetconnection;

public interface HttpURLConnectionProcessorInterface {
    void successHandler(String dataInXML);
    void failureHandler(Exception exception);
}
