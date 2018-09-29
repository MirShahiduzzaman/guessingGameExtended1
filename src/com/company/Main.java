package com.company;
/**Mir Shahiduzzaman 9/28/2018*/
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean selected = false;
        boolean diffAns = false;

        int min = 1;
        int max = 10;

        String initRes = "";

        while (!(selected))
        {
            System.out.println("Which game would you like to play?");
            System.out.println();

            System.out.println("Press 1 for you to be the guesser.");
            System.out.println("Press 2 for me to be the guesser.");

            initRes = (input.nextLine());

            if (initRes.equals("1"))
            {
                selected = true;
            }
            else
            {
                if (initRes.equals("2"))
                {
                    selected = true;
                }
            }
        }
        while (!(diffAns))
        {
            System.out.println("Please choose a difficulty");
            System.out.println();

            System.out.println("Press 1 for numbers 1 to 10");
            System.out.println("Press 2 for numbers 1 to 100");
            System.out.println("Press 3 for numbers 1 to 1000");
            System.out.println("Press 4 for numbers 1 to 10000");

            String difficult = (input.nextLine());

            if (difficult.equals("1"))
            {
                diffAns = true;
            }
            else
            {
                if (difficult.equals("2"))
                {
                    max = 100;
                    diffAns = true;
                }
                else
                {
                    if (difficult.equals("3"))
                    {
                        max = 1000;
                        diffAns = true;
                    }
                    else
                    {
                        if (difficult.equals("4"))
                        {
                            max = 10000;
                            diffAns = true;
                        }
                    }
                }
            }
        }

        if (initRes.equals("1"))
        {
            double num = (Math.random() * max) + 1;
            String strNum = Double.toString(num);
            int intGuess = 0;

            strNum = strNum.substring(0, strNum.indexOf("."));

            int realNum = Integer.parseInt(strNum);
            //everything b4 this line establishes the num

            boolean right = false;
            String guess = "";

            while (!(right))
            {
                try
                {
                    System.out.println("What is your guess? (" + min + "-" + max + ")");
                    guess = input.nextLine();

                    if (guess.length() == 0)
                    {
                        System.out.println("Please input a guess.");
                    }
                    else
                    {
                        System.out.println();

                        intGuess = Integer.parseInt(guess);
                        if (intGuess == realNum)
                        {
                            System.out.println("You got it!");
                            right = true;
                        }
                        else
                        {
                            if (intGuess < min || intGuess > max)
                            {
                                System.out.println("Your number is not in range.");
                            }
                            else
                            {
                                if (intGuess < realNum)
                                {
                                    System.out.println("My number is higher.");
                                }
                                else
                                {
                                    System.out.println("My number is lower.");
                                }
                            }
                        }
                    }
                }
                catch (Exception e)
                {
                    System.out.println("Your guess was not a number. Please input a numerical guess.");
                    guess = "";
                }
            }
        }
        else
        {
            if (initRes.equals("2"))
            {
                min = 0;
                int range = max - min;
                String response = "";

                System.out.println("Think of a number from " + min + "-" + max + " and I will try to guess it...");
                System.out.println();

                while (range >= 0)
                {
                    if((range == 0))  //if there is only one num left in the range of values do this
                    {
                        System.out.println("I found you're number! Its " + max);
                        range = -1;
                    }
                    else
                    {
                        if (range % 2 != 0)
                        {
                            System.out.println("Is your number " + (((max + min + 1) / 2)) + "? Type higher, lower, or " +
                                    "correct.");
                        }
                        else
                        {
                            System.out.println("Is your number " + (((max + min) / 2)) + "? Type higher, lower, or " +
                                    "correct.");
                        }
                        //guess number

                        response = (input.nextLine()).toLowerCase();
                        //lower case result

                        //check response
                        if (response.equals("lower")) //lower means change max
                        {
                            if (range % 2 != 0)
                            {
                                max = ((max + min + 1) / 2);
                            }
                            else
                            {
                                max = ((max + min) / 2);
                            }
                            System.out.println();

                            range = max - min;
                        }
                        else
                        {
                            if (response.equals("higher")) //higher means change min
                            {
                                if (range % 2 != 0)
                                {
                                    min = ((max + min + 1) / 2);
                                }
                                else
                                {
                                    min = ((max + min) / 2);
                                }
                                System.out.println();

                                range = max - min;
                            }
                            else
                            {
                                if (response.equals("correct"))
                                {
                                    System.out.println("Yay!");
                                    range = -1;
                                }
                                else
                                {
                                    System.out.println("For each response, type higher, lower, or correct.");
                                }
                            }
                        }
                    }
                }
            }
            input.close();
        }
    }
}
