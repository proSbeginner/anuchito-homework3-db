package com.anuchito.database.loan;

import com.anuchito.database.person.Person;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "loan_id", length = 50, unique = true)
    private String loanId;

    @Column(name = "applicant_name")
    private String applicantName;

    @Column(name = "loan_amount")
    private double loanAmount;

    @Column(name = "loan_term")
    private int loanTerm;

    @Column(name = "status")
    private String status;

    @Column(name = "interest_rate")
    private double interestRate;

        /**
     * Many-to-One relationship with Person entity.
     * A loan belongs to one person.
     * @ManyToOne: Specifies this is the "Many" side pointing to the "One" side.
     * @JoinColumn(name = "person_id", referencedColumnName = "person_id", nullable = false):
     * - name = "person_id": Maps to the foreign key column in the 'loan' table.
     * - referencedColumnName = "person_id": Tells JPA that this foreign key refers
     * to the 'person_id' column in the 'person' table (not its primary key 'id').
     * - nullable = false: Ensures that every loan must be associated with a Person.
     */
    @ManyToOne
    @JoinColumn(
        name = "person_id", 
        referencedColumnName = "person_id", 
        nullable = false
    )
    private Person person;
}
