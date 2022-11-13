package com.gargi.sorting;
import java.util.Scanner;

class TheGuesser{
	int guessNum;
	
	int guessNum()
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Guesser kindly guess the number");
		guessNum=scan.nextInt();
		return guessNum;
	}	
}

class Players{
	int guessNum;
	
	int guessNum()
	{
		Scanner scan=new Scanner(System.in);		
		guessNum=scan.nextInt();
		return guessNum;
	}
}
class ThirdUmpire{
	Scanner scan = new Scanner(System.in);
	int playerEliminated;	
	int playerEliminated() {
		System.out.println("Choose a number between 1 and 3: ");
		playerEliminated=scan.nextInt();
		
		return playerEliminated;
	}
}

class TheUmpire{
	Scanner sc = new Scanner(System.in);
	int numFromGuesser;
	int numFromPlayer,numFromPlayer2,numFromPlayer3;
	int noOfTries=5;
	boolean flag=false;
	boolean flag2=false;
	boolean flag3=false;
	int count1,count2,count3;;
	TheGuesser g=new TheGuesser();
	Players p1=new Players();
	Players p2 = new Players();
	Players p3 = new Players();
	ThirdUmpire tu= new ThirdUmpire();
    boolean timeForElimination=false;
	int eliminatedPlayer=0;
	boolean isFinal=true;
	boolean isP1=false;
	boolean isP2=false;
	boolean isP3=false;
	boolean finalP1,finalP2,finalP3=false;
	int countP1,countP2,countP3;
	
	//Collect number from the Guesser
	void collectNumFromGuesser()
	{
		numFromGuesser=g.guessNum();
	}
	
	//Collect number from player 1
	void collectNumFromPlayer1()
	{
		System.out.println("Player1 kindly guess the number");
		for(int i=0; i<5; i++) {
		numFromPlayer=p1.guessNum();
		count1++;
		if(numFromPlayer==numFromGuesser) {
			flag = true;
		    break;
		}
		else if (numFromGuesser > numFromPlayer && i != noOfTries - 1) {
			System.out.println(
				"The number is "
				+ "greater than " + numFromPlayer);
		}
		else if (numFromGuesser < numFromPlayer
				&& i != noOfTries - 1) {
			System.out.println(
				"The number is"
				+ " less than " + numFromPlayer);
		}
		
	}
		if (count1 == noOfTries && flag==false) {
			System.out.println(
				"You have exhausted 5 trials.");

			System.out.println(
				"The number was " + numFromGuesser);
		}
		else if(flag==true) {
			System.out.println("Congratulations!Player 1 You guessed the number in "+count1 +" tries");
		}
 }
	
	
	//Number from second player
	void collectNumFromPlayer2()
	{
		System.out.println("Player2 kindly guess the number");
		for(int i=0; i<5; i++) {
		numFromPlayer2=p2.guessNum();
		count2++;
		if(numFromPlayer2==numFromGuesser) {
			flag2 = true;
		    break;
		}
		else if (numFromGuesser > numFromPlayer2 && i != noOfTries - 1) {
			System.out.println(
				"The number is "
				+ "greater than " + numFromPlayer2);
		}
		else if (numFromGuesser < numFromPlayer2
				&& i != noOfTries - 1) {
			System.out.println(
				"The number is"
				+ " less than " + numFromPlayer2);
		}
		
	}
		if (count2 == noOfTries && flag2==false) {
			System.out.println(
				"You have exhausted 5 trials.");

			System.out.println(
				"The number was " + numFromGuesser);
		}
		else if(flag2==true) {
			System.out.println("Congratulations! You guessed the number in "+count2 +" tries");
		}
 }
	
	//Collect number from player 3
		void collectNumFromPlayer3()
		{
			System.out.println("Player3 kindly guess the number");
			for(int i=0; i<5; i++) {
				numFromPlayer3=p3.guessNum();
				count3++;
			if(numFromPlayer3==numFromGuesser) {
				flag3 = true;
			    break;
			}
			else if (numFromGuesser > numFromPlayer3 && i != noOfTries - 1) {
				System.out.println(
					"The number is "
					+ "greater than " + numFromPlayer3);
			}
			else if (numFromGuesser < numFromPlayer3
					&& i != noOfTries - 1) {
				System.out.println(
					"The number is"
					+ " less than " + numFromPlayer3);
			}
			
		}
			if (count3 == noOfTries && flag3==false) {
				System.out.println(
					"You have exhausted 5 trials.");

				System.out.println(
					"The number was " + numFromGuesser);
			}
			else if(flag3==true) {
				System.out.println("Congratulations!Player3 You guessed the number in "+count3 +" tries");
			}
	 }
		
		
		//Compare for 1st round
		void compare()
		{
			if(flag==true)
			{
				if(flag2==true && flag3==true)
				{
					System.out.println("All players completed this round.");
					if(count1<count3 && count2<count3) {
						System.out.println("Player1 and Player2 goes to the next round with lesser guesses");
						isP1=true; 
						isP2=true;
					}
					else if(count2<count1 && count3<count1)
					{
						System.out.println("Player2 and Player3 goes to the next round with lesser guesses");
						isP2=true; 
						isP3=true;
					}
					else if(count1<count2 && count3<count2) {
						System.out.println("Player1 and Player3 goes to the next round with lesser guesses");
						isP1=true; 
						isP3=true;
					}
					else if (count1<count2 && count2==count3) {
						System.out.println("Choose a number between 2 and 3");
						int result1=sc.nextInt();
						if (result1==2) {
							isP1=true; 
							isP2=true;
							System.out.println("Player1 and Player2 goes to the next round with lesser guesses");
						}
						else if(result1==3) {
							isP1=true; 
							isP3=true;
							System.out.println("Player1 and Player3 goes to the next round with lesser guesses");
						}
					}
					else if (count2<count1 && count1==count3) {
						System.out.println("Choose a number between 1 and 3");
						int result1=sc.nextInt();
						if (result1==1) {
							isP1=true; 
							isP2=true;
							System.out.println("Player1 and Player2 goes to the next round with lesser guesses");
						}
						else if(result1==3) {
							isP2=true; 
							isP3=true;
							System.out.println("Player2 and Player3 goes to the next round with lesser guesses");
						}
					}
					else if (count3<count1 && count1==count2) {
						System.out.println("Choose a number between 1 and 2");
						int result1=sc.nextInt();
						if (result1==1) {
							isP1=true; 
							isP3=true;
							System.out.println("Player1 and Player3 goes to the next round with lesser guesses");
						}
						else if(result1==2) {
							isP2=true; 
							isP3=true;
							System.out.println("Player2 and Player3 goes to the next round with lesser guesses");
						}
					}
					else {
					timeForElimination=true;
					System.out.println("Time to go to the third umpire for who qualifies "
							+ "for Finals:");
					}
				}
				else if(flag2==true)
				{
					System.out.println("Player 1 & Player2 qualifies for final round.");
					isP1=true; 
					isP2=true;
				}
				else if(flag3==true)
				{
					System.out.println("Player 1 & Player3 qaulifies for final round");
					isP1=true; 
					isP3=true;
				}
				else
				{
				System.out.println("Player1 is the Winner of this game");
				isFinal=false;
				finalP1=true;
				}
			}
			else if(flag2==true)
			{
				if(flag3==true)
				{
					System.out.println("Player2 & Player3 won this round");
					isP2=true; 
					isP3=true;
				}
				else
				{
				System.out.println("Player2 is the Winner of this game");
				isFinal=false;
				finalP2=true;
				}
			}
			else if(flag3==true)
			{
				System.out.println("Player3 won the game");
				isFinal=false;
				finalP3=true;
			}
			else
			{
				System.out.println("All failed to qualify the very first round "
						+ "Better luck next time!");
				isFinal=false;
				
			}
			
			if(timeForElimination==true) {
				eliminatedPlayer =tu.playerEliminated();
				System.out.println("The player who got eliminated is: " +eliminatedPlayer);
			}
			
			if(eliminatedPlayer==1) {
				isP2=true;
				isP3=true;
				System.out.println("Player2 and Player3 gets to the final round!");				
			}
			else if(eliminatedPlayer==2) {
				isP1=true;
				isP3=true;
				System.out.println("Player1 and Player3 gets to the final round!");
			}
			else if(eliminatedPlayer==3){
				isP1=true;
				isP2=true;
				System.out.println("Player1 and Player2 gets to the final round!");
			}
			if((isP1==true && isP2==true)||(isP1==true && isP3==true)||(isP2==true && isP3==true)) {
				setVariablesForFinals();
			}
			else {
				System.out.println("See you next time!");
			}
			
		}
		
      void setVariablesForFinals() {
    	  numFromGuesser=0;
    	  numFromPlayer=numFromPlayer2=numFromPlayer3=0;
    	  flag=flag2=flag3=false;
    	  count1=count2=count3=0;
      }
      //Final match started
      void finalMatch() {
    	  
    	  if(isFinal==false && finalP1==false && finalP2==false && finalP3==false) {
    		  System.out.println("Thank You for being part of ths Guesser Game so far... just "
    		  		+ "because all palyers failed to qualify for the next round,"
    		  		+ " the match is concluded this time");
    	  }
    	  else if(isFinal==true) {
    		  System.out.println("");
    		  System.out.println("***Let the Final Battle begin***");
    		  collectNumFromGuesser();
    		   if(isP1==true && isP2== true) {
    			   collectNumFromPlayer1();
    			   collectNumFromPlayer2();
    			   
    		   }
    		   else if(isP2==true && isP3== true) {
    			   collectNumFromPlayer2();
    			   collectNumFromPlayer3();
    			   
    		   }
    		   else if(isP1==true && isP3==true) {
    			   collectNumFromPlayer1();
    			   collectNumFromPlayer3();
    		   }
    	  }
      }
      //The Final match results
      void compareFinals() {
    	  if(flag==true)
			{
				if(flag2==true)
				{   if(count1<count2) {
					System.out.println("Player1 won with least guess");
				  }
				   else if(count2<count1) {
					   System.out.println("Player2 won with least guess"); 
				   }
				   else if(count1==count2) {
					System.out.println("Player1 and Player2 are joint winners in final match");
				   }
				}
				else if(flag3==true) {
				 if(count1<count3)	{
					 System.out.println("Player1 won with least guess:");
				 }
				 else if(count3<count1){
					 System.out.println("Player3 won with least guess");
				 }
				 else if(count1==count3)
				{
					System.out.println("Player 1 & Player3 are joint winners in final match .");
				}
				}	 
				else
				{
				System.out.println("Player1 is the final Winner of this game");
				}
					 
			}
			else if(flag2==true)
			{
				if(flag3==true)
				{
					if(count2<count3){
						System.out.println("Player2 won woth least guess");
					}
					else if(count3<count2){
						System.out.println("Player3 won with least guess");
					}
					else if(count2==count3)
				    {
					System.out.println("Player2 & Player3 are joint winners in the final match");
				    }
			    }
				else
				{
				System.out.println("Player2 is the final Winner of this game");
				}
			}
			else if(flag3==true)
			{
				System.out.println("Player3 is the final Winner of this game");
			}
			else if(isFinal==true && flag==false && flag2== false && flag3==false)
			{
				System.out.println("The number was "+numFromGuesser);
				System.out.println("All failed to guess the number in this final match "
						+ "Better luck some other time!");

      }
	
   }
}

public class NewGuesserGame {

	public static void main(String[] args) {
		TheUmpire u=new TheUmpire();
		System.out.println("***Let the first round begin:***");
		u.collectNumFromGuesser();
		u.collectNumFromPlayer1();
		u.collectNumFromPlayer2();
		u.collectNumFromPlayer3();
		System.out.println("Result after first round:");
		u.compare();
		u.finalMatch();
		u.compareFinals();

	}

}
