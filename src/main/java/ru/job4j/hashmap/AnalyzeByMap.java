package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double score = 0.0;
        int subjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                subjects++;
            }
        }
        return score / subjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> info = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0.0;
            int subjects = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
                subjects++;
            }
            info.add(new Label(pupil.name(), score / subjects));
        }
        return info;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        List<Label> score = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.put(subject.name(), temp.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : temp.keySet()) {
            score.add(new Label(key, (double) temp.get(key) / pupils.size()));
        }
        return score;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> info = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0.0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            info.add(new Label(pupil.name(), score));
            info.sort(Comparator.naturalOrder());
        }
        return info.get(info.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        List<Label> score = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                temp.put(subject.name(), temp.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : temp.keySet()) {
            score.add(new Label(key, (double) temp.get(key)));
            score.sort(Comparator.naturalOrder());
        }
        return score.get(score.size() - 1);
    }
}
