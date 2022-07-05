package ipl.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ipl.beans.Team;
import ipl.service.*;

/**
 * Servlet implementation class IPLController
 */
@WebServlet("/IPLController")
public class IPLController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IPLController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		

		String action = request.getParameter("action");

		if (action == null) {
			viewAllTeams(request, response);
		} else if (action.equalsIgnoreCase("delete")) {
			deleteTeam(request, response);
		} else if (action.equalsIgnoreCase("get_team_details")) {
			getTeamDetails(request, response);
		} else if (action.equalsIgnoreCase("edit")) {
			editTeam(request, response);
		}

		
	}
	
	
	public static void editTeam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		int teamId = Integer.parseInt(request.getParameter("team_id"));
		String teamName = request.getParameter("team_name");
		String city = request.getParameter("city");
		String state = request.getParameter("state");

		Team team = new Team();
		team.setCity(city);
		team.setState(state);
		team.setTeamId(teamId);
		team.setTeamName(teamName);

		int row = new TeamService().updateTeam(team);

		if (row == 1) {
			viewAllTeams(request, response);
		} else {
			out.write("Something went wrong. Team details not edited ");
			RequestDispatcher rd = request.getRequestDispatcher("view_team.jsp");
			rd.include(request, response);
		}

	}
	
	
	public static void getTeamDetails(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int teamId = Integer.parseInt(request.getParameter("team_id"));

		Team team = new TeamService().getTeam(teamId);

		request.setAttribute("team", team);

		RequestDispatcher rd = request.getRequestDispatcher("view_team.jsp");
		rd.forward(request, response);
	}

	public static void deleteTeam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int teamId = Integer.parseInt(request.getParameter("team_id"));

		int row = new TeamService().deleteTeam(teamId);

		if (row == 1) {
			viewAllTeams(request, response);
		} else {
			out.write("Something went wrong. Team not deleted");
			RequestDispatcher rd = request.getRequestDispatcher("ipl_home.jsp");
			rd.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String teamName = request.getParameter("teamName");
		String city = request.getParameter("city");
		String state = request.getParameter("state");

		Team team = new Team();
		team.setTeamName(teamName);
		team.setCity(city);
		team.setState(state);

		int row = new TeamService().insertTeam(team);

		if (row == 1) {
			viewAllTeams(request, response);
		} else {
			out.write("Something went wrong. New team not added");
			RequestDispatcher rd = request.getRequestDispatcher("add_team.html");
			rd.include(request, response);
		}
		
		
	}

	public static void viewAllTeams(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Team> teamList = new TeamService().getAllTeams();

		request.setAttribute("allTeams", teamList);

		RequestDispatcher rd = request.getRequestDispatcher("ipl_home.jsp");
		rd.forward(request, response);
	}
	
}
