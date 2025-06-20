package TypeRacer;

class Typer extends Thread {
    private String botName, wordsTyped;
    private double wpm;
    private TypeRacer typeRacer;

    public Typer(String botName, double wpm, TypeRacer typeRacer) {
        this.botName = botName;
        this.wpm = wpm;
        this.wordsTyped = "";
        this.typeRacer = typeRacer;
    }

    public void setBotName(String botName) {
        this.botName = botName;
    }

    public void setWpm(double wpm) {
        this.wpm = wpm;
    }

    public void addWordsTyped(String newWordsTyped) {
        this.wordsTyped += newWordsTyped + " ";
    }

    public String getWordsTyped() {
        return wordsTyped;
    }

    public String getBotName() {
        return botName;
    }

    public double getWpm() {
        return wpm;
    }

    @Override
    public void run() {
        String[] wordsToType = typeRacer.getWordsToType().split(" ");

        // TODO (1)
        long howLongToType = (long) (60000 / wpm);  // 60 detik * 1000 / WPM

        long startTime = System.currentTimeMillis();

        try {
            // TODO (2)
            for (String word : wordsToType) {
                Thread.sleep(howLongToType);
                addWordsTyped(word);
            }

            // selesai mengetik
            addWordsTyped("(Selesai)");

            long endTime = System.currentTimeMillis();
            int totalTimeInSeconds = (int) ((endTime - startTime) / 1000);

            // TODO (3)
            typeRacer.addResult(new Result(botName, totalTimeInSeconds));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
