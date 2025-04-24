package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp(); //utk mulai
    }

    private static void runApp() {
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");

        int selectMenu = -1;
        while (true) {
            System.out.print("> ");
            try {
                selectMenu = Integer.parseInt(sc.nextLine());
                if (selectMenu == 1 || selectMenu == 2) break;
                else System.out.println("Pilih menu 1 atau 2");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka");
            }
        }

        switch (selectMenu) {
            case 1:
                showLoginMenu();
                break;
            case 2:
                showRegisterMenu();
                break;
        }
    }

    private static void showLoginMenu() {
        System.out.println("-------------------------");
        System.out.println("Login");
        System.out.print("Masukkan Username\n> ");
        String username = sc.nextLine();

        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        if (userIndex != -1) {
            System.out.print("Password\n> ");
            String password = sc.nextLine();
            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);

            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                System.out.println("Password Salah");
            }
        } else {
            System.out.println("Username tidak ditemukan.");
        }

        runApp();
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        String username;
        while (true) {
            System.out.print("Username\n> ");
            username = sc.nextLine().trim();
            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong");
                continue;
            }
            boolean isDuplicate = false;
            for (User u : listUser) {
                if (u.getUsername().equals(username)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                System.out.println("Username sudah digunakan. Silakan coba lagi.");
            } else {
                break;
            }
        }

        String password;
        while (true) {
            System.out.print("Password\n> ");
            password = sc.nextLine().trim();
            if (password.isEmpty()) {
                System.out.println("Password tidak boleh kosong");
            } else if (password.length() < 8) {
                System.out.println("Password minimal 8 karakter");
            } else {
                break;
            }
        }

        User user = new User(username, password);
        Profile profile = new Profile();

        System.out.print("Nama Lengkap\n> ");
        String fullName = sc.nextLine().trim();
        while (fullName.isEmpty()) {
            System.out.println("Nama tidak boleh kosong");
            System.out.print("> ");
            fullName = sc.nextLine().trim();
        }

        int age = -1;
        while (true) {
            System.out.print("Umur\n> ");
            try {
                age = Integer.parseInt(sc.nextLine());
                if (age > 0) break;
                else System.out.println("Umur harus lebih dari 0");
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka");
            }
        }

        System.out.print("Hobby\n> ");
        String hobby = sc.nextLine().trim();
        while (hobby.isEmpty()) {
            System.out.println("Hobby tidak boleh kosong");
            System.out.print("> ");
            hobby = sc.nextLine().trim();
        }

        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);
        profile.setNickName(StringUtils.getNickName(fullName));

        listUser.add(user);
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("Detail User:");
        System.out.println("Nama Lengkap: " + profile.getFullName());
        System.out.println("NickName: " + profile.getNickName());
        System.out.println("Umur: " + profile.getAge());
        System.out.println("Hobby: " + profile.getHobby());
    }
}
