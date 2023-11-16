public class Song {

    /* Declare Song Attributes */
    public int id;

    private String artist;
    private String name;
    private char type;

    private String duration;
    private float rating;
    private int totalListens;

    /* Constructors */
    public Song(String name, String artist, String duration, int rating, int totalListens) {
        this.id = 0;
        this.artist = artist;
        this.name = name;
        this.type = 'P';

        this.duration = duration;
        this.rating = rating;
        this.totalListens = totalListens;
    };

    /* "Getter" Methods */
    public String getArtist() { return artist; };
    public String getName() { return name; };
    public char getType() { return type; };
    public String getDuration() { return duration; };
    public float getRating() { return rating; };
    public int getTotalListens() { return totalListens; };

    /* Create Setting Methods */

    /* toString Method */

    /* Calculate TotalPlayTime Method */
};
