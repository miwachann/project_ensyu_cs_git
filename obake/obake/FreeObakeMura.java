// Copyright 2006, Tuyano Syoda
// Rewritten by T. Ogihara (2012)

package jp.obake;

import java.awt.event.*;
import javax.swing.*;

public class FreeObakeMura extends JFrame {
	private ObakeMuraPanel opanel;
	private ObakeMuraModel omodel;
	private ObakeMuraController controller;
	
    
	public static void main(String[] args){
		new FreeObakeMura();
	}
	
    //MVCの導入
	public FreeObakeMura(){
		int x = 7;
		int y = 7;
		this.getContentPane().setLayout(null);
		this.setSize(x * 50 + 50, y * 50 + 100);
		this.setResizable(false);
		omodel = new ObakeMuraModel(x, y);
		opanel = new ObakeMuraPanel(x, y, omodel);
		controller = new ObakeMuraController(opanel, omodel);
		opanel.setController(controller);
		opanel.setBounds(25, 25, x * 50, y * 50);
		this.getContentPane().add(opanel);
		
		this.makeMenuBar();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
    
    //メニューバー
	public void makeMenuBar(){
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("ゲーム");
		JMenuItem newitem = new JMenuItem("ゲームを始める");
		newitem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				controller.newGame();
			}
		});
		
		menu.add(newitem);
		JMenuItem resetitem = new JMenuItem("このステージをやり直す");
		resetitem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				controller.resetStage();
			}
		});
        
		menu.add(resetitem);
		JMenuItem renewitem = new JMenuItem("このステージを作り直す");
		renewitem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				controller.renewStage();
			}
		});
        
		menu.add(renewitem);
		menu.addSeparator();
		JMenuItem quititem = new JMenuItem("終了");
		quititem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				System.exit(0);
			}
		});
        
		menu.add(quititem);
		bar.add(menu);
		this.setJMenuBar(bar);
	}

}
