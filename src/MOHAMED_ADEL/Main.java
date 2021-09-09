package MOHAMED_ADEL;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

///// MOHAMED FARID ABDELAZIZ SALAMA ID:6905 GROUP:3 SECTION:1    Lab3_6905_6848
///// ADEL YASSER YASSIN ABDELAZIM   ID:6848 GROUP:3 SECTION:1

public class Main {

    public static  void main(String[] args) {
        welcome();
        Scanner scanner=new Scanner(System.in);
        Player player1=new Player();
        Player player2=new Player();
        Game game=new Game();
        int row ,column ,count;
        System.out.println("Kindly enter the name of player 1");
        //temp to carry the string name
        String temp1=scanner.nextLine();
        String p1= temp1;
        player1.setName(temp1);
        System.out.println("Kindly enter the name of player 2");
        temp1=scanner.nextLine();
        String p2=temp1;
        player2.setName(temp1);
        for (count = 0; count < 42 ; count++)
        {
            game.printBoard();
            //player 1 has even turn number.
            if ((count % 2)==0)
            {
                System.out.print(p1 + ", Please enter your move\n");
                System.out.print("row: ");
                //Gives error if user inputs a non-integer and makes him retry.
                if (!scanner.hasNextInt())
                {
                    System.out.println("Input must be a number.\n");
                    scanner.next();
                    count--;
                    continue;
                }
                row = scanner.nextInt();
                System.out.print("column: ");
                //assuring that an integer is entered
                if (!scanner.hasNextInt())
                {
                    System.out.println("Input must be a number.\n");
                    scanner.next();
                    count--;
                    continue;
                }
                column = scanner.nextInt();
                if ( row > 6 || row < 1 || column < 1 || column > 7 )
                {
                    System.out.println("Invalid choice, please retry.");
                    count--;
                    continue;
                }
                if (game.isOccupied(row+1 , column +1)) {
                    System.out.println("Choice is occupied, please retry.");
                    count--;
                    continue;
                }
                if (!game.isOccupied(row + 1,column + 1)) game.setElementX(row + 1, column + 1);
                if ( game.isWon(row + 1, column + 1)) {
                    game.printBoard();
                    break;}
            }
            //Player 2 has odd turn number.
            if (count % 2 !=0)
            {
                System.out.print(p2 + ", Please enter your move.\n");
                System.out.print("row: ");
                //assuring that an integer is entered
                if (!scanner.hasNextInt())
                {
                    System.out.println("Input must be a number.\n");
                    scanner.next();
                    count--;
                    continue;
                }
                row = scanner.nextInt();
                System.out.print("column: ");
                //assuring that an integer is entered
                if (!scanner.hasNextInt())
                {
                    System.out.println("Input must be a number.\n");
                    scanner.next();
                    count--;
                    continue;
                }
                column = scanner.nextInt();
                if ( row > 6 || row < 1 || column < 1 || column > 7 )
                {
                    System.out.println("Invalid choice, please retry.");
                    count--;
                    continue;
                }
                //if choice is occupied, current player retries his turn.
                if (game.isOccupied(row+1 , column +1)) {
                    System.out.println("Choice is occupied, please retry.");
                    count--;
                    continue;
                }

                if (!game.isOccupied(row+1,column+1)) game.setElementO(row+1, column+1);
                if ( game.isWon(row+1, column+1)){
                    game.printBoard();
                    break;
                }

            }


        }
// Printing game result
        if(count==42)System.out.println("________GAME ENDED WITH A DRAW________");

        else if(count%2==0) winner(player1.getName());

        else winner(player2.getName());



    }
    //a method to welcome the Users using the game
    public static void welcome(){
        //costumizing joptionpane
        //adding image
        ImageIcon image2=new ImageIcon("unnamed.png");
        JLabel icon=new JLabel(image2);
        JLabel text=new JLabel("     Welcome to Our Tic Tac Toe game!");
        JLabel text2=new JLabel("     Click OK and continue on the console.");
        JPanel panel=new JPanel();
        panel.setLayout((new BorderLayout()));
        panel.add(icon,BorderLayout.CENTER);
        panel.add(text,BorderLayout.NORTH);
        panel.add(text2,BorderLayout.SOUTH);
        JOptionPane.showMessageDialog(null,panel,"TIC TAC TOE",JOptionPane.PLAIN_MESSAGE);
    }
    //a method to show a win message
    public static void winner(String winner){
//costumizing joptionpane
        //adding image
        ImageIcon image2=new ImageIcon("winner.jpg");
        JLabel icon=new JLabel(image2);
        JLabel text=new JLabel("                    "+winner.toUpperCase()+" HAS WON!!\n");
        JPanel panel=new JPanel();
        panel.setLayout((new BorderLayout()));
        panel.add(icon,BorderLayout.CENTER);
        panel.add(text,BorderLayout.NORTH);
        JOptionPane.showMessageDialog(null,panel,"TIC TAC TOE",JOptionPane.PLAIN_MESSAGE);


    }


 }