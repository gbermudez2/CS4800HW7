package Proxy;

import java.util.ArrayList;
import java.util.List;

public class RealSongService implements SongService {
    private List<Song> songDatabase;

    public RealSongService() {
        // Initialize a dummy song database
        songDatabase = new ArrayList<>();
        // Add some sample songs
        songDatabase.add(new Song("This Is What You Came For", "Calvin Harris and Rihanna", "N/A", 222));
        songDatabase.add(new Song("Right Round", "Flo Rida", "N/A", 207));
    }

    @Override
    public Song searchById(Integer songID) {
        simulateNetworkDelay();
        // Assuming songID corresponds to the index in the list (1-based)
        if (songID >= 1 && songID <= songDatabase.size()) {
            return songDatabase.get(songID - 1);
        } else {
            return null; // Song not found
        }
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateNetworkDelay();
        List<Song> result = new ArrayList<>();
        for (Song song : songDatabase) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                result.add(song);
            }
        }
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateNetworkDelay();
        List<Song> result = new ArrayList<>();
        for (Song song : songDatabase) {
            if (song.getAlbum().equalsIgnoreCase(album)) {
                result.add(song);
            }
        }
        return result;
    }

    private void simulateNetworkDelay() {
        try {
            Thread.sleep(1000); // Simulate 1-second delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
