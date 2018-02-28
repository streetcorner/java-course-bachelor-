package model;

import java.awt.Color;
import java.io.Console;
import java.util.Date;
import java.util.Random;

public class Board {
	ColorType [] content = {
			ColorType.A, 
			ColorType.B, 
			ColorType.C, 
			ColorType.D, 
			ColorType.E, 
			ColorType.F
	};
	int [][] mat;
	private int step;
	Random rd;
	
	public Color getRGB(int x, int y) {
		return content[mat[x][y]].rgb;
	}
	
	public Boolean initGame() {
		setStep(29);
		mat = new int[15][15];
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				mat[i][j] = rd.nextInt(6);
			}
		}
		System.out.println("Initialize success.");
		return true;
	}
	
	private final int[] dx = {1, 0, -1, 0};
	private final int[] dy = {0, -1, 0, 1};
	
	void dfs(int x, int y, int cur, int tp) {
		mat[x][y] = tp;
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < 15 && ny >= 0 && ny < 15) {
				if(mat[nx][ny] == cur) dfs(nx, ny, cur, tp);
			}
		}
	}
	
	public Boolean move(int tp) {
		if(tp == mat[0][0]) return false;
		dfs(0, 0, mat[0][0], tp);
		setStep(getStep() - 1);
		return true;
	}
	
	public Boolean iswin() {
		if(mat == null) return false;
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				if(i > 0 && mat[i][j] != mat[i - 1][j]) return false;
				if(j > 0 && mat[i][j] != mat[i][j - 1]) return false;
			}
		}
		return true;
	}
	
	//唯一实例
	private Board() {};
	
	static Board b;
	public static Board getctrl() {
		if(b == null) {
			b = new Board();
			b.rd = new Random((new Date()).getTime());
		}
		return b;
	}

	public byte[] save() {
		byte[] ret = new byte[262];
		
		//for(int i = 0; i < 262; i++) ret[i] = byte();
		//magic, check validate
		System.out.println("done1");
		ret[0] = (byte)3;
		ret[1] = (byte)2;
		ret[2] = (byte)7;
		ret[3] = (byte)9;
		ret[4] = (byte)0;

		System.out.println("done2");
		ret[5] = (byte)step;
		for(int i = 0; i < 225; i++) {
			ret[i + 6] = (byte)mat[i / 15][i % 15];
 		}
		System.out.println("done3");
		return ret;
	}
	
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public boolean load(byte[] bt) {
		// TODO Auto-generated method stub
		if(bt[0] != 3) return false;
		if(bt[1] != 2) return false;
		if(bt[2] != 7) return false;
		if(bt[3] != 9) return false;
		if(bt[4] != 0) return false;
		step = bt[5];
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				mat[i][j] = bt[i * 15 + j + 6];
			}
		}
		return true;
	}
}
