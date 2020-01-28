package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetEmpData
 */
@WebServlet("/getempdata")
public class GetEmpData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetEmpData() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GetEmpData");

		try {
			PrintWriter out = response.getWriter();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shruthidb", "shruthi", "abc@2");
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select e.name,m.name from Employee2 e inner join Manager m on e.mno=m.mid ");
			while (resultSet.next()) {
				out.println(resultSet.getString(1)+" "+resultSet.getString(2)+"   ");
				out.println(" ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
