package com.edemirkirkan.homework3.veh.entity;

import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import com.edemirkirkan.homework3.gen.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "VEH_VEHICLE")
@Getter
@Setter
public class VehVehicle extends BaseEntity {
    @Id
    @SequenceGenerator(name = "VehVehicle", sequenceName = "VEH_VEHICLE_ID_SEQ")
    @GeneratedValue(generator = "VehVehicle")
    private Long id;

    @Column(name = "BRAND", length = 100, nullable = false)
    private String brand;

    @Column(name = "MODEL", length = 100, nullable = false)
    private String model;

    // validate Turkish licence plating format
    @Pattern(regexp = "^(0[1-9]|[1-7][0-9]|8[01])(([A-Z])(\\d{4,5})|([A-Z]{2})(\\d{3,4})|([A-Z]{3})(\\d{2,4}))$",
            message = "Plate format is wrong! " + "Spaces and lowercase letters are not accepted.")
    @Column(name = "PLATE", length = 100, nullable = false, unique = true)
    private String plate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUS_CUSTOMER")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private CusCustomer cusCustomer;

}
