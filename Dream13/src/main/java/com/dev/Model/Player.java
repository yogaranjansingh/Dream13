package com.dev.Model;

public class Player {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private int iplTeamId;
	public int getIplTeamId() {
		return iplTeamId;
	}
	public void setIplTeamId(int iplTeamId) {
		this.iplTeamId = iplTeamId;
	}
	private String name;
	private String team;
	private boolean selected;
	private boolean isCaptain;
	private boolean isViceCaptain;
	public boolean isCaptain() {
		return isCaptain;
	}
	public void setCaptain(boolean isCaptain) {
		this.isCaptain = isCaptain;
	}
	public boolean isViceCaptain() {
		return isViceCaptain;
	}
	public void setViceCaptain(boolean isViceCaptain) {
		this.isViceCaptain = isViceCaptain;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	private int price;
	private int pointsScored;
	private int pointsThisSeason;
	private String playerType;
	private String imageUrl;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPointsScored() {
		return pointsScored;
	}
	public void setPointsScored(int pointsScored) {
		this.pointsScored = pointsScored;
	}
	public int getPointsThisSeason() {
		return pointsThisSeason;
	}
	public void setPointsThisSeason(int pointsThisSeason) {
		this.pointsThisSeason = pointsThisSeason;
	}
	public String getPlayerType() {
		return playerType;
	}
	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
