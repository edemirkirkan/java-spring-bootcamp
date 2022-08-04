package edemirkirkan.homework2.cty.entity;

import edemirkirkan.homework2.cnt.entity.CntCountry;
import edemirkirkan.homework2.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="CTY_CITY")
@Getter
@Setter
public class CtyCity extends BaseEntity {
    @Id
    @SequenceGenerator(name = "CtyCıty", sequenceName = "CTY_CITY_ID_SEQ")
    @GeneratedValue(generator = "CtyCıty")
    private Long id;

    @Column(name = "NAME", length = 30, nullable = false)
    private String name;

    @Column(name = "CODE", length = 10, nullable = false)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CNT_COUNTRY")
    private CntCountry cntCountry;
}
