import java.util.Scanner;
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
		return bname;}
	public int getPrice(){ //��ȡ�۸�
		return price;}
}// class Book

class BookCard{
	//����
	protected int rno; //���ߺ�        
	protected String rname; //������
	protected  Book[] books = NULL; //�ڽ�ͼ�飨���10����

	//���췽��
	public BookCard(int p1,String p2,Book[] p3){ 
	this.rno = p1;
	this.rname = p2;
	this.books = p3;}
	
	//��Ա�������˸���
	public int getRno(){ //��ȡ���ߺ�
		return rno;}
	public String getRname(){ //��ȡ������
		return rname;}
	}
	public int bnum(){ //��ȡ�ѽ�ͼ����
		return books.length;
	}
	public boolean borrow(Book b){  //�ж��Ƿ��ܹ�����,���10��
		int len = this.books.length
		if (len<10)
		{
			books[len] = b.getName();
			return true;
		}
		else 
			{return false;}
	}	
	public boolean returnBook(String s){  //�ж���s�Ƿ��ܻ�(sΪ����)
	{
		int len = this.books.length;
		for(int i = 0; i < len;i++)
		{
			if (s.equals(this.books[i].getName()) //�ж�s���Ƿ����ڽ�������
				{return true;}
			else 
				{return false;}
		}
	}	
	public void printBooks(){  //��� �ڽ��� ����
		int len = this.books.length;
		for(int i = 0; i < len;i++)
		{
			System.out.println(this.books[i].getName()+"\n");
		}
	}
	public int expensive(int p)  //ͳ�Ƴ��ڽ�ͼ���ж��۸��ڲ���p��ͼ�����
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
	
	public String[] search(String s){ //�ҳ��ڽ�ͼ�������а���s�ؼ��ֵ�ͼ��
	{
		int  n = 0;
		String[] search;
		int len = this.books.length;
		for(int i = 0; i< len;i++)
		{
			if (this.books[i].getName().indexof(s))
			{
				search[n] = this.books[i].getName();
				n++;
			}
		}
		return search;
	}
}//class BookCard

public class d{
	public static void main(String[] args){
	Book b1 = new book("������Ļ�����",23);
	Book b2 = new book("���ݿ�����������",32);
	Book b3 = new book("Java�������������",40);
	Book b4 = new book("�ִ�����ϵͳ",34);
	Book b5 = new book("��������ԭ��",28);
	
	Book[] books={b1,b2,b3,b5};
	
	BookCard b = new BookCard (980001,"��ɽ",books);
	
    b.printBooks() ; 
	
	
	
	//System.out.println("�ж��߶�line1�Ƿ��ڵ�һ���޵Ľ��Ϊ�� "+line1.checkArea());
	
	}
}