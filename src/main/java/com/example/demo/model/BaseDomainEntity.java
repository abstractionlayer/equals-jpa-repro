package com.example.demo.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


@MappedSuperclass
public class BaseDomainEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private Long version;


    public Long getId() {
        return id;
    }


    public Long getVersion() {
        return version;
    }


    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }

        if(!(o instanceof BaseDomainEntity)) {
            return false;
        }

        BaseDomainEntity other = (BaseDomainEntity) o;

        return id != null && id.equals(other.id);
        //return id != null && id.equals(other.getId()); // NOSONAR
    }


    @Override
    public int hashCode() {
        return 31;
    }
}
