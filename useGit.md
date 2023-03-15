
# Comandi git per interagire con GitHub

### **Procedura per scaricare repository remota:**

* `git clone <URL>`

Con questa operazione avremo:

* scaricato la repo, ma tracciamo solo il branch di default (in questo caso master..o meglio origin/master, ovvero master aggiornato (con la testa attaccata)). 
(Per verificare questo digitare `git branch` e vediamo solo master, mentre con `git branch -r` vediamo gli altri branch della repo che però non sono tracciati)

* settato in automatico il remote che rappresenta lo pseudonimo dell'indirizzo clonato. (Per verificare questo digitare `git remote -v`)

### **Procedura per tracciare il branch che vogliamo:**

* `git switch <nomeBranch>`
 
Questo comando crea un nuovo branch locale, settandolo in maniera che tracci il branch con quello stesso nome. (Quindi, una volta scaricata la repo, faccio git switch develop per tenere traccia di questo branch). Il nomeBranch deve corrispondere ad un branch esistente. <br>
(Verificare con `git branch -a`, e vediamo adesso il branch develop ad esempio) <br>
Questo comando viene utilizzato anche quando ho già alcuni branch e voglio switchare tra di loro. <br>
_N.B. Se ad esempio da develop voglio creare e passare ad un NUOVO branch devo utilizzare `git switch -c <nomeBranch>` oppure `git checkout -b <nomeBranch>`_ <br>

* In alternativa si può usare il comando:
`git checkout --track origin/<nomeBranch>`

_N.B. facendo solo `git checkout <nomeBranch>` si stacca la testa (detached head)._

### **Procedura per scaricare/aggiornare (senza modificare la repo locale) i cambiamenti fatti da altri caricati su repo remota (GitHub)**

* `git fetch <remote>`
(nel nostro caso 'git fetch origin', ma avendo un solo remote ci basta scrivere 'git fetch') <br>

Questo comando permette di vedere il lavoro degli altri caricato sulla repo remota (GitHub) nella nostra repo locale, senza dover fare la merge nella nostra repo locale. 

* `git fetch <remote> <branch>`

Questo comando permette di fare la fetch di un solo branch. Immaginate che dal branch develop ho creato un branch per lavorare ad una funzionalità, e mentre ci lavoro altri hanno fatto la stessa cosa per altre funzionalità, ma hanno fatto la merge con develop e caricato su GitHub. In questo momento quindi il mio branch devolop non è aggiornato alle ultime modifiche (non ha tutti i commit presenti sulla repo remota).
Facendo 'git fetch origin develop' mi ritrovo un nuovo branch che parte dal mio branch develop che si chiamerà origin/develop (che appunto rappresenta il branch aggiornato). Questo mi permette di vedere i nuovi commit, senza dover per forza fare la merge con il mio stato attuale di deve
### **Procedura per scaricare/aggiornare i cambiamenti fatti da altri caricati su repo remota (GitHub)**

* `git pull <remote> <branch>`

Con il comando pull è come eseguire i comandi fetch + merge. 
Questo comando bisogna lanciarlo nel branch che vogliamo aggiornare.
Se la merge riguarda modifiche su uno stesso o più file si possono verificare dei merge conflicts che bisogna risolvere.

* `git pull`
Lanciando questo comando git assume che il remote di default sia origin e che vogliamo aggiornare il branch su cui ci troviamo.

### **Procedura per caricare su GitHub**

* Come prima cosa bisogna fare una pull per risolvere eventuali merge conflicts, dopodichè <br>

* `git push <remote> <branch>`

---

N.B:
 Abbiamo deciso di avere:

- il branch master (su cui carichiamo le versioni funzionanti), 
- il branch develop (su cui costruiamo man mano il gioco),
- altri branch, che partono da develop, su cui creiamo nuove funzioanlità. 
Ogni branch, quando la funzionalità per cui è stato creato è completata, va riunito, con una merge, al branch deve

---
