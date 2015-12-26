def find_dictionary_matching(given_string, word_list):
	bag_of_words = []
	dangling_string = ""
	for i in range(len(given_string)):
	 	current_character = given_string[i]
	 	dangling_string += current_character

	 	#Checking if the dangling string forms a word from the wordlist
	 	if dangling_string in word_list:
	 		bag_of_words.append(dangling_string)
	 		dangling_string = ""

	 	#If there is a dangling string, then checks if it makes meaningful 
	 	#words in combination of the old words
	 	if len(dangling_string) > 0:
	 		current_string = given_string[:i+1].split()
	 		new_bag_of_words = []
	 		last_word=""
	 		while (len(bag_of_words) > 0):
	 			next_word = bag_of_words.pop() 
	 			last_word = next_word + last_word
	 			string2 = last_word + dangling_string
	 			#If the full combination of the old word and the 
	 			#dangling string is a new word, store it in bag of words
	 			if string2 in word_list:
	 				new_bag_of_words.pop()
	 				new_bag_of_words.append(string2)
	 				dangling_string = ""
	 				break
	 			# This is to check for edge cases, when the new combination of old word and dangling string 
	 			#is not a new word but a 'complete' set of its substring is.
	 			# The way I handle this is run a greedy algorithm backward on the new string and observe 
	 			#1) If the new breakdown can resolve the dangling string 
				# and make any difference in the number of words formed.
	 			#Example if wordlistt is ["go" "es" "goe"]. Forward greedy returns ["goe"] 's' (dangling) and backward greedy return ["go" "es"]
	 			# There might be some elegant way to handle this edge case, but I think this works too.
	 			else:
	 				dangling_string2 = ""
	 				backwards_word = []
	 				l = len(string2)
	 				for k in range(l):
	 					current_character2 = string2[l-k-1]
	 					dangling_string2 = current_character2 + dangling_string2
	 					if dangling_string2 in word_list:
	 						backwards_word.append(dangling_string2)
	 						dangling_string2 = ""
	 				if len(dangling_string2) == 0:
	 					if len(backwards_word) > (len(new_bag_of_words) +1):
	 						new_bag_of_words = backwards_word
	 						dangling_string = ""
	 					else: new_bag_of_words.append(next_word)
	 					break
	 				else: new_bag_of_words.append(next_word)

	 		# adding the new breakdown of the string to the old bag of words.
	 		new_bag_of_words.reverse()
	 		bag_of_words.extend(new_bag_of_words)
	 		#print bag_of_words, dangling_string

	 	#Final output in terms of Success and Failure.
	 	output = ""
	 	if i == len(given_string)-1:
	 		if dangling_string == "":
	 			output= "Success"
	 		else:
	 			output= "Failure"

	print output
	return output

find_dictionary_matching("ilikemangoes", ["i" ,"like", "mango", "mangoes", "man", "go"])

