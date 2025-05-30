package com.anuchito.database.person;

import java.util.ArrayList;
import java.util.List;

import com.anuchito.database.loan.Loan;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
  @Id
  private Long id;

  @Column(name = "person_id", nullable = false, unique = true, length = 50)
  private String personId;

  @Column(name = "name", nullable = false, length = 255)
  private String name;

  @Column(name = "age", nullable = false)
  private Integer age;

  /**
   * ความสัมพันธ์ One-to-Many กับ Loan entity
   * หนึ่ง Person สามารถมีได้หลาย Loan
   * - mappedBy = "person": บอกว่าฟิลด์ 'person' ใน Loan entity เป็นเจ้าของความสัมพันธ์นี้
   * - cascade = CascadeType.ALL: การดำเนินการ (เช่น บันทึก, ลบ) บน Person
   * จะส่งผลต่อ Loan ที่เกี่ยวข้องด้วย
   * - orphanRemoval = true: หาก Loan ถูกลบออกจากลิสต์ loans (เช่น
   * person.getLoans().remove(loan))
   * Loan นั้นจะถูกลบออกจากฐานข้อมูลด้วย
   * - fetch = FetchType.LAZY: ข้อมูล Loan จะถูกโหลดเมื่อมีการเรียกใช้
   * (lazy-loading)
   */
  @OneToMany(
    mappedBy = "person", 
    cascade = CascadeType.ALL, 
    orphanRemoval = true, 
    fetch = FetchType.LAZY
  )
  private List<Loan> loans = new ArrayList<>();
}