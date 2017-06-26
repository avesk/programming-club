#!/usr/bin/env

import sys
import fileinput

def main():

	revWord = ''
	revSort = []
	longestWord = 0

	for line in sys.stdin:
		if len(line) > longestWord:
			longestWord = len(line)
		if line == '\n':
			#revSort.append('\n);
			solve( revSort, longestWord )
			print()
			revSort = []
			longestWord = 0
			
		else:
			revWord = line[::-1]
			revSort.append( revWord )

	solve(revSort, longestWord)

def solve( revSort, longestWord ):

	revSort.sort()

	for rw in revSort:
		numMargin = longestWord - len(rw)
		margin = ' ' * numMargin
		rightWord = rw[::-1]
		rightWord = margin + rightWord
		print(rightWord, end="")

if __name__=='__main__':
	main()
