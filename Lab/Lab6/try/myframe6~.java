import java.awt.image.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.Graphics;
public class myframe extends JFrame implements ActionListener
{
	//�˵���
	JMenuBar mbar = new JMenuBar();
	JMenu mfile = new JMenu("File");
	JMenu medit = new JMenu("Edit");
	JMenuItem[] file = {new JMenuItem("open"),
						new JMenuItem("exit"),
						new JMenuItem("paint"),
						new JMenuItem("clear")
	};
	Container contentPane = getContentPane();//��ͼ��
	
	JLabel lb = new JLabel();
	//JTextArea ta = new JTextArea(20,60);//��ͼ��
	//��ʾͼƬ����
	JLabel label = new JLabel("image name��");
	JTextArea ta = new JTextArea(1,12);
	//paint
	String[] items = {"Oval","Rectangle","Triangle"};
	JComboBox choice = new JComboBox(items);//ѡ��
	
	JPanel p1 = new JPanel(new FlowLayout());
	ButtonGroup meals=new ButtonGroup();
	JCheckBox cb1 = new JCheckBox("red");//JRadioButton
	JCheckBox cb2 = new JCheckBox("yellow");
	JCheckBox cb3 = new JCheckBox("green");	
	
	public myframe()
   {	
		this.setTitle("My Frame");
		this.setSize(700,500);//���ô��ڴ�С
		this.setVisible(true);//��ʾ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
		this.setLayout(new BorderLayout());	//������	
		this.setJMenuBar(mbar);
		
		mbar.add(mfile);
		mbar.add(medit);
		mfile.add(file[0]);
		mfile.add(file[1]);
		medit.add(file[2]);
		medit.add(file[3]);	
		//ig = getToolkit().getImage(fdlg.getDirectory() + fdlg.getFile() );
		
		contentPane.add(label,"Center");
		add(lb);//��ʾͼƬ����
		
		p1.add(label);
		p1.add(ta);//textfield	
			//ta.setText("");//����ı�
		p1.add(choice);
		meals.add(cb1);
		meals.add(cb2);
		meals.add(cb3);	
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		this.add(p1,"South");
		//����ؼ�������
		for(int i = 0; i < 3 ; i++)
		{
			file[i].addActionListener(this);
		}		
		  
	}
	//��GIFͼ
	public void actionPerformed(ActionEvent evt)
	{
		//FileDialog openDlg = new FileDialog(f,"my open",FileDialog.LOAD);
		Object source = evt.getSource();//ȡ���¼�Դ
		if (source == file[0]) //open
		{			
			JFileChooser chooser = new JFileChooser();//�ļ��Ի���
			//chooser.getCurrentDirectory(); //��ȡ·��
			chooser.setCurrentDirectory(new File("."));
			chooser.setFileFilter(new javax.swing.filechooser.FileFilter() //����.gif�ļ�
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
			int r = chooser.showOpenDialog(this); //��ʾ�Ի���
			if(r == JFileChooser.APPROVE_OPTION) //��Ϊ.gif
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
		//����һ�����ڵĶ���
		new myframe();
	}
}
