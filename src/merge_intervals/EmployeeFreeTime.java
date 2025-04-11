package merge_intervals;

//! Link: https://leetcode.ca/all/759.html

import java.util.*;

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class EmployeeFreeTime {
    public static void main(String[] args) {
        // Example input
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(Arrays.asList(new Interval(1, 3), new Interval(6, 7)));
        schedule.add(Arrays.asList(new Interval(2, 4)));
        schedule.add(Arrays.asList(new Interval(8, 9), new Interval(12, 14)));

        List<Interval> freeTime = employeeFreeTime(schedule);

        // Print output
        System.out.println("Employee Free Time:");
        for (Interval interval : freeTime) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }

    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allIntervals = new ArrayList<>();

        // Step 1: Flatten the schedule into a single list
        for (List<Interval> emp : schedule) {
            allIntervals.addAll(emp);
        }

        // Step 2: Sort intervals based on start time
        allIntervals.sort(Comparator.comparingInt(a -> a.start));

        List<Interval> merged = new ArrayList<>();
        Interval prev = allIntervals.get(0);
        merged.add(prev);

        for (Interval interval : allIntervals) {
            if (prev.end >= interval.start) {
                prev.end = Math.max(prev.end, interval.end);
            } else {
                prev = interval;
                merged.add(prev);
            }
        }

        // Step 4: Find gaps between merged intervals (free time)
        List<Interval> freeTime = new ArrayList<>();
        for (int i = 1; i < merged.size(); i++) {
            freeTime.add(new Interval(merged.get(i - 1).end, merged.get(i).start));
        }

        return freeTime;
    }
}
