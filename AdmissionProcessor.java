package ru.evstafeva.applicants;

import java.util.*;

public class AdmissionProcessor {
    private Map<String, int[]> applicants;
    private List<String> admitted;

    public AdmissionProcessor() {
        this.applicants = new LinkedHashMap<>();
        this.admitted = new ArrayList<>();
    }

    public void addApplicant(String surname, String name, int score1, int score2, int score3) {
        String fullName = surname + " " + name;
        applicants.put(fullName, new int[]{score1, score2, score3});
    }

    private boolean checkAdmission(int[] scores) {
        if (scores[0] < 30 || scores[1] < 30 || scores[2] < 30) {
            return false;
        }
        return (scores[0] + scores[1] + scores[2]) >= 140;
    }


    public void processAdmission() {
        admitted.clear(); // Очищаем список перед обработкой

        for (Map.Entry<String, int[]> entry : applicants.entrySet()) {
            String fullName = entry.getKey();
            int[] scores = entry.getValue();

            if (checkAdmission(scores)) {
                admitted.add(fullName);
            }
        }
    }

    public List<String> getAdmitted() {
        return new ArrayList<>(admitted); // Возвращаем копию
    }

    public Map<String, int[]> getAllApplicants() {
        return new LinkedHashMap<>(applicants); // Возвращаем копию
    }

}