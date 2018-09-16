package org.web;


import org.dao.MovieDAO;
import org.domain.MovieVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/read")
public class ReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int mno = Integer.parseInt(req.getParameter("mno"));
        int page = Integer.parseInt(req.getParameter("page"));
        MovieDAO dao = new MovieDAO();
        MovieVO vo = dao.getReview(mno);

        HttpSession session = req.getSession();
        dao.updateView(mno);
        session.setAttribute("movie", vo);
        session.setAttribute("page", page);
        session.setAttribute("mno", mno);




        req.getRequestDispatcher("/WEB-INF/read.jsp").forward(req, resp);

    }
}
