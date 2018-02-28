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
	
	JPanel p1 = new JPanel(new FlowLayout());
	ButtonGroup meals=new ButtonGroup();
	JCheckBox cb1 = new JCheckBox("red");//JRadioButton
	JCheckBox cb2 = new JCheckBox("yellow");
	JCheckBox cb3 = new JCheckBox("green");	
	
	public myframe()
   {	
		this.setTitle("My Frame");
		this.setSize(700,500);//设置窗口大小
		this.setVisible(true);//显示窗口
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口
		this.setLayout(new BorderLayout());	//流布局	
		this.setJMenuBar(mbar);
		
		mbar.add(mfile);
		mbar.add(medit);
		mfile.add(file[0]);
		mfile.add(file[1]);
		medit.add(file[2]);
		medit.add(file[3]);	
		//ig = getToolkit().getImage(fdlg.getDirectory() + fdlg.getFile() );
		
		contentPane.add(label,"Center");
		add(lb);//显示图片区域
		
		p1.add(label);
		p1.add(ta);//textfield	
			//ta.setText("");//清空文本
		p1.add(choice);
		meals.add(cb1);
		meals.add(cb2);
		meals.add(cb3);	
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		this.add(p1,"South");
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
				String name = chooser.getSelectedFile().getAbsolutePath();
				lb.setIcon(new ImageIcon(name));
				//ig = getToolkit().getImage(name);
			}
			
		}	
		else if(source == file[1])//exit
		System.exit(0);
	}
	public static void main(String[] args)
   {
		//创建一个窗口的对象
		new myframe();
	}
}
