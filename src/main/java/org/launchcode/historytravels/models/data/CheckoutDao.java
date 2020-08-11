package org.launchcode.historytravels.models.data;

import org.launchcode.historytravels.models.Checkout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CheckoutDao extends CrudRepository<Checkout, Integer> {
}
