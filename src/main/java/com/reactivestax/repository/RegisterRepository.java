package com.reactivestax.repository;

import com.reactivestax.business.model.RegisterModelObject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RegisterRepository extends CrudRepository<RegisterModelObject, Long> {

    List<RegisterModelObject> findCustomerByNameEndsWith(String name);

}
