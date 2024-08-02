package com.example.firstproject;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.ClientCredentials;
import com.wrapper.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import org.springframework.expression.ParseException;

import java.io.IOException;

public class CreateToken {

    private static final String CLIENT_ID = "6a56b68afd0242b49a8c3a6673d39bae";
    private static final String CLIENT_SECRET = "28f83e92698544fb8890a341d140093d";

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(CLIENT_ID).setClientSecret(CLIENT_SECRET).build();

    public static String accesstoken() {
        ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
        try {
            final ClientCredentials clientCredentials = clientCredentialsRequest.execute();
            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());
            return spotifyApi.getAccessToken();

        } catch (IOException | SpotifyWebApiException | ParseException | org.apache.hc.core5.http.ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return "error";
        }
    }
}