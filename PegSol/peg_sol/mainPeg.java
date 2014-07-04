
package peg_sol;


import java.awt.event.*;
import javax.swing.*;

public class mainPeg extends JFrame
{
	private ViewPeg view;
	private ModelPeg model;
	private ControllerPeg controller;
	
	/**
	 * mainPegのインスタンスの生成を行うメソッド
	 */
	public static void main(String[] args)
	{
		new mainPeg();
	}
	
	public mainPeg()
	{
		int x=9;
        int y=9;
        
		this.getContentPane().setLayout(null);
		this.setSize(x * 50 + 50, y * 50 + 100);
		this.setResizable(false);
		
        model = new ModelPeg(x, y);
		view = new ViewPeg(x, y, model);
		controller = new ControllerPeg(view, model);
		
        view.setController(controller);
        view.setBounds(25, 25, x * 50, y * 50);
		this.getContentPane().add(view);
		
        this.makeMenuBar();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * メニューバーを追加するメソッド
	 */
	public void makeMenuBar()
	{
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("ゲーム");
		
		JMenuItem newgame = new JMenuItem("新しいゲームを始める");
		newgame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				//System.exit(0);
			}
		});
		menu.add(newgame);
		
		JMenuItem restart = new JMenuItem("ゲームのやり直し");
		restart.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				//System.exit(0);
			}
		});
		menu.add(restart);
		
		JMenuItem newstage = new JMenuItem("ステージを作成する");
		newstage.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				//System.exit(0);
			}
		});
		menu.add(newstage);
		
		menu.addSeparator();		//メニュー内に区切り線を挿入
		
		JMenuItem quititem = new JMenuItem("終了");
		quititem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				System.exit(0);
			}
		});
		menu.add(quititem);
		
		bar.add(menu);				//メニューバーにメニューを追加
		this.setJMenuBar(bar);		//ウィンドウにメニューを追加
	}
}