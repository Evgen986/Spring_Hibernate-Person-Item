package ru.evgen.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.evgen.spring.models.Person;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    /**
     * Поиск людей в БД по переданному имени
     * @param name имя человека
     * @return список найденный людей
     */
    List <Person> findByName(String name);

    /**
     * Поиск людей в БД по переданному имени И сортировка найденных людей по возрасту
     * @param name имя человека
     * @return список найденный людей (отсортированный по возрасту)
     */
    List<Person> findByNameOrderByAge(String name);

    /**
     * Поиск людей в БД по переданному email
     * @param email почта человека
     * @return список найденных людей
     */
    List<Person> findByEmail(String email);

    /**
     * Поиск людей в БД у которых имя начинается с переданной строки
     * @param startingWith с чего начинается имя
     * @return список найденных людей
     */
    List<Person> findByNameStartingWith(String startingWith);

    /**
     * Поиск людей в БД по имени ИЛИ почте
     * @param name имя человека
     * @param email почта человека
     * @return список найденных людей
     */
    List<Person> findByNameOrEmail(String name, String email);

}
