package at.htl.football;

public class Team implements Comparable<Team> {
    private String name;
    private int points;
    private int wins;
    private int draws;
    private int defeats;
    private int goalsShot;
    private int goalsReceived;

    public Team() {
    }

    public void addMatch(Match match) {

    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public int getGoalDifference() {
        return -1;
    }

    @Override
    public int compareTo(Team o) {
        return 0;
    }
}
