package CW_2.HW_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SongAndArtistSort {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Song> songList = fileToArray();

        Collections.sort(songList, new Comparator<Song>() {  //по названию
            public int compare(Song o1, Song o2) {
                return o1.song.compareTo(o2.song);
            }});
        System.out.println(songList.toString());
        System.out.println();

        Collections.sort(songList, new Comparator<Song>() {  //по исполнителю
            @Override
            public int compare(Song o1, Song o2) {
                return o1.artist.compareTo(o2.artist);
            }
        });
        System.out.println(songList.toString());
    }
    public static ArrayList<Song> fileToArray() throws FileNotFoundException {
        ArrayList<Song> rating = new ArrayList<>();
        Scanner in = new Scanner(new File("songs_1.txt"));

        while (in.hasNextLine()) {
            String string = in.nextLine();
            String[] tmpSt = string.split("_");              //   ?

            for (int i = 0; i < tmpSt.length; i++) {
                String[] tmp = new String[3];
                tmp[0] = tmpSt[i].substring(0, tmpSt[i].indexOf("/"));
                tmp[1] = tmpSt[i].substring(tmpSt[i].indexOf("/") + 1,tmpSt[i].lastIndexOf("/"));
                tmp[2] = tmpSt[i].substring(tmpSt[i].lastIndexOf("/") + 1);
                Song song = new Song(tmp[0],tmp[1],Integer.parseInt(tmp[2]));
                rating.add(song);

            }
        }
        return rating;
    }

    static class Song{
        String song, artist;
        int rate;

        public Song(String song, String artist, int rate) {
            this.song = song;
            this.artist = artist;
            this.rate = rate;
        }

        @Override
        public String toString() {
            return "\n"+song + "  " + artist + "  " + rate;
        }
    }
}
