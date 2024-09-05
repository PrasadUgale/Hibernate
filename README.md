# Hibernate

## Learning Path

### Introduction to Hibernate
* What is Hibernate and ORM (Object Relational Mapping)?
* Why use Hibernate over JDBC?
* Core features of Hibernate.

### Hibernate Setup and Configuration
* Setting up Hibernate in a Java project (without Spring).
* Hibernate configuration file (hibernate.cfg.xml).
* Required Hibernate dependencies.
* Connecting to a database using Hibernate.

### Hibernate Architecture
* Hibernate Core Components: SessionFactory, Session, Transaction.
* Persistence Context and how Hibernate manages it.

### Entity Class and Mapping
* What is an Entity in Hibernate?
* Mapping Java classes to database tables using annotations or XML.
* @Entity, @Table, @Id, and other basic annotations.
* Primary key generation strategies (GenerationType.IDENTITY, AUTO, etc.).

### CRUD Operations
* Performing basic CRUD (Create, Read, Update, Delete) operations.
* Lifecycle of Hibernate Entities (Transient, Persistent, Detached, Removed).
* Working with Session methods (save(), update(), delete(), etc.).
* Understanding Hibernate's auto-flush and commit.

### Hibernate Query Language (HQL)
* Introduction to HQL: Basics of Hibernate's own query language.
* Writing HQL queries for CRUD operations.
* Named queries and projections.

### Criteria API
* Introduction to Criteria API for dynamic queries.
* Building queries programmatically using Criteria.
* Comparison with HQL.

### Relations in Hibernate (Associations)
* One-to-One Mapping (@OneToOne).
* One-to-Many and Many-to-One Mappings (@OneToMany, @ManyToOne).
* Many-to-Many Mapping (@ManyToMany).
* Lazy and Eager Fetching strategies.
* Cascading and its effect on relationships.

### Inheritance Mapping
* Table-per-class hierarchy (@Inheritance(strategy = InheritanceType.SINGLE_TABLE)).
* Table-per-concrete-class, joined strategies, etc.
* Mapping inheritance hierarchies in relational databases.

### Caching in Hibernate
* First-Level Cache (Session-level cache).
* Second-Level Cache (SessionFactory-level cache) and configuration.
* Caching strategies and providers (Ehcache, etc.).

### Transaction Management in Hibernate
* Handling transactions in Hibernate.
* Transaction isolation levels and their impact.
* Managing transactions programmatically using Transaction and with JTA (Java Transaction API).

### Optimistic and Pessimistic Locking
* Concurrency control in Hibernate.
* Versioning and Optimistic Locking (@Version).
* Handling Pessimistic locking.

### Batch Processing in Hibernate
* Efficiently handling large datasets with batch processing.
* Configuring batch size and bulk operations.

### Hibernate Performance Tuning
* N+1 problem and how to solve it.
* Using Fetch Joins to optimize queries.
* Lazy loading and when to use it effectively.
* Query caching and other performance strategies.

### Working with Native SQL
* When and how to use native SQL in Hibernate.
* Executing SQL queries directly for custom needs.

### Hibernate Validation
* Integrating Bean Validation with Hibernate.
* Using annotations like @NotNull, @Size, @Pattern, etc.
