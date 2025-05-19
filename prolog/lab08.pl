enggerm(table, tisch, m).
enggerm(chair, stuhl, m).
enggerm(bed, bett, n).
enggerm(child,kind, n).
enggerm(brother, bruder, m).
enggerm(sister, schwester, f).
enggerm(house, haus, n).
enggerm(sun, sonne, f).
enggerm(cloud, wolke, f).
enggerm(wind, wind, m).
enggerm(rain, regen, m).
engit(table, tavolo, m).
engit(chair, sedia, f).
engit(bed, letto, m).
engit(child, bambino, m).
engit(child, bambina, f).
engit(brother, fratello, m).
engit(sister, sorella, f).
engit(house, case, f).
engit(sun, sole, f).
engit(cloud, nube, f).
engit(wind, vento, m).
engit(rain, pioggia, f).
article( f, die ).
article( m, der ).
article( n, das ).
male(carl_gustav).
male(daniel_westling).
male(carl_philip).
male(christopher_o_neill).
male(oscar).
male(alexander).
male(gabriel).
male(nicolas).
female(silvia).
female(victoria).
female(sofia_hellqvist).
female(madeleine).
female(estelle).
female(leonore).
female(adrenne).
parent(carl_gustav,victoria).
parent(carl_gustav, carl_philip).
parent(carl_gustav, madeleine).
parent(silvia,victoria).
parent(silvia, carl_philip).
parent(silvia, madeleine).
parent(victoria,estelle).
parent(victoria,oscar).
parent(daniel_westling,estelle).
parent(daniel_westling,oscar).
parent(carl_philip,alexander).
parent(carl_philip,gabriel).
parent(sofia_hellqvist,alexander).
parent(sofia_hellqvist,gabriel).
parent(madeleine,leonore).
parent(madeleine,nicolas).
parent(madeleine,adrienne).
parent(christopher_o_neill,leonore).
parent(christopher_o_neill,nicolas).
parent(christopher_o_neill,adrienne).
rulesover(carl_gustav,sweden).
rulesover(silvia,sweden).
rulesover(victoria,vastergotland).
rulesover(daniel_westling,vastergotland).
rulesover(carl_philip,varmland).
rulesover(sofia_hellqvist,varmland).
rulesover(madeleine,halsingland).
rulesover(madeleine,gastrikland).
rulesover(alexander,sodermanland).
rulesover(gabriel,dalama).
rulesover(estelle,ostergotland).
rulesover(oscar,skane).
rulesover(leonore,gotland).
rulesover(nicolas,angermanland).
rulesover(adrienne,blekinge).

gerwitharticle( E, A, G ) :-
    enggerm(E, G, X),
    article(X,A).
gerit( G, I ) :-
    enggerm(X, G, S),
    engit(X, I, Z).
samegender(E) :-
    enggerm(E,G,S),
    engit(E,I,S).
sibling(X,Y) :-
    male(Z),
    parent(Z,X),
    parent(Z,Y),
    X \= Y.
brother(X,Y) :-
    sibling(X,Y),
    male(X).
sister(X,Y) :-
    sibling(X,Y),
    female(X).
father(X,Y) :-
    male(X),
    parent(X,Y).
mother(X,Y) :-
    female(X),
    parent(X,Y).
son(X,Y) :-
    parent(Y,X),
    male(X).
daughter(X,Y) :-
    parent(Y,X),
    female(X).
king(X) :-
    male(X),
    rulesover(X,sweden).
queen(X):-
    female(X),
    rulesover(X,sweden).
duke(X):-
    male(X),
    rulesover(X,Y),
    Y \= sweden.
duchess(X):-
    female(X),
    rulesover(X,Y),
    Y \= sweden.

