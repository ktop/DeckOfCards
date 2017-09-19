# DeckOfCards Project README

## Summary
This DeckOfCards project will generate a standard 52-card poker deck made of 4 suits and 13 ranks. The deck of cards includes 3 functionalities:
- shuffle() - shuffles the deck of cards
- dealOneCard() - deals one card from the top of the deck
- reset() - returns all cards to the deck and reshuffles.

A main class is included in this project with four scenarios. Uncomment each scenario and run the project to see the output in the console.

J-Unit tests were added to cover most of the functions used in the project.

## Design Thought Process
This project was left open-ended, so I went with simplicity and efficiency in my design choices. Since there isn't a particular card game I am catering this towards, I don't really care about the value of cards, just that there are 52 combinations of 4 suits and 13 ranks.

To represent the suits and ranks, I went with `char`. I created a Card class that holds these two pieces of information. We don't need anything beyond this for the current project since there is no point in maintaining information about the card rank value in the current iteration of this project.

For the deck of cards, I thought about the most efficient way, time and space wise, to hold 52 cards and shuffle them. The algorithm I thought of at the worst case would be O(n) for time and O(1) for space; and it can be done with a simple array. Using a random number generator to generate a number between a range of the current index + 1 (inclusive) and 52 (exclusive), swap the cards in the array at current index with the card at the random number index. Increment the index and repeat until all cards are swapped. The range in the random number generator is important because I want to generate the random number without including the indices that I've already swapped. Since I'll be incrementing the current index on each iteration, this will get what I want. Doing this generates a more even shuffle.

Implementing the dealOneCard function seemed simple enough. Since I decided to use an array to store the deck, I know that actually removing an element from an array is not very efficient since it would require creating a new array one size smaller and copying over all elements. To "fake" removing a card, I instead chose to keep a pointer to the index of the card that has been drawn. The pointer represents the index of the card at the top of the deck and increments every time a card is drawn. This way, I didn't have to remove anything and still get the desired output of dealing one card.

Dealing more than 52 cards was left open ended besides the fact that you shouldn't be able to deal a 53rd card. I decided to throw an error here if you tried to do it because it made sense to me that for a general case, trying to deal more than 52 cards means that something in the game is wrong and should error out anyways. I also see the case that for certain card games, I may want to do something else when there are no more cards in the deck and continue the game rather than error out. But since this project is just designing a deck of cards, I went with the simple way to handle this issue.

Finally, I want to bring up what to do when a user decides to shuffle the deck of cards after dealing some cards out. I've never heard of shuffling the remaining deck of cards after having dealt some out midway through a game, so I decided to print a warning to the console, but execute the shuffle anyways. It's not "wrong" to want to shuffle part way through the game, but mostly just unheard of. This would be easy enough to change if there was a requirement to not allow shuffle after some cards have been dealt out with a slight modification to the conditional statement in the shuffle method.

The last thing I want to mention is how I would interpolate the current project to be scalable for real card games. I mentioned earlier that with this simple deck of cards project I didn't really care about the value of the cards, but in a real card game, I do. In this case I would need to assign values to the card ranks where the face cards are greater than number cards and Ace can sometimes hold two values. The Card class can be modified to figure out the card value if I create a map that maps the card rank to the value. The same can be done for suits as in certain games, the suits matter. The DeckOfCards class can be improved so that it can deal x number of cards to players for their hands and the deck of cards may need to have a notion of a trash pile. There are probably a lot of other improvements that can be made to scale this to a real card game, but I'll only mention these few.
