# LA_1550
Taktik eines Junior Robocode, welcher mit Java erstellt wurde. 
<br>

#### Was ist das Ziel dieses Portfolios?
###### Das Ziel dieses Portfolios ist es, dass die Leser wissen was Robocode ist, wie meine Taktik aufgebaut ist und wie ich die verschiedenen Stages im Code eingeleitet habe.
<br>

## Erklärung von Robocode
Robocode ist ein Open-Source-Programmierspiel, bei dem virtuelle Roboter auf einem Spielfeld gegeneinander kämpfen. Die einzelnen Roboter bestehen dabei aus einem Radar der Objekte orten kann, einer Kanone die geortete Objekte beschiessen kann und dem Roboter selbst, welcher umher fahren kann. Es geht darum, dass der eigene Roboter möglichst viele Punkte durch Eliminierungen und/oder durch das Überleben erzielt. Jeder Roboter hat ein Leben, mit einer gewissen Anzahl Punkte. Diese verliert man, wenn der Roboter von einem Schuss getroffen wird und/oder wenn man selber einen Schuss abgibt. Hat man kein Leben mehr, stirbt man und hat verloren. 

## Bild einer Robocode Arena mit Robotern
<br> """"""""""""BILD HIER"""""""""""""

## Taktik
Im Projekt Robocode spielt das Thema Taktik eine wichtige Rolle, denn auch wenn man den besten Code schreibt, kommt man mit einer schlechten Taktik nicht weit. Daher befasste ich mich ein Grossteil der Zeit mit dem Entwerfen einer Taktik. Das Ziel meiner Taktik ist es so lange wie möglich zu überleben, wie ich das versucht habe umzusetzten können Sie in den folgenden Kapiteln lesen. 
<br>
### Schusstaktik
Um zu starten eignete sich für mich die Schusstaktik am besten. Wichtig zu wissen ist, dass es verschiedene Schussarten gibt, welche andere Eigenschaften haben. Mit dem Befehl ``fire()`` kann man einen Schuss auslösen mit der Standard-Stärke 1, gibt man in der Klammer des Befehls einen Wert ein, so ist der Schuss je nach Wert stärker oder schwächer. Zu beachten ist, dass man Werte zwischen 0.1 bis 3 wählen kann, wobei 3 dem Gegner am meisten Schaden zufügt und 0.1 am wenigsten. Je stärker der Schuss, desto mehr Punkte verliert man. Jedoch erhält der Roboter für einen starken getroffenen Schuss mehr Punkte als für einen schwachen.  
<br>
In meiner Taktik verwendet der Roboter unterschiedliche Schussstärken, je nach Entfernung des erfassten Objektes.  <br>
Die Taktik die ich verfolgt habe ist wie folgt: Ist das erfasste Objekt weiter als 150 Pixel entfernt, schiesst mein Roboter mit Stärke 1, das habe ich gemacht, weil auf langer Distanz das Risiko höher ist nicht zu treffen als auf kurzer. Ist das erfasste Objekt zwischen 50 und 150 Pixel enfernt, schiesst er mit Stärke 2 und ist das erfasste Objekt weniger als 50 Pixel entfernt, so schiesst er mit stärke 3.
<br>
<br>
### Ausweichtaktik
Bei der Ausweichtaktik wendete ich eine ziemlich simple Methode an. Wird mein Roboter von einem Schuss getroffen, so versucht dieser mit Vorwärts ``ahead(150)``, Rückwärts ``back(100)`` und dann wieder Vorwärts ``ahead(200)`` sich von dem Radar des Gegner loszulösen.
<br>
<br>
### Video zur Bewegungstaktik
Als ich zur Bewegungsstaktik meines Roboters kam wurde mir klar, dass in meinem Fall diese der wichtigste Teil der gesamten Taktik ist. Um besser erklären zu können wie sich mein Roboter verhält hier ein Video dazu:
<br> """""""VIDEO HIER"""""""

### Überlegungen zu den einzelnen Stages der Bewegung
#### Stage 1
In Stage 1 spawnt der Roboter und bewegt sich sofort Richtung Süden, da am Anfang ziemlich viele Spieler im Zentrum sind. Indem ich den Roboter nach unten schicke, vermeide ich früh eliminiert zu werden.
<br>
#### Stage 2
Als nächstes beginnt sich der Roboter in einem Quadrat zu bewegen, das macht er so lange, bis eine gewisse Anzahl an Spieler übrig bleiben. Durch die Bewegung am Rand vermeide ich, dass andere Roboter welche auch zum Rand gehen, mich einfach treffen können.
<br>
#### Stage 3
Verbleiben weniger Spieler als die festgelegte Zahl, begibt sich der Roboter in die Mitte des Spielfeldes. Durch mehrere Tests habe ich herausgefunden, dass im Endgame sich im Zentrum weniger Spieler befinden. Hat er das Zentrum erreicht, beginnt er sich im Kreis zu bewegen. Mit der Kreisbewegung will ich möglichst vielen Schüssen ausweichen, da der Winkel schwieriger zu treffen ist, als wenn ich mich gerade bewege.

## Die verschiedenen Stages der Bewegung eingebettet im Code

![BildVomCode](https://user-images.githubusercontent.com/89131418/151137720-74fa6725-7e51-4ecc-93ba-bdea8a62af69.jpg)


Um in die nächste Stage zu gelangen, habe ich im Code eine einfache Methode verwendet. Ich habe eine Variable Stage eingefürt, welche bei 1 (für Stage 1) startet. Am Ende jeder Stage wird zu dieser Variable eins hinzugefügt (siehe Abbildung oben, rot markiert), so wird der Ablauf an die nächste Stage weitergeleitet. Eine Besonderheit sieht man am Ende der Stage 2, da erst in Stage 3 gewechselt wird, wenn eine gewisse Anzahl Spieler übrig bleiben (siehe Abbildung oben, blau markiert). So kann ich sicherstellen, dass Stage 2 so lange durchlaufen wird, bis die Bedingung erfüllt wurde.

## Verifikation
Nachdem das Portfolio gelesen wurde, sollten die LeserInnen wissen was Robocode ist, wie meine Taktik aufgebaut wurde und wie ich die verschiedenen Stages im Code eingeleitet habe.

## Reflexion
Das Projekt Robocode war ein lustiges Erlebnis, da man Spass, Ehrgeiz und Lernen kombinieren konnte. Bei dem Versuch den besten Roboter zu entwerfen, war es cool schon nach relativ kurzer Zeit messbare Ergebnisse zu sehen, wie z.B. die ersten erfolgreichen Muster, welche man mit dem Roboter abfuhr, jedoch wurde der schnelle Fortschritt zum Verhängniss, da man Teile übersprungen hat. Ein weiterer Aspekt der mir zuerst Mühe bereitet hat ist, das Umsetzten der Idee bzw. Taktik auf den Roboter. In den ersten Lektionen versuchte ich vergebens die perfekte Taktik herauszufinden, bis ich merkte, dass ein paar Dinge die ich geplant hatte nicht umsetzten konnte. Mein Verbesserungsvorschlag für zukünftige Projekte ist daher, dass ich zuerst schaue, ob das geplante umsetzbar ist, bevor ich mir zu viel vornehme. So kann ich sicherstellen, dass ich eine Arbeit nicht zwei Mal machen muss und schneller voran komme.
