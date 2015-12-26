import itertools 

def generate_all_substring(word):
	substring_list = []
	for index in range(len(word)):
		for size in range(1, len(word) +1-index):
			substring_list.append(word[index:index+size])
	return substring_list

def palindrome(word):
	#Given a string S, find the number of distinct case-insensitive palindromes that are a substring of S.
	palindrome_list = []
	substring_list = generate_all_substring(word)
	for string in substring_list:
		reverted_string = []
		for l in range(len(string)):
			reverted_string.append(string[(len(string) -l-1)])
		reverted_string = "".join(reverted_string)
		if (string == reverted_string):
			palindrome_list.append(string)
	return list(set(palindrome_list))


def apply_palindrome():
	#Apply your code on the following strings: 'apple', 'anaconda', 'MadamImAdam'.
	word_list = ['abAa', 'apple', 'anaconda', 'MadamImAdam']
	for word in word_list:
		print word, palindrome(word.lower())

def create_maximum_palindromes(character_list, string_length):
	#Given a set C of characters, and string length N as input, 
	#write a program to construct a string S of length N with characters from C 
	#such that the number of substring palindromes is maximized. 
	#Example: If C={a, b, c}, and N=4, we can construct S='abba' to obtain 4 palindromes ('a', 'b', 'abba', 'bb').
	max_p_num =0
	string_for_max_palindrome = ''
	for p in itertools.product(character_list, repeat=string_length):
		permutation = "".join(p)
		length = len(palindrome(permutation))
		if length >= max_p_num:
			max_p_num = length
			string_for_max_palindrome = permutation

	#print string_for_max_palindrome
	return max_p_num

def max_num_palindrome(char_list_length, string_length):
	character_list = []
	for i in range(char_list_length):
		character_list.append(str(i))

	#print create_maximum_palindromes(character_list, string_length)
	return create_maximum_palindromes(character_list, string_length)

apply_palindrome()
create_maximum_palindromes(['a', 'b', 'c'], 4)
max_num_palindrome(5, 6)