package myBooks;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = new ArrayList<Book>();// формируем Array лист из наших книг (их можно получить из БД)
        books.add(new Book(1L, "Java for everyone"));
        books.add(new Book(2L, "Java for beginner"));
        books.add(new Book(3L, "Java for advanced"));

        req.setAttribute("BookList", books);

        getServletContext().getRequestDispatcher("/books.jsp").forward(req, resp); // в строке указывается путь к JSP
        // формирующей HTML, туда через req передаём (req.setAttribute()) через атрибут идентификатор, по которому "выцепляем"
        // переданное и объект
    }
}
