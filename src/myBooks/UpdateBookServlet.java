package myBooks;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UpdateBookServlet extends HttpServlet {
    public List<Book> books;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connect connect = new Connect();
        String id = req.getParameter("id");
        long itemId = Long.parseLong(id);
        try {
            books = connect.updateItem(itemId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("BookList", books);
        getServletContext().getRequestDispatcher("/updBook.jsp").forward(req, resp);
        System.out.println("++++++++++++++++++++++++++++++++++++");
    }
}
