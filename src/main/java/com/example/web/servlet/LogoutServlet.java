/**
 * 
 */
package com.example.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author pau
 *
 */
public class LogoutServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -1096539725409574215L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logout(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logout(req, resp);
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        try {
            session.invalidate();
        } catch (IllegalArgumentException e) {
            log(e.getMessage(), e);
        }
        
        resp.sendRedirect(LoginServlet.VIEW);
    }
    
}
