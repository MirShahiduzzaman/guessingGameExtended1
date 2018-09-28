package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean selected = false;

        while(!(selected))
        {
            System.out.println("Which game would you like to play?");
            System.out.println();

            System.out.println("Press 1 to be the guesser.");
            System.out.println("Press 2 for me to be the guesser.");

            if ((input.nextLine()).equals("1"))
            {
                int min = 1;
                int max = 10;

                double num = (Math.random() * max) + 1;
                String realNum = Double.toString(num);

                realNum = realNum.substring(0,realNum.indexOf("."));
                //everything b4 this line establishes the num

                boolean right = false;
                String guess = "";

                while(!(right))
                {
                    System.out.println("What is your guess? (" + min + "-" + max + ")");
                    guess = input.nextLine();

                    if(guess.length() == 0)
                    {
                        System.out.println("Please input a guess.");
                    }
                    else
                    {
                        System.out.println();
                        if(guess.equals(realNum))
                        {
                            System.out.println("You got it!");
                            right = true;
                        }
                        else
                        {
                            System.out.println("Try Again.");
                        }
                    }
                }

                selected = true;
            }
            else
            {
                if ((input.nextLine()).equals("2"))
                {
                    int min = 0;
                    int max = 10;

                    int range = max-min;
                    String response = "";

                    System.out.println("Think of a number from 1-100 and I will try to guess it...");
                    System.out.println("For each response, type higher, lower, or correct.");
                    System.out.println();

                    while(range>=0)
                    {
                        if(range%2 !=0)
                        {
                            System.out.println("Is your number " + (((max + min + 1) / 2)) + "?");
                        }
                        else
                        {
                            System.out.println("Is your number " + (((max + min) / 2)) + "?");
                        }
                        //guess number

                        response = (input.nextLine()).toLowerCase();
                        //lower case result

                        //check response
                        //if need to check if last num, use if range<=1, then print Oh I got ur number! Its __. Then end the game.
                        // Else do the code after this comment
                        if(range<=1)
                        {
                            System.out.println("I know your number now! Its " + ((max + min) / 2) + ".");
                            range = -1;
                        }
                        else
                        {
                            if (response.equals("lower")) //lower means change max
                            {
                                if (range % 2 != 0) {
                                    max = ((max + min + 1) / 2);
                                } else {
                                    max = ((max + min) / 2);
                                }
                                System.out.println();

                                range = max - min;
                            }
                            else
                            {
                                if (response.equals("higher")) //higher means change min
                                {
                                    if (range % 2 != 0) {
                                        min = ((max + min + 1) / 2);
                                    } else {
                                        min = ((max + min) / 2);
                                    }
                                    System.out.println();

                                    range = max - min;
                                } else {
                                    if (response.equals("correct")) {
                                        System.out.println("Yay!");
                                        range = -1;
                                    } else {
                                        System.out.println("For each response, type higher, lower, or correct.");
                                    }
                                }
                            }
                        }
                    }

                    selected = true;
                }
                else
                {
                    System.out.println("Please select 1 or 2");
                }
            }

        }
        input.close();
    }
}
