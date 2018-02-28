import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class myframe extends JFrame
{
	//菜单栏
	//JFrame f = new JFrame("my window");
	JMenuBar mbar = new JMenuBar();
	JMenu mfile = new JMenu("File");
	JMenu medit = new JMenu("Edit");
	JMenuItem[] file = {new JMenuItem("open"),
						new JMenuItem("exit"),
						new JMenuItem("paint"),
						new JMenuItem("clear")};
						
	JTextArea ta = new JTextArea(20,60);//绘图区
	//显示图片名称
	JLabel label = new JLabel("image name：");
	JTextField tf = new JTextField(20);
	//paint
	String[] items = {"Oval","Rectangle","Triangle"};
	JComboBox choice = new JComboBox(items);//选择
	
	JPanel p1 = new JPanel(new FlowLayout());
	ButtonGroup meals=new ButtonGroup();
	JCheckBox cb1 = new JCheckBox("red");//JRadioButton
	JCheckBox cb2 = new JCheckBox("yellow");
	JCheckBox cb3 = new JCheckBox("green");
	FileDialog openDia = new FileDialog(this,"my open",FileDialog.LOAD);
	myframe()
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
		//fdlg.setVisible(true);
		//ig = getToolkit().getImage(fdlg.getDirectory() + fdlg.getFile() );
		ta.setEnabled(false);
		add(ta);//textarea
		
		p1.add(label);
		p1.add(tf);//textfield		
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
	public void actionPerformed(ActionEvent evt)
	{
		openDia.setVisible(true);  
        String dirPath = openDia.getDirectory();//获取文件路径  
        String fileName = openDia.getFile();//获取文件名称  
		File f;
	}
    public static void main(String[] args)
   {
		//创建一个窗口的对象
		new myframe();
    }
}









protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imag,0,0,600,420,null);
    }