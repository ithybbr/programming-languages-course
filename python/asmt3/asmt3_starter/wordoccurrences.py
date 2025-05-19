
from fileposition import FilePosition
from typing import Optional, Iterator

import syntax
import os

class WordOccurrences : 

	occMap : dict[ str, dict[ str, set[ FilePosition ]]] 

	
	def __init__( self, docOrRootDirPath : str ) :
		self.occMap = dict( )
		self.buildMap( docOrRootDirPath )


	# Used by the constructor to populate the occMap
	def buildMap( self, docOrDirPath : str ) -> None :

		# Raise an error if the document or directory does not exist
		if not os.path.exists( docOrDirPath ) :
			raise FileNotFoundError
		
		# Get the filepaths of all files at or below docOrDirPath, and
		# iterate through them
		for filepath in WordOccurrences.allFiles(docOrDirPath) :
		
		 	# Process each file by retrieving each word instance and location
			# using the occurrences iterator, and then store each one in the 
			# occMap by calling addMapEntry
			for word, line, column in WordOccurrences.occurrences(filepath) :
				self.addMapEntry( word, filepath, FilePosition(line, column) )
        
		
	# Generator which yields all of the files at or below the given root file 
	# or directory.  It is static, since it does not need to access the occMap.
	@staticmethod	
	def allFiles( docOrDirPath : str ) -> Iterator[ str ] :
		if os.path.isdir(docOrDirPath):
			for dirpath, subdirpath, filepaths in os.walk(docOrDirPath):
				for filepath in filepaths:
					yield os.path.join(dirpath, filepath)
		else:
			yield docOrDirPath
		# Implement me!!!
		return
					
					
	# Generator which yields all word occurrences within the file along with 
	# their line and column numbers.  It is static, since it does not need to 
	# access the occMap.
	@staticmethod
	def occurrences( filepath : str ) -> Iterator[ tuple[str, int, int] ] :
		infile = open( filepath, "r", encoding = "utf8" )
		row = 1
		column = 0
		inColumn = 0
		word = ""
		for line in infile:
			for ch in line:
				column += 1
				if syntax.inWord(ch):
					word += ch
					inColumn +=1
				else:
					if word:
						yield (word, row, column - inColumn)
						word = ""
						inColumn = 0
					if syntax.isNewLine(ch):
						row += 1
						column = 0
		# Implement me!!!
		if word:
			column += 1
			yield (word, row, column - inColumn)
		infile.close()
		return
		
		
	# Helper function for buildMap, which records the occurrence of the
	# given word, in the given file, at the given position in occMap
	def addMapEntry( self, word : str, filePath : str, pos : FilePosition ) -> None :
		word = word.lower()
		if self.occMap.get(word) is None:
			new_word = {filePath: {pos}}
			self.occMap[word] = new_word
		else:
			ext_word = self.occMap[word]
			if ext_word.get(filePath) is None:
				ext_word[filePath] = {pos}
			else:
				ext_word[filePath].add(pos)
        # Implement me!!!
		return
	

	# Returns the number of distinct words across all files
	def distinctWords( self ) -> int : 
		words = len(self.occMap)
		# Implement me!!!
		return words

	
	# Returns the total number of occurrences of a given word, if both are provided;
	# Returns the total number of occurrences of a given word across all files, if only
	#		the word is given;
	# Returns the total number of all word occurrences across all files, if neither the
	#		word nor the filepath is given
	def totalOccurrences( self, word : Optional[str] = None, filepath : Optional[str] = None ) -> int :
		words = 0
		if word is None and filepath is None:
			for wordDict in self.occMap.values():
				for sets in wordDict.values():
					words += len(sets)
		if word is not None and filepath is None:
			if word in self.occMap:
				for sets in self.occMap[word].values():
					words += len(sets)
		if word is not None and filepath is not None:
			if word in self.occMap and filepath in self.occMap[word]:
				words = len(self.occMap[word][filepath])
		# Implement me!!!
		return words


	# This is for debugging, so it doesn't need to be pretty
	def __repr__( self ) -> str : 
		# Just output the stringified version of the occMap dictionary
		return str( self.occMap )

		
	# Returns a string representation of the contents of the occurrence map
	def __str__( self ) -> str :
		res = ""
		traverse = sorted(self.occMap.keys())
		for key in traverse:
			res += f"\"{key}\" has {self.totalOccurrences(key)} occurrence(s): \n"
			word = self.occMap[key]
			for keySecond, setInDict in word.items():
				sortedSetInDict = sorted(setInDict)
				for pos in sortedSetInDict:
					res += f"( file: \"{keySecond}\"; {str(pos)} )\n"
		# Implement me!!!
		return res
 