package servlets;

import beans.Database;
import beans.Product;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Database inventory = new Database();
	
    public ProductServlet() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		String code = request.getParameter("code");
		String name = request.getParameter("name");
		String weight = request.getParameter("weight");
		String width = request.getParameter("width");
		String length = request.getParameter("length");
		String height = request.getParameter("height");
		String prodDate = request.getParameter("prodDate");
		
		PrintWriter out = response.getWriter();

		String source = "<!DOCTYPE html>" + "<html>" + "<head><meta charset='UTF-8'></head>" + "<body>";

		if ((code != null && code.length() > 0) && (name != null && name.length() > 0) &&
				(weight != null && weight.length() > 0) &&
					(width != null && width.length() > 0) &&
						(length != null && length.length() > 0) &&
							(height != null && height.length() > 0) &&
								(prodDate != null && prodDate.length() > 0)) {
									inventory.addProduct(new Product(code, name, weight, width, length, height, prodDate));
									source += "<h1>The Product was added Succesfully!</h1>" + "<p>Code: </p>" + code
																							+ "<p>Name: </p>" + name
																							+ "<p>Weight: </p>" + weight
																							+ "<p>Width: </p>" + width
																							+ "<p>Length: </p>" + length
																							+ "<p>Height: </p>"+ height
																							+ "<p>Production Date: </p>" + prodDate; }
		else
		{
			source += "<h1>Product date isn't full!</h1>";
		}
		source += "</body></html>";
		out.print(source);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		
		String button_param = request.getParameter("Show");
		if (button_param.equals("Show At"))
		{
			int index = Integer.parseInt(request.getParameter("index")) - 1;
			String jsonProd = gson.toJson(inventory.getInventory().get(index));
			response.setContentType("application/json");
			out.println(jsonProd);
			out.close();
		}
		else if (button_param.equals("Show All"))
		{
			String jsonProd = gson.toJson(inventory.getInventory());
			response.setContentType("application/json");
			out.println(jsonProd);
			out.close();
		}
	}
}
