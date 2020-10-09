package lk.ijse.dep.web.pos.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "ItemServlet", urlPatterns = "/items")
public class ItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        if (code == null) {
            System.out.println("All Items");
        } else {
            System.out.println("Item Code=" + code);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String description = request.getParameter("description");
        String qtyOnHand = request.getParameter("qtyOnHand");
        String unitPrice = request.getParameter("unitPrice");
        System.out.println(code);
        System.out.println(description);
        System.out.println(qtyOnHand);
        System.out.println(unitPrice);
        System.out.println("Saved Item");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = getParameter(req.getQueryString(), "code");
        if (code == null) {
            return;
        }
        System.out.println("Item Code=" + code);

        BufferedReader reader = req.getReader();
        String line = null;
        String requestBody = "";

        while ((line = reader.readLine()) != null) {
            requestBody += line;
        }

        String description = getParameter(requestBody, "description");
        String qtyOnHand = getParameter(requestBody, "qtyOnHand");
        String unitPrice = getParameter(requestBody, "unitPrice");

        System.out.println("Item Description=" + description);
        System.out.println("Item Qty. on Hand=" + qtyOnHand);
        System.out.println("Item UnitPrice=" + unitPrice);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String queryString = req.getQueryString();
        String code = getParameter(queryString, "code");
        if (code == null){
            return;
        }
        System.out.println("Item Deleted: " + code);
    }

    public static String getParameter(String queryString, String parameterName){
        if (queryString == null || parameterName == null || queryString.trim().isEmpty() || parameterName.trim().isEmpty()){
            return null;
        }

        String[] queryParameters = queryString.split("&");
        for (String queryParameter : queryParameters) {
            if (queryParameter.contains("=") && queryParameter.startsWith(parameterName)) {
                return queryParameter.split("=")[1];
            }
        }
        return null;
    }
}
