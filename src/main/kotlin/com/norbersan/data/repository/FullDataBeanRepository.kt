package com.norbersan.data.repository

import org.bson.Document
import org.springframework.data.mongodb.repository.Aggregation
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.Update
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

interface FullDataBeanRepository: MongoRepository<FullDataBean, String>{
    // https://stackabuse.com/spring-data-mongodb-guide-to-the-query-annotation/
    // https://www.baeldung.com/mongodb-return-specific-fields
    @Query("{ 'id' : :#{#id} }")
    @Update("{ '\$set': { 'commonIntNumber' : ?1 } }")
    fun updateCommonIntNumberById(@Param("id") id: String, number: Int)

    fun getCommonIntNumberByIdValue(id: String): Int?

    @Aggregation(pipeline =[
        "{ '\$match' : {'id' : ?0 } }",
        //"{ '\$project' : { 'commonIntNumber' : 1 } }"
    ])
    fun getCommonIntNumberByIdValue2(id: String): Int?

    @Query(value = "{ 'id' : ?0 }", fields = "{ '_id' : 0 , 'commonIntNumber' : 1 } ")
    fun getCommonIntNumberById(id: String): Document?
}

@Repository
abstract class FullDataBeanRepositoryImpl: FullDataBeanRepository {
    override fun getCommonIntNumberByIdValue(id: String): Int? = getCommonIntNumberById(id)?.get("commonIntNumber") as Int?
}


/*
    FROM https://www.baeldung.com/spring-data-derived-queries
    see also https://www.amitph.com/spring-data-jpa-query-methods/

    List<User> findByName(String name);
    List<User> findByNameIs(String name);
    List<User> findByNameEquals(String name);
    List<User> findByNameIsNot(String name);
    List<User> findByNameIsNull();
    List<User> findByNameIsNotNull();
    List<User> findByActiveTrue();
    List<User> findByActiveFalse();
    List<User> findByNameStartingWith(String prefix);
    List<User> findByNameEndingWith(String suffix);
    List<User> findByNameContaining(String infix);
    List<User> findByNameLike(String likePattern);
    List<User> findByAgeLessThan(Integer age);
    List<User> findByAgeLessThanEqual(Integer age);
    List<User> findByAgeGreaterThan(Integer age);
    List<User> findByAgeGreaterThanEqual(Integer age);
    List<User> findByAgeBetween(Integer startAge, Integer endAge);
    List<User> findByAgeIn(Collection<Integer> ages);
    List<User> findByBirthDateAfter(ZonedDateTime birthDate);
    List<User> findByBirthDateBefore(ZonedDateTime birthDate);
    List<User> findByNameOrBirthDate(String name, ZonedDateTime birthDate);
    List<User> findByNameOrBirthDateAndActive(String name, ZonedDateTime birthDate, Boolean active);
    List<User> findByNameOrderByName(String name);
    List<User> findByNameOrderByNameAsc(String name);
    List<User> findByNameOrderByNameDesc(String name);


    FROM SPTING JPA DATA
    https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.query-lookup-strategies

    FROM SPRING DATA MONGODB
    https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.repositories

    List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

    // Enables the distinct flag for the query
    List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
    List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);

    // Enabling ignoring case for an individual property
    List<Person> findByLastnameIgnoreCase(String lastname);
    // Enabling ignoring case for all suitable properties
    List<Person> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);

    // Enabling static ORDER BY for a query
    List<Person> findByLastnameOrderByFirstnameAsc(String lastname);
    List<Person> findByLastnameOrderByFirstnameDesc(String lastname);

    List<Person> findByAddressZipCode(ZipCode zipCode);
    List<Person> findByAddress_ZipCode(ZipCode zipCode);

    Page<User> findByLastname(String lastname, Pageable pageable);
    Slice<User> findByLastname(String lastname, Pageable pageable);
    List<User> findByLastname(String lastname, Sort sort);
    List<User> findByLastname(String lastname, Pageable pageable);

    User findFirstByOrderByLastnameAsc();
    User findTopByOrderByAgeDesc();
    Page<User> queryFirst10ByLastname(String lastname, Pageable pageable);
    Slice<User> findTop3ByLastname(String lastname, Pageable pageable);
    List<User> findFirst10ByLastname(String lastname, Sort sort);
    List<User> findTop10ByLastname(String lastname, Pageable pageable);

    Streamable<Person> findByFirstnameContaining(String firstname);
    Streamable<Person> findByLastnameContaining(String lastname);

    fun findByUsername(username: String): User
    fun findByFirstname(firstname: String?): User?

    @Async
    Future<User> findByFirstname(String firstname);

    @Async
    CompletableFuture<User> findOneByFirstname(String firstname);

    @Async
    ListenableFuture<User> findOneByLastname(String lastname);


    PARTIAL UPDATES:
    https://www.baeldung.com/spring-data-partial-update
    https://github.com/eugenp/tutorials/tree/master/persistence-modules/spring-data-jpa-enterprise

    https://codingexplained.com/coding/java/spring-framework/updating-entities-with-update-query-spring-data-jpa



    WITHOUT REPOSITORY FACILITIES
    https://medium.com/geekculture/types-of-update-operations-in-mongodb-using-spring-boot-11d5d4ce88cf

 */