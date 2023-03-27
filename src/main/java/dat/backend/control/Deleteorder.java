package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Order;
import dat.backend.model.entities.Product;
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
import java.util.List;

@WebServlet(name = "Deleteorder", value = "/deleteorder")
public class Deleteorder extends HttpServlet {
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
     int orderId = Integer.parseInt(request.getParameter("deleteorder"));
     List<Product> products = ProductFacade.selectProductFromOrderId(orderId, connectionPool);
     for (Product s: products) {
         try {
             ProductFacade.deleteProduct(s.getProductId(), connectionPool);
         } catch (DatabaseException e) {
             e.printStackTrace();
         }
     }

     String username = OrderFacade.SelectUserNameFromOrderId(orderId, connectionPool);

     OrderFacade.removeOrder(orderId, connectionPool);


     User user = UserFacade.SelectUserFromUsername(username, connectionPool);
     List<Order> orderList = OrderFacade.selectAllOrdersFromUser(user.getUsername(), connectionPool);
     request.setAttribute("orderList", orderList);
     request.getRequestDispatcher("WEB-INF/orderhistory.jsp").forward(request, response);

    }
}
