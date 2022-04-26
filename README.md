# JavaDice-Greed
The dice game "Greed" implemented in Java. WIP

Rules this program will use when complete:

	Players roll a die and highest roll goes first.
	Players roll the dice to get points and the first to 10,000 wins, scoring is as follows:
		1 = 100 points
    	5 = 50 points
    	3 of a kind = 100 * the face number
    	4 of a kind = 3 of a kind score * 2
    	5 of a kind = 4 of a kind score * 2
    	6 of a kind = 5 of a kind score * 2
    	straight with all 6 dice = 1200 points
  	Players have to get an initial "in" of 1,000 before their scores start counting towards their total
  	Players can reroll as many of their dice as they like to try and maximize their score
  	If a roll does not yield any points, the turn is ended and all points accumulated that turn are nulled
  	Players can end their turn at any time to add their turn score to their total (after they've gotten "in")
