package Proxy;

// HW7 CS4800
// Gabriel Bermudez

import java.util.List;

public interface SongService {
    Song searchById(Integer songID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);
}

