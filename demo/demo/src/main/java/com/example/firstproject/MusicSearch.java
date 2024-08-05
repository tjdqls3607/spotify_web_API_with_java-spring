package com.example.firstproject;

import com.neovisionaries.i18n.CountryCode;
import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Album;
import com.wrapper.spotify.requests.data.albums.GetAlbumRequest;
import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MusicSearch {

    private static final SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setAccessToken(" ")
            .build();

    private static final GetAlbumRequest getAlbumRequest = spotifyApi.getAlbum(" ")
            .market(CountryCode.KR)
            .build();

    public static void getAlbum_Sync() {
        try {
            // Execute the request synchronous
            final Album album = getAlbumRequest.execute();

            // Print album's name
            System.out.println("Name: " + album.getName());
        } catch (IOException | SpotifyWebApiException e) {
            System.out.println("Something went wrong!\n" + e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getAlbum_Async() {
        try {
            // Execute the request asynchronous
            final Future<Album> albumFuture = getAlbumRequest.executeAsync();

            // Do other things...

            // Wait for the request to complete
            final Album album = albumFuture.get();

            // Print album's name
            System.out.println("Name: " + album.getName());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Something went wrong!\n" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Synchronous call
        getAlbum_Sync();

        // Asynchronous call
        getAlbum_Async();
    }
}
