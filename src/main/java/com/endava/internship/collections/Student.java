package com.endava.internship.collections;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

public class Student implements Comparable<Student>
{
    private String name;
    private LocalDate dateOfBirth;
    private String details;

    public Student(String name, LocalDate dateOfBirth, String details) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.details = details;
    }

    public String getName() { return name; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public String getDetails() { return details; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Student st = (Student) obj;
        return st.name.equals(name) && st.dateOfBirth == dateOfBirth
                && st.details.equals(details);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result *= prime + name.hashCode();
        result *= prime + dateOfBirth.getDayOfMonth();
        result *= prime + details.hashCode();
        return result;
    }

    @Override
    public int compareTo(Student st) {
        return st.name.equals(name) ? (st.dateOfBirth.isAfter(dateOfBirth)
                || st.dateOfBirth.equals(dateOfBirth)) ? -1
                : 0 : st.name.compareTo(name) > 0 ? -1 : 0;
    }

    @Override
    public String toString()
    {
        return "name: " + this.name + " birth date: "
                + this.dateOfBirth.toString() + " details: " + this.details;
    }
}
