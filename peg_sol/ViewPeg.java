
package peg_sol;


public class ViewPeg extends JPanel
{
	int width, height;
	//Modelとcontrollerのインスタンスを作成
	ModelPeg model;
	ControllerPeg controller;
	static Image peg, ground, setPeg;
    static int gridWidth, gridHeight;
    
    
	/**
	 * マスのサイズの設定
	 */
	private static void setGridSize(int w, int h)
	{
		gridWidth = w;
        gridHeight = h;
	}
	
	/**
	 * ゲーム画面に使用する画像を取得
	 */
	private void getImages()
	{
		
	}
	
	
	public ViewPeg(int m, int n, ModelPeg model)
	{
		width = m;
		height = n;
        ModelPeg = model;
	}
	
	
	/**
	 * MVCのContorollerのインスタンスを作成
	 * マウスイベントの処置
	 */
	public void setController(ControllerPeg ctr)
	{
		controller = ctr;
	}
	
	
	
	/**
	 * ウィンドウ内の描画の処理を行う
	 */
	public void paintComponent(Graphics g)
	{
		
	}
}