import java.awt.image.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.Graphics;
public class myframe extends JFrame implements ActionListener
{
	//菜单栏
	JMenuBar mbar = new JMenuBar();
	JMenu mfile = new JMenu("File");
	JMenu medit = new JMenu("Edit");
	JMenuItem[] file = {new JMenuItem("open"),
						new JMenuItem("exit"),
						new JMenuItem("paint"),
						new JMenuItem("clear")
	};
	Container contentPane = getContentPane();//绘图区
	
	JLabel lb = new JLabel();
	//JTextArea ta = new JTextArea(20,60);//绘图区
	//显示图片名称
	JLabel label = new JLabel("image name：");
	JTextArea ta = new JTextArea(1,12);
	//paint
	String[] items = {"Oval","Rectangle","Triangle"};
	JComboBox choice = new JComboBox(items);//选择
	JComboBox cb = new JComboBox();
	
	JPanel p1 = new JPanel(new FlowLayout());
	JPanel p2 = new JPanel();
	ButtonGroup meals=new ButtonGroup();
	JCheckBox cb1 = new JCheckBox("red");//不需要设置监听者
	JCheckBox cb2 = new JCheckBox("yellow");
	JCheckBox cb3 = new JCheckBox("green");	
	boolean shapeflag= false;//是否选择了图形
	public myframe()
   {	
		this.setTitle("My Frame");
		this.setSize(700,500);//设置窗口大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
		this.setLayout(new BorderLayout());	//流布局	
		this.setJMenuBar(mbar);
		ta.setEditable(false);
		
		mbar.add(mfile);
		mbar.add(medit);
		mfile.add(file[0]);
		mfile.add(file[1]);
		medit.add(file[2]);
		medit.add(file[3]);	
		//ig = getToolkit().getImage(fdlg.getDirectory() + fdlg.getFile() );
		
		contentPane.add(lb,"Center");
		p2.add(lb);//显示图片区域		
		p1.add(label);
		p1.add(ta);//textfield	
			//ta.setText("");//清空文本
		p1.add(choice);
		choice.addActionListener(this);
		meals.add(cb1);
		meals.add(cb2);
		meals.add(cb3);	
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		this.add(p2,"Center");
		this.add(p1,"South");
		//pack();
		this.setVisible(true);//显示窗口
		//加入控件监听者
		for(int i = 0; i < 3 ; i++)
		{
			file[i].addActionListener(this);
		}			  
		
	}
	//打开GIF图
	public void actionPerformed(ActionEvent evt)
	{
		//FileDialog openDlg = new FileDialog(f,"my open",FileDialog.LOAD);
		Object source = evt.getSource();//取得事件源
		if (evt.getSource() == choice) {//选择几何图形
			cb = (JComboBox)evt.getSource();//获得选择事件源
			shapeflag = true;
			String str = (String)cb.getSelectedItem();
			ta.setText(str);
		}
		if (source == file[0]) //open
		{			
			JFileChooser chooser = new JFileChooser();//文件对话框
			//chooser.getCurrentDirectory(); //获取路径
			chooser.setCurrentDirectory(new File("."));
			chooser.setFileFilter(new javax.swing.filechooser.FileFilter() //过滤.gif文件
			{
				public boolean accept(File f)
				{
					return (f.getName().endsWith(".gif") || f.isDirectory());
				}
				public String getDescription()
				{
					return "GIF Images";
				}
			});
			int r = chooser.showOpenDialog(this); //显示对话框
			if(r == JFileChooser.APPROVE_OPTION) //若为.gif
			{
				String path = chooser.getSelectedFile().getAbsolutePath();
				String name = chooser.getSelectedFile().getName();
				lb.setIcon(new ImageIcon(path));
				ta.setText(name);
			}
		}	
		else if(source == file[1])//exit
		System.exit(0);
		else if(source == file[2]){//paint
			repaint();
			//shapeflag = false;
		}
		else if(source == file[3]){//clear 
			ta.setText("");//清空文本框
		}
	}
	public void paint(Graphics g){  
		super.paint(g);//先调用
		if(cb1.isSelected()){g.setColor(Color.red); }//红
		if(cb2.isSelected()){g.setColor(Color.yellow); }//黄
		if(cb3.isSelected()){g.setColor(Color.green); }//绿
		if(shapeflag)
		{
			int index = cb.getSelectedIndex();//"Oval","Rectangle","Triangle"
			if(index == 0){
					g.fillOval(220,180,300,150);
				}	
			else if(index == 1){
					g.fillRect(220,180,300,150);
				}	
			else if(index == 2){
					int x1[] = {350,200,500};
					int x2[] = {100,350,350};
					g.fillPolygon(x1,x2,3);
			}
		}//shapeflag
	}
	
	public static void main(String[] args)
   {
		//创建一个窗口的对象
		new myframe();
	}
}
