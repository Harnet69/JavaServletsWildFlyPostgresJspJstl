package myBooks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connect {
    public Statement stmt;

    public void ConnectToDb() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Properties info = new Properties();
        info.setProperty("useUnicode", "true");
        info.setProperty("characterEncoding", "utf8");
        Connection connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/training", "postgres", "admin");
        stmt = connect.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS books( ID SERIAL PRIMARY KEY, bookname TEXT NOT NULL, bookauthor TEXT NOT NULL, bookyear INTEGER NOT NULL)";
        stmt.executeUpdate(sql);
    }

    public void addItem(String name, String author, int year) throws SQLException, ClassNotFoundException {
        ConnectToDb();
        String sql = "INSERT INTO books(bookname, bookauthor, bookyear) VALUES('"
                + name + "','"
                + author + "','"
                + year + "')";
        stmt.executeUpdate(sql);
        System.out.println("Книга автора " + author + " с названием " + name + " написанная в  " + year + " году занесён в базу!");
        stmt.close();
    }
}