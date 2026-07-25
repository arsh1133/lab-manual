import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        int vowels = 0, consonants = 0, digits = 0, special = 0;

        for (char ch : str.toCharArray()) {

            if (Character.isLetter(ch)) {

                ch = Character.toLowerCase(ch);

                switch (ch) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        vowels++;
                        break;
                    default:
                        consonants++;
                }

            } else if (Character.isDigit(ch)) {
                digits++;
            } else if (ch != ' ') {
                special++;
            }
        }

        System.out.println("\nVowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + special);

        sc.close();
    }
}
