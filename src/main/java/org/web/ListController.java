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
import java.util.List;

@WebServlet(urlPatterns = "/list")
public class ListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        MovieDAO dao = new MovieDAO();
        String pageStr = req.getParameter("page");
        if(pageStr == null) {
                pageStr = "1";
        }
        int curPage = Integer.parseInt(pageStr);
        if(curPage < 1) {curPage = 1;}


        PageController pageController = new PageController();
        int lastPage = dao.getLastPage();
        int maxPage = pageController.getMaxPage(curPage);
        int minPage = maxPage-9;
        if(maxPage >lastPage) {
            maxPage = lastPage;
        }
        if(curPage > lastPage) { curPage = lastPage;}

//        //시작,끝,이전,다음
//        int totalPage = lastPage / 10;
//        if (lastPage%10 >0){
//            totalPage++;
//        }


        List<MovieVO> listVOList = dao.getList(curPage);

        System.out.println("========================================");
        System.out.println("lastPAGE:  " + lastPage);
        System.out.println("========================================");
        System.out.println("maxPAGE: " + maxPage);

//        req.setAttribute("totalPage",totalPage);
        req.setAttribute("lastPage",lastPage);
        req.setAttribute("curPage",curPage);
        req.setAttribute("maxPage",maxPage);
        req.setAttribute("minPage",minPage);
        req.setAttribute("list", listVOList);

        req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
    }
}
