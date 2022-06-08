package test;

import com.github.javafaker.Faker;

import java.util.Random;

public class TestData {
    Faker faker = new Faker();


    public String getName() {
        return faker.name().firstName();
    }
    public String getLastName() {
        return faker.name().lastName();
    }
    public String getUserEmail() {
        return faker.internet().emailAddress();
    }
    public String getUserPhone() {
        String phone = Integer.toString(getRandomInt(1000000000,2000000000));
        return phone;
    }
    public String getUserAddress() {
        return faker.address().fullAddress();
    }

    public String getUserSex() {
        String [] sex  ={"Male","Female","Other"};
        return sex[getRandomInt(0,2)];
    }

    public int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public String getUserHobbies() {
        String [] hobbies  ={"Sports","Reading","Music"};
        return hobbies[getRandomInt(0,2)];
    }

    public String getUserSubject() {
        String [] subject  ={"Chemistry","Hindi","English"};
        return subject[getRandomInt(0,2)];
    }

    public String getUserState() {
        String [] subject  ={"NCR","Uttar Pradesh","Haryana","Rajasthan"};
        return subject[getRandomInt(0,3)];
    }

    public String getUserCity(String state) {
        String [] NCR  ={"Delhi","Gurgaon","Noida"};
        String [] Uttar_Pradesh  ={"Agra","Lucknow","Merrut"};
        String [] Haryana  ={"Karnal","Panipat"};
        String [] Rajasthan  ={"Jaipur","Jaiselmer"};
        String ret =null;

        switch (state){
            case "NCR":
                ret = NCR[getRandomInt(0,2)];
                break;
            case "Uttar Pradesh":
                ret = Uttar_Pradesh[getRandomInt(0,2)];
                break;
            case "Haryana":
                ret = Haryana[getRandomInt(0,1)];
                break;
            case "Rajasthan":
                ret = Rajasthan[getRandomInt(0,1)];
                break;
        }

        return ret;
    }

    public String getRandomYear() {
        String year = Integer.toString(getRandomInt(1980,2000));
        return year;
    }
    public String getRandomDay() {
        String day = Integer.toString(getRandomInt(1,28));
        return day;
    }
    public String getRandomMonth() {
        String[] month = {"January","February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        return month[getRandomInt(0,11)];
    }
    public String getFile() {
        String file ="a.png";
        return file;
    }
}
