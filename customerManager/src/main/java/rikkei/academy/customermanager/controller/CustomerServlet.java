package rikkei.academy.customermanager.controller;

import rikkei.academy.customermanager.model.Customer;
import rikkei.academy.customermanager.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    protected CustomerService customerService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();

        customerService.save(new Customer(1, "Duy Nen", "duynen@gmail,com", "HN"));
        customerService.save(new Customer(2, "Cuong Toi", "cuongtoi@gmail,com", "HN"));
        customerService.save(new Customer(3, "Huy Ielts", "huyielts@gmail,com", "HN"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "GETALL":
                    break;
                case "DELETE":
                    int idDel = Integer.parseInt(req.getParameter("id"));
                    customerService.deleteById(idDel);
                    break;
                case "EDIT":
                    int idEdit = Integer.parseInt(req.getParameter("id"));
                    Customer customer = customerService.findById(idEdit);
                    req.setAttribute("customer", customer);
                    req.getRequestDispatcher("/WEB-INF/editCustomer.jsp").forward(req, resp);
                    break;
                case "CREATE":
                    req.getRequestDispatcher("/WEB-INF/newCustomer.jsp").forward(req, resp);
                    break;
                case "SHOW":
                    int idConfirm = Integer.parseInt(req.getParameter("id"));
                    Customer customer1 = customerService.findById(idConfirm);
                    req.setAttribute("customer1", customer1);
                    req.getRequestDispatcher("/WEB-INF/customerDetail.jsp").forward(req, resp);
                    break;

            }
            showListCustomer(customerService.findAll(), req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null) {
            switch (action) {
                case "UPDATE":
                    int id = Integer.parseInt(req.getParameter("id"));
                    String nameEdit = req.getParameter("name");
                    String emailEdit = req.getParameter("email");
                    String addressEdit = req.getParameter("address");
                    customerService.save(new Customer(id, nameEdit, emailEdit, addressEdit));
                    break;
                case "ADD":
                    int idNew = customerService.getNewId();
                    String nameNew = req.getParameter("name");
                    String emailNew = req.getParameter("email");
                    String addressNew = req.getParameter("address");
                    customerService.save(new Customer(idNew, nameNew, emailNew, addressNew));
                    break;
                case "CONFIRM":

                    break;
            }
            showListCustomer(customerService.findAll(), req, resp);
        }
    }

    protected void showListCustomer(List<Customer> list, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("customers", list);
        req.getRequestDispatcher("/WEB-INF/listCustomer.jsp").forward(req, resp);
    }


}
