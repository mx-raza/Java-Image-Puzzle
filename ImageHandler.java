import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageHandler {
	
	FileChooser fc = new FileChooser();
	String path = fc.getPath();
	BufferedImage original;
	BufferedImage resized;
	BufferedImage crop;
	CurrentPanel currP = new CurrentPanel();
	OriginalPanel oriP = new OriginalPanel();
	PuzzlePiece[][] pieces = new PuzzlePiece[10][10];
	PuzzlePiece[][] originals = new PuzzlePiece[10][10];
	
	public ImageHandler() {
		try {
            original = ImageIO.read(new File(path));;
            resized = resizeImage(original,800,800,BufferedImage.TYPE_INT_ARGB);
            
            for(int i=0; i<10; i++) {
            	for(int j=0; j<10; j++) {
            		crop = resized.getSubimage(i*80, j*80, 80, 80);
            		int pos[] = {i,j};
            		pieces[i][j] = new PuzzlePiece(crop,pos);
            		originals[i][j] = new PuzzlePiece(crop,pos);
            	}
            }
            
            
        } catch (IOException ex) {
            System.out.println("Cannot Resize Image!");
        }
	}
	
	
	
	private BufferedImage resizeImage(BufferedImage originalImage, int width,
            int height, int type) throws IOException {

        BufferedImage resizedImage = new BufferedImage(width, height, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, width, height, null);
        g.dispose();

        return resizedImage;
    }
	
	class CurrentPanel extends JPanel{
		public void paintComponent(Graphics g) {
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					g.drawImage(pieces[i][j].getPic(),i*80,j*80,this);
				}
			}
		}
	}
	class OriginalPanel extends JPanel{
		public void paintComponent(Graphics g) {
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) {
					g.drawImage(originals[i][j].getPic(),i*80,j*80,this);
				}
			}
		}
	}
	

	
	public Image getResized() {
		return resized;
	}
	
	public void shuffle() {
		 for(int i = 0; i<10; i++) {
			 for(int j=0; j<10; j++) {
				 int x = (int)(Math.random()*(10));
				 int y = (int)(Math.random()*(10));
				 int x2 = (int)(Math.random()*(10));
				 int y2 = (int)(Math.random()*(10));
				 
				 PuzzlePiece temp = pieces[x][y];
				 pieces[x][y] = pieces[x2][y2];
				 pieces[x][y].setCurrentPos(pieces[x2][y2].getCurrentPos());
				 pieces[x2][y2] = temp;
				 pieces[x2][y2].setCurrentPos(temp.getCurrentPos());
			 }
		 }
	}
	
	public OriginalPanel getOriginal(){
		return oriP;
	}
	
	public CurrentPanel getPanel() {
		return currP;
	}

}
