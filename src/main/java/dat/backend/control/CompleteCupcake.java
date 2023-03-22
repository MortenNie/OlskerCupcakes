package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottoms;
import dat.backend.model.entities.Product;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Topping;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ProductFacade;
import dat.backend.model.persistence.ToppingAndBottomsFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CompleteCupcake", value = "/completecupcake")
public class CompleteCupcake extends HttpServlet {
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
    String toppingName =  request.getParameter("toppings");
    Topping topping = ToppingAndBottomsFacade.getToppingsFromName(toppingName, connectionPool);

    String bottomsName = request.getParameter("bottoms");
    Bottoms bottoms = ToppingAndBottomsFacade.getBottomsFromName(bottomsName, connectionPool);

    Product product = ProductFacade.createProduct("cupcake",topping, bottoms, 1, connectionPool);

    request.setAttribute("product", product);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addProduct(product);
        HttpSession session = request.getSession();
        session.setAttribute("shoppingcart", shoppingCart);
        request.getRequestDispatcher("listofcupcakes.jsp").forward(request,response);
    }
}
