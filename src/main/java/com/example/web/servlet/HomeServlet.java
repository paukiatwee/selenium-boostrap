/**
 * 
 */
package com.example.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.user.DefaultUserService;
import com.example.user.User;

/**
 * @author pau
 *
 */
public class HomeServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 6506371248465437857L;

    public static final String VIEW = "/home.jsp";
    private DefaultUserService userService = new DefaultUserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", userService.getAll());
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        userService.add(new User(username, password, role));
        response.sendRedirect("/home");
        
    }
    
    

    
}
