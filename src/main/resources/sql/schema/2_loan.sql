CREATE TABLE IF NOT EXISTS loan (
    id SERIAL PRIMARY KEY,
    loan_id VARCHAR(50) NOT NULL UNIQUE,
    applicant_name VARCHAR(255) NOT NULL DEFAULT '',
    loan_amount DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
    loan_term INT NOT NULL DEFAULT 0,
    status VARCHAR(20) NOT NULL DEFAULT 'PENDING',
    interest_rate DECIMAL(5, 2) NOT NULL DEFAULT 0.00,
    -- Foreign Key ที่อ้างอิงถึง person.person_id (VARCHAR)
    -- Type ต้องเป็น VARCHAR(50) เพื่อให้ตรงกับ person.person_id
    person_id VARCHAR(50) NOT NULL,
    CONSTRAINT fk_loan_person_id FOREIGN KEY (person_id) REFERENCES person(person_id)
);
