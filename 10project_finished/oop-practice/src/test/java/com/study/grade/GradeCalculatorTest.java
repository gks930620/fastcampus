package com.study.grade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
 * • MVC패턴(Model-View-Controller) 기반으로 구현한다.
 * • 일급 컬렉션 사용
 */
public class GradeCalculatorTest {

    // 학점계산기 도메인 : 이수한 과목, 학점 계산기    객체먼저 생각
    // 이수한 과목 : 객체지향프로그래밍 , 자료구조, 중국어회화 ==> 과목(코스)  클래스    정적인 타입인 클래스로 추상화

    // 이수한 과목을 전달하여 평균학점 계산 요청 ----> 학점계산기  : 학점수 x 교과목 평점의 합계 --> 과목 일급콜렉션에게
    //                                                      : 수강신청 총학점 수         --> 과목 일급콜렉션에게 작업위임
    //                                                      : 학점계산기는 이 값을 나누기만함 
    @DisplayName("평균 학점을 계산한다.")
    @Test
    void calculateGradeTest(){
        List<Course> courses=List.of(new Course("OOP",3,"A+")
        ,new Course("자료구조" , 3 , "A+"));
        GradeCalculator gradeCalculator=new GradeCalculator(courses);
        double gradeResult=gradeCalculator.calculateGrade();
        assertThat(gradeResult).isEqualTo(4.5);
    }


}
