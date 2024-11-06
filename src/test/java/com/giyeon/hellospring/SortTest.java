package com.giyeon.hellospring;

import java.util.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

public class SortTest {
    Sort sort;

    @BeforeEach
    public void beforeEach() {
        sort = new Sort();
        System.out.println(sort);
    }


    @Test
    public void sortTest1(){
        List<String> list = sort.sortList(Arrays.asList("a", "bbb", "cd"));
        Assertions.assertThat(list).isEqualTo(List.of("a", "cd", "bbb"));
    }

    @Test
    public void sortTest2(){
        List<String> list = sort.sortList(Arrays.asList("a", "bbb", "cd"));
        Assertions.assertThat(list).isEqualTo(List.of("a", "cd", "bbb"));
    }

    @Test
    public void sortTest3(){
        List<String> list = sort.sortList(Arrays.asList("a", "bbb", "cd"));
        Assertions.assertThat(list).isEqualTo(List.of("a", "cd", "bbb"));
    }


}
