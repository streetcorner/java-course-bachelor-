import java.awt.image.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.Graphics;

public class myframe extends JFrame implements ActionListener
{
	//JFrame f=new JFrame("My Frame");
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
	//��ʾͼƬ����
	JLabel label = new JLabel("image name��");
	JTextArea ta = new JTextArea(1,12);//��ʾͼƬ��	
	String[] items = {"Oval","Rectangle","Triangle"};
	JComboBox choice = new JComboBox(items);//ѡ��
	JPanel p1 = new JPanel(new FlowLayout());
	JPanel p2 = new JPanel();
	ButtonGroup meals=new ButtonGroup();//����
	JCheckBox cb1 = new JCheckBox("red");//JRadioButton
	JCheckBox cb2 = new JCheckBox("yellow");
	JCheckBox cb3 = new JCheckBox("green");	
	//boolean imageflag= false,paintflag = false,shapeflag = false;
	
	public myframe()
   {	
		this.setTitle("My Frame");
		this.setSize(700,500);//���ô��ڴ�С		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
		this.setLayout(new BorderLayout());	//������	
		this.setJMenuBar(mbar);
		
		mbar.add(mfile);
		mbar.add(medit);
		mfile.add(file[0]);
		mfile.add(file[1]);
		medit.add(file[2]);
		medit.add(file[3]);			
		
		///lb.setSize(40,50);
		p2.add(lb);//��ʾͼƬ����
		p1.add(label);
		p1.add(ta);//textarea	
			//ta.setText("");//����ı�
		p1.add(choice);
		///choice.addActionListener(this);
		meals.add(cb1);
		meals.add(cb2);
		meals.add(cb3);	
		p1.add(cb1);
		p1.add(cb2);
		p1.add(cb3);
		this.add(p1,"South");
		this.add(p1,"Centre");
		
		//����ؼ�������
		for(int i = 0; i < 3 ; i++)
		{
			file[i].addActionListener(this);
		}	
		this.setVisible(true);//��ʾ����
		///validate();		
	}
	public void actionPerformed(ActionEvent evt)
	{
		//FileDialog openDlg = new FileDialog(f,"my open",FileDialog.LOAD);
		Object source = evt.getSource();//ȡ���¼�Դ
		
		//��GIFͼ
		if (source == file[0]) //open
		{		
			///imageflag = true;
			JFileChooser chooser = new JFileChooser();//�ļ��Ի���
			chooser.setCurrentDirectory(new File("."));
			chooser.setFileFilter(new javax.swing.filechooser.FileFilter() //����.gif�ļ�
			{
				public boolean accept(File f)
				{
				
					return (f.getName().endsWith(".gif") || f.isDirectory());//Ϊ.gif��Ϊ�ļ���
				}
				public String getDescription()
				{
					return "GIF Images";
				}
			});
			chooser.setMultiSelectionEnabled(true);//����ѡ�����ļ�
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//��������ѡ���ļ���·��
			int r = chooser.showOpenDialog(this); //�����Ի���
			if(r == JFileChooser.APPROVE_OPTION) //��Ϊ.gif
			{	
				String path = chooser.getSelectedFile().getAbsolutePath();
				String name = chooser.getSelectedFile().getName();
				lb.setIcon(new ImageIcon(path));
				ta.setText(name);
			}
		}			
		else if(source == file[1])//exit
		System.exit(0);
		
		//��ͼ
		else if (source == file[2])//paint
		{
			paintflag= true;
			 //if (evt.getSource() == choice) {
			 //shapeflag = true;}
		}
		//else if(source == file[2])
		//{this.repaint();}
	}

	
	public static void main(String []args)
	{
		new myframe();
	}
}