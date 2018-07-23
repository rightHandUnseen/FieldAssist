package org.rightHand.FieldAssistant.repositories;

import org.rightHand.FieldAssistant.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User, Long>{

}
