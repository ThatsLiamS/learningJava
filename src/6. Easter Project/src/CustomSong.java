public class CustomSong extends Song {

    /* Additional Song Attribute */
    private String genre;

    /* NoParameter Constructor */
    public CustomSong() {
        super.setType('C' );
    };


    /* Create Setters and Getters */
    public String getGenre() {
        return genre;
    };
    public boolean setGenre(String genre) {
        /* String value, between 1 and 20 length, only consists of Characters */
        if (genre.matches("^[a-zA-Z]{1,20}$") == true) {
            this.genre = genre;
            return true;
        };

        return false;
    };


    /* override toString Method to include Genre */
    @Override
    public String toString() {
        return "%s,%s".formatted(
            super.toString(),
            getGenre()
        );
    };

};
