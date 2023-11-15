package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;
import umc.study.domain.mapping.FoodLike;
import umc.study.domain.mapping.MissionProgress;
import umc.study.domain.mapping.TermAgreement;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, columnDefinition = "BIGINT")
    private BigInteger user_id;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String password;

    @Column(nullable = false, length = 20)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String address;

    private Date brith_date;

    private Integer point;

    @Column(nullable = false, columnDefinition = "VARCHAR(15)")
    private String Phone_number;

    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private SocialType socialType;

    private LocalDate inactiveDate;


    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<TermAgreement> termAgreementList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<FoodLike> foodLikeList = new ArrayList<>();

/*    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();*/

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MissionProgress> memberMissionList = new ArrayList<>();
}