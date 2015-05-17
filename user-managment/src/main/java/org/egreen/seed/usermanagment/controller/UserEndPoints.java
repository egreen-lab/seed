package org.egreen.seed.usermanagment.controller;

import org.egreen.seed.usermanagment.service.PersonController;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dewmal on 5/17/15.
 */
//@WebServlet(
//        urlPatterns = "/user",
//        name = "User Engagement"
//)
@WebServlet("/user")
public class UserEndPoints extends HttpServlet {

    @Resource
    private PersonController personController;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Working ");
    }
}
