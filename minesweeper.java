import java.util.Scanner;

import pkg.*;

public class minesweeper{
	public static void main(String[] args) {
	    Map map;
		if(args.length == 0)
			map = new Map();
		else if(args.length == 1)
			map = new Map(Integer.parseInt(args[0]));
		else if(args.length == 3)
			map = new Map(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		else
			map = new Map();
		System.out.println(map.printMap());
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		System.out.println("Rules:\n1. To start the game, chose anywhere on the board to dig\n2. Each Spot that does not have a bomb on it will have a number that tells you how many bombs are in a 3x3 square around the square.\n3. If you dig on a square that has bomb, the game will be over.");
		while(true){
		    System.out.println("\n1. dig\n2. flag\n3. print\n4. rules\n5. quit\n");
			String resp = sc.nextLine();
			int x = 0;
			int y = 0;
			switch(resp){
				case "dig":
					x = 0;
					y = 0;
					while(true){
						System.out.println("Please input the x-coordinate of where you would like to dig (q to quit game).");
						String xStr = sc.nextLine();
						if(xStr.equalsIgnoreCase("q")){
							quit = true;
							break;
						}
						x = Integer.parseInt(xStr);
						if(x <= map.getMap()[0].length && x > -1){
							break;
						}
						System.out.println("Please input valid value (between 0 and 9");
					}
					if(quit){
						break;
					}
					while(true){
						System.out.println("Please input the y-coordinate of where you would like to dig (q to quit game).");
						String yStr = sc.nextLine();
						if(yStr.equalsIgnoreCase("q")){
							quit = true;
							break;
						}
						y = Integer.parseInt(yStr);
						if(y <= map.getMap()[0].length && x > -1){
							break;
						}
						System.out.println("Please input valid value (between 0 and 9");
					}
					quit = map.dig(x, y);
					System.out.println(map.printMap());
					break;
				case "flag":
					x = 0;
					y = 0;
					while(true){
						System.out.println("Please input the x-coordinate of where you would like to dig (q to quit game).");
						String xStr = sc.nextLine();
						if(xStr.equalsIgnoreCase("q")){
							quit = true;
							break;
						}
						x = Integer.parseInt(xStr);
						if(x <= map.getMap()[0].length && x > -1){
							break;
						}
						System.out.println("Please input valid value (between 0 and 9");
					}
					if(quit){
						break;
					}
					while(true){
						System.out.println("Please input the y-coordinate of where you would like to dig (q to quit game).");
						String yStr = sc.nextLine();
						if(yStr.equalsIgnoreCase("q")){
							quit = true;
							break;
						}
						y = Integer.parseInt(yStr);
						if(y <= map.getMap()[0].length && x > -1){
							break;
						}
						System.out.println("Please input valid value (between 0 and 9");
					}
					map.markFlag(x, y);
					System.out.println(map.printMap());
					break;
				case "quit":
					quit = true;
					break;
				case "print":
				System.out.println(map.printMap());
					break;
				case "rules":
					System.out.println("Rules:\n1. To start the game, chose anywhere on the board to dig\n2. Each Spot that does not have a bomb on it will have a number that tells you how many bombs are in a 3x3 square around the square.\n3. If you dig on a square that has bomb, the game will be over.");
			}
		    if(quit){
				System.out.println("You lost the game, better luck next time.");
				System.out.println("The bombs were located at:");
				System.out.println(map.printBombLocs());
				System.out.println(map.printMapWithBombs());
				sc.close();
		        return;
		    }
		}
	}
	
}




