// creamos un objeto (Entidad en el contexto Hibernate)
Alumno alu = new alu("Patricia Gómez");

// CHK 1 - ¿Persistente?

EntityManager em = entityManagerFactory.createEntityManager();
EntityTransaction tx = em.getTransaction();
tx.begin();

// guardamos
em.persist(alu);

// CHK 2 - ¿Separado?
//modificamos
alu.setNombre("Patricia Gómez Pérez");

// recuperamos el ID que habrá generado el SGBD
Long idAlu = alu.getId();
tx.commit();
em.close();

// CHK 3 - ¿Transistorio?


em = entityManagerFactory.createEntityManager();
tx = em.getTransaction();
tx.begin();

// recuperamos mediante el idAlu
alu = em.find(alu.class, idAlu);

// CHK 4 - ¿Separado?

tx.commit();
em.close();

// CHK 5 - ¿Transistorio?

// de quien será sobrina???
alu.setEmail("Patricia Gómez Pérez-Reverte");

em = entityManagerFactory.createEntityManager();
tx = em.getTransaction();
tx.begin();

// fusionamos
alu = em.merge(alu);

// CHK 6 - ¿Separado? 

tx.commit();
em.close();
System.out.println(alu);

em = entityManagerFactory.createEntityManager();
tx = em.getTransaction();
tx.begin();

// recuperamos
alu = em.find(alu.class, persistedId);
em.remove(alu);

// CHK 7 - ¿Separado?

tx.commit();
em.close();
