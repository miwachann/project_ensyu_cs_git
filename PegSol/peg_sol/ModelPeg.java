
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
    boolean result, selectFlag;
    
    
	public ModelPeg(int m, int n)
	{
		super();
        width = m;
        height = n;
        
        arr = new GridAttr[width][height];
        for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
					arr[i][j] = GridAttr.Ground;
			}
		}
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
     * 選択したペグが配置できるかをテェック後、
     * 配置できるマスに薄いペグをセットするメソッド
     * （要省略）
     */
	public boolean putSetPeg(int x, int y)
    {
		boolean set = false;
        //右
        if (x+2 < width)
        {
            if (arr[x+1][y] == GridAttr.Peg && arr[x+2][y] != GridAttr.Peg)
            {
                arr[x+2][y] = GridAttr.SetPeg;
                set = true;
            }
        }
        //左
        if (x-2 >= 0)
        {
            if (arr[x-1][y] == GridAttr.Peg && arr[x-2][y] != GridAttr.Peg)
            {
                arr[x-2][y] = GridAttr.SetPeg;
                set = true;
            }
        }
        //上
        if (y-2 >= 0)
        {
            if (arr[x][y-1] == GridAttr.Peg && arr[x][y-2] != GridAttr.Peg)
            {
                arr[x][y-2] = GridAttr.SetPeg;
                set = true;
            }
        }
        //下
        if (y+2 < height)
        {
            if (arr[x][y+1] == GridAttr.Peg && arr[x][y+2] != GridAttr.Peg)
            {
                arr[x][y+2] = GridAttr.SetPeg;
                set = true;
            }
        }
        return set;
    }
	
	/**
	 * SetPegを消去するメソッド
	 */
	public void cleanSetPeg()
	{
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				if(arr[x][y] == GridAttr.SetPeg)	arr[x][y] = GridAttr.Ground;
			}
		}
		selectFlag = false;
	}
	
	/**
	 * ペグの配置を行うメソッド
	 */
	public boolean putPeg(int x, int y)
	{
		//ペグの選択時とペグの配置時の処理をわける。
		/*
		 * ペグの選択
		 * クリックした場所がペグをおける場所か判定
		 * おければペグをおく
		 * 無理なら選択をやめる。
		 */
		
		if (arr[x][y] == GridAttr.Ground)
		{
			if(selectFlag)
			{
				cleanSetPeg();
				return true;
			}
			else
			{
				arr[x][y] = GridAttr.Peg;
				return true;
			}
		}
		else if(arr[x][y] == GridAttr.Peg)
		{
			cleanSetPeg();
			if(putSetPeg(x, y))
				selectFlag = true;
			return true;
		}
		else if(arr[x][y] == GridAttr.SetPeg)
		{
			arr[x][y] = GridAttr.Peg;
			cleanSetPeg();
			return true;
		}
		
		
		return false;
	}
	
	
}