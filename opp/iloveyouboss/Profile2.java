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

public class Profile2 {

   private Map<String,Answer> answers = new HashMap<>();
   private int score;
   private String name;

   public Profile2(String name) {
      this.name = name;
   }

   public String getName() {
      return name;
   }

   public void add(Answer answer) {
      answers.put(answer.getQuestionText(), answer);
   }

   public boolean matches(Criteria criteria) {
//      score = 0;
      calculateScore(criteria);
      boolean kill = false;
      boolean anyMatches = false;

      for (Criterion criterion: criteria) {
         boolean match = criterion.matches(answerMatching(criterion));
         if (!match && criterion.getWeight() == Weight.MustMatch) {
            kill = true;
         }
//         if (match) {
//            score += criterion.getWeight().getValue();
//         }
         anyMatches |= match;
      }
      if (kill)
         return false;
      return anyMatches;
   }

   /**
    * score field => It calculates the total score by summing the weights of matching criteria.
    */
   private void calculateScore(Criteria criteria){
      score = 0;
      for(Criterion criterion : criteria){
         if (criterion.matches(answerMatching(criterion))){
            score += criterion.getWeight().getValue();
         }
      }
   }

   private Answer answerMatching(Criterion criterion){
      return answers.get(
              criterion.getAnswer().getQuestionText()
      );
   }

   public int score() {
      return score;
   }
}
