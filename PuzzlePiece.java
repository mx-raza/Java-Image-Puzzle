import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class PuzzlePiece{
	
	boolean lock = false;
	int originalPos[] = new int[2];
	int currentPos[] = new int[2];
	BufferedImage pic;
	picPanel jp = new picPanel();
	
	public PuzzlePiece(BufferedImage pic, int i[]){
		jp.setSize(80, 80);
		this.pic = pic;
		originalPos = i;
		currentPos = i;
	}
	
	public Image getPic() {
		return pic;
	}
	
	public void setCurrentPos(int pos[]) {
		currentPos = pos;
	}
	public int[] getCurrentPos() {
		return currentPos;
	}
	public picPanel getPanel() {
		return jp;
	}
	
	public void updateLock() {
		if (originalPos[0] == currentPos[0] && originalPos[1] == currentPos[1]) {
			lock = true;
		}
	}
	
	class picPanel extends JPanel{
		public void paintComponent(Graphics g) {
			g.drawImage(pic, 0, 0, this);
		}
	}

}
