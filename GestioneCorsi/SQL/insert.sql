insert into docente values(1 ,'Benito', 'Bassano', 'CV1.png');
insert into docente values(2 ,'Paolo', 'Rossi', 'CV2.png');
insert into docente values(3 ,'Carmela', 'Neri', 'CV3.png');
insert into docente values(4 ,'Mario', 'Rossi', 'CV4.png');
insert into docente values(5 ,'Martina', 'Franchi', 'CV5.png');
insert into docente values(6 ,'Ricardo', 'Fontana', 'CV6.png');
insert into docente values(7 ,'Nicola', 'Antonutti', 'CV7.png');
insert into docente values(8 ,'Claudia', 'Specchi', 'CV8.png');

insert into amministratore values('Massimo', 'Rossi', 'max', 'pass01');
insert into amministratore values('Gianni', 'Verdi', 'gianni', 'pass02');
insert into amministratore values('Laura', 'Bianchi', 'laura', 'pass03');
insert into amministratore values('Dario', 'Arancio', 'dario', 'pass04');
insert into amministratore values('Claudia', 'Viola', 'claudia', 'pass05');

insert into corso values(1, 3,'Programmazione', TO_DATE('13/09/2021','dd/mm/yyyy'), TO_DATE('22/12/2021','dd/mm/yyyy'), 'Programmazione OOP Java', 'A1', 199.99);
insert into corso values(2, 1,'Microcontrollori', TO_DATE('04/10/2021','dd/mm/yyyy'), TO_DATE('21/12/2021','dd/mm/yyyy'), 'Microcontrollori programmabili, elettronica di base, controllo di dispositivi esterni, sensori', 'A2', 149.99);
insert into corso values(3, 4,'Algoritmi e strutture dati', TO_DATE('22/09/2021','dd/mm/yyyy'), TO_DATE('17/12/2021','dd/mm/yyyy'), 'Complessità degli algoritmi, caratteristiche dei linguaggi procedurali, tabelle hash e alberi binari', 'A3', 129.99);
insert into corso values(4, 2,'Basi di dati', TO_DATE('01/10/2021','dd/mm/yyyy'), TO_DATE('22/12/2021','dd/mm/yyyy'), 'Modello relazionale, linguaggio SQL, modello entita-relazione, fasi progettazione logica', 'A4', 129.99);
insert into corso values(5, 5,'Architettura degli elaboratori', TO_DATE('17/09/2021','dd/mm/yyyy'), TO_DATE('15/12/2021','dd/mm/yyyy'), 'Architettura strutturata dei calcolatori e principi ed elementi costitutivi di un tipico calcolatore elettronico', 'A5', 159.99);
insert into corso values(6, 8,'Automi e linguaggi', TO_DATE('21/02/2022','dd/mm/yyyy'), TO_DATE('25/05/2022','dd/mm/yyyy'), 'Automi a stati finiti, espressioni e linguaggi regolari, automi a pila, macchine di turing', 'A6', 99.99);
insert into corso values(7, 2,'Prog.concorrente e distribuita', TO_DATE('01/03/2022','dd/mm/yyyy'), TO_DATE('02/06/2022','dd/mm/yyyy'), 'Programmi multi-thread e meccanismi, standard ISO/OSI, sistemi distribuiti', 'A7', 199.99);
insert into corso values(8, 6,'Progettazione del software', TO_DATE('21/02/2022','dd/mm/yyyy'), TO_DATE('19/05/2022','dd/mm/yyyy'), 'Qualità del software e il suo processo produttivo, sistemi a eventi e interfacce grafiche, Unified Modeling Language, design pattern', 'A8', 179.99);
insert into corso values(9, 4,'Fondamenti di sicurezza', TO_DATE('03/03/2022','dd/mm/yyyy'), TO_DATE('01/06/2022','dd/mm/yyyy'), 'Analisi della sicurezza della cifratura classica, protezione dati livello rete e trasporto, sistemi per il controllo di accesso in DBMS nel SQL', 'A9', 109.99);
insert into corso values(10, 7,'Sistemi operativi', TO_DATE('25/02/2022','dd/mm/yyyy'), TO_DATE('25/05/2022','dd/mm/yyyy'), 'Principi dei sistemi operativi, concorrenza, Scheduling e dispatch, gestione della memoria, macchine virtuali', 'A10', 179.99);
insert into corso values(11, 2,'Programmazione procedurale ad oggetti', TO_DATE('09/09/2021','dd/mm/yyyy'), TO_DATE('16/12/2021','dd/mm/yyyy'), 'definizioni e nozioni di base del linguaggio C, definizioni e nozioni di base del linguaggio C++, libreria STL', 'A11', 129.99);
insert into corso values(12, 7,'Programmazione di dispositivi mobili', TO_DATE('15/02/2022','dd/mm/yyyy'), TO_DATE('13/05/2022','dd/mm/yyyy'), 'Introduzione ai dispositivi mobili, Elementi di base e elementi avanzati nella programmazione di dispositivi mobili', 'A12', 149.99);
