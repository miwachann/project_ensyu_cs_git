
package peg_sol;

public class mainPeg extends JFrame
{
	
	private ViewPeg view;
	private ModelPeg model;
	private ControllerPeg controller;
	
	/**
	 * mainPegのインスタンスの生成を行うメソッド
	 */
	public static void main(String[] args){
		new mainPeg();
	}
	
	public mainPeg()
	{
		int x=;
        int y=;
        model = new ModelPeg(x, y);
		view = new ViewPeg(x, y, model);
		controller = new ControllerPeg(view, model);
        view.setContoroller(controller);
        this.makeMenuBar();
	}
	
	/**
	 * メニューバーを追加するメソッド
	 */
	public void makeMenuBar()
	{
		
	}
}