
package peg_sol;

import java.util.*;

enum GridAttr {
	Grownd, Peg, SetPeg
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
	public void selectStage()
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
	public GridAttr getAttribute(int x, int y) {
		return arr[x][y];
	}
	
	/**
	 * ペグの配置を行うメソッド
	 */
	public boolean putPeg(int x, int y)
	{
		return result;
	}
}