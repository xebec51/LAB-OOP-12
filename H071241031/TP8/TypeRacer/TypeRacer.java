package TypeRacer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class TypeRacer {
    private String wordsToType;
    private ArrayList<Typer> rareContestant = new ArrayList<>();
    private ArrayList<Result> rareStanding = new ArrayList<>();

    public String getWordsToType() {
        return wordsToType;
    }

    public ArrayList<Typer> getRareContestant() {
        return rareContestant;
    }

    private String[] wordsToTypeList = {
        "Di Bikini Bottom ada Spongebob Squarepants, dia memang keren suka main drumband",
        "Dia jadi koki masaknya krabby patty, menjalani hari hidup bersama Garry",
        "Ayo sama-sama sebutkan nama-nama makhluk dalam sana di Bikini Bottom jaya",
        "Namun ada juga namanya Patrick Star, walau dia cetar tapi hidupnya liar",
        "Tinggal dalam batu tapi suka membantu, sayang hanya satu otaknya itu buntu"
    };

    public void setNewWordsToType() {
        Random random = new Random();
        int angkaRandom = random.nextInt(wordsToTypeList.length);
        wordsToType = wordsToTypeList[angkaRandom];
    }

    // TODO (4) - Tambahkan hasil ke daftar standing
    public synchronized void addResult(Result result) {
        rareStanding.add(result);
    }

    private void printRaceStanding() {
        System.out.println("\nKlasemen Akhir Type Racer");
        System.out.println("=========================\n");

        // TODO (5) - Urutkan berdasarkan waktu tercepat
        Collections.sort(rareStanding, Comparator.comparingInt(Result::getFinishTime));

        int posisi = 1;
        for (Result r : rareStanding) {
            System.out.println(posisi + ". Bot " + r.getName() + " = " + r.getFinishTime() + " detik");
            posisi++;
        }
    }

    // TODO (6) - Mulai semua bot
    public void startRace() {
        for (Typer t : rareContestant) {
            t.start();
        }
    }

    // TODO (7 + 8) - Tampilkan progres setiap 2 detik sampai semua selesai
    public void displayRaceStandingPeriodically() throws InterruptedException {
        while (rareStanding.size() < rareContestant.size()) {
            System.out.println("\nTyping Progress...");
            System.out.println("==================");
            for (Typer t : rareContestant) {
                System.out.println("-Bot " + t.getBotName() + " => " + t.getWordsTyped());
            }
            Thread.sleep(2000);
        }

        // Tampilkan hasil akhir
        printRaceStanding();
    }
}
