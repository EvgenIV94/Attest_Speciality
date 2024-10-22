package Attest_Speciality;

import java.util.ArrayList;
import java.util.Scanner;

public class PetRegistry {
    private ArrayList<Animal> animals;
    private Scanner scanner;

    public PetRegistry() {
        animals = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addAnimal() {
        try (Counter counter = new Counter()) {
            System.out.print("Введите имя животного: ");
            String name = scanner.nextLine();
            System.out.print("Введите команду: ");
            String command = scanner.nextLine();
            System.out.print("Введите дату рождения (гггг-мм-дд): ");
            String dateOfBirth = scanner.nextLine();
    
            System.out.print("Это домашнее животное? (да/нет): ");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("да")) {
                animals.add(new DomesticAnimal(name, command, dateOfBirth));
            } else {
                animals.add(new PackAnimal(name, command, dateOfBirth));
            }
            counter.add();  // Увеличиваем счетчик
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    

    public void listAnimals() {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public void trainAnimal() {
        System.out.print("Введите имя животного для тренировки: ");
        String name = scanner.nextLine();
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                System.out.print("Введите новую команду: ");
                String command = scanner.nextLine();
                animal.setCommand(command);
                System.out.println(name + " теперь знает команду: " + command);
                return;
            }
        }
        System.out.println("Животное не найдено.");
    }

    public void showMenu() {
        while (true) {
            System.out.println("1. Завести новое животное");
            System.out.println("2. Посмотреть список животных");
            System.out.println("3. Обучить животное");
            System.out.println("4. Выйти");
            System.out.print("Выберите опцию: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addAnimal();
                    break;
                case 2:
                    listAnimals();
                    break;
                case 3:
                    trainAnimal();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    public static void main(String[] args) {
        PetRegistry registry = new PetRegistry();
        registry.showMenu();
    }
}

