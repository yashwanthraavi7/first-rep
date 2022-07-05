package ipl.beans;
import java.io.Serializable;

public class Team implements Serializable {
	
	/**
	 * 
	 */


	private int teamId;
	
	private String teamName;
	private String city;
	private String state;
	
	public Team() {
		super();
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", city=" + city + ", state=" + state + "]";
	}
	
	
	

}
