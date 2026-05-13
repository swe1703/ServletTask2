package com.example;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/survive")
public class SurvivalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        int tea = Integer.parseInt(req.getParameter("tea"));
        int sleep = Integer.parseInt(req.getParameter("sleep"));
        int backlog = Integer.parseInt(req.getParameter("backlog"));
        int leetcode = Integer.parseInt(req.getParameter("leetcode"));
        int assessment  = Integer.parseInt(req.getParameter("assessment"));

        int score = 100 + ((leetcode * 2) + (assessment * 5) - (backlog * 9) - (tea * 3) - (Math.abs(7 - sleep) * 5));
        score = Math.max(0, Math.min(100, score));

        String message;
        if(score >= 90) message = "Ready for the next round!";
        else if(score >= 70) message = "Still in the game!";
        else if(score >= 50) message = "Barely surviving deadlines!";
        else message = "Bro, study a little!";

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<div style='display:flex; flex-direction:column; justify-content:center; align-items:center; height:100vh; color:black; font-family:Arial;'>");
        out.println("<h2>Survival Score : " + score + "%</h2>");
        out.println("<h3>" + message + "</h3>");
        out.println("<a href='index.html' style='color:black; text-decoration:none;'>Try Again</a>");
        out.println("</div>");
    }
}