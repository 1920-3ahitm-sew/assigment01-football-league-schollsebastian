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
                league.addMatchResult(new Match());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printTable(List<Team> teams) {
    }
}
