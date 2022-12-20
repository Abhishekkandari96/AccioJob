/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
class Pizza
{
  private final int BasePrice;	//different for veg and non-veg
  private final int ToppingPrice;	// different for both veg and non-veg,customer decide

  private final int cheesePrice = 80;	//same for both,added by costumer
  private final int bagPrice = 20;	////same for both,added by costumer
  private final boolean isVeg;

  private int total = 0;

  private boolean isCheeseAdded = false;
  private boolean isToppingAdded = false;
  private boolean isTakeAwayAdded = false;



    Pizza (boolean isVeg)
  {
    this.isVeg = isVeg;
    if (isVeg)
      {				//prices are diffrent for veg & nonveg
	BasePrice = 300;
	ToppingPrice = 70;
	total = 300;
      }
    else
      {
	BasePrice = 400;
	ToppingPrice = 120;
	total = 400;
      }
  }
  public void extraCheese ()
  {
    if (isCheeseAdded == false)
      {
	total = total + cheesePrice;
	isCheeseAdded = true;
      }

  }
  public void extraToppings ()
  {
    if (isToppingAdded == false)
      {
	total = total + ToppingPrice;	//topping price is depend on veg and nonveg it is decided by me in object creation time only
	isToppingAdded = true;
      }
  }
  public void takeAway ()
  {
    if (isTakeAwayAdded == false)
      {
	total = total + bagPrice;
	isTakeAwayAdded = true;
      }
  }
  public String genBill ()
  {
    String bill = "Base Price Of The Pizza: " + BasePrice + "\n";

    if (isCheeseAdded)
      {
	bill = bill + "Extra Cheese Added: " + cheesePrice + "\n";
      }
    if (isToppingAdded)
      {
	bill = bill + "Extra Toppings Added: " + ToppingPrice + "\n";
      }
    if (isTakeAwayAdded)
      {
	bill = bill + "Paperbag Added : " + bagPrice + "\n";
      }
    bill = bill + "Total Price: " + total;
    return bill;
  }

}

class DiluxPizza extends Pizza
{
  DiluxPizza (boolean isVeg)
  {
    super (isVeg);
    //1way
    extraCheese ();
    extraToppings ();
    //2way-we can use but since we have not same function with same name as base class we will not use it
//        super.extraCheese();
//        super.extraToppings();
//        //3 way
//        this.extraCheese();
//        this.extraToppings();
  }

}

public class Main
{
  public static void main (String[]args)
  {
    System.out.println ("test");
    DiluxPizza order1 = new DiluxPizza (true);	//for veg==tru
      order1.takeAway ();
      System.out.println (order1.genBill ());

      System.out.println ("-----------------------------------------");
    Pizza order2 = new Pizza (true);	//for veg==tru
      order2.takeAway ();
      order2.extraToppings ();
      System.out.println (order2.genBill ());

  }
}
