
package peg_sol;

//import文に関しては。現在はObakeMuraのを適当に追加、随時添削して行く。
import java.util.*;

enum GridAttr
{
	Ground, Peg, SetPeg
};

public class ModelPeg
{
	int width,height;
    GridAttr[][] arr;
    boolean result;
    
    
	public ModelPeg(int m, int n)
	{
		super();
        width = m;
        height = n;
        
        arr = new GridAttr[width][height];
        /*
        for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
					arr[i][j] = GridAttr.Ground;
			}
		}
		*/
	}
	
	
	
	/**
	 * ステージの保存を行うメソッド
	 */
	public void saveStage()
	{
		
	}
	
	
	/**
	 * ステージの配置の読み込みを行うメソッド
	 */
	public void selectStage(int n)
	{
		
	}
	
	
	/**
	 * ステージの配置の再読み込みを行うメソッド
	 */
	public void resetStage()
	{
		
	}
	
	/**
	 * クリアしているか詰んだか確認を行うメソッド
	 */
	public boolean checkClear()
	{
		return result;
	}
	
	/**
	 * マスに何が配置されているかを返すメソッド
	 */
	public GridAttr getAttribute(int x, int y)
	{
		return arr[x][y];
	}
	
	/**
	 * ペグの配置を行うメソッド
	 */
	public boolean putPeg(int x, int y)
	{
		//ペグの選択時とペグの配置時の処理をわける。
		/*
		if (arr[x][y] == GridAttr.Ground)
		{
			arr[x][y] = GridAttr.Peg;
			return true;
		}
		return false;
		*/
		return result;
	}
}