#include <iostream>
#include <string>
#include <vector>
#include <Map>
#include <cstdlib>
#include <algorithm>
using namespace std;

class Map{
	std::vector<std::vector<std::string>> map;
    std::vector<std::vector<bool>> bombLocs;
	
	public:
		Map(){
			map.resize(10);
			for(auto& row : map){
				row.resize(10);
			}
		    for(int i = 0; i<10; i++){
				for(int j = 0; j<10; j++){
			        map[i][j] = " ";
		    }
		}
			bombLocs.resize(10);
			for(auto& row : bombLocs){
				row.resize(10);
			}
			loadBombs(15);
		}
		Map(int size){
			if(size > 99)
				size = 99;
		    map[size][size];
			for(int i = 0; i<size; i++){
			    for(int j = 0; j<size; j++){
			        map[i][j] = " ";
			    }
			}
			bombLocs[size][size];
			loadBombs(((rand()%size+1)));
		}
		Map(int height, int width, int numOfBombs){
			if(height > 99)
				height = 99;
			if(width > 99)
				width = 99;
		    map[height][width];
			for(int i = 0; i<height; i++){
			    for(int j = 0; j<width; j++){
			        map[i][j] = " ";
			    }
			}
			bombLocs[height][width];
			loadBombs(numOfBombs);
		}
		void loadBombs(int bombs){
			int rows = sizeof(bombLocs) / sizeof(bombLocs[0]);
			int columns = sizeof(bombLocs[0]) / sizeof(bool);
			while(bombs >= 0){
				for(int i = 0; i<rows; i++){
					for(int j = 0; j<columns; j++){
						if(rand() > (2147483647/2) && bombs >= 0){
							bombLocs[i][j] = true;
							bombs--;
						}
					}
				}
			}
		}
		std::string printMap(){
			std::string str = "";
			str.append("  ");
			int rows = sizeof(map) / sizeof(map[0]);
			int columns = sizeof(map[0]) / sizeof(std::string); 
			for(int i = 0; i<columns; i++){
				std::string iStr = to_string(i);
				if(iStr.length() == 1){
		        	str.append("--");
					str.append(iStr);
				}
				else if(iStr.length() == 2)
					str.append(iStr);
		    }
		    str.append("-\n");
		    for(int i = 0; i<rows; i++){
				str.append(std::to_string(i));
				str.append(" ");
		        for(int j = 0; j<columns; j++){
					str.append("| ");
					str.append(map[i][j]);
		        }
				str.append("|\n");
		    }
			str.append("  ");
		    for(int i = 0; i<rows; i++){
		        std::string iStr = to_string(i);
				if(iStr.length() == 1){
		        	str.append("--");
					str.append(iStr);
				}
				else if(iStr.length() == 2)
					str.append(iStr);
		    }
			str.append("-\n");
			return str;
		}
		std::vector<std::vector<string>> getMap(){
			return map;
		}
		int calcNearByBombs(int x, int y){
			int totBombs = 0;
			int rows = sizeof(map) / sizeof(map[0]);
			int columns = sizeof(map[0]) / sizeof(std::string);
			for(int i = y-1; i<y+2; i++){
				for(int j = x-1; j<x+2; j++){
					if((i >= 0 && i < rows) && (j >= 0 && j < columns)){
						if(bombLocs[i][j]){
							totBombs++;
						}
					}
				}
			}
			return totBombs;
		}
		bool dig(int x, int y){
			if(bombLocs[y][x]){
				return true;
			}
			else if(map[y][x] == "F"){
				return false;
			}
			else if(map[y][x] == " "){
				int totBombs = calcNearByBombs(x, y);
			map[y][x] = "" + totBombs;
				if(totBombs == 0){
					/*
					for(int i = y-1; i<y+1; i++){
						for(int j = x-1; j<x+1; j++){
							if((i >= 0 && i < map.length) && (j >= 0 && j < map[0].length)){
								dig(j, i);
							}
						}
					}
					*/
					int rows = sizeof(map) / sizeof(map[0]);
					int columns = sizeof(map[0]) / sizeof(string);
					if(x-1 >=0 && y-1 >= 0){
						dig(x-1, y-1);	
					}
					if(y-1 >= 0){
						dig(x, y-1);
					}
					if(x+1 < columns && y-1 >= 0){
						dig(x+1, y-1);
					}
					if(x-1 >= 0){
						dig(x-1, y);
					}
					if(x+1 < columns){
						dig(x+1, y);
					}
					if(x-1 >= 0 && y+1 < rows){
						dig(x-1, y+1);
					}
					if(y+1 < rows){
						dig(x, y+1);
					}
					if(x+1 < columns && y+1 < rows){
						dig(x+1, y+1);
					}
				}
			}
			return false;
		}
		void markFlag(int x, int y){
			if(map[y][x] == " "){
				map[y][x] = "F";
			}
		}
		std::string printBombLocs() {
			int rows = sizeof(bombLocs) / sizeof(bombLocs[0]);
			int columns = sizeof(bombLocs[0]) / sizeof(bool);
			std::string str = "";
			for(int i = 0; i<rows; i++){
				for(int j = 0; j<columns; j++){
					if(bombLocs[i][j]){
						//str += "{" + j + ", " + i + "}\n";
						str.append("{" + std::to_string(j) + ", " + std::to_string(i) + "}\n");
					}
				}
			}
			return str;
		}
		std::string printMapWithBombs(){
			int rows = sizeof(map) / sizeof(map[0]);
			int columns = sizeof(map[0]) / sizeof(std::string);
			std::string str = "";
			str.append("  ");
			for(int i = 0; i<columns; i++){
				string iStr = to_string(i);
				if(iStr.length() == 1){
		        	str.append("--");
					str.append(iStr);
				}
				else if(iStr.length() == 2)
					str.append(iStr);
		    }
		    str.append("-\n");
		    for(int i = 0; i<rows; i++){
				str.append(std::to_string(i));
				str.append(" ");
		        for(int j = 0; j<columns; j++){
					if(bombLocs[i][j]){
						str.append("| B");
					}
					else{
						str.append("| ");
						str.append(map[i][j]);
					}
		        }
				str.append("|\n");
		    }
			str.append("  ");
		    for(int i = 0; i<columns; i++){
		        string iStr = to_string(i);
				if(iStr.length() == 1){
		        	str.append("--");
					str.append(iStr);
				}
				else if(iStr.length() == 2)
					str.append(iStr);
		    }
			str.append("-\n");
			return str;
		}
};

int main(){

    Map map;
	/*
	if(args.length == 0)
		map = new Map();
	else if(args.length == 1)
		map = new Map(Integer.parseInt(args[0]));
	else if(args.length == 3)
		map = new Map(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
	else
	*/
	map = Map();
	std::cout << map.printMap();
	bool quit = false;
	std::cout << "Rules:\n1. To start the game, chose anywhere on the board to dig\n2. Each Spot that does not have a bomb on it will have a number that tells you how many bombs are in a 3x3 square around the square.\n3. If you dig on a square that has bomb, the game will be over.";
	while(true){
	    std::cout << "\n1. dig\n2. flag\n3. print\n4. rules\n5. quit\n(please input number that it is listed as)\n";
		string resp;
		std::cin >> resp;
		int x = 0;
		int y = 0;
		switch(std::stoi(resp)){
			case 1:
				x = 0;
				y = 0;
				while(true){
					std::cout << "Please input the x-coordinate of where you would like to dig (q to quit game).";
					string xStr;
					std::cin >> xStr;
					if(xStr == "q"){
						quit = true;
						break;
					}
					x = std::stoi(xStr);
					int columns = sizeof(map.getMap()) / sizeof(map.getMap()[0]);
					if(x <= columns && x > -1){
						break;
					}
					std::cout << "Please input valid value (between 0 and 9";
				}
				if(quit){
					break;
				}
				while(true){
					std::cout << ("Please input the y-coordinate of where you would like to dig (q to quit game).");
					string yStr;
					std::cin >> yStr;
					if(yStr == "q"){
						quit = true;
						break;
					}
					y = std::stoi(yStr);
					int columns = sizeof(map.getMap()) / sizeof(map.getMap()[0]);
					if(y <= columns && x > -1){
						break;
					}
					std::cout << ("Please input valid value (between 0 and 9");
				}
				quit = map.dig(x, y);
				std::cout << map.printMap();
				break;
			case 2:
				x = 0;
				y = 0;
				while(true){
					std::cout << "Please input the x-coordinate of where you would like to flag (q to quit game).";
					std::string xStr;
					std::cin >> xStr;
					if(xStr == "q"){
						quit = true;
						break;
					}
					x = std::stoi(xStr);
					int columns = sizeof(map.getMap()) / sizeof(map.getMap()[0]);
					if(x <= columns && x > -1){
						break;
					}
					std::cout << "Please input valid value (between 0 and 9";
				}
				if(quit){
					break;
				}
				while(true){
					std::cout << ("Please input the y-coordinate of where you would like to flag (q to quit game).");
					std::string yStr;
					std::cin >> yStr;
					if(yStr == "q"){
						quit = true;
						break;
					}
					y = std::stoi(yStr);
					int columns = sizeof(map.getMap()) / sizeof(map.getMap()[0]);
					if(y <= columns && x > -1){
						break;
					}
					std::cout << ("Please input valid value (between 0 and 9");
				}
				quit = map.dig(x, y);
				cout << map.printMap();
				break;
			case 5:
				quit = true;
				break;
			case 3:
				std::cout << map.printMap();
				break;
			case 4:
				std::cout << "Rules:\n1. To start the game, chose anywhere on the board to dig\n2. Each Spot that does not have a bomb on it will have a number that tells you how many bombs are in a 3x3 square around the square.\n3. If you dig on a square that has bomb, the game will be over.";
    	}
	    if(quit){
	    	std::cout << "You lost the game, better luck next time.";
		    std::cout << "The bombs were located at:";
		    std::cout << map.printBombLocs();
	    	std::cout << map.printMapWithBombs();
	        return 0;
	    }
		}
}