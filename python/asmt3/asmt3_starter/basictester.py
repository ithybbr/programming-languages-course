from wordoccurrences import WordOccurrences

topdir = ".\\test_dir\\Music\\Beatles"

wo = WordOccurrences( topdir )
'''
print("distinct words: " + str(wo.distinctWords()))
print("total occurrences: " + str(wo.totalOccurrences()))
print("total occurrences of love: " + str(wo.totalOccurrences("love")))
print("total occurrences of ob-la-di: " + str(wo.totalOccurrences("ob-la-di")))
print("total occurrences of detest: " + str(wo.totalOccurrences("detest")))

print("total occurrences of that's in Money.txt: "
                + str(wo.totalOccurrences("that's", ".\\test_dir\\Music\\Beatles\\Money.txt")))

print("total occurrences of ob-la-di in Money.txt: "
                + str(wo.totalOccurrences("ob-la-di", ".\\test_dir\\Music\\Beatles\\Money.txt")))

print("total occurrences of the in Funny.txt: "
                + str(wo.totalOccurrences("the", ".\\test_dir\\Music\\Beatles\\Funny.txt")))

print("-------------")
'''
# Uncomment below to see how well the __str__ function works

print( wo ) 
