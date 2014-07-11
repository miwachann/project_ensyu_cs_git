
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
	int sx, sy;
    GridAttr[][] arr;
    boolean result, selectFlag;
    
    
	public ModelPeg(int m, int n)
	{
		super();
        width = m;
        height = n;
        result = false;
        arr = new GridAttr[width][height];
        resetStage();
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
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				arr[x][y] = GridAttr.Ground;
			}
		}
	}
	
	
	/**
	 * クリアしているか詰んだか確認を行うメソッド
	 */
	public boolean checkClear()
	{
		int count = 0;
		boolean nearPeg = false; 
		result = false;
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				if(this.isPeg(x, y)){
					count++;
					if (this.isPeg(x+1, y) || this.isPeg(x-1, y) || this.isPeg(x, y+1) || this.isPeg(x, y-1))
						nearPeg = true;
				}
			}
		}
		
		if(!nearPeg)
		{
			if(count == 1)	result = true;
		}
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
	 * マスにペグが配置されているかを返すメソッド
	 */
	private boolean isPeg(int x, int y)
	{
		if(x < 0 || x >= width || y < 0 || y >= height) return false;
		return (arr[x][y] == GridAttr.Peg);
	}
	
	
	/**
     * 選択したペグが配置できるかをテェック後、
     * 配置できるマスに薄いペグをセットするメソッド
     * （要省略）
     */
	private boolean putSetPeg(int x, int y)
    {
		boolean set = false;
        //右
        if(x+2 < width && (this.isPeg(x+1, y) && !this.isPeg(x+2, y)))
        {
                arr[x+2][y] = GridAttr.SetPeg;
                set = true;
        }
        //左
        if(x-2 >= 0 && (this.isPeg(x-1, y) && !this.isPeg(x-2, y)))
        {
                arr[x-2][y] = GridAttr.SetPeg;
                set = true;
        }
        //上
        if(y-2 >= 0 && (this.isPeg(x, y-1) && !this.isPeg(x, y-2)))
        {
                arr[x][y-2] = GridAttr.SetPeg;
                set = true;
        }
        //下
        if(y+2 < height && (this.isPeg(x, y+1) && !this.isPeg(x, y+2)))
        {
                arr[x][y+2] = GridAttr.SetPeg;
                set = true;
        }
        return set;
    }
	
	
	/**
	 * SetPegを消去するメソッド
	 */
	private void cleanSetPeg()
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
	 * ペグの移動を行うメソッド
	 */
	private void movePeg(int x, int y)
	{
		arr[x][y] = GridAttr.Peg;
		arr[sx][sy] = GridAttr.Ground;
		if(x > sx)	x--;
		if(x < sx)	x++;
		if(y > sy)	y--;
		if(y < sy)	y++;
		arr[x][y] = GridAttr.Ground;
		cleanSetPeg();
	}
	
	/**
	 * 移動するペグの選択・配置を行うメソッド
	 */
	public boolean putPeg(int x, int y)
	{
		if(arr[x][y] == GridAttr.Ground)
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
		else if(this.isPeg(x, y))
		{
			cleanSetPeg();
			sx = x;
			sy = y;
			System.out.println("sx:" + sx + "/ sy:" + sy);
			if(putSetPeg(x, y)) selectFlag = true;
			return true;
		}
		else if(arr[x][y] == GridAttr.SetPeg)
		{
			movePeg(x, y);
			return true;
		}
		return false;
	}
	
}