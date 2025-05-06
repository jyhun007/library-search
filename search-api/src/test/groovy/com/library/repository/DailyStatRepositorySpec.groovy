package com.library.repository

import com.library.entity.DailyStat
import com.library.feign.NaverClient
import jakarta.persistence.EntityManager
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

import java.time.LocalDateTime

@ActiveProfiles("test")
@DataJpaTest
class DailyStatRepositorySpec extends Specification {

    @Autowired
    DailyStatRepository dailyStatRepository

    @Autowired
    EntityManager entityManager

    @SpringBean
    NaverClient naverClient = Mock()//에러를 피하기 위한 목적

    def "저장후 조회가 된다."() {
        given:
        def givenQuery = "HTTP"

        when:
        def dailyStat = new DailyStat(givenQuery, LocalDateTime.now())
        def saved = dailyStatRepository.saveAndFlush(dailyStat)

        then: "실제 저장이 된다"
        saved.id != null

        when:
        entityManager.clear()
        def result = dailyStatRepository.findById(saved.id)

        then:
        verifyAll {
            result.isPresent()
            result.get().query == givenQuery
        }

    }
}
