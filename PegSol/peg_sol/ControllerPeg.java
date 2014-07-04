
package peg_sol;

//import文に関しては。現在はObakeMuraのを適当に追加、随時添削して行く。
import java.awt.*;
import javax.swing.*;

public class ControllerPeg
{
	
	ViewPeg view;
	ModelPeg model;
	boolean gameflag;
	
	public ControllerPeg(ViewPeg v, ModelPeg m)
	{
		view = v;
        model = m;
		gameflag = false;
	}
	
	
	/**
	 * 新しいゲーム（ステージの選択）をするメソッド
	 */
	public void newGame()
	{
        //model.selectStage();
		//gameflag = true;
		//panel.repaint();
	}
	
	
	/**
	 * ステージのやり直しをするメソッド
	 */
	public void resetStage()
	{
        //model.resetStage();
		//panel.repaint();
	}
	
	
	/**
	 * ステージを作成するモードに移行するメソッド
	 */
	public void makeStage()
	{
		//panel.repaint();
	}
	
	
	/**
	 * クリックされた際の処理を行うメソッド
	 */
	public void didClick(int x, int y)
	{
		System.out.println("x:" + x + "/ y:" + y);
		
		//ペグの選択時とペグの配置時の処理をわける。
		/*
		if (arr[x][y] == GridAttr.Ground)
		{
			arr[x][y] = GridAttr.Peg;
			return true;
		}
		return false;
		*/
	}
}