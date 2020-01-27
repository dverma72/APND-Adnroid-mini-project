package com.example.firstproject;

import java.security.PrivateKey;

public class YoutubeConfig {
    public YoutubeConfig() {

    }

    private static String API_KEY = "AIzaSyDNVsMo3_eYtv3GiM-aKWtYgGd0JnQgoB8";

    public static String getApiKey(){
        return API_KEY;
    }
}
