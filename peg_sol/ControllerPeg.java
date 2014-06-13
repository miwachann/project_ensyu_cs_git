
package peg_sol;


public class ControllerPeg {
    
	
	public ControllerPeg(ViewPeg p, ModelPeg m)
	{
		
	}
	
	
	/**
	 * 新しいゲーム（ステージの選択）をするメソッド
	 */
	public void newGame()
	{
		panel.repaint();
	}
	
	
	/**
	 * ステージのやり直しをするメソッド
	 */
	public void resetStage()
	{
		panel.repaint();
	}
	
	
	/**
	 * ステージを作成するモードに移行するメソッド
	 */
	public void makeStage()
	{
		panel.repaint();
	}
	
	
	/**
	 * クリックされた際の処理を行うメソッド
	 */
	public void didClick(int x, int y)
	{
		
	}
}