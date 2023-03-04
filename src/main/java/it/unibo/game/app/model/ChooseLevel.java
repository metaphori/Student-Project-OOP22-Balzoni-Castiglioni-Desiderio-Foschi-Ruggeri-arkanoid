package it.unibo.game.app.model;

/*Classe in cui si riceve l'input/la scelta del livello dall'utente 
 *e si seleziona/si fa partire il livello corrispondente alla scelta
 */

public class ChooseLevel {
    
    private final int chosenLevel;

    public ChooseLevel(int chosenLevel) {
        this.chosenLevel = chosenLevel;
    }
    public void chooseLevel() {
        switch (chosenLevel) {
            case 1:
                new FirstLevel();
                break;
            case 2:
                new SecondLevel();
                break;
            case 3:
                new ThirdLevel();
                break;
        }
    }
}
