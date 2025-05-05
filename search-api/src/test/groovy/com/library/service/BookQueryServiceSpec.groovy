package com.library.service

import com.library.controller.response.PageResult
import com.library.controller.response.SearchResponse
import com.library.repository.BookRepository
import spock.lang.Specification

class BookQueryServiceSpec extends Specification {
    BookRepository bookRepository = Mock(BookRepository)

    BookQueryService bookService

    void setup(){
        bookService = new BookQueryService(bookRepository)
    }

    def "search시 인자가 그대로 넘어간다."() {
        given:
        def givenQuery = "HTTP완벽가이드"
        def givenPage = 1
        def givenSize = 10

        when:
        bookService.search(givenQuery,givenPage,givenSize)

        then:
        1 * bookRepository.search(*_) >> {
            String query , int page, int size ->
                assert query == givenQuery
                assert page == givenPage
                assert size == givenSize

        }
    }
}
