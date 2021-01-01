package com.zj.utils;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class GenerateUtilTest {

    @Test
    void genTel() {
        System.out.println(GenerateUtil.genTel());
    }

    @Test
    void genSex() {
        System.out.println(GenerateUtil.genSex());
    }

    @Test
    void genAge() {
        System.out.println(GenerateUtil.genAge());
    }

    @Test
    void testGenAge() {
        System.out.println(GenerateUtil.genAge(45, 25));
    }

    @Test
    void randomUUID() {
        System.out.println(GenerateUtil.genUUID());
    }

    @Test
    void genChineseName() {
        for (int i = 0; i < 40; i++) {
            System.out.println(GenerateUtil.genChineseName());
        }
    }

    @Test
    void genDate() throws ParseException {
        Date parse = new SimpleDateFormat("yyyy-MM-dd").parse("2011-1-13");

        System.out.println(GenerateUtil.genRandomDate(10));
        System.out.println(GenerateUtil.genRandomDate(10, parse));
    }
}