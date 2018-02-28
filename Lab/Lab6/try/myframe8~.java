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
	JComboBox cb = new JComboBox();
	
	JPanel p1 = new JPanel(new FlowLayout());
	JPanel p2 = new JPanel();
	ButtonGroup meals=new ButtonGroup();
	JCheckBox cb1 = new JCheckBox("red");//����Ҫ���ü�����
	JCheckBox cb2 = new JCheckBox("yellow");
	JCheckBox cb3 = new JCheckBox("green");	
	boolean shapeflag= false;//�Ƿ�ѡ����ͼ��
	boolean unclear = true;
	public myframe()
   {	
		this.setTitle("My Frame");
		this.setSize(700,500);//���ô��ڴ�С
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���
		this.setLayout(new BorderLayout());	//������	
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
		p2.add(lb);//��ʾͼƬ����		
		p1.add(label);
		p1.add(ta);//textfield	
			//ta.setText("");//����ı�
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
		this.setVisible(true);//��ʾ����
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
		if (evt.getSource() == choice) {//ѡ�񼸺�ͼ��
			cb = (JComboBox)evt.getSource();//���ѡ���¼�Դ
			shapeflag = true;
			//String str = (String)cb.getSelectedItem();
			//ta.setText(str);
		}
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
			//shapeflag = false;//���²��ܻ�ͼ
		}
		else if(source == file[3]){//clear 
			ta.setText("");//����ı���
			//clearRect(0, 0, 700,500); �������һ��ͼ�Ρ���
			unclear = false;
			repaint();
		}
	}
	public void paint(Graphics g){  
		super.paint(g);//�ȵ���
		if(unclear){
		if(cb1.isSelected()){g.setColor(Color.red); }//��
		if(cb2.isSelected()){g.setColor(Color.yellow); }//��
		if(cb3.isSelected()){g.setColor(Color.green); }//��
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
	}
	
	public static void main(String[] args)
   {
		//����һ�����ڵĶ���
		new myframe();
		
	}
}
