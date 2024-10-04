# Hibernate

## Learning Path

### Introduction to Hibernate
- [ ] What is Hibernate and ORM (Object Relational Mapping)?
- [ ] Why use Hibernate over JDBC?
- [ ] Core features of Hibernate.

### Hibernate Setup and Configuration
- [ ] Setting up Hibernate in a Java project (without Spring).
- [ ] Hibernate configuration file (hibernate.cfg.xml).
- [ ] Required Hibernate dependencies.
- [ ] Connecting to a database using Hibernate.

### Hibernate Architecture
- [ ] Hibernate Core Components: SessionFactory, Session, Transaction.
- [ ] Persistence Context and how Hibernate manages it.

### Entity Class and Mapping
- [ ] What is an Entity in Hibernate?
- [ ] Mapping Java classes to database tables using annotations or XML.
- [ ] @Entity, @Table, @Id, and other basic annotations.
- [ ] Primary key generation strategies (GenerationType.IDENTITY, AUTO, etc.).

### CRUD Operations
- [ ] Performing basic CRUD (Create, Read, Update, Delete) operations.
- [ ] Lifecycle of Hibernate Entities (Transient, Persistent, Detached, Removed).
- [ ] Working with Session methods (save(), update(), delete(), etc.).
- [ ] Understanding Hibernate's auto-flush and commit.

### Hibernate Query Language (HQL)
- [ ] Introduction to HQL: Basics of Hibernate's own query language.
- [ ] Writing HQL queries for CRUD operations.
- [ ] Named queries and projections.

### Criteria API
- [ ] Introduction to Criteria API for dynamic queries.
- [ ] Building queries programmatically using Criteria.
- [ ] Comparison with HQL.

### Relations in Hibernate (Associations)
- [ ] One-to-One Mapping (@OneToOne).
- [ ] One-to-Many and Many-to-One Mappings (@OneToMany, @ManyToOne).
- [ ] Many-to-Many Mapping (@ManyToMany).
- [ ] Lazy and Eager Fetching strategies.
- [ ] Cascading and its effect on relationships.

### Inheritance Mapping
- [ ] Table-per-class hierarchy (@Inheritance(strategy = InheritanceType.SINGLE_TABLE)).
- [ ] Table-per-concrete-class, joined strategies, etc.
- [ ] Mapping inheritance hierarchies in relational databases.

### Caching in Hibernate
- [ ] First-Level Cache (Session-level cache).
- [ ] Second-Level Cache (SessionFactory-level cache) and configuration.
- [ ] Caching strategies and providers (Ehcache, etc.).

### Transaction Management in Hibernate
- [ ] Handling transactions in Hibernate.
- [ ] Transaction isolation levels and their impact.
- [ ] Managing transactions programmatically using Transaction and with JTA (Java Transaction API).

### Optimistic and Pessimistic Locking
- [ ] Concurrency control in Hibernate.
- [ ] Versioning and Optimistic Locking (@Version).
- [ ] Handling Pessimistic locking.

### Batch Processing in Hibernate
- [ ] Efficiently handling large datasets with batch processing.
- [ ] Configuring batch size and bulk operations.

### Hibernate Performance Tuning
- [ ] N+1 problem and how to solve it.
- [ ] Using Fetch Joins to optimize queries.
- [ ] Lazy loading and when to use it effectively.
- [ ] Query caching and other performance strategies.

### Working with Native SQL
- [ ] When and how to use native SQL in Hibernate.
- [ ] Executing SQL queries directly for custom needs.

### Hibernate Validation
- [ ] Integrating Bean Validation with Hibernate.
- [ ] Using annotations like @NotNull, @Size, @Pattern, etc.

<br><br>


## Test Your Knowledge 

### JDBC & Hibernate Overview
* What are the limitations of the JDBC API?
* What is ORM?
* What are the features of Hibernate?
* Which API does Hibernate use internally to communicate with the database?

### Hibernate Configuration
* How can we provide mapping and DB details to Hibernate?
* What are the Configuration, SessionFactory, and Session objects?
* What objects do we get inside SessionFactory?

### Session Operations
* What is the program flow for select and non-select operations using the session?
* What is SRO (Single Row Operation) and Bulk Operation?

###Hibernate Query Mechanisms
* What is HQL, Native SQL, and Criteria API (QBC)?
* What are the differences between .save() and .persist()?
* What is the difference between .get() and .load()?

### Loading and Fetching Strategies
* What is eager loading and lazy loading?
* What is the process flow for select operations in Hibernate?
* If we throw multiple select statements for the same record, will it hit the database and return a new object every time?

### Hibernate Caching
* What is caching and what are the levels of caching?
* For which queries does caching work?
* What is the process flow with caching?
* How do you clear the cache? (clear() vs evict())
* Why is L2 (Level 2) caching not configured by default? How can it be configured?
* What is CacheConcurrencyStrategy and its types?
* What is QueryCache and where does it reside?

### Transaction Management
* What is the difference between commit and rollback?
* What is saveOrUpdate()?
* What is NonUniqueObjectException and OptimisticLockException?

### Entity & Mapping
* Is it mandatory to make a model serializable?
* How are records and objects synchronized?
* How do you handle a composite primary key column?
* What is @Embeddable?
* How do you handle Dates and File data?

### Versioning and Time Stamping
* What is @Version?
* What is object Time Stamping and what annotations are used for it?

### Multiple Database Handling
* How do you handle multiple databases?
* What changes are needed for multiple Hibernate configuration (cfg.xml) files?

### Connection Management
* What is connection pooling?
* What is DataSource?
* What are Hikari CP, JDBC, JTA, and JNDI?

### Generators
* What are the generators in Hibernate and their types?
* Explain Sequence Generator, GeneratedValue, Table Generator, and Custom Generator.

### Bulk Operations
* What is Bulk Operation?
* How does Hibernate handle Bulk Operations with caching?
* Does Hibernate cache SRO and Bulk operation data?

### HQL/JPQL and SQL
* What is HQL/JPQL?
* What is Native SQL and how is it used?
* What are the differences between NamedQuery and NamedNativeQuery?
* How do you handle pagination with HQL?
* How to call stored procedures in Hibernate?

### Query by Criteria (QBC)
* What are the uses of CriteriaBuilder and Root objects in QBC?
* What are CriteriaQuery, CriteriaInsert, and CriteriaDelete?
* How do you write conditions, scalar queries, and parameters in CriteriaBuilder?

### Filters in Hibernate
* What are filters and how are they used in sessions?
* Does HQL, QBC, and Native SQL support filters?

### Soft Deletion
* What is soft deletion and how does it work for SRO and Bulk operations?

### ORM Challenges
* How does ORM solve issues related to RDBMS?
* Explain Composition/Granularity, Association, and Inheritance in ORM.

### Association and Mapping
* Where do we use @Embeddable, @Embedded, @CollectionTable, @ElementCollection?
* What is the difference between storing List, Set, and Map in Hibernate?
* Explain the inheritance strategies in Hibernate.
* What annotations are used for association mapping?
* What is cascadingType, fetchType, and orphanRemoval?

### Joins and Relationships
* How to link, join, or map two fields?
* What is the difference between mappedBy and @JoinColumn?
* Where is @JoinTable required?
* Does lazy/eager loading work with one-to-one mapping?
* What is the default loading type for 1-1, M-1, and M-M relationships?
* What are HQL joins?
* What is the N+1 select query problem, and what are the solutions?

### Locking in Hibernate
* What is locking in Hibernate? Specify Optimistic and Pessimistic Locking.
