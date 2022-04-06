/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author leith
 */
public class Team {
    private int id;
    private String TeamName;
    private String Description;

    public Team(int id, String TeamName, String Description) {
        this.id = id;
        this.TeamName = TeamName;
        this.Description = Description;
    }

    public Team(String TeamName, String Description) {
        this.TeamName = TeamName;
        this.Description = Description;
    }

    public Team() {
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return TeamName;
    }

    public String getDescription() {
        return Description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Team{" + "id=" + id + ", TeamName=" + TeamName + ", Description=" + Description + '}';
    }
    
    
}
