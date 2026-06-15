# Enterprise Apps Yassine Filali

Dit is mijn project voor het vak Enterprise Apps. Het is een werkend prototype van
een website voor een Anderlechtse NGO die zich inzet voor gemeenschapsbouwen en hulp
aan mensen die het minder breed hebben.

## Hoe start je het project?

1. Open de map in IntelliJ IDEA
2. Maven opent dan alle dependencies
3. Open terminal in IntelliJ (Alt+F12) en typ:
   .\mvnw.cmd spring-boot:run
4. Open je browser op: http://localhost:9090

## Hoe gebruik je de website?

Homepage (/) - Je ziet een tabel met de 10 laatste evenementen. Klik op "Bekijk" voor details van een evenement. Onderaan staat een knop "Nieuw evenement toevoegen".

Nieuw evenement (/new) - Via het menu of via de knop op de homepage. Een formulier met alle velden. Alles moet ingevuld zijn en het emailadres moet geldig zijn.

Details (/details/{id}) - Toont alle informatie van 1 evenement. Je komt hier via de "Bekijk" knop op de homepage.

Over ons (/about) - Informatie over de NGO, adres van campus Kaai en contactgegevens.

Contact (/contact) - Een formulier om een bericht te sturen naar de administrators. Werkt via Mailtrap.

## Externe libraries & frameworks

Spring Boot 4.0.6 - Het framework voor de volledige webapp
Thymeleaf - Voor de HTML templates
Spring Data JPA - Voor de database (opslaan van evenementen en locaties)
H2 Database - In-memory database, geen installatie nodig
Spring Validation - Voor formulier validatie
Spring Mail - Voor het versturen van emails via Mailtrap
Tailwind CSS (via CDN) - Voor de styling van de pagina's

## Gebruikte tutorials & documentatie

Spring Boot documentation (https://docs.spring.io/spring-boot/)
Thymeleaf tutorial (https://www.thymeleaf.org/documentation.html)
Tailwind CSS docs (https://tailwindcss.com/docs)
Mailtrap docs voor email testing

## Geschiedenis met chats met AI's

Tijdens dit project heb ik gebruik gemaakt van een AI-tool (opencode, big-pickle model) om te helpen met het bouwen van deze webapp. Hieronder een overzicht van wat we samen hebben gedaan:

### Fase 1: Project opzetten en eerste aanpassingen
- **Dutch vertaling about-pagina**: De AI hielp met het vervangen van Lorem Ipsum door echte Nederlandse tekst over de NGO.
- **pom.xml fixes**: `spring-boot-starter-webmvc` vervangen door `spring-boot-starter-web`, `spring-boot-starter-mail` verwijderd (later terug toegevoegd voor mailtrap).
- **Repositories**: `JpaRepository` vervangen door `CrudRepository` (zoals in de cursus voorbeelden van de docent).
- **ContactController**: Vereenvoudigd (mail verwijderd, later terug met mailtrap).

### Fase 2: WSL en MySQL installatie (cursus-verplicht)
- WSL Ubuntu geïnstalleerd, MySQL server opgezet, database `ngo` aangemaakt.
- MySQL bind-address aangepast en remote user aangemaakt.
- Probleem: WSL2 localhost port forwarding was onstabiel, waardoor de app niet kon verbinden.
- **Oplossing**: teruggeschakeld naar H2 in-memory database voor een stabiel prototype.

### Fase 3: Volledige herbouw volgens opdracht
- **pom.xml**: MySQL verwijderd, H2 en `spring-boot-starter-mail` toegevoegd.
- **application.properties**: H2 config, mailtrap SMTP instellingen.
- **Evenement.java**: `@Transient locatieId` veld toegevoegd voor correcte formulier binding met de locatie dropdown.
- **NewController.java**: Locatie ID wordt omgezet naar een Locatie entity bij het opslaan.
- **ContactController.java**: Echte email-verzending via JavaMailSender + Mailtrap.
- **about.html**: Lorem Ipsum tekst gebruikt zoals de opdracht vraagt (klant moet nog teksten doorsturen).
- **new.html**: `th:field="*{locatieId}"` voor correcte dropdown binding.
- **README.md**: Uitgebreid met alle vereiste onderdelen.

### Conclusie
De AI heeft me geholpen met de juiste Spring Boot conventies, Thymeleaf syntax, Tailwind CSS classes en het debuggen van database connectie problemen. Zonder de AI had ik veel meer tijd verloren aan opzoekwerk en trial-and-error.

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

De contactpagina verstuurt e-mails via Mailtrap (fictief, voor testdoeleinden).

### Stap 1: Maak een Mailtrap account aan
1. Ga naar https://mailtrap.io en maak een gratis account aan
2. Klik op "Testing" → "Email Sandbox" → "Start Testing"
3. Maak een nieuwe inbox aan (bijv. "NGO Anderlecht")

### Stap 2: Vul je credentials in
In `application.properties` staan de Mailtrap SMTP instellingen:
```
spring.mail.host=sandbox.smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=<jouw-username>
spring.mail.password=<jouw-password>
```
Vervang `<jouw-username>` en `<jouw-password>` door je eigen gegevens uit Mailtrap.

### Stap 3: Lees je mails
- Ga naar https://mailtrap.io/inboxes
- Klik op je inbox
- Daar zie je alle binnenkomende mails die vanuit de website verstuurd zijn
- Onze inbox: https://mailtrap.io/sandboxes/4713289/settings

## Opmerkingen

De database is in-memory (H2), dus bij elke herstart verdwijnen de data.
De H2 console is beschikbaar op http://localhost:9090/h2-console (JDBC URL: jdbc:h2:mem:ngo).
Alle evenementen zijn voorbeeld data voor het prototype.
