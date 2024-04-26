---
marp: true
title: Short and sweet Hibernate 6 Intro
description: Short and sweet Hibernate 6 Intro
theme: uncover
class:
  - modern
  - invert
style: |
 
paginate: true
_paginate: false
header: "![image height:32px](favicon.png) **Christian Tüttenberg** Short and Sweet Hibernate 6 Intro"
footer: "![image height:32px](https://upload.wikimedia.org/wikipedia/commons/thumb/4/41/Hibernate_logo.svg/2880px-Hibernate_logo.svg.png)"
---

<style>
/* section {
  background-color: #fff;
   background-image: linear-gradient(to bottom right, #AA81B2 10%,  #89C4D6  80%); 
} */
</style>

# Short and sweet

## Hibernate 6 - What's new?

---

# Agenda

* Why JPA does not support records
* Modeling embeddables with records
* Table partitioning with @PartitionKey
* @SoftDelete


<!--
Some intro.
Then some reason and background.
-->

---

# Why JPA does not support records

---

# Records

```java
public record Address (String street, String city, String postalCode) {}
```

* The record class is final
* Private final fields and a public accessor method
* A canonical constructor with all fields
* An implementation of equals, hashCode, toString

---

# JPA entity requirements

* A top-level class annotated with @Entity
* **It can’t be final**
* **A public or protected, parameter-less constructor**
* Identifier that consists of at least 1 attribute


---

# Modelling embeddables with records

* EmbeddableInstantiator - Hibernate >= 6.0
* Embeddables - Hibernate >= 6.2

---

## EmbeddableInstantiator

```java
@Incubating
public interface EmbeddableInstantiator extends Instantiator {
  Object instantiate(ValueAccess var1, SessionFactoryImplementor var2);
}

@Incubating
public interface Instantiator {
  boolean isInstance(Object var1, SessionFactoryImplementor var2);

  boolean isSameClass(Object var1, SessionFactoryImplementor var2);
}
```

---

# Table partitioning

* split a large table into multiple smaller partition tables
* table and index records can fit into the in-memory Buffer Pool
* allows a more efficient seek or scan

---

# @PartitionKey

* column annotated with @PartitionKey allows column restriction
* predicate in SQL update and delete statements
* improved performance for partitioned tables

<!-- 
In data management, it is sometimes necessary 
to split data of a table into various (physical) partitions, 
based on partition keys and a partitioning scheme.

Due to the nature of partitioning, 
it is vital for the database to know the partition key of a row for certain operations, 
like SQL update and delete statements. 

If a database doesn’t know the partition of a row that should be updated or deleted, 
then it must look for the row in all partitions, leading to poor performance.

The @PartitionKey annotation is a way to tell Hibernate about the column, 
such that it can include a column restriction as predicate into 
SQL update and delete statements for entity state changes.
-->

https://vladmihalcea.com/table-partitioning-spring-hibernate/

---

# @SoftDelete

* UPDATE instead of DELETE
* Entity class annotated with @SoftDelete
* Creates a deleted column of type boolean
* The columnName attribute allows specifying a different name
* @SoftDelete strategy -> DELETE and ACTIVE
* Converter allows specifying a different data type

---

# Demo

---

# Changes overview

* Hibernate 6.2
* Hibernate 6.4
* Hibernate 6.5 - What's coming next?

---

# Hibernate 6.2
* **Support for Java records as embeddables**
* **@PartitionKey**
* Jakarta Persistence 3.1
* SQL MERGE for optional secondary tables
* Improved generated value support
* Support for STRUCT data type

---

# Hibernate 6.4
* **Soft-delete**
* Non-string tenant-id
* Support for arrays as table columns

---

# What's coming next?

##### Hibernate 6.5
* Java Time Handling
* Configurable Query Cache Layout
* records as @IdClass
* auto-enabled Filters
* Key-based Pagination
* Jakarta Data (tech preview)

---

# Q&A