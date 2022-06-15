In den Vorgaben finden Sie eine Modellierung für ein Bankensystem.

Erweitern Sie die Vorgaben um Multithreading.

Erweitern Sie die Klasse `Kunde` so, dass sie in einem eigenen Thread ausgeführt werden kann.
In der `run()`-Methode soll der `Kunde` eine `Rechnung` aus der Queue `offeneRechnungen` herausnehmen und sie bezahlen. Nutzen Sie dafür die statische Methode `Bank#ueberweisen`. Ist die Queue leer, soll der Thread so lange warten, bis eine neue Rechnung eingegangen ist. Nutzen Sie dafür einseitige Synchronisation.

Erweitern Sie die Klasse `Transaktion` so, dass sie in einem eigenen Thread ausgeführt werden kann.
In der `run()`-Methode soll die `Transaktion` ausgeführt werden. Dabei soll vom Konto `von` der in der Rechnung hinterlegte Betrag abgezogen werden. Nutzen Sie dafür die Methode `Konto#sendeGeld`. Wenn das Geld erfolgreich abgezogen worden ist, soll das Geld auf das Empfängerkonto überwiesen werden. Nutzen Sie dafür die Methode `Konto#empfangeGeld`.
Verwenden Sie Mehrseitige Synchronisation.

Passen Sie die Methode `Bank#ueberweisen` so an, dass diese einen `Transaktion`-Thread erstellt und startet. Verwenden Sie dafür eine passende Struktur.

Implementieren Sie die Klasse `Geldeintreiber`. Diese bekommt einen `Kunden` als Auftraggeber und eine Liste mit weiteren Kunden als Rechnungsempfänger übergeben.
Implementieren Sie den `Geldeintreber` so, dass dieser in einem eigenen Thread ausgeführt werden kann.
In der `run()`-Methode soll der `Geldeintreiber` eine Rechnung generieren und an einen der `Kunden` in der Liste schicken. Verwenden Sie dafür die Methode `Kunde#empfangeRechnung`. Das Ziel-`Konto` der `Rechnung` soll das `Konto` des Auftraggebers sein.
Der `Geldeintreiber` macht nach jeder versendeten Rechnung 5-sec Pause.


**Hinweis**: Achten Sie darauf, nur die nötigsten Ressourcen zu blockieren und auch nur so lange wie unbedingt nötig.
