# PlantBuddy

## Om prosjektet
Denne appen er en del av et smart hjem konsept utviklet for å hjelpe brukere med å holde styr på plantene sine. Med denne appen kan du enkelt legge til og administrere informasjon om plantene dine, og få en oversikt over dem på en ryddig og brukervennlig måte. Appen er utviklet i Kotlin og bruker Jetpack Compose for å skape et moderne og responsivt brukergrensesnitt.

## Struktur og filer
Prosjektet er organisert som følger:
- **App-kode:** Ligger i `app/src/main/java/com/example/myapplication/`. Her finner du prosjektets hovedfiler, inkludert UI komponenter, viewmodels, funksjoner og klasser.
- **Ressurser:** Alle bilder, ikoner og layout ressurser ligger i `app/src/main/res/`.

## Hvordan konfigurere og kjøre prototypen  

### Android Studio Installasjon  

1. Last ned Android Studio: https://developer.android.com/studio.  
2. Åpne setup filen etter nedlasting og følg veiviseren. Trykk "Next" til du kommer til knappen "Install".  
3. Etter installasjonen, trykk "Finish".
4. Aksepter lisensavtalene og følg konfigurasjonsveiviseren i Android Studio. Dette kan ta litt tid.
5. Når alt er ferdig, er Android Studio klar til bruk!

### APK-Installasjon  

#### På Android Studio (emulator):  
1. Last ned APK filen fra denne lenken: **[download](https://drive.usercontent.google.com/download?id=1qkFRKTN6hlL9WCheEEGpgS--0v-zwbHN&export=download&authuser=0)**.  
2. Opprett et nytt prosjekt i Android Studio.  
3. Start emulatoren fra Android Studio ved å velge enheten du vil bruke fra "AVD Manager".  
4. Dra og slipp APK filen inn i emulatorvinduet.  
5. Vent til installasjonen er ferdig, og åpne appen fra emulatoren.

#### På en fysisk Android enhet:  
1. Last ned APK filen fra denne lenken: **[download](https://drive.usercontent.google.com/download?id=1qkFRKTN6hlL9WCheEEGpgS--0v-zwbHN&export=download&authuser=0)**.  
2. Gå til innstillingene på enheten og aktiver "Tillat installasjon fra ukjente kilder".  
3. Åpne APK filen fra nedlastingsmappen og trykk "Install".  
4. Hvis du får en sikkerhetsmelding, velg "Flere detaljer" og deretter "Installer likevel".  
5. Når installasjonen er fullført, finner du appen på startskjermen. 

### Hvordan kjøre testene  

1. På Android Studio vil du se midt på toppen “run” knappen ved siden av “app” teksten. Trykk på “app” for å få frem forskjellige enhetstester som kan kjøres.

![Picture of run button](https://cdn.discordapp.com/attachments/1277910412179804224/1309384055325720618/image.png?ex=6741626d&is=674010ed&hm=188ab44c048d890200e8add2e2a465fc3ec45fc2e19e69d9ebdc6bc4fbc7e990&)

2. Etter å ha valgt en av testene, så trykk du på “run” (kjør) knappen.

![Picture of test run button](https://cdn.discordapp.com/attachments/1277910412179804224/1309384083649990706/image.png?ex=67416274&is=674010f4&hm=5670c27f5456fb4a2910df66a89cd9ed30022ece8bdb8086fc8a5f1f581f99e8&)

3. Testen kjører, så er det å vente til resultatene som vil si om logikkene på funksjonene fungerer som de skal. 

### Hvordan navigere rundt på appen
Du kommer til å havne på en login skjerm når du først kjører appen, her er det bare å trykke på "logg in" knappen for å komme videre, du trenger ikke å skrive inn noe brukernavn eller passord. Derifra er det bare å trykke rundt :)
