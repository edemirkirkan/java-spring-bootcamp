package edemirkirkan.homework2.qua.entity;

import edemirkirkan.homework2.dis.entity.DisDistrict;
import edemirkirkan.homework2.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "QUA_QUARTER")
@Getter
@Setter
public class QuaQuarter extends BaseEntity {
    @Id
    @SequenceGenerator(name = "QuaQuarter", sequenceName = "QUA_QUARTER_ID_SEQ")
    @GeneratedValue(generator = "QuaQuarter")
    private Long id;

    @Column(name = "NAME", length = 30, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DIS_DISTRICT")
    private DisDistrict disDistrict;
}
