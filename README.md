
# Enterprise Apps Yassine Filali

Dit is mijn project voor het vak Enterprise Apps. Het is een werkend prototype van
een website voor een Anderlechtse NGO die zich inzet voor gemeenschapsbouwen en hulp
aan mensen die het minder breed hebben, je kan er evenementen vinden en toevoegen en contact 
opnemen met de Administrator door een mail door te sturen.

## Hoe start je het project?

1. Open de map in IntelliJ IDEA
2. Maven opent dan alle dependencies
3. Open terminal in IntelliJ (Alt+F12) en typ:
   .\mvnw.cmd spring-boot:run
4. Open je browser op: http://localhost:9090

## Hoe gebruik je de website?

Homepage (/) - Je ziet een tabel met de 10 laatste evenementen. 

Klik op "Bekijk" voor details van een evenement je ziet dan de tijstip, locatie, beschrijving en contactgegevens van de organisator.

Onderaan staat een knop "Nieuw evenement toevoegen".

Nieuw evenement (/new) - Via het menu of via de knop op de homepage. 

Een formulier met alle velden. Alles moet ingevuld zijn en het emailadres moet geldig zijn.

Details (/details/{id}) - Toont alle informatie van 1 evenement. 

Je komt hier via de "Bekijk" knop op de homepage.

Over ons (/about) - Informatie over de NGO, adres van campus Kaai en contactgegevens.

Contact (/contact) - Een formulier om een bericht te sturen naar de administrators via mailtrap.io

## Externe libraries & frameworks

Spring Boot 4.0.6 - Framework voor de webapp
Thymeleaf - Voor HTML templates
Spring Data JPA - Database (opslaan van evenementen en locaties)
H2 Database - In-memory database geen installatie nodig
Spring Validation - Voor formulier validatie
Spring Mail - Voor emails via Mailtrap
Tailwind CSS - Voor de styling

## Gebruikte tutorials & documentatie

Cursus Enterprise Apps - voor de opbouw van het project
Spring Boot documentation - https://docs.spring.io/spring-boot/
Thymeleaf documentation - https://www.thymeleaf.org/documentation.html
Tailwind CSS documentation - https://tailwindcss.com/docs
Baeldung Spring Boot tutorials - https://www.baeldung.com/spring-boot
Mailtrap documentation - https://help.mailtrap.io/

## Projectstructuur

src/main/java/com/example/enterpriseappsyassinefilali/
config/
  DataInitializer.java - Start data (12 events, 3 locaties)
controller/
  IndexController.java - Homepage
  NewController.java - Nieuw evenement formulier
  DetailsController.java - Detail pagina
  AboutController.java - Over ons
  ContactController.java - Contact formulier
model/
  Evenement.java - Event model
  Locatie.java - Locatie model
  ContactBericht.java - Contact form data
repository/
  EvenementRepository.java
  LocatieRepository.java
service/
  EvenementService.java

src/main/resources/
templates/
  fragments/header.html
  fragments/footer.html
  index.html
  new.html
  details.html
  about.html
  contact.html
application.properties

## Mailtrap instellen

1. Ga naar https://mailtrap.io en maak een gratis account aan
2. Klik op "Testing" → "Email Sandbox" → "Start Testing"
3. Maak een nieuwe inbox aan (bijv. "NGO Anderlecht")
4. Klik op je inbox → tab "SMTP settings" → kopieer username en password
5. Plak die in application.properties:

spring.mail.username=je-username
spring.mail.password=je-password

6. Ga naar http://localhost:9090/contact en verstuur een bericht
7. Kijk in je Mailtrap inbox om de mail te lezen

Link naar onze inbox: https://mailtrap.io/sandboxes/4713289/settings

## Opmerkingen

De database is in-memory (H2), dus bij elke herstart verdwijnen de data.
De H2 console is beschikbaar op http://localhost:9090/h2-console (JDBC URL: jdbc:h2:mem:ngo).
Alle evenementen zijn voorbeeld data voor het prototype.
