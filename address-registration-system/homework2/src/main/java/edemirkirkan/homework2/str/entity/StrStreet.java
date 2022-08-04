package edemirkirkan.homework2.str.entity;

import edemirkirkan.homework2.gen.entity.BaseEntity;
import edemirkirkan.homework2.qua.entity.QuaQuarter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "STR_STREET")
@Getter
@Setter
public class StrStreet extends BaseEntity {
    @Id
    @SequenceGenerator(name = "StrStreet", sequenceName = "STR_STREET_ID_SEQ")
    @GeneratedValue(generator = "StrStreet")
    private Long id;

    @Column(name = "NAME", length = 30, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_QUA_QUARTER")
    private QuaQuarter quaQuarter;
}
