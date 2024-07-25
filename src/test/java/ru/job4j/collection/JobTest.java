package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    void whenJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Cleaning", 2),
                new Job("TV", 3),
                new Job("Sport", 1)
        );
        Collections.sort(jobs, new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Cleaning", 2),
                new Job("Sport", 1),
                new Job("TV", 3)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Cleaning", 2),
                new Job("TV", 3),
                new Job("Sport", 1)
        );
        Collections.sort(jobs, new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("TV", 3),
                new Job("Sport", 1),
                new Job("Cleaning", 2)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("TV", 3),
                new Job("Cooking", 1),
                new Job("Sport", 2)
        );
        Collections.sort(jobs, new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Cooking", 1),
                new Job("Sport", 2),
                new Job("TV", 3)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("TV", 3),
                new Job("Cooking", 1),
                new Job("Sport", 2)
        );
        Collections.sort(jobs, new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("TV", 3),
                new Job("Sport", 2),
                new Job("Cooking", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobDescByNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenJobAscByNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}
