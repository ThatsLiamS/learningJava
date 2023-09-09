import java.util.Scanner;

public class Calculations {
    
    public static void examples(String[] args) {

        int number1     = 9; //declare and assign
        int number2 = 2;

        //add //subtract //multiply //divide
        int answerPlus = number1 + number2;
        int answerMinus = number1 - number2;
        int answerTimes = number1 * number2;
        double answerDivide = number1 / number2; 
        System.out.print(answerDivide + answerTimes + answerMinus + answerPlus);

        int count=0;
        count = count+1; //or count++;
        count = count-1; //or count--;

        //round a double //100.0 = 2dp, 1000.0 = 3dp
        double original=1.2236245543;
        double newData=Math.round(original*100.0)/100.0;
        System.out.println("To 2 dp: "+newData);

        //Use PI from the Math library
        System.out.print(Math.PI * 10.0);
    };
    
    public static void main(String[] args) {

        /* SwimmingPool.java task */
        Scanner inputScanner = new Scanner(System.in);

        int length; int width; double depth; 
        System.out.print("Enter the Length: "); length = inputScanner.nextInt();
        System.out.print("Enter the Width: "); width = inputScanner.nextInt();
        System.out.print("Enter the Depth (1dp): "); depth = inputScanner.nextDouble();

        System.out.println("The perimeter is:" + (length + width) * 2 + 'm');
        System.out.println("The volume is:" + (length * width * depth) + "m cubed\n");


        /* RoundPool.java task */
        System.out.print("Enter the pool's diameter (2dp): ");
        double diameter = inputScanner.nextDouble();

        System.out.println("The circumference of the pool is " + Math.round((diameter * Math.PI)*100.0)/100.0 + "m");
        System.out.println("The area of the pool is " + Math.round((diameter/2) * Math.PI * 100.0)/100.0 + "m squared");

        System.out.println("Radius MOD 1 == " + (diameter/2) % 1);

        inputScanner.close();
    };
}