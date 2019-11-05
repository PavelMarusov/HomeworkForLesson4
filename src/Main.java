import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int bossHealh = 1000;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static int[] heroesHealhs = {250, 250, 250, 200, 350, 250, 200, 200};
    public static String[] heroesNames = {"War", "Mag", "Telepat", "Doc", "Tank", "Dody", "Berserc", "Tor"};
    public static int[] heroesDamages = {20, 20, 20, 0, 15, 10, 20, 20};
    public static int heroesHealthRecovery = 10;
    public static String[] heroesAttacTypes = {"Physical", "Magical", "Kinetic", "Doc", "Tank", "Dodger", "Berserc", "Tor"};

    public static void changeBossDefence() {
        Random r = new Random();
        int randomIndex = r.nextInt(heroesAttacTypes.length);
        bossDefenceType = heroesAttacTypes[randomIndex];
    }

    public static void tor() {
        Random r = new Random();
        int [] a = {r.nextInt(3)};
        for (int t :a) {
            if ( t ==2){
                continue;
            }
            for (int i = 0; i < heroesHealhs.length; i++) {

                heroesHealhs[i] = heroesHealhs[i] - bossDamage;
            }




        }



//            for (int i = 0; i < a;) {
//
//
//                heroesHealhs[i] = heroesHealhs[i] - bossDamage;
//            }


    }

    public static void berserk() {
        if (!heroesAttacTypes.equals(bossDefenceType)) {
            heroesHealhs[6] = heroesHealhs[6] - bossDamage;
            heroesDamages[6] = heroesDamages[6] + 5;
        }


    }

    public static void dodger() {
        if (!heroesAttacTypes.equals(bossDefenceType)) {
            heroesHealhs[5] = heroesHealhs[5] - 0;

        } else {
            heroesHealhs[5] = heroesHealhs[5] - bossDamage;

        }


    }

    public static void tank() {
        Random r = new Random();
        int randomDmage = r.nextInt(bossDamage);
        heroesHealhs[4] = heroesHealhs[4] - bossDamage - randomDmage;
    }

    public static void printStatiscics() {
        System.out.println("______________________");
        System.out.println("Boss health" + bossHealh);
//        System.out.println(heroeName[1] + " " + heroesHealhs[4]);
//        System.out.println(heroeName[0] + " " + heroesHealhs[3]);


        for (int i = 0; i < heroesNames.length; i++) {
            System.out.println(heroesNames[i] + " health " + heroesHealhs[i]);
            System.out.println(heroesHealhs[i] + " health recovery " + heroesHealthRecovery);


        }


        System.out.println("_________________");
    }


    public static void round() {
        changeBossDefence();

        heroesHit();
        berserk();

        tank();
        tor();
        dodger();

//        if (bossHealh > 0) {
//            boosHit();
//        }

        heroesHitPointAp();


        printStatiscics();
    }


    public static void main(String[] args) {


        printStatiscics();
        while (!isFinished()) {
            round();
        }
    }

    public static boolean isFinished() {

        if (bossHealh <= 0) {
            System.out.println("Heroes von");
            return true;
        }
        if (heroesHealhs[0] <= 0 && heroesHealhs[1] <= 0 && heroesHealhs[2] <= 0 && heroesHealhs[3] <= 0 && heroesHealhs[4] <= 0) {
            System.out.println("Boss von");
            return true;


        }

        return false;
    }

//    public static void boosHit() { // команда выполняется в методе tor
//
//        for (int i = 0; i < heroesHealhs.length; i++) {
//
//            heroesHealhs[i] = heroesHealhs[i] - bossDamage;
//        }
//    }

    public static void heroesHitPointAp() {
        if (heroesHealhs[0] < 200 || heroesHealhs[1] < 200 || heroesHealhs[2] < 200 || heroesHealhs[4] < 200) {
            for (int i = 0; i < heroesHealhs.length; i++) {
                if (i == 3) {
                    continue;

                }
                heroesHealhs[i] = heroesHealhs[i] + heroesHealthRecovery;

            }

        }

    }

    public static void heroesHit() {

        for (int i = 0; i < heroesDamages.length; i++) {
            if (!heroesAttacTypes[i].equals(bossDefenceType)) {
                Random r = new Random();
                int coefficient = r.nextInt(2) + 2;
                bossHealh = bossHealh - heroesDamages[i] * coefficient;
                System.out.println(heroesAttacTypes[i] + " critical attack " + heroesDamages[i] * coefficient);

            } else {


                bossHealh = bossHealh - heroesDamages[i];
            }

        }

    }


}
