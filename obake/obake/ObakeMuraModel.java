// Written by T. Ogihara (2012)

package jp.obake;

import java.util.*;

enum GridAttr {
	Ground, Ghost, House, Occupied, Destroyed
};


public class ObakeMuraModel {
	int width, height;
	GridAttr[][] arr;
	int numberOfHouse;
    
	public ObakeMuraModel(int m, int n) {
		super();
		width = m;
		height = n;
		numberOfHouse = 0;
		arr = new GridAttr[width][height];
		this.remakeStage();
	}
    
	public void makeFirstStage() {
		numberOfHouse = 1;
		this.remakeStage();
	}
    
	public void makeNextStage() {
		numberOfHouse++;
		this.remakeStage();
	}
    
	public void remakeStage() {
		Random rnd = new Random(new Date().getTime());
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++)
				arr[i][j] = GridAttr.Ground;
		int count = 0;
		while (count < numberOfHouse){
			int x = rnd.nextInt(width);
			int y = rnd.nextInt(height);
			if (arr[x][y] == GridAttr.Ground){
				arr[x][y] = GridAttr.House;
				count++;
			}
		}
	}
    
	public void resetStage() {
		for(int i = 0; i < width; i++)
			for(int j = 0; j < height; j++) {
				if (arr[i][j] == GridAttr.Ghost){
					arr[i][j] = GridAttr.Ground;
				}else if (arr[i][j] == GridAttr.Occupied
						|| arr[i][j] == GridAttr.Destroyed)
					arr[i][j] = GridAttr.House;
				}
			}
	}
    
	private boolean isGhost(int x, int y) {
		if (x < 0 || x >= width || y < 0 || y >= height) return false;
		return (arr[x][y] == GridAttr.Ghost);
	}
    
	public boolean checkClear(){
		int count = 0;
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				if (arr[i][j] == GridAttr.House
					|| arr[i][j] == GridAttr.Occupied || arr[i][j] == GridAttr.Destroyed) {
					int n = 0;
					if (this.isGhost(i-1, j-1)) ++n;
					if (this.isGhost(i	, j-1)) ++n;
					if (this.isGhost(i+1, j-1)) ++n;
					if (this.isGhost(i-1, j	)) ++n;
					if (this.isGhost(i+1, j	)) ++n;
					if (this.isGhost(i-1, j+1)) ++n;
					if (this.isGhost(i	, j+1)) ++n;
					if (this.isGhost(i+1, j+1)) ++n;
					if (n == 3)
							arr[i][j] = GridAttr.Occupied;
					else {
							count++;
							arr[i][j] = (n > 3) ? GridAttr.Destroyed : GridAttr.House;
					}
				}
			}
		return (count == 0);
	}
    
	public GridAttr getAttribute(int x, int y) {
		return arr[x][y];
	}
    
	public boolean putGhost(int x, int y) {
		if (arr[x][y] == GridAttr.Ground) {
			arr[x][y] = GridAttr.Ghost;
			return true;
		}
		return false;
	}
}
