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

@WebServlet(urlPatterns = "/write")
public class WriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        req.getRequestDispatcher("/WEB-INF/write.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        MovieDAO dao = new MovieDAO();


        String mtitle = req.getParameter("mtitle");
        String userid = req.getParameter("userid");
        String rtitle = req.getParameter("rtitle");
        String cmt = req.getParameter("cmt");
        String mimg = req.getParameter("mimg");
        MovieVO vo = new MovieVO();
        vo.setCmt(cmt);
        vo.setMimg(mimg);
        vo.setUserid(userid);
        vo.setRtitle(rtitle);
        vo.setMtitle(mtitle);
        dao.addReview(vo);


        resp.sendRedirect("/list");


    }
}
