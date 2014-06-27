
package peg_sol;

import java.awt.*;
import javax.swing.*;

public class ControllerPeg
{
	
<<<<<<< HEAD:peg_sol/ControllerPeg.java
=======
	ViewPeg view;
	ModelPeg model;
	
>>>>>>> FETCH_HEAD:PegSol/peg_sol/ControllerPeg.java
	public ControllerPeg(ViewPeg v, ModelPeg m)
	{
		view = v;
        model = m;
<<<<<<< HEAD:peg_sol/ControllerPeg.java
        gameflag = false;
=======
>>>>>>> FETCH_HEAD:PegSol/peg_sol/ControllerPeg.java
	}
	
	
	/**
	 * 新しいゲーム（ステージの選択）をするメソッド
	 */
	public void newGame()
	{
<<<<<<< HEAD:peg_sol/ControllerPeg.java
        model.selectStage();
		gameflag = true;
		panel.repaint();
=======
        //model.selectStage();
		//gameflag = true;
		//panel.repaint();
>>>>>>> FETCH_HEAD:PegSol/peg_sol/ControllerPeg.java
	}
	
	
	/**
	 * ステージのやり直しをするメソッド
	 */
	public void resetStage()
	{
<<<<<<< HEAD:peg_sol/ControllerPeg.java
        model.resetStage();
		panel.repaint();
=======
        //model.resetStage();
		//panel.repaint();
>>>>>>> FETCH_HEAD:PegSol/peg_sol/ControllerPeg.java
	}
	
	
	/**
	 * ステージを作成するモードに移行するメソッド
	 */
	public void makeStage()
	{
<<<<<<< HEAD:peg_sol/ControllerPeg.java
        
		panel.repaint();
=======
		//panel.repaint();
>>>>>>> FETCH_HEAD:PegSol/peg_sol/ControllerPeg.java
	}
	
	
	/**
	 * クリックされた際の処理を行うメソッド
	 */
	public void didClick(int x, int y)
	{
		
		
	}
}