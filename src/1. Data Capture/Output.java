public class Output {

    public static void examples(String[] args) {

        System.out.println("Hello World"); // text

        String name = "James";     // declare a variable
        System.out.println(name);  // use a variable

        System.out.println("Hello" + name); // concatenation

        System.out.println(4 * 2); // calculation

        System.out.print("All ");
        System.out.print("On ");
        System.out.print("One ");
        System.out.print("Line ");

        System.out.println("On \n separate \n lines]");

        System.out.println("All \t tabbed \t out");
    };

    public static void main(String[] args) {
        
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* HelloWorld.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        System.out.println("Hello World");

        System.out.println(9 / 3);
        System.out.println(9 % 3);

        System.out.println("Stone Roses: " + "Ian, " + "John, " + "Reni, " + "Mani");

        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        /* AdvancedOutput.java task */
        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        
        String name = "Liam Skinner";
        System.out.println("Hello " + name);

        System.out.println(0xF);
        System.out.println(0b10101010);
    };

};