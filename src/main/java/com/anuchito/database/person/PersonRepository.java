package com.anuchito.database.person;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByPersonId(String personId);

    /**
     * ค้นหา Person ที่กู้ Loan ที่มี loanId ที่ระบุ
     * โดยใช้ JPQL เพื่อ Join ตาราง Person และ Loan ผ่านตาราง loan (Loan.person_fk_id)
     *
     * @param loanId The loanId of the Loan to search for.
     * @return The Person entity associated with the given loanId, wrapped in Optional.
     */
    @Query("SELECT p FROM Person p JOIN p.loans l WHERE l.loanId = :loanId")
    Optional<Person> findByLoanId(@Param("loanId") String loanId);
}