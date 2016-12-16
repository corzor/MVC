import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet performing role of Controller.
 *
 * Created by Richard Corzo on 12/14/2016.
 */
public class CounterServlet extends HttpServlet {
    private Model model = new Model();
    private int start_value = 10;	// Initial value for model, which in turn initialises view

    public CounterServlet() {
        System.out.println("CounterServlet()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("CounterServlet: loaded");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CounterServlet: initializing View");

        // Initialize Model
        model.setValue(start_value);
        // Initialize View
        req.setAttribute("counter", model.getValue());
        // Set View
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view.jsp");  // web View
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CounterServlet: acting on Model");

        // Update Model
        model.incrementValue();
        // Update View
        req.setAttribute("counter", model.getValue());
        // Set View
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view.jsp");  // web View
        requestDispatcher.forward(req, resp);
    }
}
