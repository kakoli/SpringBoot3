# SpringBoot 3
* **SpringData JPA** - CRUD db operations via Spring Data JPA. Many-One JPA bidirectional relationship.

**POST APIs** :

Dept-Emp has bidirectional One-Many relation.
* [.../api/v3/emp]() - Save an employee with personal details like salary, address etc., dept details like dept name etc.
Inserts in all 3 tables of emp, address, dept.

**GET APIs** :
* [.../api/v3/emp/{empId}]() - Get employee details based on Id. Also gets the address and department details of the 
* employee.

**PUT APIs** :
* [.../api/v3/emp/{empId}]() - Update specific attributes(eg-salary) of a specific employee.