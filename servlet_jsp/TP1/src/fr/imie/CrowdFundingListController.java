package fr.imie;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrowdFundingList
 */
@WebServlet("/CrowdFundingListController")
public class CrowdFundingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrowdFundingListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("CrowdFundingList",request.getSession().getAttribute("CrowdFundingList"));	
		request.getRequestDispatcher("/WEB-INF/CrowdFoundingList.jsp").forward(request, response);
		
		

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer numLigne = Integer.parseInt(request.getParameter("numLigne"));
		List<CrowdFundingDTO> CFList =(List<CrowdFundingDTO>) request.getSession().getAttribute("CrowdFundingList");
		CrowdFundingDTO current = CFList.get(numLigne);
		//request.getSession().setAttribute("CrowdFundingCurrent", current);
		response.sendRedirect("./CrowdFundingRecordController?name="+current.getName());
	}

}
