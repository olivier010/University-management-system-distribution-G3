CREATE DATABASE IF NOT EXISTS university_db;
USE university_db;

-- Institutions Table (Top Level)
CREATE TABLE institutions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255)
);

-- Colleges Table (Belongs to an Institution)
CREATE TABLE colleges (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    institution_id BIGINT NOT NULL,
    FOREIGN KEY (institution_id) REFERENCES institutions(id) ON DELETE CASCADE
);

-- Departments Table (Belongs to a College)
CREATE TABLE departments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    college_id BIGINT NOT NULL,
    FOREIGN KEY (college_id) REFERENCES colleges(id) ON DELETE CASCADE
);

-- Students Table (Belongs to a Department)
CREATE TABLE students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE SET NULL
);

-- Lecturers Table (Belongs to a Department)
CREATE TABLE lecturers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE SET NULL
);

-- Courses Table (Belongs to a Department)
CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    credits INT NOT NULL,
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES departments(id) ON DELETE SET NULL
);

-- Sample Data Configuration
INSERT INTO institutions (name, address) VALUES ('Global University', '123 Main St');
-- Assumption: Global University has ID 1
INSERT INTO colleges (name, institution_id) VALUES ('College of Engineering', 1);
-- Assumption: College of Engineering has ID 1
INSERT INTO departments (name, college_id) VALUES ('Computer Science', 1);
-- Assumption: Computer Science has ID 1
INSERT INTO students (first_name, last_name, email, department_id) VALUES
('John', 'Doe', 'john.doe@example.com', 1),
('Jane', 'Smith', 'jane.smith@example.com', 1),
('Alice', 'Johnson', 'alice.j@example.com', 1);

INSERT INTO lecturers (first_name, last_name, email, department_id) VALUES
('Dr. Alan', 'Turing', 'alan.turing@example.com', 1);

INSERT INTO courses (title, credits, department_id) VALUES
('Introduction to Algorithms', 4, 1),
('Data Structures', 3, 1);

