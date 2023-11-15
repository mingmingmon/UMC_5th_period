package umc.study.domain;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.mapping.MemberAgree;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Terms extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String title;

    private String body;

    private Boolean optional;

    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();
}