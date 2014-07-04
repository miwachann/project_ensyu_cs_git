
package peg_sol;

//import文に関しては。現在はObakeMuraのを適当に追加、随時添削して行く。
import java.awt.*;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.event.*;
import java.net.URL;
import java.lang.ClassLoader;
import java.util.*;
import javax.swing.*;
import javax.swing.JComponent;



public class ViewPeg extends JPanel
{
	int width, height;
	//Modelとcontrollerのインスタンスを作成
	ModelPeg pegModel;
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
		Class cls = this.getClass();
		URL url;
		url = cls.getResource("./src/ground.gif");
		ground = Toolkit.getDefaultToolkit().getImage(url);
		setGridSize(50, 50);
	}
	
	
	public ViewPeg(int m, int n, ModelPeg model)
	{
		
		super();		//親クラスの実行
		width = m;
		height = n;
		pegModel = model;
		if (ground == null)	this.getImages();		//起動時の画像を読み込み
		this.setSize(new Dimension(width * gridWidth, height * gridHeight));
		this.setPreferredSize(new Dimension(width * gridWidth, height * gridHeight));
		repaint();									//呼び出されるたびに再描画(new game?)
		
	}
	
	
	/**
	 * MVCのContorollerのインスタンスを作成
	 * マウスイベントの処置
	 */
	public void setController(ControllerPeg ctr)
	{
		controller = ctr;
		//マウスイベントの受け取り
		this.addMouseListener(new MouseAdapter()
		{
			//マウスクリックが行われた際
			public void mouseClicked(MouseEvent ev)
			{
				controller.didClick(ev.getX() / gridWidth, ev.getY() / gridHeight);
			}
		});
	}
	
	
	
	/**
	 * ウィンドウ内の描画の処理を行う
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	//superクラスからpaintComponentの呼び出し
		g.setColor(Color.WHITE);
		/*
		g.fillRect(0,0, width * gridWidth, height * gridHeight);
		for (int i=0; i<width; i++)
		{
			for (int j=0; j<height; j++)
			{
				Image img;
				GridAttr attr = model.getAttribute(i, j);
				g.drawImage(ground,i * gridWidth, j * gridHeight, this);
				switch (attr)
				{
				
				}
				if (img != null)	g.drawImage(img, i * gridWidth, j * gridHeight, this);
			}
		}
		*/
	}
}