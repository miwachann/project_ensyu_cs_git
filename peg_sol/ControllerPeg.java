
package peg_sol;


public class ControllerPeg {
    
	
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
        model.selectStage();
		gameflag = true;
		panel.repaint();
	}
	
	
	/**
	 * ステージのやり直しをするメソッド
	 */
	public void resetStage()
	{
        model.resetStage();
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