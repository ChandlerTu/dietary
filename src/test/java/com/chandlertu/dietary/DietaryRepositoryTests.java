package com.chandlertu.dietary;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DietaryRepositoryTests {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private DietaryRepository repository;

  @Test
  public void findByTaskId() {
    Dietary dietary = new Dietary();
    dietary.setFood("苹果");
    dietary.setGram(200);
    entityManager.persist(dietary);

    Iterable<Dietary> iterable = repository.findAll();

    assertThat(iterable.iterator().next().getFood()).isEqualTo("苹果");
  }

}
