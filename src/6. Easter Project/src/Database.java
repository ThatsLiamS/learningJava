/* Import Required Modules & Packages */
import java.io.*;

public class Database {

    /* Create an Array of Songs */
    Song[] allSongs = new Song[125];
    int totalSongs = 0;


    /* Add a new CustomSong */
    public boolean createNewSong(String artist, String name, int duration, float rating, int totalListens, String genre) {

        /* Is the Array full? */
        if (totalSongs == allSongs.length) {
            return false;
        };

        /* Create a new Song Class */
        CustomSong mySong = new CustomSong();

        /* Set the Appropriate Values */
        mySong.setArtist(artist);
        mySong.setName(name);

        mySong.setDuration(duration);
        mySong.setRating(rating);
        mySong.setTotalListens(totalListens);

        mySong.setGenre(genre);

        /* Add the new Song to the Array */
        allSongs[totalSongs] = mySong;
        totalSongs++;

        return true;
    };


    /* Update a PreExisting CustomSong */
    public boolean updateSong(int id, String artist, String name, int duration, float rating, int totalListens) {
        int position = searchById(id);

        /* If the Song Doesn't Exist */
        if (position == -1) {
            return false;
        };

        /* Find the Song within the Array */
        Song mySong = allSongs[position];

        /* Update attributes as needed */
        mySong.setArtist(artist);
        mySong.setName(name);

        mySong.setDuration(duration);
        mySong.setRating(rating);
        mySong.setTotalListens(totalListens);
    
        return true;
    };


    /* Delete a CustomSong */
    public boolean deleteSong(int id) {
        int position = searchById(id);

        /* If the Song Doesn't Exist */
        if (position == -1) {
            return false;
        };

        /* Loop through all Songs */
        for (int index = 0; index < totalSongs; index++) {
            /* Move all elements One Position Forwards */
            if (index > position) {
                allSongs[index - 1] = allSongs[index];
                allSongs[index] = null;
            };
        };
        /* Decrease Song Count by 1 */
        totalSongs--;

        return true;
    };


    /* Search through All Songs (Artist, Name, Duration) */
    public int searchById(int songId) {
        for (int index = 0; index < totalSongs; index++) {
            if (allSongs[index].id == songId) {
                return index;
            };
        };
        /* Song Not Found */
        return -1;
    };

    public String searchAndFindAll(String attribute, String searchQuery) {
        String elementsFound = "";

        /* Loop through All Songs */
        for (int index = 0; index < totalSongs; index++) {

            /* Fetch the Song's Attribute */
            String currentSong = "";
            switch (attribute) {
                case "artist":
                    currentSong = allSongs[index].getArtist();
                    break;
                case "name":
                    currentSong = allSongs[index].getName();
                    break;
                case "duration":
                    currentSong = allSongs[index].getDuration() + "";
                    break;
            };

            /* If the Query Matches */
            if (currentSong.equalsIgnoreCase(searchQuery)) {
                elementsFound = elementsFound + (elementsFound.length() == 0 ? "" : ",") + index;
            };
        };

        /* Return the ElementsFound or -1 if None */
        return (elementsFound.length() == 0 ? "-1" : elementsFound);
    };


    /* Sort all Songs (Any Attribute) */
    private void swapVariables(int index) {
        Song swappingValue = allSongs[index];
        allSongs[index] = allSongs[index + 1];
        allSongs[index + 1] = swappingValue;
    };

    public void sort(String attribute) {
        /* Loop through all the Songs */
        for (int outer = 0; outer < totalSongs; outer++) {
            for (int inner = 0; inner < (totalSongs - 1); inner++) {

                /* If it is a String Attribute */
                if (attribute.equals("artist") || attribute.equals("name")) {

                    String songOne = ""; String songTwo = "";
                    switch (attribute) {
                        case "artist":
                            songOne = allSongs[inner].getArtist();
                            songTwo = allSongs[inner + 1].getArtist();
                            break;
                        case "name":
                            songOne = allSongs[inner].getName();
                            songTwo = allSongs[inner + 1].getName();
                            break;
                    };

                    /* Swap the StringValues if "Attribute < Attribute+1" */
                    if (songOne.compareTo(songTwo) > 0) {
                        /* Largest => ... => Smallest */
                        swapVariables(inner);
                    };
                }

                /* If it is an Integer Attribute */
                else if (attribute.equals("duration") || attribute.equals("totalListens")) {

                    int songOne = 0; int songTwo = 0;
                    switch (attribute) {
                        case "duration":
                            songOne = allSongs[inner].getDuration();
                            songTwo = allSongs[inner + 1].getDuration();
                            break;
                        case "totalListens":
                            songOne = allSongs[inner].getTotalListens();
                            songTwo = allSongs[inner + 1].getTotalListens();
                            break;
                    };

                    /* Swap the IntegerValues if "Attribute < Attribute+1" */
                    if (songOne < songTwo) {
                        /* Largest => ... => Smallest */
                        swapVariables(inner);
                    };
                }

                /* If it is a Float Attribute */
                else if (attribute.equals("rating")) {

                    float songOne = allSongs[inner].getRating();
                    float songTwo = allSongs[inner + 1].getRating();

                    /* Swap the FloatValues if "Attribute < Attribute+1" */
                    if (songOne < songTwo) {
                        /* Largest => ... => Smallest */
                        swapVariables(inner);
                    };
                };

            };
        };
    };


    /* Import Songs from TXT (CVS) File ~with Decryption~ */
    public boolean importAllSongs() {
        allSongs = new Song[125];
        totalSongs = 0;

        try (BufferedReader myFile = new BufferedReader(new FileReader("SongList.txt"))) {

            /* Loop through Every Record in the File */
            
            for (String line = myFile.readLine(); line != null; line = myFile.readLine()) {
                String[] data = line.split(",");
                Song mySong;
    
                /* PreExisting Song */
                if (Character.compare(data[3].charAt(0), 'P') == 0) {
                    mySong = new Song();
                }
                /* CustomSong */
                else {
                    CustomSong currentSong = new CustomSong();
                    currentSong.setGenre(data[7]);
                    mySong = currentSong;
                };

                /* Set the Common Attributes */
                mySong.setArtist(data[1]);
                mySong.setName(data[2]);
                mySong.setDuration( Integer.parseInt(data[4]) );
                mySong.setRating( Float.parseFloat(data[5])  );
                mySong.setTotalListens( Integer.parseInt(data[6]) );

                /* Add to the Array */
                allSongs[totalSongs] = mySong;
                totalSongs++;
            };

            return true;
        } catch (Exception exc) {
           return false;
        }
    };


    /* Export Songs to TXT (CVS) File ~with Encryption~ */
    public boolean exportAllSongs() {

        try (FileWriter myFile = new FileWriter("SongList.txt", false)) {

            /* Loop through Records in the Array */
            for (int index = 0; index < totalSongs; index++) {
                Song mySong = allSongs[index];
                myFile.write(mySong.toString() + "\r\n");
            };

            return true;
        } catch (Exception Exc) {
            return false;
        }
    };

};
