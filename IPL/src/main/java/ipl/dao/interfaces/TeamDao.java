package ipl.dao.interfaces;
import java.util.*;

import ipl.beans.Team;

public interface TeamDao {

	
	List<Team> getAllTeams();
	
	
	int insertTeam(Team team);
	
	int deleteTeamById(int teamId);
	
	Team getTeamById(int teamId);
	
	int updateTeam(Team team);



	

	
	
}
