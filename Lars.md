# Projektrapport för MongoDB Crud facades


### Skapare
Emil Sivertsson

### Beskrivning av projektet
Programmet använder sig av MongoDB för att skapa en databas med personer, kunder och anställda.
Det går att lägga till, uppdatera och ta bort personer, kunder och anställda från databasen.
Databasen ligger bakom en facade som hanterar CRUD operationer.
Jag skapade programmet innan Marcus uppdaterade projektbeskrivningen , så jag har inte utfört allt från Main, utan skapat en application klass som hanterar det.


### Arbetet och dess genomförande
Jag gjorde en kort planering innan jag började, där jag skrev ner vad jag skulle göra och hur jag skulle göra det.
Jag hade inte riktigt greppat allt med MongoDB, så jag gick igenom deras egna tutorials för att få en bättre förståelse för hur det fungerar.
Jag började med att skapa en abstract person klass, som sedan skulle ärvas av kund och anställd som hade sina egna attribut.
Därefter skrev jag meny och delar av Applications klassen och facaden med de metoder som jag visste att jag skulle behöva.
Efter många timmar kollande på Mongodb turorials så tog jag en metod i taget och skrev dem och sen testade jag dem i Applications klassen.

### Vad som varit svårt
Som jag skrev längre upp så var jag inte helt på det klara med hur MongoDB fungerade, så det tog ett tag att förstå hur jag skulle göra.
jag upplevde SQL som mycket lättare att ta till mig. men jag ser absolut fördelar med enkelheten och flexibiliteten med MongoDB.

### Beskriv lite olika lösningar du gjort
Min lösning för att skapa en ny person och att uppdatera en person liknar varandra.
för att skapa en person så tar jag användarens input, instanserar ett objekt av den valda klassen och skickar det vidare till facaden, som skickar vidare till 
databasen som omvandlar objektet till ett dokument och lägger till det i databasen.
För att uppdatera en person, så får användaren välja ett id att uppdatera, fylla i informationen.
Programet instanserar ett objekt, och skickar detta och Id:t till facaden som skickar vidare det till databasen, som letar upp dokumentet med det id:t och ersätter det.


### Beskriv något som var besvärligt att få till
Jag upplever att skillnaden mellan att i en SQL kunna ha unika nr som skapas av mig, och att i mongoDB ha ett ObjectID som skapas av databasen,
så var det krångligt att få till att kunna uppdatera eller ta bort kund eller anställd med hjälp av deras ID.
jag hade ju helst använt deras unika id för att undvika dubletter, som det är nu så använder den sig av det id som användaren matar in, vilket väldigt lätt blir dublett.
nå ja. till nästa gång!


## Slutsatser

### Vad gick bra och dåligt
Överlag flöt projekt på, Jag önskar att jag hade haft mer tid att experimentera med fler sökningar och regex.
MongoDB har ju så många möjligheter, så det hade varit kul att få testa mer, till ex ACID-transaktioner.


### Vad har du lärt dig
Att det är kul med företag som MongoDB som har så mycket bra tutorials och dokumentation.
De var väldigt väl producerade och lätta att följa, så jag lärde mig mycket av att gå igenom dem.
Att använda facade gör koden mer lättläst och enkel att förstå, det blev mitt insteg i att använda design patterns.

### Vad hade ni gjort annorlunda om ni gjort om projektet
Jag hade nog försökt att få till en bättre lösning för att hantera ID:n, så att det inte blir dubletter.
Nu så här några projekt senare, så hade jag inte valt att skriva så långa metoder. helt otestbart.


### Vilka möjligheter ser du med de kunskaper du fått under kursen.
Jag ser fram emot att testa andra databasertyper , men framför allt ser jag framemot att lära mig mer noSQL.