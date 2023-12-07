import java.util.Arrays;

public class WaterFighter {

    /**
     *  The name of the fighter
     */
    public String name;
    /**
     * The arrays that contains the cards of the fighter
     */
    private WatergunCard[] cards;
    /**
     * Index of the first free element in the array
     */
    private int cardsIndex;

    public WaterFighter(String name) {
        this.name = name;
        this.cards = new WatergunCard[20]; //initializes an array with 20 elements
        this.cardsIndex = 0;
    }

    public String getName() {
        return name;
    }

    public void addCard(WatergunCard c) {
        //ToDo: Add a card to the bottom of the deck. Parameter c is the card to be added.

        for (int i = cardsIndex; i >0 ; i--) {
            cards[i]=cards[i-1];
        }

        cards[0]= c;
        cardsIndex++;

        }


    public WatergunCard playCard() {
        // ToDo: Remove and return the first card on the deck. (before starting remove "return null;")
        int firstCardIndex=cardsIndex-1;
        WatergunCard firstCard = cards[firstCardIndex];
        cards[firstCardIndex]=null;
        cardsIndex=firstCardIndex;

        return firstCard ;
    }

    public int cardsNumber() {
        // ToDo: Return the number of cards in the player's deck (before starting remove "return 0;")
        return cardsIndex;
    }
}
