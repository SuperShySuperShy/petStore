import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PetStore {
    private static List<String> cart = new ArrayList<>(); // Store items in the cart

    public static void main(String[] args) {
        System.out.println("Petstore v1.0");

        Scanner myPet = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Select Pet (Dog, Cat, Fish, Bird): ");

        String myPetStr = myPet.nextLine();  // Read user input

        Scanner myBreed = new Scanner(System.in);  // Create a Scanner object
        if (myPetStr.equals("Dog")) {
            System.out.println("Select Breed (Bulldog, Poodle, Golden Retriever, Labrador): ");
        } else if (myPetStr.equals("Cat")) {
            System.out.println("Select Breed (Manx, Persian): ");
        } else if (myPetStr.equals("Fish")) {
            System.out.println("Select Breed (Angel Fish, Tiger Shark, Koi, Goldfish): ");
        } else if (myPetStr.equals("Bird")) {
            System.out.println("Select Breed (Amazon Parrot, Finch): ");
        } else {
            System.out.println("Not Existing Pet");
            return;  // Exit the program if an invalid pet is selected
        }

        String myBreedStr = myBreed.nextLine();  // Read user input

        System.out.println("Item ID    Product ID    Description                     List Price");
        
        if (myPetStr.equals("Dog")) {
            if (myBreedStr.equals("Labrador")) {
                System.out.println("EST-22    K9-RT-02    Adult Male Labrador Retriever    $135.50");
                System.out.println("EST-23    K9-RT-02    Adult Female Labrador Retriever  $145.49");
                addToCart("EST-22", "K9-RT-02", "Adult Male Labrador Retriever", 135.50);
                addToCart("EST-23", "K9-RT-02", "Adult Female Labrador Retriever", 145.49);
            }
        } else if (myPetStr.equals("Cat")) {
            if (myBreedStr.equals("Manx")) {
                System.out.println("EST-14    FL-DSH-01    Tailless Manx                  $58.50");
                System.out.println("EST-15    FL-DSH-01    With tail Manx                 $23.50");
                addToCart("EST-14", "FL-DSH-01", "Tailless Manx", 58.50);
                addToCart("EST-15", "FL-DSH-01", "With tail Manx", 23.50);
            } else if (myBreedStr.equals("Persian")) {
                // Add items for Persian breed here
            }
        } else if (myPetStr.equals("Fish")) {
            if (myBreedStr.equals("Goldfish")) {
                System.out.println("EST-4     FI-FW-01     Spotted Koi                    $18.50");
                System.out.println("EST-5     FI-FW-01     Spotless Koi                   $18.50");
                addToCart("EST-4", "FI-FW-01", "Spotted Koi", 18.50);
                addToCart("EST-5", "FI-FW-01", "Spotless Koi", 18.50);
            } else if (myBreedStr.equals("Tiger Shark")) {
                // Add items for Tiger Shark breed here
            }
        } else if (myPetStr.equals("Bird")) {
            if (myBreedStr.equals("Amazon Parrot")) {
                System.out.println("EST-18    AV-CB-01     Adult Male Amazon Parrot      $193.50");
                // Add more items for Amazon Parrot breed here if needed
                addToCart("EST-18", "AV-CB-01", "Adult Male Amazon Parrot", 193.50);
            } else if (myBreedStr.equals("Finch")) {
                // Add items for Finch breed here
            }
        }

        checkout();
    }

    public static void addToCart(String itemID, String productID, String description, double listPrice) {
        Scanner cartScanner = new Scanner(System.in);
        System.out.println("Do you want to add this item to your cart? (yes/no): ");
        String addToCart = cartScanner.nextLine();
        
        if (addToCart.equalsIgnoreCase("yes")) {
            cart.add(itemID + " - " + description + " - $" + listPrice);
            System.out.println("Item added to the cart.");
        }
    }

    public static void checkout() {
        System.out.println("\nYour Cart:");
        for (String item : cart) {
            System.out.println(item);
        }

        double total = calculateTotal();
        System.out.println("\nTotal Amount: $" + total);
        System.out.println("Thank you for shopping with us!");
    }

    public static double calculateTotal() {
        double total = 0.0;
        for (String item : cart) {
            String[] parts = item.split(" - ");
            String priceString = parts[2].substring(2); // Remove "$" sign
            double price = Double.parseDouble(priceString);
            total += price;
        }
        return total;
    }
}
