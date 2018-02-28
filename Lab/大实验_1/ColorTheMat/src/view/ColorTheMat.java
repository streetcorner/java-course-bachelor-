package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

import model.Board;
import model.ColorType;

class TimeThread implements Runnable {
	JFrame f;
	
	TimeThread(JFrame ff) {
		f = ff;
	}
	
	public void run() {
		while(true) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			f.setTitle("Color The Matrix --- " + df.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class GameBoard extends JFrame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		
		if(source == start[0]) {
			bd.initGame();
			repaint();
		} else if(source == start[1]) {
			//TODO
			//save current game
			JFileChooser fc = new JFileChooser();
			fc.showSaveDialog(this);
			String filename = fc.getSelectedFile().toString();
			FileOutputStream output = null;
			if(!filename.endsWith(".ctm")) {
				filename += ".ctm";
			}
			try {
				output = new FileOutputStream(filename);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				output.write(Board.getctrl().save());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				output.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showInternalMessageDialog(
					this.getContentPane(),
					"Save success",  
					"Save", c
					JOptionPane.INFORMATION_MESSAGE); 
		} else if(source == start[2]){
			//TODO
			//load a game
			JFileChooser fc = new JFileChooser();
			int rt = fc.showOpenDialog(null);
			String filename = fc.getSelectedFile().toString();
			
			if(rt == JFileChooser.APPROVE_OPTION) {
				if(!filename.endsWith(".ctm")) {

					JOptionPane.showInternalMessageDialog(
							this.getContentPane(), 
							"Invalid file", 
							"Error", 
							JOptionPane.INFORMATION_MESSAGE); 
				}
				FileInputStream input = null;
				try {
					input = new FileInputStream(filename);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				byte[] bt = new byte[262];
				try {
					input.read(bt, 0, 262);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(bd.getctrl().load(bt)) {

					JOptionPane.showInternalMessageDialog(
							this.getContentPane(), 
							"Load success", 
							"Load", 
							JOptionPane.INFORMATION_MESSAGE); 
				}
			}
		}
		
		if(source == bta[0]) {
			System.out.println("hit button1");
			bd.move(0);
			//repaint();
		} else if(source == bta[1]) {
			bd.move(1);
			//repaint();
		} else if(source == bta[2]) {

			bd.move(2);
			//repaint();
		} else if(source == bta[3]) {

			bd.move(3);
			//repaint();
		} else if(source == bta[4]) {

			bd.move(4);
			//repaint();
		} else if(source == bta[5]) {

			bd.move(5);
			//repaint();
		}
		if(bd.iswin()) {
			JOptionPane.showInternalMessageDialog(
					this.getContentPane(), 
					"You win the game!", 
					"Win", 
					JOptionPane.INFORMATION_MESSAGE); 
			bd.initGame();
			
		}
		if(bd.getStep() == 0) {
			ls.setText("Move left:" + 0);
			JOptionPane.showMessageDialog(
					null,
					"You lose...",
					"Lose",
					JOptionPane.ERROR_MESSAGE);   
			bd.initGame();
		}
		ls.setText("Move left:" + bd.getStep());
		repaint();
	}
	

	JMenuBar mbar = new JMenuBar();
	JMenu mstart = new JMenu("start");
	JMenuItem[] start = {new JMenuItem("new game"),
			new JMenuItem("save"),
			new JMenuItem("load")
	};

	JButton[] bta = new JButton[6];
	//Container contentPane = getContentPane();
	Board bd = Board.getctrl();
	JLabel ls = new JLabel();
	
	public GameBoard() {
		
		this.setJMenuBar(mbar);
		this.setTitle("Color The Matrix");
		this.setSize(600, 480);
		
		mbar.add(mstart);
		for(int i = 0; i < 3; i++) {
			mstart.add(start[i]);
		}
		for(int i = 0; i < 6; i++) {
			bta[i] = new JButton("aaa");
			bta[i].setText("aaa");
			bta[i].addActionListener(this);
		}
		
		bta[0].setForeground(ColorType.A.rgb);
		bta[1].setForeground(ColorType.B.rgb);
		bta[2].setForeground(ColorType.C.rgb);
		bta[3].setForeground(ColorType.D.rgb);
		bta[4].setForeground(ColorType.E.rgb);
		bta[5].setForeground(ColorType.F.rgb);
	
		JPanel btp = new JPanel(new GridLayout(7, 1));
		
		
		ls.setText("Move left:" + 29);
		btp.add(ls);
		for(int i = 0; i < 6; i++) {
			btp.add(bta[i]);
		}
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.WEST, btp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		for(int i = 0; i < 3; i++) {
			start[i].addActionListener(this);
		}
		bd.initGame();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		//g.clearRect(120, 50, 600, 600);
		int sx = 120;
		int sy = 50;
		int x = 28;
		int y = 28;
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				g.setColor(bd.getRGB(i, j));
				g.fillRect(sx + i * x, sy + j * y, x, y);
			}
		}
	}
	
}

public class ColorTheMat {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		GameBoard gb = new GameBoard();
		TimeThread uptime = new TimeThread(gb);
		uptime.run();
	}


}
