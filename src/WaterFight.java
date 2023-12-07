import java.util.Random;

public class WaterFight {

    // Number of cards
    private static final int N = 10;

    // Fighters participating in the water fight
    private WaterFighter fighter1;
    private WaterFighter fighter2;

    // Constructor
    public WaterFight(WaterFighter f1, WaterFighter f2) {
        this.fighter1 = f1;
        this.fighter2 = f2;
    }

    public void startFight() {
        // The fighters draw their first N cards and put them in their decks
        for (int i = 0; i < N; i++) {
            fighter1.addCard(generateCard());
            fighter2.addCard(generateCard());
        }

        while (fighter1.cardsNumber() > 0 && fighter2.cardsNumber() > 0) {
            playTurn(fighter1, fighter2);
            System.out.println(fighter1.getName() + ": " + fighter1.cardsNumber() + " cards\n" + fighter2.getName() + ": " + fighter2.cardsNumber() + " cards\n");
            if (fighter1.cardsNumber() > 0 && fighter2.cardsNumber() > 0) {
                playTurn(fighter2, fighter1);
                System.out.println(fighter1.getName() + ": " + fighter1.cardsNumber() + " cards\n" + fighter2.getName() + ": " + fighter2.cardsNumber() + " cards\n");
            }
        }
        if (fighter1.cardsNumber() == 0 && fighter2.cardsNumber() > 0) {
            System.out.println(fighter2.getName() + " wins");
        } else {
            System.out.println(fighter1.getName() + " wins");
        }
    }

    private void playTurn(WaterFighter splasher, WaterFighter absorber) {
        /**
         * ToDo:
         * This method corresponds to a turn of WaterFight. Both fighters draw one card from
         * the top of their deck. If the splash value of splasher's card is higher that the
         * absorb value of the absorber's card, the splasher wins the turn,
         * otherwise, the absorber wins (ties are won by the absorber).
         * Who wins the turn puts both played cards on the bottom of their deck.
         * The method prints the splash and absorb value of each card.
         */

        WatergunCard splasherCard=splasher.playCard();

        int splasherSplash=splasherCard.getSplash();
        int splasherAbsorb=splasherCard.getAbsorb();

        System.out.println("Splasher is "+splasher.getName()+". Card --> SPLASH= "+splasherSplash+", ABSORB= "+splasherAbsorb);

        WatergunCard absorberCard=absorber.playCard();

        int absorberSplash=absorberCard.getSplash();
        int absorberAbsorb=absorberCard.getAbsorb();

        System.out.println("Absorber is "+absorber.getName()+". Card --> ABSORB= " +absorberAbsorb+", SPLASH= "+absorberSplash);


        if (splasherSplash>absorberAbsorb){
            System.out.println(splasher.getName()+" wins!");
            splasher.addCard(absorberCard);
            splasher.addCard(splasherCard);
        }
        else{
            System.out.println(absorber.getName()+" wins!");
            absorber.addCard(splasherCard);
            absorber.addCard(absorberCard);

        }
    }

    private WatergunCard generateCard() {
        Random r = new Random();
        return new WatergunCard(r.nextInt(11), r.nextInt(11));
    }
}
