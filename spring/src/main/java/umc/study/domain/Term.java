package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Term extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String title;

    @Column(nullable = false, columnDefinition = "VARCHAR(1000)")
    private String body;

    @Column(nullable = false, columnDefinition = "VARCHAR(5)")
    private Boolean essential;

  /*  @OneToMany(mappedBy = "term", cascade = CascadeType.ALL)
    private List<TermAgreement> termAgreementList = new ArrayList<>();*/
}