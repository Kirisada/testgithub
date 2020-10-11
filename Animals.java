import java.util.Scanner;
import java.text.DecimalFormat;

public class Animals {

    public void Display_Menu() {
        System.out.println("===============================================");
        System.out.println("================ Animal Program ===============");
        System.out.println("===============================================");
        System.out.println("==== Which Animal would you like to create ====");
        System.out.println("=== 1. Cow                                  ===");
        System.out.println("=== 2. Sheep                                ===");
        System.out.println("===============================================");
        System.out.println("== Pls select an option from the above menu ===");
        System.out.println("===============================================");
    }

    public int Select_option() {
        Scanner input_Scanner = new Scanner(System.in);
        boolean valid_option = false;
        int choice = 0;
        while (!valid_option) {
            try {
                choice = input_Scanner.nextInt();
                if (choice == 1 || choice == 2) {
                    valid_option = true;
                } else {
                    System.out.println("Please enter a valid option");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid option");
            }
        }
        return choice;
    }

    public void Create_animal() {
        Display_Menu();
        Animal nAnimal = new Animal();
        int choice = Select_option();
        if (choice == 1) {
            nAnimal = new Cow(Set_name(), 0.4F, 8, 8);
            nAnimal.Manage_program(nAnimal);
        } else if (choice == 2) {
            nAnimal = new Sheep(Set_name(), 0.4F, 8, 8);
            nAnimal.Manage_program(nAnimal);
        }
    }

    public String Set_name() {
        Scanner input_Scanner = new Scanner(System.in);
        boolean valid_option = false;
        String name = "";
        while (!valid_option) {
            try {
                System.out.printf("Name :");
                name = input_Scanner.nextLine();
                valid_option = true;
            } catch (Exception e) {
                System.out.println("Please enter a name");
            }
        }
        return name;
    }

    public static void main(String[] args) {
        Animals nAnimals = new Animals();
        nAnimals.Create_animal();
    }
}

class Animal {
    public String name;
    public float weight;
    public int days_growing = 0;
    public float growth_rate;
    public float food_need;
    public float water_need;
    public String status = "Newborn";
    public String type = "Generic";

    public Animal() {

    }

    public Animal(String name, float growth_rate, float food_need, float water_need) {
        this.name = name;
        this.growth_rate = growth_rate;
        this.food_need = food_need;
        this.water_need = water_need;
    }

    public void report() {
        System.out.println("===============================================");
        System.out.println("================ Animal Program ===============");
        System.out.println("===============================================");
        System.out.println("=== Name : " + this.name);
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("0.00");
        System.out.println("=== Weight : " + df.format(this.weight));
        System.out.println("=== Day_growing : " + this.days_growing);
        System.out.println("=== Growth_rate : " + this.growth_rate);
        System.out.println("=== Food_need : " + this.food_need);
        System.out.println("=== Water_need : " + this.water_need);
        System.out.println("=== Status : " + this.status);
        System.out.println("=== Type : " + this.type);
        System.out.println("===============================================");
    }

    public void update_staus() {
        if (this.weight > 175F) {
            this.status = "Old";
        } else if (this.weight >= 142.86F) {
            this.status = "Mature";
        } else if (this.weight >= 82.51F) {
            this.status = "Young";
        } else if (this.weight >= 14.46F) {
            this.status = "Newborn";
        }
    }

    public void grow(float food, float water) {
        if (food >= this.food_need && water >= this.water_need) {
            if (this.status == "Newborn") {
                this.weight += this.growth_rate * 1.5F;
            } else if (this.status == "Young") {
                this.weight += this.growth_rate * 1.25F;
            } else if (this.status == "Old") {
                this.weight += this.growth_rate / 2F;
            } else {
                this.weight += this.growth_rate;
            }
            this.days_growing += 1;
            this.update_staus();
        }
    }

    public void Auto_grow(Animal animalObj, int days) {
        int food = 0, water = 0;
        for (int i = 0; i <= days; i++) {
            food = 10;
            water = 10;
            animalObj.grow(food, water);
        }
        System.out.println("Success...");
        Manage_program(animalObj);
    }

    public void Manual_grow(Animal animalObj) {
        Scanner input_value = new Scanner(System.in);
        boolean valid = false;
        int food = 0, water = 0;
        while (!valid) {
            try {
                System.out.println("Please enter a food value (1-10) : ");
                food = input_value.nextInt();
                if (food <= 1 || food <= 10) {
                    valid = true;
                } else {
                    System.out.println("Value entered no valid = please enter a value botween 1 and 10");
                }
            } catch (Exception e) {
                System.out.println("Value entered no valid = please enter a value botween 1 and 10");
            }
        }
        valid = false;
        while (!valid) {
            try {
                System.out.println("Please enter a water value (1-10) : ");
                water = input_value.nextInt();
                if (water <= 1 || water <= 10) {
                    valid = true;
                } else {
                    System.out.println("Value entered no valid = please enter a value botween 1 and 10");
                }
            } catch (Exception e) {
                System.out.println("Value entered no valid = please enter a value botween 1 and 10");
            }
        }
        animalObj.grow(food, water);
        System.out.println("Success...");
        Manage_program(animalObj);
    }

    public void Display_Menu() {
        clearScreen();
        System.out.println("===============================================");
        System.out.println("================ Animal Program ===============");
        System.out.println("===============================================");
        System.out.println("=== 1. Grow manually over 1 day             ===");
        System.out.println("=== 2. Grow automatically over 30 days      ===");
        System.out.println("=== 3. Report status                        ===");
        System.out.println("=== 0. Exit program                         ===");
        System.out.println("===============================================");
        System.out.println("== Pls select an option from the above menu ===");
        System.out.println("===============================================");
    }

    public int Get_menu_choice() {
        Scanner input_value = new Scanner(System.in);
        boolean option_valid = false;
        int choice = 0;
        while (!option_valid) {
            try {
                System.out.println("Opiton Selected : ");
                choice = input_value.nextInt();
                if (choice <= 0 || choice <= 4) {
                    option_valid = true;
                } else {
                    System.out.println("Please enter a valid option");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid option");
            }
        }
        return choice;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void Manage_program(Animal animalObj) {
        boolean noexit = true;
        int option = 0;
        while (noexit) {
            Display_Menu();
            option = Get_menu_choice();
            clearScreen();
            if (option == 1) {
                Manual_grow(animalObj);
                break;
            } else if (option == 2) {
                Auto_grow(animalObj, 30);
                break;
            } else if (option == 3) {
                animalObj.report();
                System.out.println("===============================================");
                System.out.println("===============================================");
                System.out.println("=== 1. Back Menu                            ===");
                System.out.println("=== 0. Exit program                         ===");
                System.out.println("===============================================");
                System.out.println("== Pls select an option from the above menu ===");
                System.out.println("===============================================");
                noexit = true;
                while (noexit) {
                    option = Get_menu_choice();
                    clearScreen();
                    if (option == 1) {
                        Manage_program(animalObj);
                        break;
                    } else if (option == 0) {
                        noexit = false;
                    }
                }
                break;
            } else if (option == 0) {
                noexit = false;
            }
        }
    }

}

class Cow extends Animal {
    public Cow(String name, float growth_rate, float food_need, float water_need) {
        super.name = name;
        super.growth_rate = growth_rate;
        super.food_need = food_need;
        super.water_need = water_need;
        super.type = "Cow";
        super.weight = 16.49F;
    }

    @Override
    public void update_staus() {
        if (super.weight > 175F) {
            super.status = "Old";
        } else if (super.weight >= 142.86F) {
            super.status = "Mature";
        } else if (super.weight >= 82.51F) {
            super.status = "Young";
        } else if (this.weight >= 14.46F) {
            super.status = "Newborn";
        }
    }

    @Override
    public void grow(float food, float water) {
        if (food >= super.food_need && water >= super.water_need) {
            if (super.status == "Young") {
                super.weight += super.growth_rate * 1.25F;
            } else if (this.status == "Old") {
                super.weight += super.growth_rate / 2F;
            } else {
                super.weight += super.growth_rate;
            }
            this.days_growing += 1;
            this.update_staus();
        }
    }
}

class Sheep extends Animal {
    public Sheep(String name, float growth_rate, float food_need, float water_need) {
        super.name = name;
        super.growth_rate = growth_rate;
        super.food_need = food_need;
        super.water_need = water_need;
        super.type = "Sheep";
        super.weight = 3F;
    }

    @Override
    public void update_staus() {
        if (super.weight > 160F) {
            super.status = "Old";
        } else if (super.weight >= 38F) {
            super.status = "Mature";
        } else if (super.weight >= 18F) {
            super.status = "Young";
        } else if (this.weight >= 3F) {
            super.status = "Newborn";
        }
    }

    @Override
    public void grow(float food, float water) {
        if (food >= super.food_need && water >= super.water_need) {
            if (super.status == "Young") {
                super.weight += super.growth_rate / 2F;
            } else if (this.status == "Old") {
                super.weight += super.growth_rate / 2F;
            } else {
                super.weight += super.growth_rate;
            }
            this.days_growing += 1;
            this.update_staus();
        }
    }
}
