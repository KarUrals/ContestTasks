package kar.urals.skb.kontur.summer2023.sandbox.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> standings = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] info = str.split(" ");
            standings.put(info[0], Integer.parseInt(info[1]));
        }
        String lastMatch = sc.nextLine();
        String[] teams = lastMatch.split("-");
        String teamA = teams[0];
        String teamB = teams[1];
        sc.close();

        Map<String, Integer> teamAWinCaseStandings = new HashMap<>(standings);
        teamAWinCaseStandings.put(teamA, standings.get(teamA) + 3);
        int winCasePosition = findTeamPositionFromMap(teamAWinCaseStandings, teamA);

        Map<String, Integer> drawCaseStandings = new HashMap<>(standings);
        drawCaseStandings.put(teamA, standings.get(teamA) + 1);
        drawCaseStandings.put(teamB, standings.get(teamB) + 1);
        int drawCasePosition = findTeamPositionFromMap(drawCaseStandings, teamA);

        Map<String, Integer> teamBWinCaseStandings = new HashMap<>(standings);
        teamBWinCaseStandings.put(teamB, standings.get(teamB) + 3);
        int defeatCasePosition = findTeamPositionFromMap(teamBWinCaseStandings, teamA);

        System.out.println(winCasePosition + " " + drawCasePosition + " " + defeatCasePosition);
    }

    static int findTeamPositionFromMap(Map<String, Integer> standings, String teamName) {
        int teamPosition = 1;

        List<Map.Entry<String, Integer>> list = new ArrayList<>(standings.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()));

        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getKey().equals(teamName)) {
                break;
            }
            teamPosition++;
        }

        return teamPosition;
    }
}
