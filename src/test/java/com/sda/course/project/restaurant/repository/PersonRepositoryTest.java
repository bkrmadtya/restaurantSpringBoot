package com.sda.course.project.restaurant.repository;

import com.sda.course.project.restaurant.entity.PersonEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void whenFindByName_thenReturnPerson() {
        // given
        PersonEntity bikram = new PersonEntity();
        bikram.setFirstName("Bikram");
        bikram.setLastName("Karki");
        bikram.setEmail("karki.bikram007@gmail.com");
        bikram.setPhone(2354248);

        entityManager.persist(bikram);
        entityManager.flush();

        // when
        PersonEntity found = personRepository.findByFirstName(bikram.getFirstName());

        // then
        assert (found.getFirstName()).equals(bikram.getFirstName());
    }


}
