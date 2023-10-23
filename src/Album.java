import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album extends Song{
    private String artist;
    private String title;
    List<Song>songs;

    public Album() {
    }

    public Album(String artist, String title) {
        this.artist = artist;
        this.title = title;
        songs=new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //functionalities in the album

    public boolean findSong(String title){
        for(Song song:songs){
            if(song.getTitle().equalsIgnoreCase(title)){
                return true;
            }
        }
        return false;
    }

    //add song
   public String addSongToAlbum(String title,double duration){
        Song song=new Song(title,duration);
        if(!this.findSong(title)){
            this.songs.add(song);
            return "Song added Successfully!!";
        }
        return "Song already exist";
    }

    //add to playlist from album
    public  String addSongtoPlaylistFromAlbum(String title, LinkedList<Song>playList){
        for(Song song:songs){
            if(song.getTitle().equalsIgnoreCase(title)){
                playList.add(song);
                return "Song has been added to playlist";
            }
        }
        return "Song doesn't exist in album";
    }

    /**
     * polymorphism: method  
     * @param songNo
     * @param playList
     * @return
     */
    public String addSongtoPlaylistFromAlbum(int songNo,LinkedList<Song>playList){
        int index=songNo-1;
        if(index>=0 && index<songs.size()){
            playList.add(songs.get(index));
            return "Song has been added to playlist";
        }
        return "Song doesn't exist in album";
    }

}
