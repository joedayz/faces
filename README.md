faces
=====

Laboratorios o ejemplos utilizando Spring RichFaces, PrimeFaces.

01-jsf-start: Demo inicial de JSF 1.2 con facelets.
01-jsf-solution: Demo final de JSF 1.2 con facelets
02-richFaces-start: Demo inicial de RichFaces.
02-richFaces-solution: Demo final de RichFaces
03-security-solution: Demo final de Richfaces 3 , Spring 3, Spring Security 3

Archetypes Maven
================

Archetype: RichFaces 4.1.0.Final + Spring 3.1.0.RELEASE + Hibernate 3.3.0

mvn archetype:generate -DarchetypeGroupId=org.ploin.archetype -DarchetypeArtifactId=demoSpringRichHibernate-archetype -DarchetypeVersion=1.2 -DarchetypeRepository=http://www.ploin-m2.de/nexus/content/groups/public/ -DgroupId=pe.joedayz.ejemplos  -DartifactId=richfaces4-start

Archetype: RichFaces 4.0

mvn archetype:generate  -DarchetypeGroupId=org.richfaces.archetypes -DarchetypeArtifactId=richfaces-archetype-simpleapp -DarchetypeVersion=4.0.0.Final -DgroupId=pe.joedayz.ejemplos -DartifactId=richfaces4-inicio

Links de Interes
================

1. Custom Scopes [http://blog.oio.de/2012/07/24/jsf-2-custom-scopes-without-3rd-party-libraries/]