package at.htl.football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        League league = new League();

        try {
            List<String> results = Files.readAllLines(Paths.get("bundesliga-1819.csv"));

            for (int i = 1; i < results.size(); i++) {
                String[] match = results.get(i).split(";");
                league.addMatchResult(new Match(match[1], match[2], Integer.parseInt(match[3]), Integer.parseInt(match[4])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        printTable(league.getTable());
    }

    private static void printTable(List<Team> teams) {
        System.out.printf("%-20s%5s%5s%5s%5s%5s%5s%5s%n", "Team", "Pts", 'W', 'D', 'L', "GF", "GA", "GD");

        for (Team team : teams) {
            System.out.printf("%-20s%5d%5d%5d%5d%5d%5d%5d%n", team.getName(), team.getPoints(), team.getWins(), team.getDraws(), team.getDefeats(),
                    team.getGoalsShot(), team.getGoalsReceived(), team.getGoalDifference());
        }

        System.out.println("\n\nPts...Points, W...Won, D...Drawn, L...Lost\n" +
                "GF...Goals for, GA...Goals against, GD...Goal difference");
    }
}
