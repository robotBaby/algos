import sys, os, math
import re
import pprint

def word_distance1(file, w1, w2) :
	#given two words w1 and w2, write a program that 
	#finds the fewest number of characters that separate 
	#some appearances of w1 and w2 in D respectively. 
	#Your program should output the positions of w1, w2, and the distance between them.	
	f = open(file)
	f = f.readlines()
	word_position = 0
	word1_position = []
	word2_position = []
	for line in f :
		line = line.replace(".", ";").replace(" ", ";").strip("\n")
		#print line
		line = line.split(";")
		for word in line:
			if word==w1:
				word1_position.append(word_position)
			if word==w2:
				word2_position.append(word_position)
			word_position += len(word) +1
	min_triple= min_distance(word1_position, word2_position)
	#print word1_position, word2_position, min_triple
	if min_triple[0] < min_triple[1]:
		return min_triple[0], min_triple[1], min_triple[2]-len(w1)
	elif min_triple[0] > min_triple[1]: 
		return min_triple[0], min_triple[1], min_triple[2]-len(w2)
	else: return min_triple

	return -1

def min_distance(w1_pos, w2_pos):
	w2_pos = sorted(w2_pos)
	distances = []
	for pos in w1_pos:
		distances.append(binary_search(w2_pos, pos, 0, len(w2_pos)))
	#print distances
	t =[]
	min = "inf"
	for triple in distances:
		if triple[2] < min:
			t=triple
			min= triple[2]
	return t

def binary_search(a, x, lo, hi):
    while lo < hi:
        mid = (lo+hi)/2
        hival = a[hi-1]
        loval = a[lo]
        midval = a[mid]
        if abs(midval-x) > abs(hival-x):
            lo = mid+1
        elif abs(midval-x) > abs(loval-x): 
            hi = mid
        else:
            return x, midval, abs(midval -x)
    return x, a[-1], 0

def word_distance2(file, word_list):
	#given a set W of n words {w1, ..., wn}, write a program 
	#that finds the fewest number of characters that separate 
	#ANY two distinct words from w. Your program should output the two words, their positions and the distance between them.
	for i in (range(0, len(word_list)-1)):
		for j in (range(i+1, len(word_list)-1)):
			if (word_list[i] != word_list[j]):
				print word_list[i], word_list[j], word_distance1(file, word_list[i], word_list[j])
	
def word_collection(file, word_list, num_words):
	#given a set W of n words {w1, ..., wn}, and a number K (at most n), 
	#write a program that finds the shortest portion of the document 
	#that contains at least K distinct words from W. 
	#Your program should output the portion of the document and the words contained in it.
	f = open(file)
	f = f.readlines()
	word_counter=0
	words_contained=[]
	lines = []
	for line in f :
		line1 = line.replace(".", "").replace(",", "").replace("\n", "").strip(" ")
		words = line1.split(" ")
		for word in words:
			if word_counter >= num_words:
				break
			else: 
				if line not in lines:
					# Assuming that the portion of the document means till the end of the current line.
					lines.append(line)
			if word in word_list:
				if word not in words_contained:
					word_counter += 1
					words_contained.append(word)
					

	return lines, words_contained

print(word_distance1("document.txt", "Hello", "World"))
word_distance2("document.txt", ["Hello" , "World", "world", "world"])
print(word_collection("document.txt", ["Hello", "World", "world", "world"], 2))