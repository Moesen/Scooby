package sample;

public class Song implements Comparable <Song> {

    private String title;
    private String artist;
    private int length;

    Song(String title, String artist, int length){

        this.title = title;
        this.artist = artist;
        this.length = length;

    }

    public String toString(){
        return "Title: " + title + ", Artist: " + artist + ", Length: " + showTime();

    }

    //Changes time to M:S
    private String showTime(){
        int m, s;
        m = length/60;
        s = length%60;
        return "" + m + ":" + s;
    }

    public int compareTo(Song s) {
        if(this.length > s.length) return 1;
        else return -1;
    }
}
