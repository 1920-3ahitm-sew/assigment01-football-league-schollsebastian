package at.htl.football;

import java.util.*;

public class League {
    private List<Team> teams = new ArrayList<>();

    public void addMatchResult(Match match) {
        findOrCreateTeam(match.getHomeName()).addMatch(match);
        findOrCreateTeam(match.getGuestName()).addMatch(match);
    }

    private Team findOrCreateTeam(String teamName) {
//        int start = 0;
//        int end = teams.size() - 1;
//
//        while (start <= end) {
//            int mid = (start + end) / 2;
//
//            if (teams.get(mid).getName().equals(teamName)) {
//                return teams.get(mid);
//            } else {
//                if (teams.get(mid).getName().compareTo(teamName) > 0) {
//                    end = mid - 1;
//                } else {
//                    start = mid + 1;
//                }
//            }
//        }

        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }

        Team newTeam = new Team(teamName);
        teams.add(newTeam);
        return newTeam;
    }

    public List<Team> getTable() {
        teams.sort(Collections.reverseOrder());
        return teams;
    }
}
