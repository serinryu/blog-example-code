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

public class Profile1 {

   private Map<String,Answer> answers = new HashMap<>();
   private int score;
   private String name;

   public Profile1(String name) {
      this.name = name;
   }
   
   public String getName() {
      return name;
   }

   public void add(Answer answer) {
      answers.put(answer.getQuestionText(), answer);
   }
   
   public boolean matches(Criteria criteria) {
      score = 0;
      boolean kill = false;
      boolean anyMatches = false;

      for (Criterion criterion: criteria) {
//         Answer answer = answers.get(
//                 criterion.getAnswer().getQuestionText());
//         boolean match =
//                 criterion.getWeight() == Weight.DontCare ||
//                         answer.match(criterion.getAnswer());
         Answer answer = answerMatching(criterion); // Extract Method
         boolean match = criterion.matches(answer); // Extract Method
         if (!match && criterion.getWeight() == Weight.MustMatch) {  
            kill = true;
         }
         if (match) {         
            score += criterion.getWeight().getValue();
         }
         anyMatches |= match;
      }
      if (kill)       
         return false;
      return anyMatches;
   }

   // 추출한 이 메소드는 의미상 Criterion 클래스의 메소드로 가는 것이 적절하므로 이동했음
   //  public boolean matches(Criterion criterion, Answer answer){
   //     return criterion.getWeight() == Weight.DontCare || answer.match(criterion.getAnswer());
   //  }

   private Answer answerMatching(Criterion criterion){
      return answers.get(
              criterion.getAnswer().getQuestionText()
      );
   }

   public int score() {
      return score;
   }
}
