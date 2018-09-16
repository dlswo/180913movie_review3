package org.web;


import org.dao.MovieDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/remove")
public class Removecontroller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int mno = Integer.parseInt(req.getParameter("mno"));
        MovieDAO dao = new MovieDAO();
        dao.deleteReview(mno);           //수정해야함

        resp.sendRedirect("/list");
    }
}
