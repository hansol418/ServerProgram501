package com.busanit501.samplejsp501.menu.controller;

import com.busanit501.samplejsp501.menu.dto.MenuDTO;
import com.busanit501.samplejsp501.menu.service.MenuService;
import com.busanit501.samplejsp501.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "menuReg", urlPatterns = "/menu/register")
public class MenuRegController extends HttpServlet {

    //주입 , 서비스 인스턴스 , 포함.
    private MenuService menuService = MenuService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //todo 글 입력 폼
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/menu/menuReg.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // todo 글 입력 처리 하는 로직.
        // TodoDTO 타입을 받아서, 서비스에 전달하는 로직.
        MenuDTO menuDTO = MenuDTO.builder()
                .menuTitle(req.getParameter("menuTitle"))
                .menuRegDate(LocalDate.parse(req.getParameter("menuRegDate")))
                .build();

        // 실제 데이터 입력하기.
        try {
            menuService.register2(menuDTO);
            // 리다이렉트, 메인: 리스트
            resp.sendRedirect("/menu/list");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}







