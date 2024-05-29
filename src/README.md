# Projecte BDD relaccionals amb JDBC 
Pau Muñoz Serra

## Introducció
Aquest projecte és una aplicació de Java que utilitza el patró de disseny Model-Vista-Controlador (MVC) per interactuar amb una base de dades. El programa permet realitzar diferentes operacions CRUD (Crear, Llegir, Actualitzar, Eliminar) sobre una taula segons la classe amb la qual interactuem, així com inserir registres de forma aleatòria.

### Estructura del projecte

- ***Model:*** conté les classes que realitzen totes les funcións i executen programari "pesat", el qual fan totes les cerques, afegir dades, eliminar... 
  - DAO: Es la classe Interface, que esta connectada a la resta de classes acabada en DAO, ja que comparteixen funcions genèriques entre elles.
  - Connexio.java: La qual te les funcions de connectar-nos i desconnectar-nos de la Base de Dades.
  - *DAO.java: Són les classes que contenen totes les funcións que interactuen amb la base de dades, les quals poden editar, afegir, eliminar... registres de les taules de la base de dades.
  - *.java: Totes les classes que representa a un registre de cada taula, que contenen tots els camps de la taula, que tenim a la nostra base de dades.
- ***Vista:*** Conté totes les classes que s'encarreguen de mostrar la informació per pantalla.
  - Vista.java: És la classe que s'encarrega de mostrar la informació, a més de passar-li alguna classe amb informació per imprimir-ho.
- ***Controlador:*** Conté la classe que s'encarrega anar cridant les funcións per realitzar els exercicis i mostrar els textos.
  - Controlador.java: Classe que s'encarrega de cridar a les funcións del CRUD sobre la base de dades per poder actuar sobre la base de dades, a més de cridar la Vista per poder veure-ho per pantalla.
- ***Utils:*** conté les classes que s'encarreguen de fer tasques auxiliars.
  - RandomJugadorGenerator.java: classe que s'encarrega de generar jugadors de manera aleatòria.

### Funcionalitats

- ***CRUD:*** Són les diferents acciones que pots fer sobre una base de dades.
  - Create: És per poder inserir un nou jugador/equip... en la base de dades.
  - Read: És per poder obtenir un registre d'un jugador/equip... i obtenir tota la seva informació.
  - Update: És per poder actualitzar la informació d'un jugador/equip... existent, amb ajuda d'un objecte de la classe necessària.
  - Delete: És per poder eliminar un registre de la base de dades.
- ***Inserir jugadors de manera aleatòria:*** l'aplicació permet inserir jugadors de manera aleatòria utilitzant la classe RandomJugadorGenerator.

### Conexión a la base de datos

L'aplicació utilitza la classe DBConnection per a establir la connexió amb la base de dades. La connexió es realitza utilitzant [nom del driver de la base de dades].

### Patrón DAO

El programa utilitza el patró DAO (Data Access Object) per a interactuar amb la base de dades. El patró DAO s'encarrega de la connexió i desconnexió de la base de dades, proporcionar una "variable" per a interactuar amb la base de dades.

### Clases y métodos importantes

- ***JugadorDAO.java:***
  - insertJugador(Jugador jugador): mètode que insereix un nou jugador en la base de dades.
  - getJugadores(): mètode que obté la llista de tots els jugadors.
  - getJugador(*int aneu): mètode que busca un jugador específic pel seu ID.
  - updateJugador(Jugador jugador): mètode que actualitza la informació d'un jugador existent.
  - deleteJugador(*int aneu): mètode que elimina un jugador de la base de dades.
- ***RandomJugadorGenerator.java:***
  - generateJugador(): mètode que genera un jugador de manera aleatòria.
  - 
## Conclusión

Aquest projecte és un programa de Java que utilitza el patró de disseny MVC i el patró DAO per a interactuar amb una base de dades. El programa permet realitzar operacions CRUD sobre registres a la base de dades, a més d'organitzar-me millor que la UF anterior i he après dels errors de temps, controlant-lo millor i donant un millor resultat.
