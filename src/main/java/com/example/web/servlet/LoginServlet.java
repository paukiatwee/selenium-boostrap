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
public class LoginServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -7945908883546663218L;
    public static final String VIEW = "index.jsp";
    private DefaultUserService userService = new DefaultUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(VIEW);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(login(username, password)) {
            response.sendRedirect("/home");
        } else {
            request.setAttribute("login", "Login Failed, please try again.");
            request.getRequestDispatcher(VIEW).forward(request, response);            
        }
    }

    private boolean login(String username, String password) {
        return userService.login(new User(username, password));
    }

    
}
