package ru.evgen.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.evgen.spring.models.Person;
import ru.evgen.spring.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    /**
     * Метод получения всех людей из БД
     * @return список людей
     */
    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    /**
     * Метод получения человека по Id
     * peopleRepository.findById возвращает объект Optional, т.к. человек может быть не найден
     * поэтому в return возвращаем или человека или null.
     * @param id
     * @return
     */
    public Person findOne(int id){
        Optional <Person> person = peopleRepository.findById(id);
        return person.orElse(null);
    }

    /**
     * Метод сохранения человека
     * Аннотация @Transactional над методом имеет приоритет над аннотацией класса
     * и разрешает запись
     * @param person
     */
    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }

    /**
     * Метод изменения человека
     * @param id
     * @param person
     */
    @Transactional
    public void update(int id, Person person){
        person.setId(id); // Присваиваем id человеку, т.к. с формы html человек приходит с не заполненным id
        peopleRepository.save(person);
    }

    /**
     * Удаление человека
     * @param id
     */
    @Transactional
    public void delete(int id){
        peopleRepository.deleteById(id);
    }

    public void test(){
        System.out.println("Тестирование дебагера. В Хайбернейт транзакции.");
    }

    // Реализация кастомных методов из репозитория PeopleRepository
    public List <Person> findByName(String name){
        return peopleRepository.findByName(name);
    }

    public List<Person> findByNameOrderByAge(String name){
        return peopleRepository.findByNameOrderByAge(name);
    }

    public List<Person> findByEmail(String email){
        return peopleRepository.findByEmail(email);
    }
    public List<Person> findByNameStartingWith(String startingWith){
        return peopleRepository.findByNameStartingWith(startingWith);
    }
    public List<Person> findByNameOrEmail(String name, String email){
        return peopleRepository.findByNameOrEmail(name, email);
    }

}
