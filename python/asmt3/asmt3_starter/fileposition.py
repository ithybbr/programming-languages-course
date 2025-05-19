
class FilePosition : 
	line : int
	column : int
	
	def __init__( self, ln : int, col : int ) :
		self.line = ln
		self.column = col
		
	def __repr__( self ) -> str : 
		return "( {}, {} )". format( self.line, self.column )
	
	def __str__( self ) -> str :
		return "line " + str( self.line ) + ", column " + str( self.column )
		
	# Fix me!!!
	def __hash__( self ) -> int :
		tup = (self.line, self.column)
		return hash(tup)

	# Fix me!!!		
	def __eq__( self, other ) -> bool :
		if self.line == other.line and self.column == other.column:
			return True
		else:
			return False
	
	# Fix me!!!
	def __lt__( self, other ) -> bool :
		if self.line < other.line:
			return True
		if self.line == other.line and self.column < other.column:
			return True
		return False