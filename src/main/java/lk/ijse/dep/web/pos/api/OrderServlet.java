package lk.ijse.dep.web.pos.api;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(name = "OrderServlet", urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String date = request.getParameter("date");
        String customerId = request.getParameter("customerId");

        System.out.println(id);
        System.out.println(date);
        System.out.println(customerId);

        String[] code = request.getParameterValues("code");
        String[] qty = request.getParameterValues("qty");
        String[] unitPrices = request.getParameterValues("unitPrice");

        System.out.println("------------- ORDER DETAILS -----------------");
        for (int i =0;i<code.length;i++) {
            System.out.println("Code=" + code[i] + ", Qty=" + qty[i] + ", UnitPrice=" + unitPrices[i] );
        }

        System.out.println("Saved Order");
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
