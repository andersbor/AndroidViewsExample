package dk.easj.anbo.viewsexample;

import java.io.Serializable;

public class Person implements Serializable {
    // better: implement Parcelable, Android Notes for Professionals, chapter 60
    public enum Gender {
        Male, Female
    } // This is a type!

    private String name;
    private String country;
    private Gender gender; // This is a field
    private boolean news;

    // Serializable classes must have a no-arg constructor
    public Person() {
    }

    public Person(String name, String country, Gender gender, boolean news) {
        this.name = name;
        this.country = country;
        this.gender = gender;
        this.news = news;
    }

    // Property: get+set
    // Java has no special property syntax
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isNews() {
        return news;
    }

    public void setNews(boolean news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                ", news=" + news +
                '}';
    }
}
