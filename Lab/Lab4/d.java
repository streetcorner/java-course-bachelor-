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
		return bname;
	}
	public int getPrice(){ //获取价格
		return price;
	}
}// class Book


class BookCard{
	//属性
	protected int rno; //读者号        
	protected String rname; //读者名
	protected  Book[] books; //在借图书（最多10本）

	//构造方法
	public BookCard(int p1,String p2,Book[] p3){ 
	this.rno = p1;
	this.rname = p2;
	this.books = p3;}
	
	//成员方法（八个）
	public int getRno(){ //获取读者号
		return rno;
	}
	public String getRname(){ //获取读者名
		return rname;
	}
	public int bnum(){
		return books.length;
	}
	public boolean borrow(Book b){  //判断是否能够借书,最多10本
		int len = this.books.length;
		if (len<10)
		{
			//books[len] = b;
			return true;
		}
		else 
			{return false;}
	}	
	public boolean returnBook(String s) //判断书s是否能还(s为书名)
	{
		int len = this.books.length;
		for(int i = 0; i < len;i++)
		{
			if (s.equals(this.books[i].getName()))//判断s书是否在在借数组中
			{
				return true;
			}	
		}
		return false;
	}	
	public void printBooks()//输出图书清单
	{
		int len = this.books.length;
		for(int i = 0; i < len ;i++)
		{
			System.out.println(this.books[i].getName());
		}
	}
	public int expensive(int p)//统计出在借图书中定价高于参数p的图书册数
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
	public String[] search(String s)//找出在借图书中所有包括s关键字的图书
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
		Book b1 = new Book("计算机文化基础",23);
		Book b2 = new Book("数据库与计算机管理",32);
		Book b3 = new Book("Java面向对象程序设计",40);
		Book b4 = new Book("现代操作系统",34);
		Book b5 = new Book("计算机组成原理",28);
		
		Book[] books={b1,b2,b3,b5};	
		
		BookCard b = new BookCard (980001,"王山",books);	
		int price = 30;
		
		//b.printBooks(); 		
		System.out.println("读者的编号为： "+b.getRno());
		System.out.println("\n");
		System.out.println("读者的姓名为： "+b.getRname());
		System.out.println("\n");
		System.out.println("在借图书数为： "+b.bnum());
		System.out.println("\n");
		System.out.println("图书"+b1.getName()+"是否能借："+b.borrow(b1));
		System.out.println("\n");
		System.out.println("图书"+b1.getName()+"是否能还："+b.returnBook("计算机文化基础"));
		System.out.println("\n");
		System.out.println("在借图书清单为：");
		b.printBooks();
		System.out.println("\n");
		System.out.println("定价高于"+ price +"的图书的本数为： " + b.expensive(price));
		System.out.println("\n");
		System.out.println("在借图书清单为：");
		int len = b.search("计算机").length;
		for(int i = 0; i < len ; i++){
			System.out.println(b.search("计算机")[i]);
		}
	}
}