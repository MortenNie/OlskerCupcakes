package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottoms;
import dat.backend.model.entities.Topping;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ToppingAndBottomsFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Ordercupcake", value = "/ordercupcake")
public class Ordercupcake extends HttpServlet {
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<Topping> allToppings = ToppingAndBottomsFacade.getAllTopping(connectionPool);
       List<Bottoms> allBottoms = ToppingAndBottomsFacade.getAllBottoms(connectionPool);
       request.setAttribute("alltoppings", allToppings);
       request.setAttribute("allbottoms", allBottoms);
       request.getRequestDispatcher("listofcupcakes.jsp").forward(request, response);

    }
}
