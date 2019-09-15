package at.htl.football;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class LeagueTest {
    @Test
    public void teams_dont_exist_yet() {
        League league = new League();
        league.addMatchResult(new Match("Bayern Munich", "Hoffenheim", 3, 1));

        assertThat(league.getTable().get(0).getPoints(), is(3));
        assertThat(league.getTable().get(1).getPoints(), is(0));
    }

    @Test
    public void teams_exist() {
        League league = new League();
        league.addMatchResult(new Match("Bayern Munich", "Hoffenheim", 3, 1));
        league.addMatchResult(new Match("Bayern Munich", "Hoffenheim", 2, 2));

        assertThat(league.getTable().get(0).getPoints(), is(4));
        assertThat(league.getTable().get(1).getPoints(), is(1));
    }
}