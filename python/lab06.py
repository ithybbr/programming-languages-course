
from typing import List, Tuple, Dict, Optional, Union, Literal 
import random


class WrongDate( Exception ) :
   def __init__( self, reason ) :
      self. __reason = reason

   def __repr__( self ) :
      return self.__reason 


class Date :
   year : int
   month : int
   day : int

   # In monthnames, the first name is the 'preferred name', which will be used
   # when printing. Any further names are optional names. 
   # One can also add different languages. 

   monthnames : Tuple[ List[ Union[ str, int ] ], ... ] = ( 
       [ 'january', 'jan', 1, '1' ], [ 'february', 'feb', '2', 2 ], 
       [ 'march', 3, '3' ],
       [ 'april', 4, '4' ],  [ 'may', 5, '5' ], [ 'june', 6, '6' ], 
       [ 'july', 7, '7' ],  [ 'august', 8, '8' ],
       [ 'september', 'sept', 9, '9' ], [ 'october', 'oct', 10, '10' ],
       [ 'november', 'nov', 11, '11' ],
       [ 'december', 'dec', 12, '12' ] )

   monthindex : Dict[ Union[ str, int ], int ] = { name : ind 
            for ind, names in enumerate( monthnames ) for name in names  } 
  
   normalyear = ( 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 )
   leapyear =   ( 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 )
    
   weekdays = ( 'sunday', 'monday', 'tuesday', 'wednesday', 
                'thursday', 'friday', 'saturday' ) 
   @staticmethod
   def isleapyear( y : int ) -> bool :
      if(y%4==0):
         if(y%100 == 0 and not y%400 == 0):
            return False
         return True
      else:
         return False
   @classmethod
   def __init__( self, year : int, month : Union[ int, str ], day: int ) :
      if not isinstance(year,int):
         raise WrongDate( "year {} is not an integer". format( year ))
      if(year >= 1900 and year <= 2100):
         self.year = year
      else:
          raise WrongDate( "year {} is not between 1900 and 2100". format( year ))
      if month in Date.monthindex:
         if isinstance(month, int):
            self.month = month
         else:
            self.month = Date.monthindex[month] + 1
      else:
          raise WrongDate( "month {} is not valid". format( month ))
      if not isinstance(day,int):
         raise WrongDate( "day {} is not an integer". format( day ))
      if((day >= 1 and Date.isleapyear(year) == True and day <= Date.normalyear[Date.monthindex[month]]) or (day >= 1 and Date.isleapyear(year) == False and day <= Date.leapyear[Date.monthindex[month]])):
         self.day = day
      else:
          raise WrongDate( "day {} is not between 1 and the last day of the month". format( day ))
   @classmethod
   def __repr__( self ) -> str :
      return "( {}, {}, {} )". format( self. year, self. month, self. day ) 
   @classmethod
   def __str__( self ) -> str :
      return "( {}, {}, {} )". format( self. day, Date.monthnames[self.month - 1][0], self. year )
   @classmethod
   def weekday( self ) -> str :
      d = self.day
      m = self.month
      y = self.year
      if(m < 3):
         m += 12
         y -= 1
      c = y // 100
      y = y % 100
      h = (c // 4 - 2 * c + y + y // 4 + 13 * (m + 1) // 5 + d - 1)%7 
      return Date.weekdays[h]
def lucky_dates( ) :
   return [ ( 1956, 1, 31, 'tuesday', 'birthday of Guido Van Rossum' ),
     ( 1945, 'october', 24, 'wednesday', 'Founding of UN' ),
     ( 1969, 'july', 20, 'sunday', 'first moon landing' ),
     ( 1991, 'dec', 16, 'monday', 'independence of Kazakhstan' ),
     ( 1961, 'april', 12, 'wednesday', 'space flight of Yuri Gagarin' ), 
     ( 2022, 'september', 17, 'saturday', 'Nursultan renamed into Astana' ) ] 

def unlucky_dates( ) :
   return [ ( 1912, 'april', 15, 'monday', 'sinking of Titanic' ), 
     ( 1929, 'october', 29, 'tuesday',
                      'Wall Street Market Crash (Black Tuesday)' ), 
     ( 1959, 'february', 3, 'tuesday', 'the day the music died' ), 
     ( 1977, 'march', 27, 'sunday', 'Los Rodeos collision' ),
     ( 2019, 'march', 23, 'saturday', 'Astana renamed into Nursultan' ), 
     ( 2022, 'october', 21, 'friday', '!! deadline of this exercise !!' ) ]


def tester( ) :
   for date in ( ( 'a', 1, 1 ), ( 2, 'x', 3 ), ( 3, 4, 'y' ), 
                 ( 1900, 'x', 12 ),
                 ( 1899, 1, 1 ), ( 1900, 1, 1 ), ( 1900, 'jan', 1 ),
                 ( 1910, 12, 31 ), ( 1911, 3.14, 8 ),
                 ( 1900, 'feb', 28 ), ( 1900, 'feb', 29 ) ) : 
      try :
         y,m,d = date
         print( "testing {} {} {}". format( y,m,d ))

         dt = Date(y,m,d) 
         print( "date = {}". format( dt )) 

      except WrongDate as w:
         print( "   exception {}". format(w) )
      print( "" ) 

   dates = lucky_dates( ) + unlucky_dates( ) 
   random. shuffle( dates )
 
   for date in dates: 
      y,m,d,w1, importance = date
      dt = Date(y,m,d) 
      w2 = dt. weekday( ) 
      print( "{} : {} ({})". format( importance, dt, w2 ))
      if w1 != w2 : 
         print( "function weekday returned {} but correct day is {} !!!". format( w2, w1 ))
      print( "" )
   for year in (2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 1700, 1800, 1600):
      if(Date.isleapyear(year)):
         print(f"{year} is leap year")
      else:
         print(f"{year} is normal year")
   today = Date(2023,10,21)
   print("21.10.2023 is", today.weekday())
   print( "tests finished" ) 

 
