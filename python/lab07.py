import time
from typing import Iterator
class Life : 
    state : list [list [bool]]
    m :int
    n :int
    def __init__( self, m : int, n : int ) :
        self.m = m
        self.n = n
        self.state = []
        for x in range(m):
            in_list = []
            for y in range(n):
                in_list.append(False)
            self.state.append(in_list)
    def __repr__( self ) -> str :
        return str( self. state )
    def neighbours( self, i : int, j : int ) -> Iterator[tuple[int, int]]:
        if i-1 >= 0 and j - 1 >= 0:
            yield (i-1,j-1)
        if i-1 >= 0 and j >= 0 and j < self.n:
            yield (i-1,j)
        if i-1 >= 0 and j + 1 < self.n:    
            yield (i-1,j+1)
        if i >= 0 and i < self.m and j - 1 >= 0:
            yield (i,j-1)
        if i >= 0 and i < self.m and j + 1 < self.n:
            yield (i,j+1)
        if i + 1 < self.m and j - 1 >= 0:
            yield (i+1,j-1)
        if i + 1 < self.m and j >= 0 and j < self.n:    
            yield (i+1,j)
        if i + 1 < self.m and j + 1 < self.n:
            yield (i+1,j+1)

    def nextstate( self ) -> None:
        next = []
        for x in range(self.m):
            in_next = []
            for y in range(self.n):
                neigh = 0
                for i, j in self.neighbours(x,y):
                    if self.state[i][j]:
                        neigh += 1
                if self.state[x][y]:
                    if neigh == 3 or neigh == 2:
                        in_next.append(True)
                    else:
                        in_next.append(False)
                else:
                    if neigh == 3:
                        in_next.append(True)
                    else:
                        in_next.append(False)
            next.append(in_next)
        self.state = next

    def addfigure(self,i:int, j:int, figure:list[str]) -> None:
        if i < 0 or j < 0 or i + len(figure) > self.m or j + len(figure[0]) > self.n:
            raise ValueError("outside of grid")
        for x in range(len(figure)):
            for y in range(len(figure[0])):
                if figure[x][y] == "." or figure[x][y] == " ":
                    self.state[i + x][j + y] = False
                else:
                    self.state[i + x][j + y] = True     

    def __str__( self ) -> str :
        ret_str = ""
        for x in range(self.m):
            str = ""
            for y in range(self.n):
                if self.state[x][y]:
                    str += '#'
                else:
                    str += '.'
            str += '\n'
            ret_str += str
        return ret_str
def start( ) :
    toad = [".###","###."]
    blinker = ["###"]
    block = ["..##..","..##.."]
    glidergun = [
    "...................................#............",
    ".................................#.#............",
    ".......................##......##............##.",
    "......................#...#....##............##.",
    "...........##........#.....#...##...............",
    "...........##........#...#.##....#.#............",
    ".....................#.....#.......#............",
    "......................#...#.....................",
    ".......................##......................." ]
    lf = Life( 50, 80 )
    lf. addfigure( 10,10, glidergun )
    lf. addfigure( 30, 10, toad )
    lf. addfigure( 40, 15, blinker )
    while True:
        print( lf )
        print( "press Ctrl-C tostop" )
        lf. nextstate( )
        time. sleep( 0.25 )