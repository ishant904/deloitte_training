package test1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jdbc.DBConnector;

public class Tester {
	
	static List<Book> book=new ArrayList<>();
	static List<Author> author=new ArrayList<>();
	static List<Publisher> publisher=new ArrayList<>();

	public static void main(String[] args) {
		listBookAuthPub();
		// TODO Auto-generated method stub
		//sortByAuthor(book);
		//dispBookAfterYears(book, 2000);
		dispBookInCity(book, "Delhi");

	}
	
	public static void listBookAuthPub() {
		Connection con=new DBConnector("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr").getConnection();
		String sql = "select b.isbn,b.title,b.pages,b.pub_year,b.type,a.name,a.nationality,p.name,p.city from book b inner join author a on b.author_id=a.id inner join publisher p on a.publisher_id=p.id";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				int isbn = rs.getInt(1);
				String title = rs.getString(2);
				int pages = rs.getInt(3);
				int pub_year=rs.getInt(4);
				String type=rs.getString(5);
				String auth_name=rs.getString(6);
				String auth_nation=rs.getString(7);
				String pub_name=rs.getString(8);
				String pub_city=rs.getString(9);
				Publisher p = new Publisher(pub_name,pub_city);
				Author a =new Author(auth_name,auth_nation,p);
				Book b=new Book(isbn,title,pages,pub_year,type,a);
				publisher.add(p);
				author.add(a);
				book.add(b);
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}
	
	public static void sortByAuthor(List<Book> books) {
		Collections.sort(books, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				// TODO Auto-generated method stub
				return o1.getAuth().getName().compareToIgnoreCase(o2.getAuth().getName());
			}
		});
		
		for(Book b:books) {
			System.out.println(b);
		}
	}
	public static void sortByTitle(List<Book> books) {
		Collections.sort(books, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				// TODO Auto-generated method stub
				return o1.getTitle().compareToIgnoreCase(o2.getTitle());
			}
		});
		
		for(Book b:books) {
			System.out.println(b);
		}
	}
	
	public static void dispBookAfterYears(List<Book> books,int year) {
		for(Book b:books) {
			if(b.getPubYear()>year)
				System.out.println(b);
		}
	}
	public static void dispBookInCity(List<Book> books,String city) {
		for(Book b:books) {
			if((b.getType().equals("poem"))&&(b.getAuth().getPub().getCity().equals(city)))
				System.out.println(b);
		}

	}
	

}
