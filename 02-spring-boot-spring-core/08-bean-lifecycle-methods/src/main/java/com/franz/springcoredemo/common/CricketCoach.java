package com.franz.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // Define our init method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff(): " +getClass().getSimpleName());
    }

    // Define our destroy method
    @PreDestroy
    public void doMyCleanUpStuff() {
        System.out.println("In doMyCleanUpStuff(): " +getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "Practice fast bowling for 15 minutes.";
    }

}
