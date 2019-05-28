package com.dev.Model;

import java.util.Date;
import java.util.HashMap;

public class Match {
	
	private int id;
	private int iplTeam1Id;
	private int iplTeam2Id;
	private int userId1;
	private int userId2;
	private String result;
	private Date dateOfMatch;
	private int teamId1;
	private int teamId2;
	private String status;
	
	HashMap<Integer, String> m = new HashMap<Integer, String>();
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTeamId1() {
		return teamId1;
	}
	public void setTeamId1(int teamId1) {
		this.teamId1 = teamId1;
	}
	
	public int getUserId2() {
		return userId2;
	}
	public void setUserId2(int userId2) {
		this.userId2 = userId2;
	}
	public int getTeamId2() {
		return teamId2;
	}
	public void setTeamId2(int teamId2) {
		this.teamId2 = teamId2;
	}
	public int getUserId1() {
		return userId1;
	}
	public void setUserId1(int userId1) {
		this.userId1 = userId1;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getDateOfMatch() {
		return dateOfMatch;
	}
	public void setDateOfMatch(Date dateOfMatch) {
		this.dateOfMatch = dateOfMatch;
	}
	public int getIplTeam1Id() {
		return iplTeam1Id;
	}
	public void setIplTeam1Id(int iplTeam1Id) {
		this.iplTeam1Id = iplTeam1Id;
	}
	public int getIplTeam2Id() {
		return iplTeam2Id;
	}
	public void setIplTeam2Id(int iplTeam2Id) {
		this.iplTeam2Id = iplTeam2Id;
	}
	
	
}
