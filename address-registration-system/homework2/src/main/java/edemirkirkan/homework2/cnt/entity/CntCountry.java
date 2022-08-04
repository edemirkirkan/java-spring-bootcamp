package edemirkirkan.homework2.cnt.entity;

import edemirkirkan.homework2.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="CNT_COUNTRY")
@Getter
@Setter
public class CntCountry extends BaseEntity {
    @Id
    @SequenceGenerator(name = "CntCountry", sequenceName = "CNT_COUNTRY_ID_SEQ")
    @GeneratedValue(generator = "CntCountry")
    private Long id;

    @Column(name = "NAME", length = 30, nullable = false)
    private String name;

    @Column(name = "CODE", length = 10, nullable = false, unique = true)
    private String code;
}
