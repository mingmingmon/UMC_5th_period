package umc.study.domain.mapping;


import lombok.*;
import umc.study.domain.Member;
import umc.study.domain.Term;

import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class TermAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private BigInteger id;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean agreement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private Term term;

}