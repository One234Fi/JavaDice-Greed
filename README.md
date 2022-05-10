# JavaDice-Greed
The dice game "Greed" implemented in Java. 

The game is fully functional now! I wouldn't call it complete yet though. I'm probably going to have to do some further testing and bug hunting to make doubly sure that the entire program is working properly. I'm also planning on adding more types of AI that will make the game a little more interesting to play. At minimum there will be at least one conservative AI and a risky AI. 

Rules this program uses:

	Players roll the dice to get points and the first to 10,000 wins, scoring is as follows:
		1 = 100 points
    	5 = 50 points
    	3 of a kind = 100 * the face number
    	4 of a kind = 3 of a kind score * 2
    	5 of a kind = 4 of a kind score * 2
    	6 of a kind = 5 of a kind score * 2
    	straight with all 6 dice = 1200 points
  	Players have to get an initial "in" of 1,000 before their scores start counting towards their total
  	Players can reroll as many of their non-scored dice as they like to try and maximize their score, 
	One five can also be rerolled if the player has at least one scored die left after rolling five (in other words if roll value > 50)
  	If a roll does not yield any points, the turn is ended and all points accumulated that turn are nulled
  	Players can end their turn at any time to add their turn score to their total (after they've gotten "in")
