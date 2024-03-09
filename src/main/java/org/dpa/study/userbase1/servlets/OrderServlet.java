package org.dpa.study.userbase1.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.dpa.study.userbase1.services.OrdersService;

import java.io.IOException;

@WebServlet(name = "OrderServlet", urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getContentType().equals("application/json")) {
            OrdersService.addOrder(request);
        } else {
            System.out.println("something went wrong");
        }
    }
}
