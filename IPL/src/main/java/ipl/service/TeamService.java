package ipl.service;

import java.util.*;

import ipl.beans.Team;
import ipl.dao.impl.*;

public class TeamService {

	public List<Team> getAllTeams() {
		// return new TeamDAOImpl().getALLTeams();
		return new TeamDAOImpl().getAllTeams();
	}

	public int insertTeam(Team team) {
		return new TeamDAOImpl().insertTeam(team);
	}

	public int deleteTeam(int teamId) {
		return new TeamDAOImpl().deleteTeamById(teamId);
	}

	public Team getTeam(int teamId) {
		return new TeamDAOImpl().getTeamById(teamId);
	}

	public int updateTeam(Team team) {
		return new TeamDAOImpl().updateTeam(team);
	}

}
