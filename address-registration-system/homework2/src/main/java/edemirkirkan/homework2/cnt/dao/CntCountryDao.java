package edemirkirkan.homework2.cnt.dao;

import edemirkirkan.homework2.cnt.entity.CntCountry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CntCountryDao extends JpaRepository<CntCountry, Long> {
    CntCountry findByCode(String code);
}
