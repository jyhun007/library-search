package com.library.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "daily_stat")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class DailyStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "query")
    private String query;

    public DailyStat(String query, LocalDateTime eventDateTime) {
        this.query = query;
        this.eventDateTime = eventDateTime;
    }

    @Column(name = "event_date_time")
    private LocalDateTime eventDateTime;

}
