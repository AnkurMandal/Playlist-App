import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Album arijitAlbum =new Album("Arijit Singh","Arijit's Album");
       Album alanWalkar=new Album("Alan Walkar","Alan's Playlist");

        System.out.println(arijitAlbum.addSongToAlbum("Kesariya",4.5));
        System.out.println(arijitAlbum.addSongToAlbum("Apna bana le",5.7));
        System.out.println(arijitAlbum.addSongToAlbum("Tum hi ho",5.3));

        System.out.println(alanWalkar.addSongToAlbum("Faded",4.3));
        System.out.println(alanWalkar.addSongToAlbum("Alone",3.6));
        System.out.println(alanWalkar.addSongToAlbum("Dark Side",4.5));

        LinkedList<Song> myPlaylist=new LinkedList<>();
        LinkedList<Song> myPlaylist2=new LinkedList<>();

        System.out.println(arijitAlbum.addSongtoPlaylistFromAlbum("Kesariya",myPlaylist));
        System.out.println(arijitAlbum.addSongtoPlaylistFromAlbum(2,myPlaylist));
        System.out.println(arijitAlbum.addSongtoPlaylistFromAlbum(5,myPlaylist));

        System.out.println(alanWalkar.addSongtoPlaylistFromAlbum("Dark Side",myPlaylist));
        System.out.println(alanWalkar.addSongtoPlaylistFromAlbum(1,myPlaylist));
        System.out.println(alanWalkar.addSongtoPlaylistFromAlbum(2,myPlaylist));

        play(myPlaylist);
    }

    private static  void play(LinkedList <Song> myPlaylist) {
        if(myPlaylist.isEmpty()){
            System.out.println("Your Playlist is empty...");
            return;
        }

        ListIterator<Song>itr=myPlaylist.listIterator();
        System.out.println("Now playing: "+itr.next());
        /*
        for pressing next button set wasNext=true
        for pressing prev button set wasNext=false
         */
        boolean wasNext=true;
        printMenu(myPlaylist);
        Scanner sc=new Scanner(System.in);
        boolean quit=false;
        while (!quit){
            System.out.println("Enter Your Choice");
            int choice=sc.nextInt();
            switch (choice){
                case 1: printMenu(myPlaylist);
                    break;
                case 2: if(!wasNext){
                    itr.next();
                    wasNext=true;
                }
                    if(itr.hasNext()) System.out.println("Now playing : "+itr.next());
                    else System.out.println("You have reached the end of playlist");
                    break;
                case 3:if(wasNext){
                    itr.previous();
                    wasNext=false;
                }
                    if(itr.hasPrevious()) System.out.println("Now playing : "+itr.previous());
                else System.out.println("This is the first song of the playlist");
                    break;
                case 4:if(wasNext) {
                    System.out.println("Now Playing: "+itr.previous());
                    wasNext=false;
                }
                else {
                    System.out.println("Now Playing: "+itr.next());
                    wasNext=true;
                }
                    break;
                case 5:
                    break;
                case 6:printAllSong(myPlaylist);
                    break;
                case 7:quit=true;
                    break;
                default:
                    System.out.println("Invalid Option, please choice again");
            }
        }
    }

    private static void printAllSong(LinkedList<Song> myPlaylist) {
        if(myPlaylist.isEmpty()) {
            System.out.println("Playlist is empty");
            return;
        }
        for(Song song:myPlaylist){
            System.out.println(song);
        }
    }

    private static void printMenu(LinkedList<Song> myPlaylist) {
        System.out.println("1, Show the menu Again");
        System.out.println("2, Play next song");
        System.out.println("3, Play previous song");
        System.out.println("4, Play current song again");
        System.out.println("5, Delete the current song from the playlist");
        System.out.println("6, Print all the song from the playlist");
        System.out.println("7, Quit Application");
    }
}