package umc.study.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Qna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private BigInteger id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String title;

    @Column(nullable = false, columnDefinition = "VARCHAR(1000)")
    private String content;

    @Column(nullable = false, columnDefinition = "VARCHAR(10)")
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
