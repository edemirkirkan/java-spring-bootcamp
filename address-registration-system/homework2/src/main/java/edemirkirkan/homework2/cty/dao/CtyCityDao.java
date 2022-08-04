package edemirkirkan.homework2.cty.dao;


import edemirkirkan.homework2.cty.entity.CtyCity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CtyCityDao extends JpaRepository<CtyCity, Long> {
    CtyCity findByCode(String code);
}
