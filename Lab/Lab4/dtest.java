import java.util.Scanner;
class Book //书类
{
	//属性
	protected String bname; //书名
	protected int price; //定价

	//构造方法
	public Book(String p1,int p2){ 
	this.bname = p1;
	this.price = p2;}
	
	//成员方法
	public String getName(){//获取书名
		return bname;}
	public int getPrice(){ //获取价格
		return price;}
}// class Book

class BookCard{
	//属性
	protected int rno; //读者号        
	protected String rname; //读者名
	protected  Book[] books = NULL; //在借图书（最多10本）

	//构造方法
	public BookCard(int p1,String p2,Book[] p3){ 
	this.rno = p1;
	this.rname = p2;
	this.books = p3;}
	
	//成员方法（八个）
	public int getRno(){ //获取读者号
		return rno;}
	public String getRname(){ //获取读者名
		return rname;}
	}
	public int bnum(){ //获取已借图书数
		return books.length;
	}
	public boolean borrow(Book b){  //判断是否能够借书,最多10本
		int len = this.books.length
		if (len<10)
		{
			books[len] = b.getName();
			return true;
		}
		else 
			{return false;}
	}	
	public boolean returnBook(String s){  //判断书s是否能还(s为书名)
	{
		int len = this.books.length;
		for(int i = 0; i < len;i++)
		{
			if (s.equals(this.books[i].getName()) //判断s书是否在在借数组中
				{return true;}
			else 
				{return false;}
		}
	}	
	public void printBooks(){  //输出 在借书 名单
		int len = this.books.length;
		for(int i = 0; i < len;i++)
		{
			System.out.println(this.books[i].getName()+"\n");
		}
	}
	public int expensive(int p)  //统计出在借图书中定价高于参数p的图书册数
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
	
	public String[] search(String s){ //找出在借图书中所有包括s关键字的图书
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
	Book b1 = new book("计算机文化基础",23);
	Book b2 = new book("数据库与计算机管理",32);
	Book b3 = new book("Java面向对象程序设计",40);
	Book b4 = new book("现代操作系统",34);
	Book b5 = new book("计算机组成原理",28);
	
	Book[] books={b1,b2,b3,b5};
	
	BookCard b = new BookCard (980001,"王山",books);
	
    b.printBooks() ; 
	
	
	
	//System.out.println("判断线段line1是否在第一象限的结果为： "+line1.checkArea());
	
	}
}