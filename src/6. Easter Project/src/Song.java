public class Song {

    /* Declare Song Attributes */
    protected int id;

    private String artist;
    private String name;
    private char type;

    private int duration;
    private float rating;
    private int totalListens;

    /* NoParameter Constructor */
    public Song () {
        id = 0;
        this.type = 'P';
    };


    /* "Getter" Methods */
    public String getArtist() {
        return artist;
    };
    public String getName() {
        return name;
    };
    public char getType() {
        return type;
    };
    public int getDuration() {
        return duration;
    };
    public float getRating() {
        return rating;
    };
    public int getTotalListens() {
        return totalListens;
    };

    /* Create Setting Methods ~with RegularExpression Validation~ */
    public boolean setArtist(String nameOfArtist) {
        this.artist = nameOfArtist;
        return true;
    };
    public boolean setName(String nameOfSong) {
        this.name = nameOfSong;
        return true;
    };
    public boolean setType(char typeOfClass) {
        this.type = typeOfClass;
        return true;
    };
    public boolean setDuration(int timeInSeconds) {
        this.duration = timeInSeconds;
        return true;
    };
    public boolean setRating(float ratingOutOfTen) {
        this.rating = ratingOutOfTen;
        return true;
    };
    public boolean setTotalListens(int numberOfListens) {
        this.totalListens = numberOfListens;
        return true;
    };


    /* toString Method */
    public String toString() {
        return "%s,%s,%s,%s,%s,%s,%s".formatted(
            id,
            getArtist(),
            getName(),
            getType(),
            getDuration(),
            getRating(),
            getTotalListens()
        );
    };

    /* Calculate TotalPlayTime Method */
    public int totalPlayTime() {
        return (duration * totalListens);
    };

};
