package com.edemirkirkan.homework3.sec.jwt;

import com.edemirkirkan.homework3.cus.entity.CusCustomer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class SecUserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    private SecUserDetails(Long id, String firstName, String lastName, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static SecUserDetails build(CusCustomer cusCustomer) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("user"));
        return new SecUserDetails(cusCustomer.getId(), cusCustomer.getFirstName(),
                cusCustomer.getLastName(), cusCustomer.getUsername(),
                cusCustomer.getPassword(), grantedAuthorityList);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

