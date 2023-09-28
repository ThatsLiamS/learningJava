public class ChallengeChristmas {

    public static void main(String[] args) {
        
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* Challenge - Twelve Days.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        String[] Lyrics = {
            "A Partridge in a Pear Tree\n\n",
            "Turtle Doves",
            "French Hens",
            "Calling Birds", 
            "Golden Rings",
            "Geese a Laying",
            "Swans a Swimming",
            "Maids a Milking",
            "Ladies Dancing",
            "Lords a Leaping",
            "Pipers Piping",
            "Drummers Drumming",
        };

        /* Loop through the 12 days */
        for (int day = 1; day < 13; day++) {

            /* Which Date Suffix is correct */
            String value = (day == 1) ? "st" : ((day == 2) ? "nd" : ((day == 3) ? "rd" : "th"));

            /* Display the lyrics */
            System.out.println("On the " + day + value + " day of Christmas,\nmy true love sent to me:");

            /* Display the Gifts */
            for (int gift = day - 1; gift >= 0; gift--) {
                System.out.println((gift != 0 ? (gift + 1 + " ") : "") + Lyrics[gift]);
            };

            /* Add a small delay */
            try { Thread.sleep(2000); } catch (Exception exc) { };
        };

    };
};