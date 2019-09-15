package at.htl.football;

import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class TeamTest {
    @Test
    public void addMatch_team_is_home_team_and_won() {
        Team team = new Team("Bayern Munich");
        Match match = new Match("Bayern Munich", "Hoffenheim", 3, 1);

        team.addMatch(match);

        assertThat(team.getGoalsShot(), is(match.getHomeGoals()));
        assertThat(team.getGoalsReceived(), is(match.getGuestGoals()));
        assertThat(team.getPoints(), is(match.getHomePoints()));
        assertThat(team.getWins(), is(1));
        assertThat(team.getDraws(), is(0));
        assertThat(team.getDefeats(), is(0));
    }

    @Test
    public void addMatch_team_is_home_team_and_lost() {
        Team team = new Team("Bayern Munich");
        Match match = new Match("Bayern Munich", "Hoffenheim", 1, 3);

        team.addMatch(match);

        assertThat(team.getGoalsShot(), is(match.getHomeGoals()));
        assertThat(team.getGoalsReceived(), is(match.getGuestGoals()));
        assertThat(team.getPoints(), is(match.getHomePoints()));
        assertThat(team.getWins(), is(0));
        assertThat(team.getDraws(), is(0));
        assertThat(team.getDefeats(), is(1));
    }

    @Test
    public void addMatch_team_is_home_team_and_it_was_a_draw() {
        Team team = new Team("Bayern Munich");
        Match match = new Match("Bayern Munich", "Hoffenheim", 2, 2);

        team.addMatch(match);

        assertThat(team.getGoalsShot(), is(match.getHomeGoals()));
        assertThat(team.getGoalsReceived(), is(match.getGuestGoals()));
        assertThat(team.getPoints(), is(match.getHomePoints()));
        assertThat(team.getWins(), is(0));
        assertThat(team.getDraws(), is(1));
        assertThat(team.getDefeats(), is(0));
    }

    @Test
    public void addMatch_team_is_guest_team_and_won() {
        Team team = new Team("Bayern Munich");
        Match match = new Match("Hoffenheim", "Bayern Munich", 1, 3);

        team.addMatch(match);

        assertThat(team.getGoalsShot(), is(match.getGuestGoals()));
        assertThat(team.getGoalsReceived(), is(match.getHomeGoals()));
        assertThat(team.getPoints(), is(match.getGuestPoints()));
        assertThat(team.getWins(), is(1));
        assertThat(team.getDraws(), is(0));
        assertThat(team.getDefeats(), is(0));
    }

    @Test
    public void addMatch_team_is_guest_team_and_lost() {
        Team team = new Team("Bayern Munich");
        Match match = new Match("Hoffenheim", "Bayern Munich", 3, 1);

        team.addMatch(match);

        assertThat(team.getGoalsShot(), is(match.getGuestGoals()));
        assertThat(team.getGoalsReceived(), is(match.getHomeGoals()));
        assertThat(team.getPoints(), is(match.getGuestPoints()));
        assertThat(team.getWins(), is(0));
        assertThat(team.getDraws(), is(0));
        assertThat(team.getDefeats(), is(1));
    }

    @Test
    public void addMatch_team_is_guest_team_and_it_was_a_draw() {
        Team team = new Team("Bayern Munich");
        Match match = new Match("Hoffenheim", "Bayern Munich", 2, 2);

        team.addMatch(match);

        assertThat(team.getGoalsShot(), is(match.getGuestGoals()));
        assertThat(team.getGoalsReceived(), is(match.getHomeGoals()));
        assertThat(team.getPoints(), is(match.getGuestPoints()));
        assertThat(team.getWins(), is(0));
        assertThat(team.getDraws(), is(1));
        assertThat(team.getDefeats(), is(0));
    }

    @Test
    public void addMatch_team_is_neither_home_team_nor_guest_team() {
        Team team = new Team("Fortuna Dusseldorf");
        Match match = new Match("Bayern Munich", "Hoffenheim", 3, 1);

        assertThat(team.getGoalsShot(), is(0));
        assertThat(team.getGoalsReceived(), is(0));
        assertThat(team.getPoints(), is(0));
        assertThat(team.getWins(), is(0));
        assertThat(team.getDraws(), is(0));
        assertThat(team.getDefeats(), is(0));
    }

    @Test
    public void compareTo_team1_has_more_points() {
        Team team1 = new Team("Bayern Munich");
        Team team2 = new Team("Hoffenheim");
        Match match = new Match("Bayern Munich", "Hoffenheim", 3, 1);

        team1.addMatch(match);
        team2.addMatch(match);

        assertThat(team1.compareTo(team2), greaterThan(0));
    }

    @Test
    public void compareTo_team2_has_more_points() {
        Team team1 = new Team("Bayern Munich");
        Team team2 = new Team("Hoffenheim");
        Match match = new Match("Bayern Munich", "Hoffenheim", 1, 3);

        team1.addMatch(match);
        team2.addMatch(match);

        assertThat(team1.compareTo(team2), lessThan(0));
    }

    @Test
    public void compareTo_team1_has_greater_goal_difference() {
        Team team1 = new Team("Bayern Munich");
        Team team2 = new Team("Hoffenheim");
        Match match1 = new Match("Bayern Munich", "Hoffenheim", 1, 3);
        Match match2 = new Match("Bayern Munich", "Hoffenheim", 4, 1);

        team1.addMatch(match1);
        team1.addMatch(match2);
        team2.addMatch(match1);
        team2.addMatch(match2);

        assertThat(team1.compareTo(team2), greaterThan(0));
    }

    @Test
    public void compareTo_team2_has_greater_goal_difference() {
        Team team1 = new Team("Bayern Munich");
        Team team2 = new Team("Hoffenheim");
        Match match1 = new Match("Bayern Munich", "Hoffenheim", 1, 3);
        Match match2 = new Match("Bayern Munich", "Hoffenheim", 2, 1);

        team1.addMatch(match1);
        team1.addMatch(match2);
        team2.addMatch(match1);
        team2.addMatch(match2);
        assertThat(team1.compareTo(team2), lessThan(0));
    }

    @Test
    public void compareTo_teams_have_equal_points_and_goal_difference() {
        Team team1 = new Team("Bayern Munich");
        Team team2 = new Team("Hoffenheim");
        Match match1 = new Match("Bayern Munich", "Hoffenheim", 1, 3);
        Match match2 = new Match("Bayern Munich", "Hoffenheim", 3, 1);

        team1.addMatch(match1);
        team1.addMatch(match2);
        team2.addMatch(match1);
        team2.addMatch(match2);

        assertThat(team1.compareTo(team2), is(0));
    }
}