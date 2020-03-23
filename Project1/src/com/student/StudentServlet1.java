package com.student;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.StudentCon;
import com.studentbean.StudentBean;
import com.studentservice.StudentService;

public class StudentServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public int id;
	public String name;
	public String address;
	public String email;
	public String qual;
	PrintWriter pw;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		pw = response.getWriter();
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		name = request.getParameter("name");
		address = request.getParameter("address");
		email = request.getParameter("email");
		qual = request.getParameter("qual");

		response.setContentType("text/html");
		String a = request.getParameter("a");

		switch (a) {

		case "insert":
			insert(request, response);
			break;
		case "update":
			update(request, response);
			break;
		case "delete":
			delete(request, response);
			break;
		case "select":
			select(request, response);
			break;
		case "proceed":
			proceed(request, response);
			break;
		}

	}

	private void select(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));

		StudentCon con = new StudentCon();
		String[] s = new String[5];
		s = con.select(id);
		request.setAttribute("select", s);
		request.setAttribute("check", "sel");
		RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
		rd.include(request, response);
		pw.close();

	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		pw = response.getWriter();
		StudentBean student = new StudentBean(id, name, address, email, qual);

		StudentService service = new StudentService();
		String result = service.insertData(student);

		request.setAttribute("check", "ins");
		request.setAttribute("insert", result);
		RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
		rd.include(request, response);
		pw.close();

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));

		StudentService service = new StudentService();
		String result = service.deleteData(id);

		request.setAttribute("check", "del");
		request.setAttribute("delete", result);
		RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
		rd.include(request, response);
		pw.close();

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pw = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		StudentCon con = new StudentCon();
		String[] s = new String[5];
		s = con.select(id);
		String s1 = s[0];
		String s2 = s[1];
		String s3 = s[2];
		String s4 = s[3];
		String s5 = s[4];
		request.setAttribute("data1", s1);
		request.setAttribute("data2", s2);
		request.setAttribute("data3", s3);
		request.setAttribute("data4", s4);
		request.setAttribute("data5", s5);

		RequestDispatcher rd = request.getRequestDispatcher("updatetest.jsp");
		rd.include(request, response);

		pw.close();

	}

	private void proceed(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		pw = response.getWriter();

		try {

			id = Integer.parseInt(request.getParameter("id"));
			name = request.getParameter("name");
			address = request.getParameter("address");
			email = request.getParameter("email");
			qual = request.getParameter("qual");

			StudentBean student = new StudentBean(id, name, address, email, qual);
			StudentService service = new StudentService();
			String result = service.updateData(student);
			request.setAttribute("check", "upd");
			request.setAttribute("update", result);
			RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
			rd.include(request, response);

			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
