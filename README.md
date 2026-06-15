
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
   
<img width="898" height="370" alt="image" src="https://github.com/user-attachments/assets/1c253ab1-8ecc-4ec3-86d6-7f7de1f2e1c1" />

5. Open je browser op: http://localhost:9090



## Hoe gebruik je de website?

<img width="959" height="412" alt="image" src="https://github.com/user-attachments/assets/41a5c282-3b80-4f2e-adf1-e66c53873401" />


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
  DataInitializer.java - Start data (12 events en 3 locaties)
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

Zoals je ziet, is het een standaard spring boot project met Maeven
De controllers zorgen voor de routing en het ophalen van data uit de database via de repositories 
De services bevatten de business logica en de modellen representeren de data

## Mailtrap instellen

1. Ga naar https://mailtrap.io en maak een account aan
2. Klik op "Testing" dan op "Email Sandbox" dan "Start Testing"
3. Maak een nieuwe inbox aan (bijv. "NGO Anderlecht")
4. Klik op je inbox daarna tab "SMTP settings" en kopieer username en password
5. Plak die in application.properties zo:
                                            spring.mail.username=je-username
                                            spring.mail.password=je-password


6. Ga naar /contact pagina en stuur een mail naar de administrators en je krijgt een bevestiging 
   dat de mail is verstuurd.
7. Kijk in je Mailtrap inbox om de mail te lezen

Link naar mijn inbox: https://mailtrap.io/sandboxes/4713289/settings

<img width="959" height="410" alt="image" src="https://github.com/user-attachments/assets/64614694-fd95-45ca-a615-f40b3d43648e" />
Hier komen de mails terecht en je kan ze daar zien in mailtrap




## Opmerkingen

De database is in-memory (H2), dus bij elke herstart verdwijnen de data
De H2 console is beschikbaar op http://localhost:9090/h2-console (JDBC URL: jdbc:h2:mem:ngo)
Alle evenementen zijn voorbeeld data voor het prototype.
