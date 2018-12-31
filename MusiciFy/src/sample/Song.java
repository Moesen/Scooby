package sample;

public class Song implements Comparable <Song> {

    private String title;
    private String artist;
    private String genre;
    private int order;
    private int length;


    Song(String title, String artist, int length){

        this.title = title;
        this.artist = artist;
        this.length = length;

    }

    //Sets genre
    public void setGenre(String genre, int order){
        this.genre = genre;
        this.order = order;
    }


    //returns format Title: Artist: Length:
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

    //Throws error if genre not defined
    //Returns 1 if this is
    public int compareTo(Song s) {
        if(s.genre == null || this.genre == null){
            throw new ExceptionInInitializerError("Genre not defined");
        }
        return Integer.compare(s.order, this.order);
    }
}
