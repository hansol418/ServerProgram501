package com.busanit501.samplejsp501;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 웹브라우전에 접근시 , http://localhost:8080/my
@WebServlet(name = "mySevlet" , urlPatterns = "/my")

public class MyServlet extends HelloServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "내가 만든 MyServlet 파일에서 답보내기 연습중." + "</h1>");
        out.println("</body></html>");
    }
}
