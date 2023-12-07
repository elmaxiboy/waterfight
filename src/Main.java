public class Main {

    public static void main(String[] args) {
        /** ToDo
         *  1) Create two WaterFighters
         *  2) Create a WaterFight
         *  3) Start the fight
         */

        WaterFighter ursula= new WaterFighter("Ursula");
        WaterFighter ariel= new WaterFighter("Ariel");

        WaterFight fight = new WaterFight(ursula,ariel);

        fight.startFight();



    }

}