import java.util.Arrays;
import java.util.Random;

public class Main {
    public static int bossHealh = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static int[] heroesHealhs = {250, 250, 250,};
    public static String  heroeName = "Medik";
    public static int[] heroesDamages = {20, 20, 20,};
    public static int heroesHealthRecovery = 10;
    public static String[] heroesAttacTypes = {"Physical", "Magical", "Kinetic",};

    public static void changeBossDefence() {
        Random r = new Random();
        int randomIndex = r.nextInt(heroesAttacTypes.length);
        bossDefenceType = heroesAttacTypes[randomIndex];
    }

    public static void printStatiscics() {
        System.out.println("______________________");
        System.out.println("Boss health" + bossHealh);
//        System.out.println(heroeName[1] + " " + heroesHealhs[4]);
//        System.out.println(heroeName[0] + " " + heroesHealhs[3]);


        for (int i = 0; i < heroesAttacTypes.length; i++) {
            System.out.println(heroesAttacTypes[i] + " health " + heroesHealhs[i]);
            System.out.println(heroesHealhs[i] + " health recovery " + heroesHealthRecovery);


        }



        System.out.println("_________________");
        }




    public static void round() {
        changeBossDefence();
        heroesHit();
        if (bossHealh > 0) {
            boosHit();
        }
        if(heroesHealhs [0] > 200|| heroesHealhs [1] < 200||heroesHealhs [2] < 200){
            heroesHitPointAp();
        }



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
        if (heroesHealhs[0] <= 0 && heroesHealhs[1] <= 0 && heroesHealhs[2] <= 0 && heroesHealhs[3]<=0 && heroesHealhs[4]<=0) {
            System.out.println("Boss von");
            return true;


        }

        return false;
    }

    public static void boosHit() {
        for (int i = 0; i < heroesHealhs.length; i++) {
            heroesHealhs[i] = heroesHealhs[i] - bossDamage;
        }
    }

    public static void heroesHitPointAp() {
        if (heroesHealhs[0] < 200 || heroesHealhs[1] < 200 || heroesHealhs[2] < 200 || heroesHealhs[3] < 200 ) {
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
