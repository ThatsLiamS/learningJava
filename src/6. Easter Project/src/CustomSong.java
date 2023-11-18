public class CustomSong extends Song {

    /* Additional Song Attribute */
    private String genre;

    /* NoParameter Constructor */
    public CustomSong() {
        super.setType( 'C' );
    };


    /* Create Setters and Getters */
    public String getGenre() {
        return genre;
    };
    public boolean setGenre(String genre) {
        this.genre = genre;
        return true;
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
