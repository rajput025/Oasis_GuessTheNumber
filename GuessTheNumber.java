import java.util.Random; import java.util.Scanner;
class Game { int systemInput ; int userInput; int noOfGuesses = 0;
    Game(){
        Random random = new Random();
        this.systemInput= random.nextInt(100)+1;
    }
    public boolean takeUserInput(){
        if(noOfGuesses<10){
            System.out.print("Guess the number :");
            this.userInput=GuessTheNumber.takeIntegerInput(100);
            noOfGuesses++;
            return false;
        }
        else{
            System.out.println("Number of attempts finished... Better luck next time\n");
            return true;
        }
    }
    public boolean isCorrectGuess(){
        if(systemInput ==  userInput){
            System.out.println("congratulations ,you guess the number  "+systemInput+" in "+noOfGuesses+"  guesses");
            switch (noOfGuesses){
                case 1:
                    System.out.println("your score is 100");
                    break;
                case 2:
                    System.out.println("your score id 90");
                    break;
                case 3:
                    System.out.println("your score id 80");
                    break;
                case 4:
                    System.out.println("your score id 70");
                    break;
                case 5:
                    System.out.println("your score id 60");
                    break;
                case 6:
                    System.out.println("your score id 50");
                    break;
                case 7:
                    System.out.println("your score id 40");
                    break;
                case 8:
                    System.out.println("your score id 30");
                    break;
                case 9:
                    System.out.println("your score id 20");
                    break;
                case 10:
                    System.out.println("your score id 10");
                    break;
            }
            System.out.println();
            return true;
        }else if(noOfGuesses < 10 && userInput > systemInput){
            if(userInput - systemInput >10){
                System.out.println("Too high");
            }
            else{
                System.out.println("little High");
            }
        }
        else if(noOfGuesses < 10 && userInput < systemInput){
            if(systemInput - userInput >10){
                System.out.println("Too low");
            }
            else{
                System.out.println("little low");
            }
        }
        return false;
    }
}
public class GuessTheNumber { public static int takeIntegerInput(int limit){ int input =0; boolean flag = false;
    while(!flag){
        try{
            Scanner sc =  new Scanner(System.in);
            input = sc.nextInt();
            flag = true;
            if(flag && input > limit || input < 1 ){
                System.out.println("Enter only value");
                flag = false;
            }
        }
        catch (Exception e){
            System.out.println("Enter only integer value");
            flag = false;
        }
    };
    return input;
}

public static void main(String[] args) {
// write your code here
    System.out.println("1. Start the game \n2.Exit");
    System.out.println("Enter your choice :");
    int choice = takeIntegerInput(2);
    int nextRound = 1;
    int noofRound = 0 ;
    if(choice ==1) {
        while (nextRound == 1) {
            Game game = new Game();
            boolean isMatched = false;
            boolean isLimited = false;
            System.out.println("\nRound " + ++noofRound + " starts ...");
            while (!isMatched && !isLimited) {
                isLimited = game.takeUserInput();
                isMatched = game.isCorrectGuess();
            }
            System.out.println("1.Next Round \n2.  Exit");
            System.out.println("Enter your choice : ");
            nextRound = takeIntegerInput(2);
            if (nextRound != 1) {
                System.exit(0);
            }

        }
    }
    else {
        System.exit(0);
    }
}
}