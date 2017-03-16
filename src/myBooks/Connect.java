package myBooks;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Connect {
    public Statement stmt;
    private String user = "postgres";
    private String pass = "admin";

    public void ConnectToDb() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Properties info = new Properties();
        info.setProperty("user",user);
        info.setProperty("password",pass);
        info.setProperty("useUnicode", "true");
        info.setProperty("characterEncoding", "utf8");
        Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/training?charSet=UTF8", info);
        stmt = connect.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS books( ID SERIAL PRIMARY KEY, bookname TEXT NOT NULL, bookauthor TEXT NOT NULL, bookyear INTEGER NOT NULL)";
        stmt.executeUpdate(sql);
    }

    public void addItem(String name, String author, String year) throws SQLException, ClassNotFoundException {
        ConnectToDb();
        String sql = "INSERT INTO books(bookname, bookauthor, bookyear) VALUES('"
                + name + "','"
                + author + "','"
                + year + "')";
        stmt.executeUpdate(sql);
        System.out.println("Книга автора " + author + " с названием " + name + " написанная в  " + year + " году занесён в базу!");
        stmt.close();
    }

    public List<Book> selectItem() throws SQLException, ClassNotFoundException {
        ConnectToDb();
        String sql = "SELECT * FROM books;";
        ResultSet rs = stmt.executeQuery(sql);
        List<Book> books = new ArrayList<Book>();
            while ( rs.next() ) {
            long id = rs.getInt("id");
            String  name = rs.getString("bookname");
            String  author = rs.getString("bookauthor");
            int year  = rs.getInt("bookyear");
            books.add(new Book((long) id, name, author, year));
        }
        rs.close();
        stmt.close();
        return books;
    }

    public List<Book> showUpdatingItem(long itemId) throws SQLException, ClassNotFoundException {
        ConnectToDb();
        String sql = "SELECT * FROM books WHERE id="+itemId;
        ResultSet rs = stmt.executeQuery(sql);
        List<Book> books = new ArrayList<Book>();
        while ( rs.next() ) {
            long id = rs.getInt("id");
            String  name = rs.getString("bookname");
            String  author = rs.getString("bookauthor");
            int year  = rs.getInt("bookyear");
            //Book book = new Book(id, name, author, year);
            books.add(new Book((long) id, name, author, year));
        }
        rs.close();
        stmt.close();
        return books;
    }

    public void updateItem(long id, String name, String author, String year) throws SQLException, ClassNotFoundException {
        ConnectToDb();
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+name+" "+id+" "+author+" "+year);
        String sql = "UPDATE books SET bookname ='"+name+"' ,bookauthor ='"+author+"' , bookyear ='"+year+"' WHERE id="+id;
        stmt.executeUpdate(sql);
        System.out.println("Книга автора " + author + " с названием " + name + " написанная в  " + year + " году изменена!");
        stmt.close();
    }
}