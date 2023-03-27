package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Product;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.ProductFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "Deleteproductfromcart", value = "/deleteproductfromcart")
public class Deleteproductfromcart extends HttpServlet {
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
        int productId = Integer.parseInt(request.getParameter("deleteproductfromcart"));
        HttpSession session = request.getSession();
        ShoppingCart sc = (ShoppingCart) session.getAttribute("shoppingcart");
        List<Product> productList = sc.getProducts();

        try {
            ProductFacade.deleteProduct(productId, connectionPool);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext(); ) {
            Product value = iterator.next();
            if (value.getProductId() == productId) {
                iterator.remove();
            }
        }

        ShoppingCart sc2 = new ShoppingCart();


       if(productList.isEmpty()) {

           request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);


       } else {
           for (Product t : productList) {
               sc2.addProduct(t);

           }



           session.removeAttribute("shoppingcart");
           session.setAttribute("shoppingcart", sc2);
           request.getRequestDispatcher("shoppingcart.jsp").forward(request, response);
       }
    }
}
