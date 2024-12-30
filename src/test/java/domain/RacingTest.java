package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class RacingTest {

    @DisplayName("레이싱 게임 성공")
    @Test
    void startThenCorrect() {
        // given
        Racing racing = new Racing();
        // when
        String result = racing.start("a, b", 3);
        // then
        assertTrue(result.contains("가 최종 우승했습니다."));
    }
}