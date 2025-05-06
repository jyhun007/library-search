package com.library.service

import com.library.entity.DailyStat
import spock.lang.Specification

class BookApplicationServiceSpec extends Specification {
    BookQueryService bookQueryService = Mock(BookQueryService)
    DailyStatCommandService dailyStatCommandService = Mock(DailyStatCommandService)

    BookApplicationService bookApplicationService;

    void setup() {
        bookApplicationService = new BookApplicationService(bookQueryService, dailyStatCommandService)
    }


    def "search메서드 호출시 검색겨로가를 반환하면서 통계데이터를 저장한다."() {
        given:
        def givenQuery="HTTP"
        def givenSize = 10
        def givenPage = 1


        when:
        bookApplicationService.search(givenQuery, givenPage, givenSize)

        then:
        1 * bookQueryService.search(*_) >> {
            String query, int page, int size ->
                assert query == givenQuery
                assert page == givenPage
                assert size == givenSize
        }

        and:
        1* dailyStatCommandService.save(*_) >> {
            DailyStat dailyStat ->
                assert dailyStat.query == givenQuery
        }
    }
}
