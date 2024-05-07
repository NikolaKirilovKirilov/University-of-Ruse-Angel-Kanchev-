package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Name extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Name() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String name = request.getParameter("ime");

		PrintWriter out = response.getWriter();

		String source = "<!DOCTYPE html>" + "<html>" + "<head><meta charset='UTF-8'></head>" + "<body>";

		if (name != null && name.length() > 0) {
			for (int i = 0; i < name.length(); i++) {
				int size = (int) (Math.random() * 41) + 15;

				String color = getRandomColor();

				char leter = name.charAt(i);

				source += "<span style='color:" + color + "; font-size:" + size + "pt;'>" + leter + "</span>";
			}
		}
		else {
			source += "Грешка. Заредете html файла.";
		}

		source += "</body></html>";

		out.print(source);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected String getRandomColor() {
		String digits = "0123456789ABCDEF";
		String color = "#";
		for (int i = 0; i < 6; i++) {
			int randomPosition = (int) (Math.random() * 16);
			color += digits.charAt(randomPosition);
		}

		return color;
	}

}
