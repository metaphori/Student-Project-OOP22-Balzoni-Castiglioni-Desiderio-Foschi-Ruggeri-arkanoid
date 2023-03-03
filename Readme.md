# Arkanoid

`./gradlew run`


### organizzazione view

La classe UIController può essere utilizzata per gestire le diverse viste all'interno di un singolo JFrame. In pratica, questa classe sarà responsabile di cambiare la vista visualizzata a seconda dell'interazione dell'utente o di altre azioni.

Per farlo, la classe UIController potrebbe includere un riferimento al JFrame principale e alle diverse viste che si vogliono visualizzare all'interno di esso. Le viste potrebbero essere rappresentate come diverse classi JPanel, ognuna delle quali contiene i componenti grafici necessari per visualizzare l'interfaccia utente desiderata.

Quando un utente interagisce con l'interfaccia utente o si verifica un evento che richiede il cambio di vista, la classe UIController potrebbe utilizzare il metodo setVisible() per nascondere la vista corrente e visualizzare la nuova vista corrispondente. Inoltre, potrebbe essere utile utilizzare metodi ausiliari per gestire altre operazioni, come l'inizializzazione delle viste, il caricamento dei dati e così via.

In questo modo, la classe UIController può fornire un'interfaccia di alto livello per gestire le diverse viste all'interno del JFrame.

In oltre UiController comunicherá con il controller principale dell'applicazione. Questo permetterá namutentibilitá futura poiché se jSwing diventerá deprecato basterá aggiornare il comparto view con una libreria aggiornata senza dover modificare la logica dell'applicazione
