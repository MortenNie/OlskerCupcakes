package dat.backend.control;

import com.mysql.cj.Session;
import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Product;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrderFacade;
import dat.backend.model.persistence.ProductFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Confirmorder", value = "/confirmorder")
public class Confirmorder extends HttpServlet {
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
       int pris = Integer.parseInt(request.getParameter("confirmorder"));
       HttpSession session = request.getSession();
       User user = (User) session.getAttribute("user");

       if (user.getBalance()-pris >= 0) {

            int orderId = -1;
            ShoppingCart sc = (ShoppingCart) session.getAttribute("shoppingcart");
            List<Product> list = sc.getProducts();
            List<Integer> productIds = new ArrayList<>();
            try {
                orderId = OrderFacade.addOrder(user.getUsername(), connectionPool);
            } catch (DatabaseException e) {
                e.printStackTrace();
            }

            for (Product s : list) {
                productIds.add(s.getProductId());

            }

            for (Integer t : productIds) {
                try {
                    ProductFacade.addOrderIdToProduct(orderId, t, connectionPool);
                } catch (DatabaseException e) {
                    e.printStackTrace();
                }

            }
            int newBalance = user.changeToNewBalance(pris);
            try {
                UserFacade.changeBalance(user.getUsername(), newBalance, connectionPool);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sc.getProducts().clear();
            session.removeAttribute("shoppingcart");
            request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);

        } else {
            request.setAttribute("errormessage", "Your balance is too low to pay for your order");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}

//rest kode fra jons version som han hjalp os med

 /*int pris = Integer.parseInt(request.getParameter("confirmorder"));
       HttpSession session = request.getSession();
       User user = (User) session.getAttribute("user");
       int orderId = -1;
        ShoppingCart sc = (ShoppingCart) session.getAttribute("shoppingcart");
        List<Product> productList = sc.getProducts();
        try {
            orderId = OrderFacade.addOrder(user.getUsername(), connectionPool);
            for (Product p : productList) {
                ProductFacade.addOrderIdToProduct(orderId, p.getTopping().getToppingName(), p.getBottoms().getBottomsName(), connectionPool);
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
       request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }
} */