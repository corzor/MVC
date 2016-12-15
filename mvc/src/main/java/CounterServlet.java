import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by robin on 12/14/2016.
 */
public class CounterServlet extends HttpServlet {
    private Model model;
    private int start_value = 10;	//initialise model, which in turn initialises view

    public CounterServlet() {
        System.out.println("CounterServlet()");
        // Create Model
        Model myModel = new Model();
        addModel(myModel);
        initModel(start_value);
    }
    //Joe I should be able to add any model/view with the correct API
    //but here I can only add Model/View
    private void addModel(Model m){
        System.out.println("CounterServlet: adding model");
        this.model = m;
    } //addModel()

    private void initModel(int x){
        model.setValue(x);
    } //initModel()

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("CounterServlet: loaded");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CounterServlet: initializing View");

        req.setAttribute("counter", model.getValue());
        // Set View
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view.jsp");  // web View
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("CounterServlet: acting on Model");

        model.incrementValue();

        req.setAttribute("counter", model.getValue());
        // Set View
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view.jsp");  // web View
        requestDispatcher.forward(req, resp);
    }
}
