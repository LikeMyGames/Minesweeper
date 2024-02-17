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
		if(size > 99)
			size = 99;
        map = new String[size][size];
		for(int i = 0; i<map.length; i++){
		    for(int j = 0; j<map[0].length; j++){
		        map[i][j] = " ";
		    }
		}
		bombLocs = new boolean[size][size];
		loadBombs(((int)(Math.random()*size+1)));
    }
    
    public Map(int height, int width, int numOfBombs){
		if(height > 99)
			height = 99;
		if(width > 99)
			width = 99;
        map = new String[height][width];
		for(int i = 0; i<map.length; i++){
		    for(int j = 0; j<map[0].length; j++){
		        map[i][j] = " ";
		    }
		}
		bombLocs = new boolean[height][width];
		loadBombs(numOfBombs);
    }

	public void loadBombs(int bombs){
		
		while(bombs >= 0){
			for(int i = 0; i<bombLocs.length; i++){
				for(int j = 0; j<bombLocs[0].length; j++){
					if(Math.random() > 0.9 && bombs >= 0){
						bombLocs[i][j] = true;
						bombs--;
					}
				}
			}
		}
		
		//while(bombs > 0)
	}
    
    
	public String printMap(){
		String str = "";
		str += "  ";
		for(int i = 0; i<map[0].length; i++){
			Integer I = i;
			String iStr = I.toString();
			if(iStr.length() == 1)
	        	str += "--" + iStr;
			else if(iStr.length() == 2)
				str += iStr;
	    }
	    str += "-\n";
	    for(int i = 0; i<map.length; i++){
			str += i + " ";
	        for(int j = 0; j<map[0].length; j++){
	            str += "| " + map[i][j];
	        }
	        str += "|\n";
	    }
		str += "  ";
	    for(int i = 0; i<map[0].length; i++){
	        Integer I = i;
			String iStr = I.toString();
			if(iStr.length() == 1)
	        	str += "--" + iStr;
			else if(iStr.length() == 2)
				str += iStr;
	    }
	    str += "-\n";
		return str;
	}

	public String[][] getMap(){
		return map;
	}

	public int calcNearByBombs(int x, int y){
		int totBombs = 0;
		for(int i = y-1; i<y+2; i++){
			for(int j = x-1; j<x+2; j++){
				if((i >= 0 && i < map.length) && (j >= 0 && j < map[0].length)){
					//System.out.println("[" + j + ", " + i + "]: " + bombLocs[i][j]);
					if(bombLocs[i][j]){
						totBombs++;
					}
				}
			}
		}
		return totBombs;
	}

	public boolean dig(int x, int y){
		if(bombLocs[y][x]){
			return true;
		}
		else if(map[y][x].equalsIgnoreCase("f")){
			return false;
		}
		else if(map[y][x].equals(" ")){
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
				if(x-1 >=0 && y-1 >= 0){
					dig(x-1, y-1);	
				}
				if(y-1 >= 0){
					dig(x, y-1);
				}
				if(x+1 < map[0].length && y-1 >= 0){
					dig(x+1, y-1);
				}
				if(x-1 >= 0){
					dig(x-1, y);
				}
				if(x+1 < map[0].length){
					dig(x+1, y);
				}
				if(x-1 >= 0 && y+1 < map.length){
					dig(x-1, y+1);
				}
				if(y+1 < map.length){
					dig(x, y+1);
				}
				if(x+1 < map[0].length && y+1 < map.length){
					dig(x+1, y+1);
				}
			}
		}
		return false;
	}

	public void markFlag(int x, int y){
		if(map[y][x].equals(" ")){
			map[y][x] = "F";
		}
	}

	public String printBombLocs() {
		String str = "";
		for(int i = 0; i<bombLocs.length; i++){
			for(int j = 0; j<bombLocs[0].length; j++){
				if(bombLocs[i][j]){
					str += "{" + j + ", " + i + "}\n";
				}
			}
		}
		return str;
	}

	public String printMapWithBombs(){
		String str = "";
		str += "  ";
		for(int i = 0; i<map[0].length; i++){
			Integer I = i;
			String iStr = I.toString();
			if(iStr.length() == 1)
	        	str += "--" + iStr;
			else if(iStr.length() == 2)
				str += iStr;
	    }
	    str += "-\n";
	    for(int i = 0; i<map.length; i++){
			str += i + " ";
	        for(int j = 0; j<map[0].length; j++){
				if(bombLocs[i][j]){
					str += "| B";
				}
				else{
	            	str += "| " + map[i][j];
				}
	        }
	        str += "|\n";
	    }
		str += "  ";
	    for(int i = 0; i<map[0].length; i++){
	        Integer I = i;
			String iStr = I.toString();
			if(iStr.length() == 1)
	        	str += "--" + iStr;
			else if(iStr.length() == 2)
				str += iStr;
	    }
	    str += "-\n";
		return str;
	}
}
