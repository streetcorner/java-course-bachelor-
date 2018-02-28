class Book //����
{
	//����
	protected String bname; //����
	protected int price; //����

	//���췽��
	public Book(String p1,int p2){ 
	this.bname = p1;
	this.price = p2;}
	
	//��Ա����
	public String getName(){//��ȡ����
		return bname;
	}
	public int getPrice(){ //��ȡ�۸�
		return price;
	}
}// class Book


class BookCard{
	//����
	protected int rno; //���ߺ�        
	protected String rname; //������
	protected  Book[] books; //�ڽ�ͼ�飨���10����

	//���췽��
	public BookCard(int p1,String p2,Book[] p3){ 
	this.rno = p1;
	this.rname = p2;
	this.books = p3;}
	
	//��Ա�������˸���
	public int getRno(){ //��ȡ���ߺ�
		return rno;
	}
	public String getRname(){ //��ȡ������
		return rname;
	}
	public int bnum(){
		return books.length;
	}
	public boolean borrow(Book b){  //�ж��Ƿ��ܹ�����,���10��
		int len = this.books.length;
		if (len<10)
		{
			//books[len] = b;
			return true;
		}
		else 
			{return false;}
	}	
	public boolean returnBook(String s) //�ж���s�Ƿ��ܻ�(sΪ����)
	{
		int len = this.books.length;
		for(int i = 0; i < len;i++)
		{
			if (s.equals(this.books[i].getName()))//�ж�s���Ƿ����ڽ�������
			{
				return true;
			}	
		}
		return false;
	}	
	public void printBooks()//���ͼ���嵥
	{
		int len = this.books.length;
		for(int i = 0; i < len ;i++)
		{
			System.out.println(this.books[i].getName());
		}
	}
	public int expensive(int p)//ͳ�Ƴ��ڽ�ͼ���ж��۸��ڲ���p��ͼ�����
	{ 	
		int num = 0;
		int len = this.books.length;
		for(int i = 0; i < len;i++)
		{
			if (this.books[i].getPrice()>p)
			num++;
		}
		return num;
	}
	public String[] search(String s)//�ҳ��ڽ�ͼ�������а���s�ؼ��ֵ�ͼ��
	{	
		int  n = 0;
		String[] search = new String[3];
		int len = this.books.length;
		for(int i = 0; i< len;i++)
		{
			String bkname = this.books[i].getName();
			if (bkname.indexOf(s) != -1)
			{
				search[n] =bkname;
				n++;
			}
		}
		return search;
	}
}//class BookCard

public class d{
	public static void main(String[] args){
		Book b1 = new Book("������Ļ�����",23);
		Book b2 = new Book("���ݿ�����������",32);
		Book b3 = new Book("Java�������������",40);
		Book b4 = new Book("�ִ�����ϵͳ",34);
		Book b5 = new Book("��������ԭ��",28);
		
		Book[] books={b1,b2,b3,b5};	
		
		BookCard b = new BookCard (980001,"��ɽ",books);	
		int price = 30;
		
		//b.printBooks(); 		
		System.out.println("���ߵı��Ϊ�� "+b.getRno());
		System.out.println("\n");
		System.out.println("���ߵ�����Ϊ�� "+b.getRname());
		System.out.println("\n");
		System.out.println("�ڽ�ͼ����Ϊ�� "+b.bnum());
		System.out.println("\n");
		System.out.println("ͼ��"+b1.getName()+"�Ƿ��ܽ裺"+b.borrow(b1));
		System.out.println("\n");
		System.out.println("ͼ��"+b1.getName()+"�Ƿ��ܻ���"+b.returnBook("������Ļ�����"));
		System.out.println("\n");
		System.out.println("�ڽ�ͼ���嵥Ϊ��");
		b.printBooks();
		System.out.println("\n");
		System.out.println("���۸���"+ price +"��ͼ��ı���Ϊ�� " + b.expensive(price));
		System.out.println("\n");
		System.out.println("�ڽ�ͼ���嵥Ϊ��");
		int len = b.search("�����").length;
		for(int i = 0; i < len ; i++){
			System.out.println(b.search("�����")[i]);
		}
	}
}