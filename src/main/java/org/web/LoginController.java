package org.web;

import org.dao.MemberDAO;
import org.domain.MemberVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher =
                req.getRequestDispatcher("/WEB-INF/login.jsp");

        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MemberDAO dao = new MemberDAO();
        List<MemberVO> memberVOList = dao.checkLogin();
        System.out.println("Login post...................");
        String id = req.getParameter("id");
        String pw = req.getParameter("pw");
        System.out.println(id + ":" + pw);

        MemberVO vo = new MemberVO();
        vo.setId(id);
        vo.setPw(pw);
        for (MemberVO vol : memberVOList) {
            if (id.equals(vol.getId()) == true && pw.equals(vol.getPw()) == true) {
                resp.sendRedirect("/list");
                HttpSession session = req.getSession();
                if (vo != null) {
                    session.setAttribute("member", vo);
                }
                return;
            }
        }
        resp.sendRedirect("/login");

    }
}