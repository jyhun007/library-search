package com.library.util

import spock.lang.Specification

import java.time.LocalDate

class DateUtilsSpec extends Specification {

    DateUtils dateUtils

    void setup(){
        dateUtils = new DateUtils()
    }

    def "문자열yyyyMMdd가 LocalDate 객체로 변환된다"() {
        given:
        def givenDateString = '20200101'
        def expectedLocalDate = LocalDate.of(2020,1,1)

        when:
        def result = dateUtils.parseYYYYMMDD(givenDateString)

        then:
        verifyAll {
            result == expectedLocalDate
        }
    }
}
