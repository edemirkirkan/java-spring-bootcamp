package edemirkirkan.homework2.add.entity;

import edemirkirkan.homework2.gen.entity.BaseEntity;
import edemirkirkan.homework2.str.entity.StrStreet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="ADD_ADDRESS")
@Getter
@Setter
public class AddAddress extends BaseEntity {
    @Id
    @SequenceGenerator(name = "AddAddress", sequenceName = "ADD_ADDRESS_ID_SEQ")
    @GeneratedValue(generator = "AddAddress")
    private Long id;

    @Column(name = "BUILDING_NO", length = 10)
    private String buildingNo;

    @Column(name = "FLAT_NO", length = 10)
    private String flatNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_STR_STREET")
    private StrStreet strStreet;
}
