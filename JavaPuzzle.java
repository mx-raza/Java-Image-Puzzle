import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class JavaPuzzle {
	
	ImageHandler ih = new ImageHandler();
	JFrame jf = new JFrame();
	JPanel jpi;
	JPanel jp = new JPanel();
	JPanel jpb = new JPanel();
	JTextArea jt = new JTextArea(10,8);
	JButton jbLoad = new JButton("Load Another Image");
	JButton jbShow = new JButton("Show Original Image");
	JButton jbExit = new JButton("Exit");

	private void Load() {
		try{
			ImageHandler newih = new ImageHandler();
			ih = newih;
			ih.shuffle();
			jpi = ih.getPanel();
			jf.getContentPane().add(BorderLayout.CENTER,jpi);
			jf.setVisible(true);
		}catch(Exception e) {
		}
	}
	
	private void Show() {
		jpi = ih.getOriginal();
		jf.getContentPane().add(BorderLayout.CENTER,jpi);
		jf.setVisible(true);
	}
	
	private void go() {
		
		ih.shuffle();
		jpi = ih.getPanel();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(820,1050);
		
		JScrollPane scroller = new JScrollPane(jt);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		BoxLayout boxlayout = new BoxLayout(jp,BoxLayout.Y_AXIS);
		
		jp.setLayout(boxlayout);
		jpb.add(jbLoad);
		jbLoad.addActionListener(new LoadListener());
		jbShow.addActionListener(new ShowListener());
		jbExit.addActionListener(new ExitListener());
		jpb.add(jbShow);
		jpb.add(jbExit);
		jt.setSize(800,100);
		jp.add(scroller);
		jp.setSize(800, 200);
		jp.add(jpb);
		jpi.addMouseListener(new DraggerListener());
		jf.getContentPane().add(BorderLayout.CENTER,jpi);
		jf.getContentPane().add(BorderLayout.SOUTH,jp);
		jf.setVisible(true);
	}
	class DraggerListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("clicked");
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class LoadListener implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			Load();
		}
	}
	class ShowListener implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			Show();
		}
	}
	class ExitListener implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			jf.dispose();
		}
	}

	
	public static void main(String[] args) {
		JavaPuzzle tp = new JavaPuzzle();
		tp.go();
	
	}
	
}