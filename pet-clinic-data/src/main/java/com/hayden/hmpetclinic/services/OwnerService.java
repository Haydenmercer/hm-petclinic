package com.hayden.hmpetclinic.services;

import com.hayden.hmpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

   Owner findByLastName(String lastName);

}
