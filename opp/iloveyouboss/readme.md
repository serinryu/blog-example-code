
# Refactoring Profile class 

[📝 Description](https://serinryu.medium.com/tdd-refactoring-pragmatic-unit-testing-in-java-with-junit-3d8cd88db460)

Employers and employees both create profiles by answering a series of multiple choice or yes-no questions. The site scores profiles based on criteria from the other party and shows the best potential matches from the perspective of both employee and employer.

However, Profile class code need Refactoring, because it’s not easy to read. Conditional expressions often read poorly, particularly when they are complex. 

Therefore, our goal is reduce complexity in the matches() method so that we can readily
understand what it’s responsible for—its *policy*.

> HOW? By extracting detailed bits of logic to separate methods or classes

- Profile 0 : Original
- Profile 1 : Extract inner methods (`answerMatching()`, `matches()`)
- Profile 2 : Extract inner methods (`calculateScore()`)
- Profile 3 : Extract inner methods (`doesNotMeetAnyMustMatchCriterion()`)
- Profile 4 : Extract inner methods (`anyMatch()`)
  - After refactoring of the matches() method, each of anyMatches(), calculateScore(), and doesNotMeetAnyMustMatchCriterion()iterates through the criterion collection. Three new loops—we have potentially quadrupled the time to execute the matches() method. Yes, performance is important. But is the refactored code now incapable of meeting performance expectations? Invest in keeping the code clean instead of wasting time with premature optimization efforts, If performance isn’t an immediate problem. 
  - Still, The Profile class violates the **Single Responsibility Principle (SRP)** of object- oriented class design, which tells us that classes should have only one reason to change.
- Profile 5 : Extract `matches()` responsibility to another class, named `MatchSet` class. (Profile + MatchSet)
  - Now, Profile class has only 1 responsibility. Another responsibility will be handled by `MatchSet` class.

---

Reference :  "Pragmatic Unit Testing in Java with JUnit", Chap 02,08,09
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 


[Source code](https://github.com/gilbutITbook/006814/tree/master/iloveyouboss_big-1)
