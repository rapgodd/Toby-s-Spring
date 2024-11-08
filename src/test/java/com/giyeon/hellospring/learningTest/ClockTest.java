package com.giyeon.hellospring.learningTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockTest {
     //Clock을 이용해서 LocalDateTime.now가 잘 작동하는가?
    @Test
    void test(){
        Clock clock = Clock.systemDefaultZone();
        LocalDateTime now1 = LocalDateTime.now(clock);
        LocalDateTime now2 = LocalDateTime.now(clock);
        Assertions.assertThat(now1).isNotEqualTo(now2);
    }

    // Clock을 Test에서 사용할 때 내가 원하는 시간을 지정해서 현재 시간을 가져오게 할 수 있는가?
    @Test
    void fixedClock() {
        Clock clock = Clock.fixed(Instant.now(), ZoneId.systemDefault());

        LocalDateTime now1 = LocalDateTime.now(clock);
        LocalDateTime now2 = LocalDateTime.now(clock);
        LocalDateTime now3 = LocalDateTime.now(clock).plusHours(1);
        Assertions.assertThat(now1).isEqualTo(now2);
        Assertions.assertThat(now3).isEqualTo(now1.plusHours(1));

    }

}
