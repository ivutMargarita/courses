
    CREATE TABLE users(
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(200) NOT NULL,
    created_date TIMESTAMP,
    active BOOLEAN DEFAULT(TRUE) NOT NULL
    );

     CREATE TABLE roles(
     id BIGSERIAL PRIMARY KEY,
     name VARCHAR(30) NOT NULL
     );

    CREATE TABLE courses(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    hours INT NOT NULL,
    teacher_id BIGINT NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES users (id)
    );

    CREATE TABLE users_roles_links (
     user_id BIGINT NOT NULL,
     role_id BIGINT NOT NULL,
     FOREIGN KEY (user_id) REFERENCES users (id),
     FOREIGN KEY (role_id) REFERENCES roles (id)
     );

    CREATE TABLE users_courses_links (
     user_id BIGINT NOT NULL,
     course_id BIGINT NOT NULL,
     FOREIGN KEY (user_id) REFERENCES users (id),
     FOREIGN KEY (course_id) REFERENCES courses (id)
     );

    INSERT INTO users(username,password,created_date,active)
          VALUES('Dasha','2119','2022-06-16 16:37:23',true),
          ('Nastya','3456','2023-07-14 18:57:29',false),
          ('Andrey','0000','2029-03-19 11:34:53',true);

    INSERT INTO courses(name,hours,teacher_id)
          VALUES('high math',4,1),
    		('information resourses',8,2),
     		('law',10,1);

    INSERT INTO roles(name)
          VALUES('admin'),
          ('student');

    INSERT INTO users_roles_links(user_id,role_id)
          VALUES(1,1),
          (2,2);

    SELECT *
    FROM course
    WHERE course_id >= 2
    ORDER BY course_id ASC;

    SELECT username, active
    FROM users
    WHERE username = 'Dasha';

    SELECT users.id, courses.name
    FROM courses
    INNER JOIN users
    ON courses.name_id = users.name_id
    ORDER BY id;






