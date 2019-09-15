package at.htl.football;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class MatchTest {
    @Test
    public void home_team_wins() {
        Match match = new Match("Bayern Munich", "Hoffenheim", 3, 1);

        assertThat(match.getHomePoints(), is(3));
        assertThat(match.getGuestPoints(), is(0));
    }
    @Test
    public void guest_team_wins() {
        Match match = new Match("Bayern Munich", "Hoffenheim", 1, 3);

        assertThat(match.getHomePoints(), is(0));
        assertThat(match.getGuestPoints(), is(3));
    }

    @Test
    public void draw() {
        Match match = new Match("Bayern Munich", "Hoffenheim", 2, 2);

        assertThat(match.getHomePoints(), is(1));
        assertThat(match.getGuestPoints(), is(1));
    }
}