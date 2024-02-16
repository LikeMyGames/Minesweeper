import java.util.*;
import pkg.Map;

public class minesweeper{
	public static void main(String[] args) {
	    
		Map map = new Map();
		map.printMap();
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		System.out.println("Rules:\n1. To start the game, chose anywhere on the board to dig\n2. Each Spot that does not have a bomb on it will have a number that tells you how many bombs are in a 3x3 square around the square.\n3. If you dig on a square that has bomb, the game will be over.");
		while(true){
		    System.out.println("1. dig\n2. flag\n3. print\n4. rules\n5. quit");
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
					map.dig(x, y);
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
					break;
				case "quit":
					return;
				case "print":
					map.printMap();
					break;
				case "rules":
					System.out.println("Rules:\n1. To start the game, chose anywhere on the board to dig\n2. Each Spot that does not have a bomb on it will have a number that tells you how many bombs are in a 3x3 square around the square.\n3. If you dig on a square that has bomb, the game will be over.");
			}
		    if(quit){
				sc.close();
		        return;
		    }
		}
	}
	
}




