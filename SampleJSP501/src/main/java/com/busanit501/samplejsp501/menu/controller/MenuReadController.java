package com.busanit501.samplejsp501.menu.controller;

import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Log4j2
@WebServlet(name = "lunchread", urlPatterns = "/lunch/read")
public class LunchReadController extends HttpServlet {
    //주입 , 서비스 인스턴스 , 포함.
    private LunchService lunchService = LunchService.INSTANCE;

    // 게시글 하나의 정보의 창(화면), todo(게시글 한개) 하나의 정보가 필요해요.
    // todo 할일 목록, 1. 청소하기. 2.설겆이하기. 3.분리수거하기. 4. 애들 목욕시키기


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Long menuNo = Long.valueOf(req.getParameter("menuNo"));
            LunchDTO sample = lunchService.getSelectOne(menuNo);
            req.setAttribute("sample", sample);
            req.getRequestDispatcher("/WEB-INF/lunchmenu/lunchRead.jsp")
                    .forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}