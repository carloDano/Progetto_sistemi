# Progetto_sistemi
Relazione Tecnica - Realizzazione di un’Applicazione Client-Server per la Consultazione Remota di un File CSV Studente: Dano Carlo (carlodano01@gmail.com) Data: [Inserire data di consegna]

L’obiettivo del progetto è sviluppare un’applicazione client-server in linguaggio Java, progettata per la consultazione remota di un file CSV contenente dati sugli Agriturismi e B&B Locande d’Italia. Questo sistema consentirà agli utenti di accedere in maniera semplice e veloce alle informazioni presenti nel file, utilizzando una comunicazione affidabile tra client e server, basata su socket TCP. Il server, incaricato della gestione del file e delle richieste degli utenti, risponderà in modo efficiente alle interrogazioni inviate dal client, sia per ottenere dati specifici che per visualizzare l’intero contenuto del file. Il sistema prevede che il server legga e organizzi i dati contenuti nel file CSV in una struttura che consenta una gestione rapida e sicura delle informazioni. La comunicazione tra client e server avverrà tramite socket TCP, garantendo affidabilità nella trasmissione dei dati e una gestione corretta degli errori. In caso di richiesta errata o di formato non valido, il server risponderà con messaggi di errore ben strutturati, affinché l’utente sia sempre consapevole della natura del problema. L’interfaccia del client sarà semplice e intuitiva, pensata per facilitare l’invio delle richieste e la visualizzazione dei risultati. Il client potrà inviare comandi testuali al server, come ad esempio GET_ROW n per ottenere una riga specifica del file CSV o GET_ALL per visualizzare l’intero contenuto del file. Il server, da parte sua, interpreterà queste richieste, restituendo i dati richiesti o comunicando eventuali errori se la richiesta non può essere soddisfatta. Per garantire la gestione simultanea di più client, il server utilizzerà i thread, consentendo a ciascun client di interagire in modo indipendente senza compromettere le prestazioni complessive del sistema. La concorrenza sarà quindi gestita in modo efficace, assicurando che le operazioni siano svolte rapidamente e senza blocchi. Inoltre, il codice sarà progettato in modo modulare, separando chiaramente le responsabilità tra la gestione dei dati, la comunicazione via socket e la logica di controllo degli errori. Il protocollo di comunicazione tra client e server seguirà una sintassi semplice e ben definita, per permettere una rapida implementazione e facilitare il debug. Le richieste inviate dal client saranno chiaramente distinte, e il server risponderà con i dati richiesti, o con messaggi di errore nel caso in cui i dati non siano disponibili o la sintassi della richiesta non sia corretta. Dal punto di vista tecnico, l’applicazione sarà sviluppata in Java, sfruttando le capacità di gestione dei socket TCP e il multithreading. La lettura e la gestione del file CSV saranno eseguite in modo efficiente, garantendo tempi di risposta rapidi anche per file di grandi dimensioni. Il progetto sarà sviluppato seguendo le migliori pratiche di programmazione, con un’attenzione particolare alla documentazione del codice, alla gestione degli errori e alla qualità del software. Per migliorare ulteriormente l'applicazione, si prevede di implementare alcune estensioni future, come la possibilità di filtrare e ordinare i dati in base a criteri specifici, rendendo così l’applicazione ancora più potente e versatile. Un'altra possibile estensione potrebbe essere l'implementazione di un'interfaccia grafica, che consentirebbe agli utenti di consultare i dati in modo ancora più intuitivo. Inoltre, sarà possibile esplorare l’utilizzo del protocollo UDP per confrontare le prestazioni con il TCP, e valutare se è una soluzione più adatta per il tipo di applicazione. Al termine del progetto, verranno consegnati il codice sorgente completo, un file README con le istruzioni per l’installazione e l’esecuzione dell’applicazione, e una relazione tecnica dettagliata che spiegherà le scelte progettuali adottate. Questo progetto rappresenta un’importante opportunità di approfondimento delle tematiche relative alla programmazione di rete in Java, in particolare nella gestione dei socket, nell'elaborazione di file CSV e nella gestione concorrente delle connessioni. In conclusione, il progetto mira a fornire un sistema robusto e scalabile, seguendo le migliori pratiche di sviluppo software, e offre la possibilità di evolversi facilmente nel tempo con nuove funzionalità. La struttura modulare permetterà infatti di integrare futuri miglioramenti senza compromettere l'affidabilità e l'efficienza dell’applicazione.