package Proxy;

import java.util.List;

public class MusicApp {
    public static void main(String[] args) {
        // Creating a song service proxy
        SongService songService = new RealSongService(); // Replace RealSongService with your actual implementation
        SongService proxy = new SongProxy(songService);

        // Searching for songs
        System.out.println("Searching for songs...");
        Song song1 = proxy.searchById(1);
        System.out.println("Song found: " + song1);

        Song song2 = proxy.searchById(2);
        System.out.println("Song found: " + song2);

        // Additional searches
        List<Song> songsWithTitle = proxy.searchByTitle("Right Round");
        System.out.println("Songs with title 'Song Title': " + songsWithTitle);

        List<Song> songsWithAlbum = proxy.searchByAlbum("N/A");
        System.out.println("Songs from album 'Album Name': " + songsWithAlbum);
    }
}

