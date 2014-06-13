// Written by T. Ogihara (2012)

package jp.obake;

import java.awt.*;
import javax.swing.*;

public class ObakeMuraController {
    
	ObakeMuraPanel panel;
	ObakeMuraModel model;
	boolean gameflag;
    
	public ObakeMuraController(ObakeMuraPanel p, ObakeMuraModel m) {
		panel = p;
		model = m;
		gameflag = false;
	}
    
	public void newGame(){
		model.makeFirstStage();
		gameflag = true;
		panel.repaint();
	}
	
	public void resetStage() {
		model.resetStage();
		panel.repaint();
	}
	
	public void renewStage(){
		model.remakeStage();
		panel.repaint();
	}
    
	public void didClick(int x, int y) {
		if (gameflag && model.putGhost(x, y)) {
			panel.repaint();
			if (model.checkClear()) {
				JOptionPane.showMessageDialog(panel.getParent().getParent(),
						"制圧完了！");
				model.makeNextStage();
				panel.repaint();
			}
		}
	}

}

