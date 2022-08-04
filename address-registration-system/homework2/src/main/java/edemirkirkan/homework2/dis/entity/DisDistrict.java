package edemirkirkan.homework2.dis.entity;

import edemirkirkan.homework2.cty.entity.CtyCity;
import edemirkirkan.homework2.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="DIS_DISTRICT")
@Getter
@Setter
public class DisDistrict extends BaseEntity {
    @Id
    @SequenceGenerator(name = "DisDistrict", sequenceName = "DIS_DISTRICT_ID_SEQ")
    @GeneratedValue(generator = "DisDistrict")
    private Long id;

    @Column(name = "NAME", length = 30, nullable = false)
    private String name;

    @Column(name = "POSTAL_CODE", length = 30, nullable = false)
    private String postalCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CTY_CITY")
    private CtyCity ctyCity;
}
