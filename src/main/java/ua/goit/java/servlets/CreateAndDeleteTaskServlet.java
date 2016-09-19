package ua.goit.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by 7 on 18.09.2016.
 */
public class CreateAndDeleteTaskServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        createTask(req, session);
        resp.sendRedirect("MyToDoList.jsp");

    }

    private void createTask(HttpServletRequest req, HttpSession session) {

        List<Task> list = (List<Task>)session.getAttribute("list");

        if (list == null) {
            list = new ArrayList<>();
        }
        session.setAttribute("list", list);

        Task task = new Task();
        task.setName(req.getParameter("enteredTask"));
        task.setUuid(UUID.randomUUID().toString());

        list.add(task);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String id = req.getParameter("button_id");
        deleteTask(session, id);
        resp.sendRedirect("MyToDoList.jsp");

    }

    private void deleteTask(HttpSession session, String id) {
        List<Task> list = (List<Task>) session.getAttribute("list");
        int a = -1;

        for (Task task : list) {
            if (task.getUuid().equals(id)) {
                a = list.indexOf(task);
            }
        }
        list.remove(a);
    }
}
