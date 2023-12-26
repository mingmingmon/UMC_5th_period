package umc.study.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Ceo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(20)")
    private String password;

    private String name;

    @Column(nullable = false, columnDefinition = "VARCHAR(15)")
    private String phone_number;

    @OneToMany(mappedBy = "ceo", cascade = CascadeType.ALL)
    private List<Store> storeList = new ArrayList<>();

}
