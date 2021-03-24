package com.codecool.chessopen;

import java.io.*;
import java.util.*;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName) {

        List<String> orderedResults = new ArrayList<>();
        Map<String, Integer> results = new HashMap<>();

        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            String line;
            while (fileReader.hasNextLine()) {
                line = fileReader.nextLine();
                String[] temp = line.split(",");
                int sum = 0;
                for (int i = 1; i < 6; i++) {
                    sum += Integer.parseInt(temp[i]);
                }
                results.put(temp[0], sum);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        results.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(stringIntegerEntry -> orderedResults.add(stringIntegerEntry.getKey()));

        return orderedResults;
    }

}
