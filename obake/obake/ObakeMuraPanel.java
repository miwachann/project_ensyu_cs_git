// Copyright 2006, Tuyano Syoda
// Rewritten by T. Ogihara (2012)

package jp.obake;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.*;
import java.lang.ClassLoader;

import javax.swing.*;

/*JPanelの継承*/
public class ObakeMuraPanel extends JPanel {
	int width, height;
	//Modelとコントローラーのインスタンスを作成
	ObakeMuraModel obakeModel;
	ObakeMuraController controller;
	static Image house, house2, house3, jimen, obake;
	static int gridWid, gridHgt;
    
	/*マスのサイズの設定*/
	private static void setGridSize(int w, int h) {
		gridWid = w;
		gridHgt = h;
	}
    
	/*ゲーム画面に使用する画像を取得*/
	private void getImages() {
		Class cls = this.getClass();
		URL url;
		//画像ファイルを検索してURLを作成し、画像ファイルのロードを行う
		url = cls.getResource("jimen.gif");
		jimen = Toolkit.getDefaultToolkit().getImage(url);
		url = cls.getResource("house.gif");
		house = Toolkit.getDefaultToolkit().getImage(url);
		url = cls.getResource("house2.gif");
		house2 = Toolkit.getDefaultToolkit().getImage(url);
		url = cls.getResource("house3.gif");
		house3 = Toolkit.getDefaultToolkit().getImage(url);
		url = cls.getResource("obake.gif");
		obake = Toolkit.getDefaultToolkit().getImage(url);
		setGridSize(50, 50); // image width & height
	}
    
	/*メインの部分*/
	public ObakeMuraPanel(int m, int n, ObakeMuraModel model){
		super();		//親クラスの実行
		width = m;
		height = n;
		obakeModel = model;
		if (house == null)	this.getImages();		//起動時の画像を読み込み
		this.setSize(new Dimension(width * gridWid, height * gridHgt));
		this.setPreferredSize(new Dimension(width * gridWid, height * gridHgt));
		repaint();									//呼び出されるたびに再描画(new game?)
	}
    
	/*MVCのContorollerのインスタンスを作成*/
	public void setController(ObakeMuraController ctr) {
		controller = ctr;
		//マウスイベントの受け取り
		this.addMouseListener(new MouseAdapter() {
				//マウスクリックが行われた際
				public void mouseClicked(MouseEvent ev){
					controller.didClick(ev.getX() / gridWid, ev.getY() / gridHgt);
				}
		});
	}
    
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0,0, width * gridWid, height * gridHgt);
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				Image img;
				GridAttr attr = obakeModel.getAttribute(i, j);
				g.drawImage(jimen,i * gridWid, j * gridHgt,	this);
				switch (attr) {
				case Ghost:		 img = obake; break;
				case House:		 img = house; break;
				case Occupied:	img = house2; break;
				case Destroyed: img = house3; break;
				default: img = null; break;
				}
				if (img != null)
					g.drawImage(img, i * gridWid, j * gridHgt, this);
			}
	}

}
