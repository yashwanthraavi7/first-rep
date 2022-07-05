package ipl.dao.impl;

import java.sql.*;

import ipl.beans.Team;
import ipl.dao.interfaces.TeamDao;
import java.util.*;

public class TeamDAOImpl implements TeamDao {

	public static void main(String[] args) {

		Team team = new Team();
		team.setTeamId(2);
		team.setTeamName("Mumbai Indians");
		team.setCity("Mumbai");
		team.setState("Maha");

		System.out.println(new TeamDAOImpl().updateTeam(team) + "  " + team);

		/*
		 * int row = new TeamDAOImpl().deleteTeamById(1008);
		 * System.out.println("deleted " + row + "records" );
		 */

		/*
		 * List<Team> teamList = new TeamDAOImpl().getAllTeams();
		 * 
		 * for (Team team : teamList) System.out.println(team);
		 */

		/*
		 * Team team = new Team(); team.setCity("Chandigarh"); team.setState("Punjab");
		 * team.setTeamName("PBKS");
		 * 
		 * System.out.println("Inserted " + new TeamDAOImpl().insertTeam(team) +
		 * " record");
		 */
	}

	@Override
	public int insertTeam(Team team) {

		int i = 0;
		try {

			Connection con = ConnectionFactory.getConnection();

			String query = "Insert into team (teamName, city, state) values (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, team.getTeamName());
			ps.setString(2, team.getCity());
			ps.setString(3, team.getState());

			i = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return i;

	}

	@Override
	public int deleteTeamById(int teamId) {
		int row = 0;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("Delete from team where teamid = ?");
			ps.setInt(1, teamId);

			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return row;

	}

	@Override
	public Team getTeamById(int teamId) {

		Team team = null;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from team where teamid = ?");
			ps.setInt(1, teamId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				team = new Team();
				team.setTeamId(rs.getInt(1));
				team.setTeamName(rs.getString(2));
				team.setCity(rs.getString(3));
				team.setState(rs.getString(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return team;
	}

	@Override
	public int updateTeam(Team team) {

		int row = 0;
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con
					.prepareStatement("update team set teamName = ?, city = ?, state = ? where teamid = ?");
			ps.setString(1, team.getTeamName());
			ps.setString(2, team.getCity());
			ps.setString(3, team.getState());
			ps.setInt(4, team.getTeamId());

			row = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return row;
	}

	@Override
	public List<Team> getAllTeams() {

		List<Team> teamList = new ArrayList<Team>();
		Team team;
		try {

			Connection con = ConnectionFactory.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from team");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				team = new Team();
				team.setTeamId(rs.getInt(1));
				team.setTeamName(rs.getString(2));
				team.setCity(rs.getString(3));
				team.setState(rs.getString(4));

				teamList.add(team);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return teamList;
	}

}
