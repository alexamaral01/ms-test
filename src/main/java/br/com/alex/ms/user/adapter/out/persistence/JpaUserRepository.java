package br.com.alex.ms.user.adapter.out.persistence;


import org.springframework.data.repository.CrudRepository;

public interface JpaUserRepository extends CrudRepository<UserEntity, Long> {

}
