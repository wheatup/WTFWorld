package com.wheatup.wtfworld.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wheatup.wtfworld.server.GameServer;

import cc.wheatup.server.Server;

@WebServlet("/console/ConsoleController")
public class ConsoleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String type = request.getParameter("type");
		if("command".equalsIgnoreCase(type)) {
			String value = request.getParameter("value");
			if("START_SERVER".equalsIgnoreCase(value)){
				GameServer.start();
				out.print("SUCCESS");
				out.flush();
				out.close();
			}else if("STOP_SERVER".equalsIgnoreCase(value)) {
				GameServer.stop();
				out.print("SUCCESS");
				out.flush();
				out.close();
			}
		}else if("query".equalsIgnoreCase(type)) {
			String value = request.getParameter("value");
			if("IS_SERVER_RUNNING".equalsIgnoreCase(value)) {
				if(Server.isRunning()) {
					out.print("true");
					out.flush();
					out.close();
				}else {
					out.print("false");
					out.flush();
					out.close();
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
