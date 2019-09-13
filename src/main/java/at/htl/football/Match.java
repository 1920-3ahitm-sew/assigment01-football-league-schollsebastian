package at.htl.football;

public class Match {
    private String homeName;
    private String guestName;
    private int homeGoals;
    private int guestGoals;

    public Match() {
    }

    public String getHomeName() {
        return homeName;
    }

    public String getGuestName() {
        return guestName;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getGuestGoals() {
        return guestGoals;
    }

    public int getHomePoints() {
        return -1;
    }

    public int getGuestPoints() {
        return -1;
    }
}
