package com.spring.mvc.MVC03;

import com.spring.mvc.MVC03.entity.Score;
import com.spring.mvc.MVC03.repository.ScoreRepository;
import com.spring.mvc.MVC03.repository.ScoreRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreRepositoryTest {
    ScoreRepository repository = new ScoreRepositoryImpl();
    // 여기서는 테스트 대상인 ScoreRepositoryImpl 객체를 생성 (new)
    // 그러나 스프링은 IoC 패턴을 위해 DI 주입이 원칙임

    @Test
    public void ScoreRepositoryStaticVarTest(){
        // 접근 제한자가 public으로 풀려있는 동안만 실행 가능
        //System.out.println(ScoreRepositoryImpl.scoreMap);
        //System.out.println(ScoreRepositoryImpl.sequence);
    }

    // TDD 방법
    // 1. 원본 클래스에 원하는 기능을 구현하지는 말고 선언만 해 둔다.
    // 2. 테스트 코드 내부에 원하는 기능대로 작성되었을때 어떤 결과가 나올지 단언해둔다. 아직 기능이 만들어진 상태가 아니므로 테스트는 통과되지 못한다.
    // 3. 원본 클래스의 기능을 구현하면서 테스트가 통과될 때까지 계속 테스트 해본다. (테스트 먼저 작성 -> 수정하며 기능 구현)

    @Test
    public void findAllTest(){
        // given (테스트를 위해 사전에 설정해야 하는 데이터를 선언하는 구간)

        // when (테스트 대상 메서드를 실행하는 구간으로, 보통 한 줄로 작성함)
        List<Score> result = repository.findAll();

        // then (테스트 결과가 이렇게 나올것이다 라는 단언을 합니다.)
        // 나는 result 내부에 3개의 Score가 있다고 단언한다. scoreMap에 사전설정으로 3개의 데이터를 넣었으므로, 3개가 나와야 정상인 상황
        // System.out.println(result.size() == 3);
        assertEquals(3, result.size());
    }

    @Test
    @DisplayName("저장소에서 2번 유저를 가져와서 이름과 국어성적 비교")
    public void findByStudentNumberTest(){
        // given (2번학생 정보가 실제 정보와 일치하는지 체크할 예정임)
        int studentNumber = 2;
        // when (2번 학생정보를 넣어 findByStudentNumber를 호출하고, 결과는 result에 저장
        Score result = repository.findByStudentNumber(studentNumber);
        // then (단언부에는 2개 이상의 단언문이 들어가도 상관 없음)
        // 2번유저를 얻어왔으므로, getter로 국어성적 조사시 33점일것이다.
        assertEquals(33, result.getKorScore());
        // 2번유저를 얻어왔으므로, getter로 이름 조사시 "이자바" 일것이다.
        assertEquals("이부트", result.getName());
    }

    @Test
    @DisplayName("없는 번호로 조회시 null이어야함.")
    public void notFindByStudentNumberTest(){
        // given
        int studentNumber = 99;
        // when
        Score result = repository.findByStudentNumber(studentNumber);
        //then
        assertNull(result);// 대상 변수가 null이면 통과, 아니면 실패
    }

    @Test
    @DisplayName("새로운 성적정보를 저장하면 전체 데이터의 개수는 4개가 된다.")
    public void saveTest(){
        // given
        Score score= new Score();
        score.setName("티디디");
        score.setKorScore(100);
        score.setEngScore(70);
        score.setMathScore(80);
        // when
        boolean boolResult = repository.save(score);
        List<Score> result = repository.findAll();// 저장한 후 전체 데이터 가져오기
        // then
        assertEquals(4, result.size());
        assertTrue(boolResult); // 실행이 잘 되면 true, 뭔가 오류나면 false
    }

    @Test
    @DisplayName("2번 학생을 삭제하면 남은 총 인원은 2명이 된다.")
    public void deleteByStudentNumberTest(){
        // given
        int studentNumber = 2;
        // when
        boolean result = repository.deleteByStudentNumber(studentNumber);
        List<Score> scoreList = repository.findAll();
        Score score = repository.findByStudentNumber(studentNumber);
        // then
        assertEquals(2, scoreList.size());
        assertTrue(result); // 삭제 성공시 true
    }

}
