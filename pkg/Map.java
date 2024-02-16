package pkg;

public class Map {
    String[][] map;
    boolean[][] bombLocs;
    
    public Map(){
        map = new String[10][10];
        for(int i = 0; i<map.length; i++){
		    for(int j = 0; j<map[0].length; j++){
		        map[i][j] = " ";
		    }
		}
		bombLocs = new boolean[10][10];
		loadBombs(15);
    }
    
    public Map(int size){
        map = new String[size][size];
		for(int i = 0; i<map.length; i++){
		    for(int j = 0; j<map[0].length; j++){
		        map[i][j] = " ";
		    }
		}
		bombLocs = new boolean[size][size];
    }
    
    public Map(int height, int width){
        map = new String[height][width];
		for(int i = 0; i<map.length; i++){
		    for(int j = 0; j<map[0].length; j++){
		        map[i][j] = " ";
		    }
		}
		bombLocs = new boolean[height][width];
    }

	public void loadBombs(int bombs){
		for(int i = 0; i<bombLocs.length; i++){
			for(int j = 0; j<bombLocs[0].length; j++){
				if(Math.random() > 0.5 && bombs>0){
					bombLocs[i][j] = true;
					bombs--;
				}
			}
		}
	}
    
    
	public void printMap(){
	    for(int i = 0; i<map[0].length; i++){
	        System.out.print("---");
	    }
	    System.out.println("-");
	    for(int i = 0; i<map.length; i++){
	        for(int j = 0; j<map[0].length; j++){
	            System.out.print("| " + map[i][j]);
	        }
	        System.out.println("|");
	    }
	    for(int i = 0; i<map[0].length; i++){
	        System.out.print("---");
	    }
	    System.out.println("-");
	    return;
	}

	public String[][] getMap(){
		return map;
	}

	public void dig(int x, int y){
		int totBombs = 0;
		for(int i = y-1; i<y+1; i++){
			for(int j = x-1; j<x+1; j++){
				if(bombLocs[i][j]){
					totBombs++;
				}
			}
		}
		map[y][x] = "" + totBombs;
	}

	public void markFlag(int x, int y){

	}
}
