/***
 * Excerpted from "Pragmatic Unit Testing in Java with JUnit",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/utj2 for more book information.
***/
package com.pragmatic.iloveyouboss;

import java.util.HashMap;
import java.util.Map;

/**
 * PROFILE 5 + MatchSet
 * Let’s extract the code related to the matches() responsibility to another class, named MatchSet
 */

public class Profile5 {
   private Map<String,Answer> answers = new HashMap<>();
   private String name;

   public Profile5(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void add(Answer answer) {
      answers.put(answer.getQuestionText(), answer);
   }

   // Use MatchSet instance to check matching and get score
   public MatchSet getMatchSet(Criteria criteria) {
      return new MatchSet(answers, criteria);
   }

   @Override
   public String toString() {
      return name;
   }

}