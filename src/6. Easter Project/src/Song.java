public class Song {

    /* Static Variables & ID Generation */
    private static int nextId = 0;
    private static int generateId() {
        return nextId++;
    };

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
        id = generateId();
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

    /* Create Setting Methods with RegularExpression Validation */
    public boolean setArtist(String nameOfArtist) {
        /* String value, between 1 and 35 length, only consists of Characters and Spaces */
        if (nameOfArtist.matches("^[a-zA-Z\s]{1,35}$") == true) {
            this.artist = nameOfArtist;
            return true;
        };

        return false;
    };
    public boolean setName(String nameOfSong) {
        /* String value, between 1 and 50 length, only consists of Characters, Spaces, Full Stops, Question Marks*/
        if (nameOfSong.matches("^[a-zA-Z\s.?]{1,50}$") == true) {
            this.name = nameOfSong;
            return true;
        };

        return false;
    };
    public boolean setType(char typeOfClass) {
        /* LookUp Validation with 'C' OR 'P' (Custom or PreMade) */
        if (Character.compare('C', typeOfClass) == 0 || Character.compare('P', typeOfClass) == 0) {
            this.type = typeOfClass;
            return true;
        };

        return false;
    };
    public boolean setDuration(int timeInSeconds) {
        /* Range Validation: Between 20 minutes and 0 Seconds */
        if (1200 >= timeInSeconds && timeInSeconds >= 1) {
            this.duration = timeInSeconds;
            return true;
        };

        return false;
    };
    public boolean setRating(float ratingOutOfTen) {
        /* Range Validation: Between 10.0f and 0.0f */
        if (10.0f >= ratingOutOfTen && ratingOutOfTen >= 0.0f) {
            this.rating = ratingOutOfTen;
            return true;
        };

        return false;
    };
    public boolean setTotalListens(int numberOfListens) {
        /* Range Validation: Real, Positive Integer */
        if (numberOfListens >= 0) {
            this.totalListens = numberOfListens;
            return true;
        };

        return false;
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
