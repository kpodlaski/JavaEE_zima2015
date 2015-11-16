package servets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String param = request.getParameter("img");
		
		InputStream is;
		if ("kw".equals(param)){
			is= this.getClass().getClassLoader().
						 getResourceAsStream("/resources/blue.jpg");
			response.setHeader("Content-Type", "image/jpeg");	
			request.getSession().setAttribute("img", "kw");
		}
		else {
			is= this.getClass().getClassLoader().
				 getResourceAsStream("/resources/papuga.png");
			response.setHeader("Content-Type", "image/png");
			request.getSession().setAttribute("img", "NOTkw");
		}
		
		int b;
		while ( (b= is.read() )!=-1){
			response.getOutputStream().write(b);
		}
		
	}

}
